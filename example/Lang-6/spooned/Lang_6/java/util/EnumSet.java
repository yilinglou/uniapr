package java.util;


public abstract class EnumSet<E extends java.lang.Enum<E>> extends java.util.AbstractSet<E> implements java.io.Serializable , java.lang.Cloneable {
    private static class SerializationProxy<E extends java.lang.Enum<E>> implements java.io.Serializable {
        private final java.lang.Class<E> elementType;

        private final java.lang.Enum<?>[] elements;

        private static final long serialVersionUID = 362491234563181265L;

        SerializationProxy(java.util.EnumSet<E> set) {
            elementType = set.elementType;
            elements = set.toArray(java.util.EnumSet.ZERO_LENGTH_ENUM_ARRAY);
        }

        @java.lang.SuppressWarnings("unchecked")
        private java.lang.Object readResolve() {
            java.util.EnumSet<E> result = java.util.EnumSet.noneOf(elementType);
            for (java.lang.Enum<?> e : elements)
                result.add(((E) (e)));

            return result;
        }
    }

    final java.lang.Class<E> elementType;

    final java.lang.Enum<?>[] universe;

    private static java.lang.Enum<?>[] ZERO_LENGTH_ENUM_ARRAY = new java.lang.Enum<?>[0];

    EnumSet(java.lang.Class<E> elementType, java.lang.Enum<?>[] universe) {
        this.elementType = elementType;
        this.universe = universe;
    }

    public static <E extends java.lang.Enum<E>> java.util.EnumSet<E> noneOf(java.lang.Class<E> elementType) {
        java.lang.Enum<?>[] universe = java.util.EnumSet.getUniverse(elementType);
        if (universe == null)
            throw new java.lang.ClassCastException((elementType + " not an enum"));

        if ((universe.length) <= 64)
            return new java.util.RegularEnumSet<>(elementType, universe);
        else
            return new java.util.JumboEnumSet<>(elementType, universe);

    }

    public static <E extends java.lang.Enum<E>> java.util.EnumSet<E> allOf(java.lang.Class<E> elementType) {
        java.util.EnumSet<E> result = java.util.EnumSet.noneOf(elementType);
        result.addAll();
        return result;
    }

    abstract void addAll();

    public static <E extends java.lang.Enum<E>> java.util.EnumSet<E> copyOf(java.util.EnumSet<E> s) {
        return s.clone();
    }

    public static <E extends java.lang.Enum<E>> java.util.EnumSet<E> copyOf(java.util.Collection<E> c) {
        if (c instanceof java.util.EnumSet) {
            return ((java.util.EnumSet<E>) (c)).clone();
        }else {
            if (c.isEmpty())
                throw new java.lang.IllegalArgumentException("Collection is empty");

            java.util.Iterator<E> i = c.iterator();
            E first = i.next();
            java.util.EnumSet<E> result = java.util.EnumSet.of(first);
            while (i.hasNext())
                result.add(i.next());

            return result;
        }
    }

    public static <E extends java.lang.Enum<E>> java.util.EnumSet<E> complementOf(java.util.EnumSet<E> s) {
        java.util.EnumSet<E> result = java.util.EnumSet.copyOf(s);
        result.complement();
        return result;
    }

    public static <E extends java.lang.Enum<E>> java.util.EnumSet<E> of(E e) {
        java.util.EnumSet<E> result = java.util.EnumSet.noneOf(e.getDeclaringClass());
        result.add(e);
        return result;
    }

    public static <E extends java.lang.Enum<E>> java.util.EnumSet<E> of(E e1, E e2) {
        java.util.EnumSet<E> result = java.util.EnumSet.noneOf(e1.getDeclaringClass());
        result.add(e1);
        result.add(e2);
        return result;
    }

    public static <E extends java.lang.Enum<E>> java.util.EnumSet<E> of(E e1, E e2, E e3) {
        java.util.EnumSet<E> result = java.util.EnumSet.noneOf(e1.getDeclaringClass());
        result.add(e1);
        result.add(e2);
        result.add(e3);
        return result;
    }

    public static <E extends java.lang.Enum<E>> java.util.EnumSet<E> of(E e1, E e2, E e3, E e4) {
        java.util.EnumSet<E> result = java.util.EnumSet.noneOf(e1.getDeclaringClass());
        result.add(e1);
        result.add(e2);
        result.add(e3);
        result.add(e4);
        return result;
    }

    public static <E extends java.lang.Enum<E>> java.util.EnumSet<E> of(E e1, E e2, E e3, E e4, E e5) {
        java.util.EnumSet<E> result = java.util.EnumSet.noneOf(e1.getDeclaringClass());
        result.add(e1);
        result.add(e2);
        result.add(e3);
        result.add(e4);
        result.add(e5);
        return result;
    }

    @java.lang.SafeVarargs
    public static <E extends java.lang.Enum<E>> java.util.EnumSet<E> of(E first, E... rest) {
        java.util.EnumSet<E> result = java.util.EnumSet.noneOf(first.getDeclaringClass());
        result.add(first);
        for (E e : rest)
            result.add(e);

        return result;
    }

    public static <E extends java.lang.Enum<E>> java.util.EnumSet<E> range(E from, E to) {
        if ((from.compareTo(to)) > 0)
            throw new java.lang.IllegalArgumentException(((from + " > ") + to));

        java.util.EnumSet<E> result = java.util.EnumSet.noneOf(from.getDeclaringClass());
        result.addRange(from, to);
        return result;
    }

    abstract void addRange(E from, E to);

    @java.lang.SuppressWarnings("unchecked")
    public java.util.EnumSet<E> clone() {
        try {
            return ((java.util.EnumSet<E>) (super.clone()));
        } catch (java.lang.CloneNotSupportedException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    abstract void complement();

    final void typeCheck(E e) {
        java.lang.Class<?> eClass = e.getClass();
        if ((eClass != (elementType)) && ((eClass.getSuperclass()) != (elementType)))
            throw new java.lang.ClassCastException(((eClass + " != ") + (elementType)));

    }

    private static <E extends java.lang.Enum<E>> E[] getUniverse(java.lang.Class<E> elementType) {
        return sun.misc.SharedSecrets.getJavaLangAccess().getEnumConstantsShared(elementType);
    }

    java.lang.Object writeReplace() {
        return new java.util.EnumSet.SerializationProxy<>(this);
    }

    private void readObject(java.io.ObjectInputStream stream) throws java.io.InvalidObjectException {
        throw new java.io.InvalidObjectException("Proxy required");
    }
}

