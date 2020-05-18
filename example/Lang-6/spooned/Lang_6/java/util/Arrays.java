package java.util;


public class Arrays {
    static final class NaturalOrder implements java.util.Comparator<java.lang.Object> {
        static final java.util.Arrays.NaturalOrder INSTANCE = new java.util.Arrays.NaturalOrder();

        @java.lang.SuppressWarnings("unchecked")
        public int compare(java.lang.Object first, java.lang.Object second) {
            return ((java.lang.Comparable<java.lang.Object>) (first)).compareTo(second);
        }
    }

    static final class LegacyMergeSort {
        private static final boolean userRequested = java.security.AccessController.doPrivileged(new sun.security.action.GetBooleanAction("java.util.Arrays.useLegacyMergeSort")).booleanValue();
    }

    private static class ArrayList<E> extends java.util.AbstractList<E> implements java.io.Serializable , java.util.RandomAccess {
        private static final long serialVersionUID = -2764017481108945198L;

        private final E[] a;

        ArrayList(E[] array) {
            a = java.util.Objects.requireNonNull(array);
        }

        @java.lang.Override
        public int size() {
            return a.length;
        }

        @java.lang.Override
        public java.lang.Object[] toArray() {
            return a.clone();
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public <T> T[] toArray(T[] a) {
            int size = size();
            if ((a.length) < size)
                return java.util.Arrays.copyOf(this.a, size, ((java.lang.Class<? extends T[]>) (a.getClass())));

            java.lang.System.arraycopy(this.a, 0, a, 0, size);
            if ((a.length) > size)
                a[size] = null;

            return a;
        }

        @java.lang.Override
        public E get(int index) {
            return a[index];
        }

        @java.lang.Override
        public E set(int index, E element) {
            E oldValue = a[index];
            a[index] = element;
            return oldValue;
        }

        @java.lang.Override
        public int indexOf(java.lang.Object o) {
            E[] a = this.a;
            if (o == null) {
                for (int i = 0; i < (a.length); i++)
                    if ((a[i]) == null)
                        return i;


            }else {
                for (int i = 0; i < (a.length); i++)
                    if (o.equals(a[i]))
                        return i;


            }
            return -1;
        }

        @java.lang.Override
        public boolean contains(java.lang.Object o) {
            return (indexOf(o)) != (-1);
        }

        @java.lang.Override
        public java.util.Spliterator<E> spliterator() {
            return java.util.Spliterators.spliterator(a, java.util.Spliterator.ORDERED);
        }

        @java.lang.Override
        public void forEach(java.util.function.Consumer<? super E> action) {
            java.util.Objects.requireNonNull(action);
            for (E e : a) {
                action.accept(e);
            }
        }

        @java.lang.Override
        public void replaceAll(java.util.function.UnaryOperator<E> operator) {
            java.util.Objects.requireNonNull(operator);
            E[] a = this.a;
            for (int i = 0; i < (a.length); i++) {
                a[i] = operator.apply(a[i]);
            }
        }

        @java.lang.Override
        public void sort(java.util.Comparator<? super E> c) {
            java.util.Arrays.sort(a, c);
        }
    }

    private static final int MIN_ARRAY_SORT_GRAN = 1 << 13;

    private static final int INSERTIONSORT_THRESHOLD = 7;

    private Arrays() {
    }

    private static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new java.lang.IllegalArgumentException((((("fromIndex(" + fromIndex) + ") > toIndex(") + toIndex) + ")"));
        }
        if (fromIndex < 0) {
            throw new java.lang.ArrayIndexOutOfBoundsException(fromIndex);
        }
        if (toIndex > arrayLength) {
            throw new java.lang.ArrayIndexOutOfBoundsException(toIndex);
        }
    }

    public static void sort(int[] a) {
        java.util.DualPivotQuicksort.sort(a, 0, ((a.length) - 1), null, 0, 0);
    }

    public static void sort(int[] a, int fromIndex, int toIndex) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        java.util.DualPivotQuicksort.sort(a, fromIndex, (toIndex - 1), null, 0, 0);
    }

    public static void sort(long[] a) {
        java.util.DualPivotQuicksort.sort(a, 0, ((a.length) - 1), null, 0, 0);
    }

    public static void sort(long[] a, int fromIndex, int toIndex) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        java.util.DualPivotQuicksort.sort(a, fromIndex, (toIndex - 1), null, 0, 0);
    }

    public static void sort(short[] a) {
        java.util.DualPivotQuicksort.sort(a, 0, ((a.length) - 1), null, 0, 0);
    }

    public static void sort(short[] a, int fromIndex, int toIndex) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        java.util.DualPivotQuicksort.sort(a, fromIndex, (toIndex - 1), null, 0, 0);
    }

    public static void sort(char[] a) {
        java.util.DualPivotQuicksort.sort(a, 0, ((a.length) - 1), null, 0, 0);
    }

    public static void sort(char[] a, int fromIndex, int toIndex) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        java.util.DualPivotQuicksort.sort(a, fromIndex, (toIndex - 1), null, 0, 0);
    }

    public static void sort(byte[] a) {
        java.util.DualPivotQuicksort.sort(a, 0, ((a.length) - 1));
    }

    public static void sort(byte[] a, int fromIndex, int toIndex) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        java.util.DualPivotQuicksort.sort(a, fromIndex, (toIndex - 1));
    }

    public static void sort(float[] a) {
        java.util.DualPivotQuicksort.sort(a, 0, ((a.length) - 1), null, 0, 0);
    }

    public static void sort(float[] a, int fromIndex, int toIndex) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        java.util.DualPivotQuicksort.sort(a, fromIndex, (toIndex - 1), null, 0, 0);
    }

    public static void sort(double[] a) {
        java.util.DualPivotQuicksort.sort(a, 0, ((a.length) - 1), null, 0, 0);
    }

    public static void sort(double[] a, int fromIndex, int toIndex) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        java.util.DualPivotQuicksort.sort(a, fromIndex, (toIndex - 1), null, 0, 0);
    }

    public static void parallelSort(byte[] a) {
        int n = a.length;
        int p;
        int g;
        if ((n <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN)) || ((p = java.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1))
            java.util.DualPivotQuicksort.sort(a, 0, (n - 1));
        else
            new java.util.ArraysParallelSortHelpers.FJByte.Sorter(null, a, new byte[n], 0, n, 0, ((g = n / (p << 2)) <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN) ? java.util.Arrays.MIN_ARRAY_SORT_GRAN : g)).invoke();

    }

    public static void parallelSort(byte[] a, int fromIndex, int toIndex) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        int n = toIndex - fromIndex;
        int p;
        int g;
        if ((n <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN)) || ((p = java.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1))
            java.util.DualPivotQuicksort.sort(a, fromIndex, (toIndex - 1));
        else
            new java.util.ArraysParallelSortHelpers.FJByte.Sorter(null, a, new byte[n], fromIndex, n, 0, ((g = n / (p << 2)) <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN) ? java.util.Arrays.MIN_ARRAY_SORT_GRAN : g)).invoke();

    }

    public static void parallelSort(char[] a) {
        int n = a.length;
        int p;
        int g;
        if ((n <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN)) || ((p = java.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1))
            java.util.DualPivotQuicksort.sort(a, 0, (n - 1), null, 0, 0);
        else
            new java.util.ArraysParallelSortHelpers.FJChar.Sorter(null, a, new char[n], 0, n, 0, ((g = n / (p << 2)) <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN) ? java.util.Arrays.MIN_ARRAY_SORT_GRAN : g)).invoke();

    }

    public static void parallelSort(char[] a, int fromIndex, int toIndex) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        int n = toIndex - fromIndex;
        int p;
        int g;
        if ((n <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN)) || ((p = java.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1))
            java.util.DualPivotQuicksort.sort(a, fromIndex, (toIndex - 1), null, 0, 0);
        else
            new java.util.ArraysParallelSortHelpers.FJChar.Sorter(null, a, new char[n], fromIndex, n, 0, ((g = n / (p << 2)) <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN) ? java.util.Arrays.MIN_ARRAY_SORT_GRAN : g)).invoke();

    }

    public static void parallelSort(short[] a) {
        int n = a.length;
        int p;
        int g;
        if ((n <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN)) || ((p = java.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1))
            java.util.DualPivotQuicksort.sort(a, 0, (n - 1), null, 0, 0);
        else
            new java.util.ArraysParallelSortHelpers.FJShort.Sorter(null, a, new short[n], 0, n, 0, ((g = n / (p << 2)) <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN) ? java.util.Arrays.MIN_ARRAY_SORT_GRAN : g)).invoke();

    }

    public static void parallelSort(short[] a, int fromIndex, int toIndex) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        int n = toIndex - fromIndex;
        int p;
        int g;
        if ((n <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN)) || ((p = java.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1))
            java.util.DualPivotQuicksort.sort(a, fromIndex, (toIndex - 1), null, 0, 0);
        else
            new java.util.ArraysParallelSortHelpers.FJShort.Sorter(null, a, new short[n], fromIndex, n, 0, ((g = n / (p << 2)) <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN) ? java.util.Arrays.MIN_ARRAY_SORT_GRAN : g)).invoke();

    }

    public static void parallelSort(int[] a) {
        int n = a.length;
        int p;
        int g;
        if ((n <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN)) || ((p = java.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1))
            java.util.DualPivotQuicksort.sort(a, 0, (n - 1), null, 0, 0);
        else
            new java.util.ArraysParallelSortHelpers.FJInt.Sorter(null, a, new int[n], 0, n, 0, ((g = n / (p << 2)) <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN) ? java.util.Arrays.MIN_ARRAY_SORT_GRAN : g)).invoke();

    }

    public static void parallelSort(int[] a, int fromIndex, int toIndex) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        int n = toIndex - fromIndex;
        int p;
        int g;
        if ((n <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN)) || ((p = java.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1))
            java.util.DualPivotQuicksort.sort(a, fromIndex, (toIndex - 1), null, 0, 0);
        else
            new java.util.ArraysParallelSortHelpers.FJInt.Sorter(null, a, new int[n], fromIndex, n, 0, ((g = n / (p << 2)) <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN) ? java.util.Arrays.MIN_ARRAY_SORT_GRAN : g)).invoke();

    }

    public static void parallelSort(long[] a) {
        int n = a.length;
        int p;
        int g;
        if ((n <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN)) || ((p = java.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1))
            java.util.DualPivotQuicksort.sort(a, 0, (n - 1), null, 0, 0);
        else
            new java.util.ArraysParallelSortHelpers.FJLong.Sorter(null, a, new long[n], 0, n, 0, ((g = n / (p << 2)) <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN) ? java.util.Arrays.MIN_ARRAY_SORT_GRAN : g)).invoke();

    }

    public static void parallelSort(long[] a, int fromIndex, int toIndex) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        int n = toIndex - fromIndex;
        int p;
        int g;
        if ((n <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN)) || ((p = java.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1))
            java.util.DualPivotQuicksort.sort(a, fromIndex, (toIndex - 1), null, 0, 0);
        else
            new java.util.ArraysParallelSortHelpers.FJLong.Sorter(null, a, new long[n], fromIndex, n, 0, ((g = n / (p << 2)) <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN) ? java.util.Arrays.MIN_ARRAY_SORT_GRAN : g)).invoke();

    }

    public static void parallelSort(float[] a) {
        int n = a.length;
        int p;
        int g;
        if ((n <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN)) || ((p = java.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1))
            java.util.DualPivotQuicksort.sort(a, 0, (n - 1), null, 0, 0);
        else
            new java.util.ArraysParallelSortHelpers.FJFloat.Sorter(null, a, new float[n], 0, n, 0, ((g = n / (p << 2)) <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN) ? java.util.Arrays.MIN_ARRAY_SORT_GRAN : g)).invoke();

    }

    public static void parallelSort(float[] a, int fromIndex, int toIndex) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        int n = toIndex - fromIndex;
        int p;
        int g;
        if ((n <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN)) || ((p = java.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1))
            java.util.DualPivotQuicksort.sort(a, fromIndex, (toIndex - 1), null, 0, 0);
        else
            new java.util.ArraysParallelSortHelpers.FJFloat.Sorter(null, a, new float[n], fromIndex, n, 0, ((g = n / (p << 2)) <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN) ? java.util.Arrays.MIN_ARRAY_SORT_GRAN : g)).invoke();

    }

    public static void parallelSort(double[] a) {
        int n = a.length;
        int p;
        int g;
        if ((n <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN)) || ((p = java.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1))
            java.util.DualPivotQuicksort.sort(a, 0, (n - 1), null, 0, 0);
        else
            new java.util.ArraysParallelSortHelpers.FJDouble.Sorter(null, a, new double[n], 0, n, 0, ((g = n / (p << 2)) <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN) ? java.util.Arrays.MIN_ARRAY_SORT_GRAN : g)).invoke();

    }

    public static void parallelSort(double[] a, int fromIndex, int toIndex) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        int n = toIndex - fromIndex;
        int p;
        int g;
        if ((n <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN)) || ((p = java.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1))
            java.util.DualPivotQuicksort.sort(a, fromIndex, (toIndex - 1), null, 0, 0);
        else
            new java.util.ArraysParallelSortHelpers.FJDouble.Sorter(null, a, new double[n], fromIndex, n, 0, ((g = n / (p << 2)) <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN) ? java.util.Arrays.MIN_ARRAY_SORT_GRAN : g)).invoke();

    }

    @java.lang.SuppressWarnings("unchecked")
    public static <T extends java.lang.Comparable<? super T>> void parallelSort(T[] a) {
        int n = a.length;
        int p;
        int g;
        if ((n <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN)) || ((p = java.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1))
            java.util.TimSort.sort(a, 0, n, java.util.Arrays.NaturalOrder.INSTANCE, null, 0, 0);
        else
            new java.util.ArraysParallelSortHelpers.FJObject.Sorter<T>(null, a, ((T[]) (java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), n))), 0, n, 0, ((g = n / (p << 2)) <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN) ? java.util.Arrays.MIN_ARRAY_SORT_GRAN : g), java.util.Arrays.NaturalOrder.INSTANCE).invoke();

    }

    @java.lang.SuppressWarnings("unchecked")
    public static <T extends java.lang.Comparable<? super T>> void parallelSort(T[] a, int fromIndex, int toIndex) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        int n = toIndex - fromIndex;
        int p;
        int g;
        if ((n <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN)) || ((p = java.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1))
            java.util.TimSort.sort(a, fromIndex, toIndex, java.util.Arrays.NaturalOrder.INSTANCE, null, 0, 0);
        else
            new java.util.ArraysParallelSortHelpers.FJObject.Sorter<T>(null, a, ((T[]) (java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), n))), fromIndex, n, 0, ((g = n / (p << 2)) <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN) ? java.util.Arrays.MIN_ARRAY_SORT_GRAN : g), java.util.Arrays.NaturalOrder.INSTANCE).invoke();

    }

    @java.lang.SuppressWarnings("unchecked")
    public static <T> void parallelSort(T[] a, java.util.Comparator<? super T> cmp) {
        if (cmp == null)
            cmp = java.util.Arrays.NaturalOrder.INSTANCE;

        int n = a.length;
        int p;
        int g;
        if ((n <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN)) || ((p = java.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1))
            java.util.TimSort.sort(a, 0, n, cmp, null, 0, 0);
        else
            new java.util.ArraysParallelSortHelpers.FJObject.Sorter<T>(null, a, ((T[]) (java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), n))), 0, n, 0, ((g = n / (p << 2)) <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN) ? java.util.Arrays.MIN_ARRAY_SORT_GRAN : g), cmp).invoke();

    }

    @java.lang.SuppressWarnings("unchecked")
    public static <T> void parallelSort(T[] a, int fromIndex, int toIndex, java.util.Comparator<? super T> cmp) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        if (cmp == null)
            cmp = java.util.Arrays.NaturalOrder.INSTANCE;

        int n = toIndex - fromIndex;
        int p;
        int g;
        if ((n <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN)) || ((p = java.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1))
            java.util.TimSort.sort(a, fromIndex, toIndex, cmp, null, 0, 0);
        else
            new java.util.ArraysParallelSortHelpers.FJObject.Sorter<T>(null, a, ((T[]) (java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), n))), fromIndex, n, 0, ((g = n / (p << 2)) <= (java.util.Arrays.MIN_ARRAY_SORT_GRAN) ? java.util.Arrays.MIN_ARRAY_SORT_GRAN : g), cmp).invoke();

    }

    public static void sort(java.lang.Object[] a) {
        if (java.util.Arrays.LegacyMergeSort.userRequested)
            java.util.Arrays.legacyMergeSort(a);
        else
            java.util.ComparableTimSort.sort(a, 0, a.length, null, 0, 0);

    }

    private static void legacyMergeSort(java.lang.Object[] a) {
        java.lang.Object[] aux = a.clone();
        java.util.Arrays.mergeSort(aux, a, 0, a.length, 0);
    }

    public static void sort(java.lang.Object[] a, int fromIndex, int toIndex) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        if (java.util.Arrays.LegacyMergeSort.userRequested)
            java.util.Arrays.legacyMergeSort(a, fromIndex, toIndex);
        else
            java.util.ComparableTimSort.sort(a, fromIndex, toIndex, null, 0, 0);

    }

    private static void legacyMergeSort(java.lang.Object[] a, int fromIndex, int toIndex) {
        java.lang.Object[] aux = java.util.Arrays.copyOfRange(a, fromIndex, toIndex);
        java.util.Arrays.mergeSort(aux, a, fromIndex, toIndex, (-fromIndex));
    }

    @java.lang.SuppressWarnings({ "unchecked", "rawtypes" })
    private static void mergeSort(java.lang.Object[] src, java.lang.Object[] dest, int low, int high, int off) {
        int length = high - low;
        if (length < (java.util.Arrays.INSERTIONSORT_THRESHOLD)) {
            for (int i = low; i < high; i++)
                for (int j = i; (j > low) && ((((java.lang.Comparable) (dest[(j - 1)])).compareTo(dest[j])) > 0); j--)
                    java.util.Arrays.swap(dest, j, (j - 1));


            return ;
        }
        int destLow = low;
        int destHigh = high;
        low += off;
        high += off;
        int mid = (low + high) >>> 1;
        java.util.Arrays.mergeSort(dest, src, low, mid, (-off));
        java.util.Arrays.mergeSort(dest, src, mid, high, (-off));
        if ((((java.lang.Comparable) (src[(mid - 1)])).compareTo(src[mid])) <= 0) {
            java.lang.System.arraycopy(src, low, dest, destLow, length);
            return ;
        }
        for (int i = destLow, p = low, q = mid; i < destHigh; i++) {
            if ((q >= high) || ((p < mid) && ((((java.lang.Comparable) (src[p])).compareTo(src[q])) <= 0)))
                dest[i] = src[(p++)];
            else
                dest[i] = src[(q++)];

        }
    }

    private static void swap(java.lang.Object[] x, int a, int b) {
        java.lang.Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    public static <T> void sort(T[] a, java.util.Comparator<? super T> c) {
        if (c == null) {
            java.util.Arrays.sort(a);
        }else {
            if (java.util.Arrays.LegacyMergeSort.userRequested)
                java.util.Arrays.legacyMergeSort(a, c);
            else
                java.util.TimSort.sort(a, 0, a.length, c, null, 0, 0);

        }
    }

    private static <T> void legacyMergeSort(T[] a, java.util.Comparator<? super T> c) {
        T[] aux = a.clone();
        if (c == null)
            java.util.Arrays.mergeSort(aux, a, 0, a.length, 0);
        else
            java.util.Arrays.mergeSort(aux, a, 0, a.length, 0, c);

    }

    public static <T> void sort(T[] a, int fromIndex, int toIndex, java.util.Comparator<? super T> c) {
        if (c == null) {
            java.util.Arrays.sort(a, fromIndex, toIndex);
        }else {
            java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
            if (java.util.Arrays.LegacyMergeSort.userRequested)
                java.util.Arrays.legacyMergeSort(a, fromIndex, toIndex, c);
            else
                java.util.TimSort.sort(a, fromIndex, toIndex, c, null, 0, 0);

        }
    }

    private static <T> void legacyMergeSort(T[] a, int fromIndex, int toIndex, java.util.Comparator<? super T> c) {
        T[] aux = java.util.Arrays.copyOfRange(a, fromIndex, toIndex);
        if (c == null)
            java.util.Arrays.mergeSort(aux, a, fromIndex, toIndex, (-fromIndex));
        else
            java.util.Arrays.mergeSort(aux, a, fromIndex, toIndex, (-fromIndex), c);

    }

    @java.lang.SuppressWarnings({ "rawtypes", "unchecked" })
    private static void mergeSort(java.lang.Object[] src, java.lang.Object[] dest, int low, int high, int off, java.util.Comparator c) {
        int length = high - low;
        if (length < (java.util.Arrays.INSERTIONSORT_THRESHOLD)) {
            for (int i = low; i < high; i++)
                for (int j = i; (j > low) && ((c.compare(dest[(j - 1)], dest[j])) > 0); j--)
                    java.util.Arrays.swap(dest, j, (j - 1));


            return ;
        }
        int destLow = low;
        int destHigh = high;
        low += off;
        high += off;
        int mid = (low + high) >>> 1;
        java.util.Arrays.mergeSort(dest, src, low, mid, (-off), c);
        java.util.Arrays.mergeSort(dest, src, mid, high, (-off), c);
        if ((c.compare(src[(mid - 1)], src[mid])) <= 0) {
            java.lang.System.arraycopy(src, low, dest, destLow, length);
            return ;
        }
        for (int i = destLow, p = low, q = mid; i < destHigh; i++) {
            if ((q >= high) || ((p < mid) && ((c.compare(src[p], src[q])) <= 0)))
                dest[i] = src[(p++)];
            else
                dest[i] = src[(q++)];

        }
    }

    public static <T> void parallelPrefix(T[] array, java.util.function.BinaryOperator<T> op) {
        java.util.Objects.requireNonNull(op);
        if ((array.length) > 0)
            new java.util.ArrayPrefixHelpers.CumulateTask<>(null, op, array, 0, array.length).invoke();

    }

    public static <T> void parallelPrefix(T[] array, int fromIndex, int toIndex, java.util.function.BinaryOperator<T> op) {
        java.util.Objects.requireNonNull(op);
        java.util.Arrays.rangeCheck(array.length, fromIndex, toIndex);
        if (fromIndex < toIndex)
            new java.util.ArrayPrefixHelpers.CumulateTask<>(null, op, array, fromIndex, toIndex).invoke();

    }

    public static void parallelPrefix(long[] array, java.util.function.LongBinaryOperator op) {
        java.util.Objects.requireNonNull(op);
        if ((array.length) > 0)
            new java.util.ArrayPrefixHelpers.LongCumulateTask(null, op, array, 0, array.length).invoke();

    }

    public static void parallelPrefix(long[] array, int fromIndex, int toIndex, java.util.function.LongBinaryOperator op) {
        java.util.Objects.requireNonNull(op);
        java.util.Arrays.rangeCheck(array.length, fromIndex, toIndex);
        if (fromIndex < toIndex)
            new java.util.ArrayPrefixHelpers.LongCumulateTask(null, op, array, fromIndex, toIndex).invoke();

    }

    public static void parallelPrefix(double[] array, java.util.function.DoubleBinaryOperator op) {
        java.util.Objects.requireNonNull(op);
        if ((array.length) > 0)
            new java.util.ArrayPrefixHelpers.DoubleCumulateTask(null, op, array, 0, array.length).invoke();

    }

    public static void parallelPrefix(double[] array, int fromIndex, int toIndex, java.util.function.DoubleBinaryOperator op) {
        java.util.Objects.requireNonNull(op);
        java.util.Arrays.rangeCheck(array.length, fromIndex, toIndex);
        if (fromIndex < toIndex)
            new java.util.ArrayPrefixHelpers.DoubleCumulateTask(null, op, array, fromIndex, toIndex).invoke();

    }

    public static void parallelPrefix(int[] array, java.util.function.IntBinaryOperator op) {
        java.util.Objects.requireNonNull(op);
        if ((array.length) > 0)
            new java.util.ArrayPrefixHelpers.IntCumulateTask(null, op, array, 0, array.length).invoke();

    }

    public static void parallelPrefix(int[] array, int fromIndex, int toIndex, java.util.function.IntBinaryOperator op) {
        java.util.Objects.requireNonNull(op);
        java.util.Arrays.rangeCheck(array.length, fromIndex, toIndex);
        if (fromIndex < toIndex)
            new java.util.ArrayPrefixHelpers.IntCumulateTask(null, op, array, fromIndex, toIndex).invoke();

    }

    public static int binarySearch(long[] a, long key) {
        return java.util.Arrays.binarySearch0(a, 0, a.length, key);
    }

    public static int binarySearch(long[] a, int fromIndex, int toIndex, long key) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        return java.util.Arrays.binarySearch0(a, fromIndex, toIndex, key);
    }

    private static int binarySearch0(long[] a, int fromIndex, int toIndex, long key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = a[mid];
            if (midVal < key)
                low = mid + 1;
            else
                if (midVal > key)
                    high = mid - 1;
                else
                    return mid;


        } 
        return -(low + 1);
    }

    public static int binarySearch(int[] a, int key) {
        return java.util.Arrays.binarySearch0(a, 0, a.length, key);
    }

    public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        return java.util.Arrays.binarySearch0(a, fromIndex, toIndex, key);
    }

    private static int binarySearch0(int[] a, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];
            if (midVal < key)
                low = mid + 1;
            else
                if (midVal > key)
                    high = mid - 1;
                else
                    return mid;


        } 
        return -(low + 1);
    }

    public static int binarySearch(short[] a, short key) {
        return java.util.Arrays.binarySearch0(a, 0, a.length, key);
    }

    public static int binarySearch(short[] a, int fromIndex, int toIndex, short key) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        return java.util.Arrays.binarySearch0(a, fromIndex, toIndex, key);
    }

    private static int binarySearch0(short[] a, int fromIndex, int toIndex, short key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            short midVal = a[mid];
            if (midVal < key)
                low = mid + 1;
            else
                if (midVal > key)
                    high = mid - 1;
                else
                    return mid;


        } 
        return -(low + 1);
    }

    public static int binarySearch(char[] a, char key) {
        return java.util.Arrays.binarySearch0(a, 0, a.length, key);
    }

    public static int binarySearch(char[] a, int fromIndex, int toIndex, char key) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        return java.util.Arrays.binarySearch0(a, fromIndex, toIndex, key);
    }

    private static int binarySearch0(char[] a, int fromIndex, int toIndex, char key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            char midVal = a[mid];
            if (midVal < key)
                low = mid + 1;
            else
                if (midVal > key)
                    high = mid - 1;
                else
                    return mid;


        } 
        return -(low + 1);
    }

    public static int binarySearch(byte[] a, byte key) {
        return java.util.Arrays.binarySearch0(a, 0, a.length, key);
    }

    public static int binarySearch(byte[] a, int fromIndex, int toIndex, byte key) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        return java.util.Arrays.binarySearch0(a, fromIndex, toIndex, key);
    }

    private static int binarySearch0(byte[] a, int fromIndex, int toIndex, byte key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            byte midVal = a[mid];
            if (midVal < key)
                low = mid + 1;
            else
                if (midVal > key)
                    high = mid - 1;
                else
                    return mid;


        } 
        return -(low + 1);
    }

    public static int binarySearch(double[] a, double key) {
        return java.util.Arrays.binarySearch0(a, 0, a.length, key);
    }

    public static int binarySearch(double[] a, int fromIndex, int toIndex, double key) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        return java.util.Arrays.binarySearch0(a, fromIndex, toIndex, key);
    }

    private static int binarySearch0(double[] a, int fromIndex, int toIndex, double key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            double midVal = a[mid];
            if (midVal < key)
                low = mid + 1;
            else
                if (midVal > key)
                    high = mid - 1;
                else {
                    long midBits = java.lang.Double.doubleToLongBits(midVal);
                    long keyBits = java.lang.Double.doubleToLongBits(key);
                    if (midBits == keyBits)
                        return mid;
                    else
                        if (midBits < keyBits)
                            low = mid + 1;
                        else
                            high = mid - 1;


                }

        } 
        return -(low + 1);
    }

    public static int binarySearch(float[] a, float key) {
        return java.util.Arrays.binarySearch0(a, 0, a.length, key);
    }

    public static int binarySearch(float[] a, int fromIndex, int toIndex, float key) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        return java.util.Arrays.binarySearch0(a, fromIndex, toIndex, key);
    }

    private static int binarySearch0(float[] a, int fromIndex, int toIndex, float key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            float midVal = a[mid];
            if (midVal < key)
                low = mid + 1;
            else
                if (midVal > key)
                    high = mid - 1;
                else {
                    int midBits = java.lang.Float.floatToIntBits(midVal);
                    int keyBits = java.lang.Float.floatToIntBits(key);
                    if (midBits == keyBits)
                        return mid;
                    else
                        if (midBits < keyBits)
                            low = mid + 1;
                        else
                            high = mid - 1;


                }

        } 
        return -(low + 1);
    }

    public static int binarySearch(java.lang.Object[] a, java.lang.Object key) {
        return java.util.Arrays.binarySearch0(a, 0, a.length, key);
    }

    public static int binarySearch(java.lang.Object[] a, int fromIndex, int toIndex, java.lang.Object key) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        return java.util.Arrays.binarySearch0(a, fromIndex, toIndex, key);
    }

    private static int binarySearch0(java.lang.Object[] a, int fromIndex, int toIndex, java.lang.Object key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            @java.lang.SuppressWarnings("rawtypes")
            java.lang.Comparable midVal = ((java.lang.Comparable) (a[mid]));
            @java.lang.SuppressWarnings("unchecked")
            int cmp = midVal.compareTo(key);
            if (cmp < 0)
                low = mid + 1;
            else
                if (cmp > 0)
                    high = mid - 1;
                else
                    return mid;


        } 
        return -(low + 1);
    }

    public static <T> int binarySearch(T[] a, T key, java.util.Comparator<? super T> c) {
        return java.util.Arrays.binarySearch0(a, 0, a.length, key, c);
    }

    public static <T> int binarySearch(T[] a, int fromIndex, int toIndex, T key, java.util.Comparator<? super T> c) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        return java.util.Arrays.binarySearch0(a, fromIndex, toIndex, key, c);
    }

    private static <T> int binarySearch0(T[] a, int fromIndex, int toIndex, T key, java.util.Comparator<? super T> c) {
        if (c == null) {
            return java.util.Arrays.binarySearch0(a, fromIndex, toIndex, key);
        }
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = a[mid];
            int cmp = c.compare(midVal, key);
            if (cmp < 0)
                low = mid + 1;
            else
                if (cmp > 0)
                    high = mid - 1;
                else
                    return mid;


        } 
        return -(low + 1);
    }

    public static boolean equals(long[] a, long[] a2) {
        if (a == a2)
            return true;

        if ((a == null) || (a2 == null))
            return false;

        int length = a.length;
        if ((a2.length) != length)
            return false;

        for (int i = 0; i < length; i++)
            if ((a[i]) != (a2[i]))
                return false;


        return true;
    }

    public static boolean equals(int[] a, int[] a2) {
        if (a == a2)
            return true;

        if ((a == null) || (a2 == null))
            return false;

        int length = a.length;
        if ((a2.length) != length)
            return false;

        for (int i = 0; i < length; i++)
            if ((a[i]) != (a2[i]))
                return false;


        return true;
    }

    public static boolean equals(short[] a, short[] a2) {
        if (a == a2)
            return true;

        if ((a == null) || (a2 == null))
            return false;

        int length = a.length;
        if ((a2.length) != length)
            return false;

        for (int i = 0; i < length; i++)
            if ((a[i]) != (a2[i]))
                return false;


        return true;
    }

    public static boolean equals(char[] a, char[] a2) {
        if (a == a2)
            return true;

        if ((a == null) || (a2 == null))
            return false;

        int length = a.length;
        if ((a2.length) != length)
            return false;

        for (int i = 0; i < length; i++)
            if ((a[i]) != (a2[i]))
                return false;


        return true;
    }

    public static boolean equals(byte[] a, byte[] a2) {
        if (a == a2)
            return true;

        if ((a == null) || (a2 == null))
            return false;

        int length = a.length;
        if ((a2.length) != length)
            return false;

        for (int i = 0; i < length; i++)
            if ((a[i]) != (a2[i]))
                return false;


        return true;
    }

    public static boolean equals(boolean[] a, boolean[] a2) {
        if (a == a2)
            return true;

        if ((a == null) || (a2 == null))
            return false;

        int length = a.length;
        if ((a2.length) != length)
            return false;

        for (int i = 0; i < length; i++)
            if ((a[i]) != (a2[i]))
                return false;


        return true;
    }

    public static boolean equals(double[] a, double[] a2) {
        if (a == a2)
            return true;

        if ((a == null) || (a2 == null))
            return false;

        int length = a.length;
        if ((a2.length) != length)
            return false;

        for (int i = 0; i < length; i++)
            if ((java.lang.Double.doubleToLongBits(a[i])) != (java.lang.Double.doubleToLongBits(a2[i])))
                return false;


        return true;
    }

    public static boolean equals(float[] a, float[] a2) {
        if (a == a2)
            return true;

        if ((a == null) || (a2 == null))
            return false;

        int length = a.length;
        if ((a2.length) != length)
            return false;

        for (int i = 0; i < length; i++)
            if ((java.lang.Float.floatToIntBits(a[i])) != (java.lang.Float.floatToIntBits(a2[i])))
                return false;


        return true;
    }

    public static boolean equals(java.lang.Object[] a, java.lang.Object[] a2) {
        if (a == a2)
            return true;

        if ((a == null) || (a2 == null))
            return false;

        int length = a.length;
        if ((a2.length) != length)
            return false;

        for (int i = 0; i < length; i++) {
            java.lang.Object o1 = a[i];
            java.lang.Object o2 = a2[i];
            if (!(o1 == null ? o2 == null : o1.equals(o2)))
                return false;

        }
        return true;
    }

    public static void fill(long[] a, long val) {
        for (int i = 0, len = a.length; i < len; i++)
            a[i] = val;

    }

    public static void fill(long[] a, int fromIndex, int toIndex, long val) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++)
            a[i] = val;

    }

    public static void fill(int[] a, int val) {
        for (int i = 0, len = a.length; i < len; i++)
            a[i] = val;

    }

    public static void fill(int[] a, int fromIndex, int toIndex, int val) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++)
            a[i] = val;

    }

    public static void fill(short[] a, short val) {
        for (int i = 0, len = a.length; i < len; i++)
            a[i] = val;

    }

    public static void fill(short[] a, int fromIndex, int toIndex, short val) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++)
            a[i] = val;

    }

    public static void fill(char[] a, char val) {
        for (int i = 0, len = a.length; i < len; i++)
            a[i] = val;

    }

    public static void fill(char[] a, int fromIndex, int toIndex, char val) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++)
            a[i] = val;

    }

    public static void fill(byte[] a, byte val) {
        for (int i = 0, len = a.length; i < len; i++)
            a[i] = val;

    }

    public static void fill(byte[] a, int fromIndex, int toIndex, byte val) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++)
            a[i] = val;

    }

    public static void fill(boolean[] a, boolean val) {
        for (int i = 0, len = a.length; i < len; i++)
            a[i] = val;

    }

    public static void fill(boolean[] a, int fromIndex, int toIndex, boolean val) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++)
            a[i] = val;

    }

    public static void fill(double[] a, double val) {
        for (int i = 0, len = a.length; i < len; i++)
            a[i] = val;

    }

    public static void fill(double[] a, int fromIndex, int toIndex, double val) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++)
            a[i] = val;

    }

    public static void fill(float[] a, float val) {
        for (int i = 0, len = a.length; i < len; i++)
            a[i] = val;

    }

    public static void fill(float[] a, int fromIndex, int toIndex, float val) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++)
            a[i] = val;

    }

    public static void fill(java.lang.Object[] a, java.lang.Object val) {
        for (int i = 0, len = a.length; i < len; i++)
            a[i] = val;

    }

    public static void fill(java.lang.Object[] a, int fromIndex, int toIndex, java.lang.Object val) {
        java.util.Arrays.rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++)
            a[i] = val;

    }

    @java.lang.SuppressWarnings("unchecked")
    public static <T> T[] copyOf(T[] original, int newLength) {
        return ((T[]) (java.util.Arrays.copyOf(original, newLength, original.getClass())));
    }

    public static <T, U> T[] copyOf(U[] original, int newLength, java.lang.Class<? extends T[]> newType) {
        @java.lang.SuppressWarnings("unchecked")
        T[] copy = (((java.lang.Object) (newType)) == ((java.lang.Object) (java.lang.Object[].class))) ? ((T[]) (new java.lang.Object[newLength])) : ((T[]) (java.lang.reflect.Array.newInstance(newType.getComponentType(), newLength)));
        java.lang.System.arraycopy(original, 0, copy, 0, java.lang.Math.min(original.length, newLength));
        return copy;
    }

    public static byte[] copyOf(byte[] original, int newLength) {
        byte[] copy = new byte[newLength];
        java.lang.System.arraycopy(original, 0, copy, 0, java.lang.Math.min(original.length, newLength));
        return copy;
    }

    public static short[] copyOf(short[] original, int newLength) {
        short[] copy = new short[newLength];
        java.lang.System.arraycopy(original, 0, copy, 0, java.lang.Math.min(original.length, newLength));
        return copy;
    }

    public static int[] copyOf(int[] original, int newLength) {
        int[] copy = new int[newLength];
        java.lang.System.arraycopy(original, 0, copy, 0, java.lang.Math.min(original.length, newLength));
        return copy;
    }

    public static long[] copyOf(long[] original, int newLength) {
        long[] copy = new long[newLength];
        java.lang.System.arraycopy(original, 0, copy, 0, java.lang.Math.min(original.length, newLength));
        return copy;
    }

    public static char[] copyOf(char[] original, int newLength) {
        char[] copy = new char[newLength];
        java.lang.System.arraycopy(original, 0, copy, 0, java.lang.Math.min(original.length, newLength));
        return copy;
    }

    public static float[] copyOf(float[] original, int newLength) {
        float[] copy = new float[newLength];
        java.lang.System.arraycopy(original, 0, copy, 0, java.lang.Math.min(original.length, newLength));
        return copy;
    }

    public static double[] copyOf(double[] original, int newLength) {
        double[] copy = new double[newLength];
        java.lang.System.arraycopy(original, 0, copy, 0, java.lang.Math.min(original.length, newLength));
        return copy;
    }

    public static boolean[] copyOf(boolean[] original, int newLength) {
        boolean[] copy = new boolean[newLength];
        java.lang.System.arraycopy(original, 0, copy, 0, java.lang.Math.min(original.length, newLength));
        return copy;
    }

    @java.lang.SuppressWarnings("unchecked")
    public static <T> T[] copyOfRange(T[] original, int from, int to) {
        return java.util.Arrays.copyOfRange(original, from, to, ((java.lang.Class<? extends T[]>) (original.getClass())));
    }

    public static <T, U> T[] copyOfRange(U[] original, int from, int to, java.lang.Class<? extends T[]> newType) {
        int newLength = to - from;
        if (newLength < 0)
            throw new java.lang.IllegalArgumentException(((from + " > ") + to));

        @java.lang.SuppressWarnings("unchecked")
        T[] copy = (((java.lang.Object) (newType)) == ((java.lang.Object) (java.lang.Object[].class))) ? ((T[]) (new java.lang.Object[newLength])) : ((T[]) (java.lang.reflect.Array.newInstance(newType.getComponentType(), newLength)));
        java.lang.System.arraycopy(original, from, copy, 0, java.lang.Math.min(((original.length) - from), newLength));
        return copy;
    }

    public static byte[] copyOfRange(byte[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0)
            throw new java.lang.IllegalArgumentException(((from + " > ") + to));

        byte[] copy = new byte[newLength];
        java.lang.System.arraycopy(original, from, copy, 0, java.lang.Math.min(((original.length) - from), newLength));
        return copy;
    }

    public static short[] copyOfRange(short[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0)
            throw new java.lang.IllegalArgumentException(((from + " > ") + to));

        short[] copy = new short[newLength];
        java.lang.System.arraycopy(original, from, copy, 0, java.lang.Math.min(((original.length) - from), newLength));
        return copy;
    }

    public static int[] copyOfRange(int[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0)
            throw new java.lang.IllegalArgumentException(((from + " > ") + to));

        int[] copy = new int[newLength];
        java.lang.System.arraycopy(original, from, copy, 0, java.lang.Math.min(((original.length) - from), newLength));
        return copy;
    }

    public static long[] copyOfRange(long[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0)
            throw new java.lang.IllegalArgumentException(((from + " > ") + to));

        long[] copy = new long[newLength];
        java.lang.System.arraycopy(original, from, copy, 0, java.lang.Math.min(((original.length) - from), newLength));
        return copy;
    }

    public static char[] copyOfRange(char[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0)
            throw new java.lang.IllegalArgumentException(((from + " > ") + to));

        char[] copy = new char[newLength];
        java.lang.System.arraycopy(original, from, copy, 0, java.lang.Math.min(((original.length) - from), newLength));
        return copy;
    }

    public static float[] copyOfRange(float[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0)
            throw new java.lang.IllegalArgumentException(((from + " > ") + to));

        float[] copy = new float[newLength];
        java.lang.System.arraycopy(original, from, copy, 0, java.lang.Math.min(((original.length) - from), newLength));
        return copy;
    }

    public static double[] copyOfRange(double[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0)
            throw new java.lang.IllegalArgumentException(((from + " > ") + to));

        double[] copy = new double[newLength];
        java.lang.System.arraycopy(original, from, copy, 0, java.lang.Math.min(((original.length) - from), newLength));
        return copy;
    }

    public static boolean[] copyOfRange(boolean[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0)
            throw new java.lang.IllegalArgumentException(((from + " > ") + to));

        boolean[] copy = new boolean[newLength];
        java.lang.System.arraycopy(original, from, copy, 0, java.lang.Math.min(((original.length) - from), newLength));
        return copy;
    }

    @java.lang.SafeVarargs
    @java.lang.SuppressWarnings("varargs")
    public static <T> java.util.List<T> asList(T... a) {
        return new java.util.Arrays.ArrayList<>(a);
    }

    public static int hashCode(long[] a) {
        if (a == null)
            return 0;

        int result = 1;
        for (long element : a) {
            int elementHash = ((int) (element ^ (element >>> 32)));
            result = (31 * result) + elementHash;
        }
        return result;
    }

    public static int hashCode(int[] a) {
        if (a == null)
            return 0;

        int result = 1;
        for (int element : a)
            result = (31 * result) + element;

        return result;
    }

    public static int hashCode(short[] a) {
        if (a == null)
            return 0;

        int result = 1;
        for (short element : a)
            result = (31 * result) + element;

        return result;
    }

    public static int hashCode(char[] a) {
        if (a == null)
            return 0;

        int result = 1;
        for (char element : a)
            result = (31 * result) + element;

        return result;
    }

    public static int hashCode(byte[] a) {
        if (a == null)
            return 0;

        int result = 1;
        for (byte element : a)
            result = (31 * result) + element;

        return result;
    }

    public static int hashCode(boolean[] a) {
        if (a == null)
            return 0;

        int result = 1;
        for (boolean element : a)
            result = (31 * result) + (element ? 1231 : 1237);

        return result;
    }

    public static int hashCode(float[] a) {
        if (a == null)
            return 0;

        int result = 1;
        for (float element : a)
            result = (31 * result) + (java.lang.Float.floatToIntBits(element));

        return result;
    }

    public static int hashCode(double[] a) {
        if (a == null)
            return 0;

        int result = 1;
        for (double element : a) {
            long bits = java.lang.Double.doubleToLongBits(element);
            result = (31 * result) + ((int) (bits ^ (bits >>> 32)));
        }
        return result;
    }

    public static int hashCode(java.lang.Object[] a) {
        if (a == null)
            return 0;

        int result = 1;
        for (java.lang.Object element : a)
            result = (31 * result) + (element == null ? 0 : element.hashCode());

        return result;
    }

    public static int deepHashCode(java.lang.Object[] a) {
        if (a == null)
            return 0;

        int result = 1;
        for (java.lang.Object element : a) {
            int elementHash = 0;
            if (element instanceof java.lang.Object[])
                elementHash = java.util.Arrays.deepHashCode(((java.lang.Object[]) (element)));
            else
                if (element instanceof byte[])
                    elementHash = java.util.Arrays.hashCode(((byte[]) (element)));
                else
                    if (element instanceof short[])
                        elementHash = java.util.Arrays.hashCode(((short[]) (element)));
                    else
                        if (element instanceof int[])
                            elementHash = java.util.Arrays.hashCode(((int[]) (element)));
                        else
                            if (element instanceof long[])
                                elementHash = java.util.Arrays.hashCode(((long[]) (element)));
                            else
                                if (element instanceof char[])
                                    elementHash = java.util.Arrays.hashCode(((char[]) (element)));
                                else
                                    if (element instanceof float[])
                                        elementHash = java.util.Arrays.hashCode(((float[]) (element)));
                                    else
                                        if (element instanceof double[])
                                            elementHash = java.util.Arrays.hashCode(((double[]) (element)));
                                        else
                                            if (element instanceof boolean[])
                                                elementHash = java.util.Arrays.hashCode(((boolean[]) (element)));
                                            else
                                                if (element != null)
                                                    elementHash = element.hashCode();










            result = (31 * result) + elementHash;
        }
        return result;
    }

    public static boolean deepEquals(java.lang.Object[] a1, java.lang.Object[] a2) {
        if (a1 == a2)
            return true;

        if ((a1 == null) || (a2 == null))
            return false;

        int length = a1.length;
        if ((a2.length) != length)
            return false;

        for (int i = 0; i < length; i++) {
            java.lang.Object e1 = a1[i];
            java.lang.Object e2 = a2[i];
            if (e1 == e2)
                continue;

            if (e1 == null)
                return false;

            boolean eq = java.util.Arrays.deepEquals0(e1, e2);
            if (!eq)
                return false;

        }
        return true;
    }

    static boolean deepEquals0(java.lang.Object e1, java.lang.Object e2) {
        assert e1 != null;
        boolean eq;
        if ((e1 instanceof java.lang.Object[]) && (e2 instanceof java.lang.Object[]))
            eq = java.util.Arrays.deepEquals(((java.lang.Object[]) (e1)), ((java.lang.Object[]) (e2)));
        else
            if ((e1 instanceof byte[]) && (e2 instanceof byte[]))
                eq = java.util.Arrays.equals(((byte[]) (e1)), ((byte[]) (e2)));
            else
                if ((e1 instanceof short[]) && (e2 instanceof short[]))
                    eq = java.util.Arrays.equals(((short[]) (e1)), ((short[]) (e2)));
                else
                    if ((e1 instanceof int[]) && (e2 instanceof int[]))
                        eq = java.util.Arrays.equals(((int[]) (e1)), ((int[]) (e2)));
                    else
                        if ((e1 instanceof long[]) && (e2 instanceof long[]))
                            eq = java.util.Arrays.equals(((long[]) (e1)), ((long[]) (e2)));
                        else
                            if ((e1 instanceof char[]) && (e2 instanceof char[]))
                                eq = java.util.Arrays.equals(((char[]) (e1)), ((char[]) (e2)));
                            else
                                if ((e1 instanceof float[]) && (e2 instanceof float[]))
                                    eq = java.util.Arrays.equals(((float[]) (e1)), ((float[]) (e2)));
                                else
                                    if ((e1 instanceof double[]) && (e2 instanceof double[]))
                                        eq = java.util.Arrays.equals(((double[]) (e1)), ((double[]) (e2)));
                                    else
                                        if ((e1 instanceof boolean[]) && (e2 instanceof boolean[]))
                                            eq = java.util.Arrays.equals(((boolean[]) (e1)), ((boolean[]) (e2)));
                                        else
                                            eq = e1.equals(e2);









        return eq;
    }

    public static java.lang.String toString(long[] a) {
        if (a == null)
            return "null";

        int iMax = (a.length) - 1;
        if (iMax == (-1))
            return "[]";

        java.lang.StringBuilder b = new java.lang.StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();

            b.append(", ");
        }
    }

    public static java.lang.String toString(int[] a) {
        if (a == null)
            return "null";

        int iMax = (a.length) - 1;
        if (iMax == (-1))
            return "[]";

        java.lang.StringBuilder b = new java.lang.StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();

            b.append(", ");
        }
    }

    public static java.lang.String toString(short[] a) {
        if (a == null)
            return "null";

        int iMax = (a.length) - 1;
        if (iMax == (-1))
            return "[]";

        java.lang.StringBuilder b = new java.lang.StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();

            b.append(", ");
        }
    }

    public static java.lang.String toString(char[] a) {
        if (a == null)
            return "null";

        int iMax = (a.length) - 1;
        if (iMax == (-1))
            return "[]";

        java.lang.StringBuilder b = new java.lang.StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();

            b.append(", ");
        }
    }

    public static java.lang.String toString(byte[] a) {
        if (a == null)
            return "null";

        int iMax = (a.length) - 1;
        if (iMax == (-1))
            return "[]";

        java.lang.StringBuilder b = new java.lang.StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();

            b.append(", ");
        }
    }

    public static java.lang.String toString(boolean[] a) {
        if (a == null)
            return "null";

        int iMax = (a.length) - 1;
        if (iMax == (-1))
            return "[]";

        java.lang.StringBuilder b = new java.lang.StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();

            b.append(", ");
        }
    }

    public static java.lang.String toString(float[] a) {
        if (a == null)
            return "null";

        int iMax = (a.length) - 1;
        if (iMax == (-1))
            return "[]";

        java.lang.StringBuilder b = new java.lang.StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();

            b.append(", ");
        }
    }

    public static java.lang.String toString(double[] a) {
        if (a == null)
            return "null";

        int iMax = (a.length) - 1;
        if (iMax == (-1))
            return "[]";

        java.lang.StringBuilder b = new java.lang.StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();

            b.append(", ");
        }
    }

    public static java.lang.String toString(java.lang.Object[] a) {
        if (a == null)
            return "null";

        int iMax = (a.length) - 1;
        if (iMax == (-1))
            return "[]";

        java.lang.StringBuilder b = new java.lang.StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(java.lang.String.valueOf(a[i]));
            if (i == iMax)
                return b.append(']').toString();

            b.append(", ");
        }
    }

    public static java.lang.String deepToString(java.lang.Object[] a) {
        if (a == null)
            return "null";

        int bufLen = 20 * (a.length);
        if (((a.length) != 0) && (bufLen <= 0))
            bufLen = java.lang.Integer.MAX_VALUE;

        java.lang.StringBuilder buf = new java.lang.StringBuilder(bufLen);
        java.util.Arrays.deepToString(a, buf, new java.util.HashSet<java.lang.Object[]>());
        return buf.toString();
    }

    private static void deepToString(java.lang.Object[] a, java.lang.StringBuilder buf, java.util.Set<java.lang.Object[]> dejaVu) {
        if (a == null) {
            buf.append("null");
            return ;
        }
        int iMax = (a.length) - 1;
        if (iMax == (-1)) {
            buf.append("[]");
            return ;
        }
        dejaVu.add(a);
        buf.append('[');
        for (int i = 0; ; i++) {
            java.lang.Object element = a[i];
            if (element == null) {
                buf.append("null");
            }else {
                java.lang.Class<?> eClass = element.getClass();
                if (eClass.isArray()) {
                    if (eClass == (byte[].class))
                        buf.append(java.util.Arrays.toString(((byte[]) (element))));
                    else
                        if (eClass == (short[].class))
                            buf.append(java.util.Arrays.toString(((short[]) (element))));
                        else
                            if (eClass == (int[].class))
                                buf.append(java.util.Arrays.toString(((int[]) (element))));
                            else
                                if (eClass == (long[].class))
                                    buf.append(java.util.Arrays.toString(((long[]) (element))));
                                else
                                    if (eClass == (char[].class))
                                        buf.append(java.util.Arrays.toString(((char[]) (element))));
                                    else
                                        if (eClass == (float[].class))
                                            buf.append(java.util.Arrays.toString(((float[]) (element))));
                                        else
                                            if (eClass == (double[].class))
                                                buf.append(java.util.Arrays.toString(((double[]) (element))));
                                            else
                                                if (eClass == (boolean[].class))
                                                    buf.append(java.util.Arrays.toString(((boolean[]) (element))));
                                                else {
                                                    if (dejaVu.contains(element))
                                                        buf.append("[...]");
                                                    else
                                                        java.util.Arrays.deepToString(((java.lang.Object[]) (element)), buf, dejaVu);

                                                }







                }else {
                    buf.append(element.toString());
                }
            }
            if (i == iMax)
                break;

            buf.append(", ");
        }
        buf.append(']');
        dejaVu.remove(a);
    }

    public static <T> void setAll(T[] array, java.util.function.IntFunction<? extends T> generator) {
        java.util.Objects.requireNonNull(generator);
        for (int i = 0; i < (array.length); i++)
            array[i] = generator.apply(i);

    }

    public static <T> void parallelSetAll(T[] array, java.util.function.IntFunction<? extends T> generator) {
        java.util.Objects.requireNonNull(generator);
        java.util.stream.IntStream.range(0, array.length).parallel().forEach(( i) -> {
            array[i] = generator.apply(i);
        });
    }

    public static void setAll(int[] array, java.util.function.IntUnaryOperator generator) {
        java.util.Objects.requireNonNull(generator);
        for (int i = 0; i < (array.length); i++)
            array[i] = generator.applyAsInt(i);

    }

    public static void parallelSetAll(int[] array, java.util.function.IntUnaryOperator generator) {
        java.util.Objects.requireNonNull(generator);
        java.util.stream.IntStream.range(0, array.length).parallel().forEach(( i) -> {
            array[i] = generator.applyAsInt(i);
        });
    }

    public static void setAll(long[] array, java.util.function.IntToLongFunction generator) {
        java.util.Objects.requireNonNull(generator);
        for (int i = 0; i < (array.length); i++)
            array[i] = generator.applyAsLong(i);

    }

    public static void parallelSetAll(long[] array, java.util.function.IntToLongFunction generator) {
        java.util.Objects.requireNonNull(generator);
        java.util.stream.IntStream.range(0, array.length).parallel().forEach(( i) -> {
            array[i] = generator.applyAsLong(i);
        });
    }

    public static void setAll(double[] array, java.util.function.IntToDoubleFunction generator) {
        java.util.Objects.requireNonNull(generator);
        for (int i = 0; i < (array.length); i++)
            array[i] = generator.applyAsDouble(i);

    }

    public static void parallelSetAll(double[] array, java.util.function.IntToDoubleFunction generator) {
        java.util.Objects.requireNonNull(generator);
        java.util.stream.IntStream.range(0, array.length).parallel().forEach(( i) -> {
            array[i] = generator.applyAsDouble(i);
        });
    }

    public static <T> java.util.Spliterator<T> spliterator(T[] array) {
        return java.util.Spliterators.spliterator(array, ((java.util.Spliterator.ORDERED) | (java.util.Spliterator.IMMUTABLE)));
    }

    public static <T> java.util.Spliterator<T> spliterator(T[] array, int startInclusive, int endExclusive) {
        return java.util.Spliterators.spliterator(array, startInclusive, endExclusive, ((java.util.Spliterator.ORDERED) | (java.util.Spliterator.IMMUTABLE)));
    }

    public static java.util.Spliterator.OfInt spliterator(int[] array) {
        return java.util.Spliterators.spliterator(array, ((java.util.Spliterator.ORDERED) | (java.util.Spliterator.IMMUTABLE)));
    }

    public static java.util.Spliterator.OfInt spliterator(int[] array, int startInclusive, int endExclusive) {
        return java.util.Spliterators.spliterator(array, startInclusive, endExclusive, ((java.util.Spliterator.ORDERED) | (java.util.Spliterator.IMMUTABLE)));
    }

    public static java.util.Spliterator.OfLong spliterator(long[] array) {
        return java.util.Spliterators.spliterator(array, ((java.util.Spliterator.ORDERED) | (java.util.Spliterator.IMMUTABLE)));
    }

    public static java.util.Spliterator.OfLong spliterator(long[] array, int startInclusive, int endExclusive) {
        return java.util.Spliterators.spliterator(array, startInclusive, endExclusive, ((java.util.Spliterator.ORDERED) | (java.util.Spliterator.IMMUTABLE)));
    }

    public static java.util.Spliterator.OfDouble spliterator(double[] array) {
        return java.util.Spliterators.spliterator(array, ((java.util.Spliterator.ORDERED) | (java.util.Spliterator.IMMUTABLE)));
    }

    public static java.util.Spliterator.OfDouble spliterator(double[] array, int startInclusive, int endExclusive) {
        return java.util.Spliterators.spliterator(array, startInclusive, endExclusive, ((java.util.Spliterator.ORDERED) | (java.util.Spliterator.IMMUTABLE)));
    }

    public static <T> java.util.stream.Stream<T> stream(T[] array) {
        return java.util.Arrays.stream(array, 0, array.length);
    }

    public static <T> java.util.stream.Stream<T> stream(T[] array, int startInclusive, int endExclusive) {
        return java.util.stream.StreamSupport.stream(java.util.Arrays.spliterator(array, startInclusive, endExclusive), false);
    }

    public static java.util.stream.IntStream stream(int[] array) {
        return java.util.Arrays.stream(array, 0, array.length);
    }

    public static java.util.stream.IntStream stream(int[] array, int startInclusive, int endExclusive) {
        return java.util.stream.StreamSupport.intStream(java.util.Arrays.spliterator(array, startInclusive, endExclusive), false);
    }

    public static java.util.stream.LongStream stream(long[] array) {
        return java.util.Arrays.stream(array, 0, array.length);
    }

    public static java.util.stream.LongStream stream(long[] array, int startInclusive, int endExclusive) {
        return java.util.stream.StreamSupport.longStream(java.util.Arrays.spliterator(array, startInclusive, endExclusive), false);
    }

    public static java.util.stream.DoubleStream stream(double[] array) {
        return java.util.Arrays.stream(array, 0, array.length);
    }

    public static java.util.stream.DoubleStream stream(double[] array, int startInclusive, int endExclusive) {
        return java.util.stream.StreamSupport.doubleStream(java.util.Arrays.spliterator(array, startInclusive, endExclusive), false);
    }
}

