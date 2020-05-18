package java.util;


public class HashMap<K, V> extends java.util.AbstractMap<K, V> implements java.io.Serializable , java.lang.Cloneable , java.util.Map<K, V> {
    static class Node<K, V> implements java.util.Map.Entry<K, V> {
        final int hash;

        final K key;

        V value;

        java.util.HashMap.Node<K, V> next;

        Node(int hash, K key, V value, java.util.HashMap.Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final java.lang.String toString() {
            return ((key) + "=") + (value);
        }

        public final int hashCode() {
            return (java.util.Objects.hashCode(key)) ^ (java.util.Objects.hashCode(value));
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(java.lang.Object o) {
            if (o == (this))
                return true;

            if (o instanceof java.util.Map.Entry) {
                java.util.Map.Entry<?, ?> e = ((java.util.Map.Entry<?, ?>) (o));
                if ((java.util.Objects.equals(key, e.getKey())) && (java.util.Objects.equals(value, e.getValue())))
                    return true;

            }
            return false;
        }
    }

    final class KeySet extends java.util.AbstractSet<K> {
        public final int size() {
            return size;
        }

        public final void clear() {
            java.util.HashMap.this.clear();
        }

        public final java.util.Iterator<K> iterator() {
            return new KeyIterator();
        }

        public final boolean contains(java.lang.Object o) {
            return containsKey(o);
        }

        public final boolean remove(java.lang.Object key) {
            return (removeNode(java.util.HashMap.hash(key), key, null, false, true)) != null;
        }

        public final java.util.Spliterator<K> spliterator() {
            return new java.util.HashMap.KeySpliterator<>(java.util.HashMap.this, 0, (-1), 0, 0);
        }

        public final void forEach(java.util.function.Consumer<? super K> action) {
            java.util.HashMap.Node<K, V>[] tab;
            if (action == null)
                throw new java.lang.NullPointerException();

            if (((size) > 0) && ((tab = table) != null)) {
                int mc = modCount;
                for (int i = 0; i < (tab.length); ++i) {
                    for (java.util.HashMap.Node<K, V> e = tab[i]; e != null; e = e.next)
                        action.accept(e.key);

                }
                if ((modCount) != mc)
                    throw new java.util.ConcurrentModificationException();

            }
        }
    }

    final class Values extends java.util.AbstractCollection<V> {
        public final int size() {
            return size;
        }

        public final void clear() {
            java.util.HashMap.this.clear();
        }

        public final java.util.Iterator<V> iterator() {
            return new ValueIterator();
        }

        public final boolean contains(java.lang.Object o) {
            return containsValue(o);
        }

        public final java.util.Spliterator<V> spliterator() {
            return new java.util.HashMap.ValueSpliterator<>(java.util.HashMap.this, 0, (-1), 0, 0);
        }

        public final void forEach(java.util.function.Consumer<? super V> action) {
            java.util.HashMap.Node<K, V>[] tab;
            if (action == null)
                throw new java.lang.NullPointerException();

            if (((size) > 0) && ((tab = table) != null)) {
                int mc = modCount;
                for (int i = 0; i < (tab.length); ++i) {
                    for (java.util.HashMap.Node<K, V> e = tab[i]; e != null; e = e.next)
                        action.accept(e.value);

                }
                if ((modCount) != mc)
                    throw new java.util.ConcurrentModificationException();

            }
        }
    }

    final class EntrySet extends java.util.AbstractSet<java.util.Map.Entry<K, V>> {
        public final int size() {
            return size;
        }

        public final void clear() {
            java.util.HashMap.this.clear();
        }

        public final java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        public final boolean contains(java.lang.Object o) {
            if (!(o instanceof java.util.Map.Entry))
                return false;

            java.util.Map.Entry<?, ?> e = ((java.util.Map.Entry<?, ?>) (o));
            java.lang.Object key = e.getKey();
            java.util.HashMap.Node<K, V> candidate = getNode(java.util.HashMap.hash(key), key);
            return (candidate != null) && (candidate.equals(e));
        }

        public final boolean remove(java.lang.Object o) {
            if (o instanceof java.util.Map.Entry) {
                java.util.Map.Entry<?, ?> e = ((java.util.Map.Entry<?, ?>) (o));
                java.lang.Object key = e.getKey();
                java.lang.Object value = e.getValue();
                return (removeNode(java.util.HashMap.hash(key), key, value, true, true)) != null;
            }
            return false;
        }

        public final java.util.Spliterator<java.util.Map.Entry<K, V>> spliterator() {
            return new java.util.HashMap.EntrySpliterator<>(java.util.HashMap.this, 0, (-1), 0, 0);
        }

        public final void forEach(java.util.function.Consumer<? super java.util.Map.Entry<K, V>> action) {
            java.util.HashMap.Node<K, V>[] tab;
            if (action == null)
                throw new java.lang.NullPointerException();

            if (((size) > 0) && ((tab = table) != null)) {
                int mc = modCount;
                for (int i = 0; i < (tab.length); ++i) {
                    for (java.util.HashMap.Node<K, V> e = tab[i]; e != null; e = e.next)
                        action.accept(e);

                }
                if ((modCount) != mc)
                    throw new java.util.ConcurrentModificationException();

            }
        }
    }

    abstract class HashIterator {
        java.util.HashMap.Node<K, V> next;

        java.util.HashMap.Node<K, V> current;

        int expectedModCount;

        int index;

        HashIterator() {
            expectedModCount = modCount;
            java.util.HashMap.Node<K, V>[] t = table;
            current = next = null;
            index = 0;
            if ((t != null) && ((size) > 0)) {
                do {
                } while (((index) < (t.length)) && ((next = t[((index)++)]) == null) );
            }
        }

        public final boolean hasNext() {
            return (next) != null;
        }

        final java.util.HashMap.Node<K, V> nextNode() {
            java.util.HashMap.Node<K, V>[] t;
            java.util.HashMap.Node<K, V> e = next;
            if ((modCount) != (expectedModCount))
                throw new java.util.ConcurrentModificationException();

            if (e == null)
                throw new java.util.NoSuchElementException();

            if (((next = (current = e).next) == null) && ((t = table) != null)) {
                do {
                } while (((index) < (t.length)) && ((next = t[((index)++)]) == null) );
            }
            return e;
        }

        public final void remove() {
            java.util.HashMap.Node<K, V> p = current;
            if (p == null)
                throw new java.lang.IllegalStateException();

            if ((modCount) != (expectedModCount))
                throw new java.util.ConcurrentModificationException();

            current = null;
            K key = p.key;
            removeNode(java.util.HashMap.hash(key), key, null, false, false);
            expectedModCount = modCount;
        }
    }

    final class KeyIterator extends java.util.HashMap<K, V>.HashIterator implements java.util.Iterator<K> {
        public final K next() {
            return nextNode().key;
        }
    }

    final class ValueIterator extends java.util.HashMap<K, V>.HashIterator implements java.util.Iterator<V> {
        public final V next() {
            return nextNode().value;
        }
    }

    final class EntryIterator extends java.util.HashMap<K, V>.HashIterator implements java.util.Iterator<java.util.Map.Entry<K, V>> {
        public final java.util.Map.Entry<K, V> next() {
            return nextNode();
        }
    }

    static class HashMapSpliterator<K, V> {
        final java.util.HashMap<K, V> map;

        java.util.HashMap.Node<K, V> current;

        int index;

        int fence;

        int est;

        int expectedModCount;

        HashMapSpliterator(java.util.HashMap<K, V> m, int origin, int fence, int est, int expectedModCount) {
            this.map = m;
            this.index = origin;
            this.fence = fence;
            this.est = est;
            this.expectedModCount = expectedModCount;
        }

        final int getFence() {
            int hi;
            if ((hi = fence) < 0) {
                java.util.HashMap<K, V> m = map;
                est = m.size;
                expectedModCount = m.modCount;
                java.util.HashMap.Node<K, V>[] tab = m.table;
                hi = fence = (tab == null) ? 0 : tab.length;
            }
            return hi;
        }

        public final long estimateSize() {
            getFence();
            return ((long) (est));
        }
    }

    static final class KeySpliterator<K, V> extends java.util.HashMap.HashMapSpliterator<K, V> implements java.util.Spliterator<K> {
        KeySpliterator(java.util.HashMap<K, V> m, int origin, int fence, int est, int expectedModCount) {
            super(m, origin, fence, est, expectedModCount);
        }

        public java.util.HashMap.KeySpliterator<K, V> trySplit() {
            int hi = getFence();
            int lo = index;
            int mid = (lo + hi) >>> 1;
            return (lo >= mid) || ((current) != null) ? null : new java.util.HashMap.KeySpliterator<>(map, lo, (index = mid), (est >>>= 1), expectedModCount);
        }

        public void forEachRemaining(java.util.function.Consumer<? super K> action) {
            int i;
            int hi;
            int mc;
            if (action == null)
                throw new java.lang.NullPointerException();

            java.util.HashMap<K, V> m = map;
            java.util.HashMap.Node<K, V>[] tab = m.table;
            if ((hi = fence) < 0) {
                mc = expectedModCount = m.modCount;
                hi = fence = (tab == null) ? 0 : tab.length;
            }else
                mc = expectedModCount;

            if ((((tab != null) && ((tab.length) >= hi)) && ((i = index) >= 0)) && ((i < (index = hi)) || ((current) != null))) {
                java.util.HashMap.Node<K, V> p = current;
                current = null;
                do {
                    if (p == null)
                        p = tab[(i++)];
                    else {
                        action.accept(p.key);
                        p = p.next;
                    }
                } while ((p != null) || (i < hi) );
                if ((m.modCount) != mc)
                    throw new java.util.ConcurrentModificationException();

            }
        }

        public boolean tryAdvance(java.util.function.Consumer<? super K> action) {
            int hi;
            if (action == null)
                throw new java.lang.NullPointerException();

            java.util.HashMap.Node<K, V>[] tab = map.table;
            if (((tab != null) && ((tab.length) >= (hi = getFence()))) && ((index) >= 0)) {
                while (((current) != null) || ((index) < hi)) {
                    if ((current) == null)
                        current = tab[((index)++)];
                    else {
                        K k = current.key;
                        current = current.next;
                        action.accept(k);
                        if ((map.modCount) != (expectedModCount))
                            throw new java.util.ConcurrentModificationException();

                        return true;
                    }
                } 
            }
            return false;
        }

        public int characteristics() {
            return (((fence) < 0) || ((est) == (map.size)) ? java.util.Spliterator.SIZED : 0) | (java.util.Spliterator.DISTINCT);
        }
    }

    static final class ValueSpliterator<K, V> extends java.util.HashMap.HashMapSpliterator<K, V> implements java.util.Spliterator<V> {
        ValueSpliterator(java.util.HashMap<K, V> m, int origin, int fence, int est, int expectedModCount) {
            super(m, origin, fence, est, expectedModCount);
        }

        public java.util.HashMap.ValueSpliterator<K, V> trySplit() {
            int hi = getFence();
            int lo = index;
            int mid = (lo + hi) >>> 1;
            return (lo >= mid) || ((current) != null) ? null : new java.util.HashMap.ValueSpliterator<>(map, lo, (index = mid), (est >>>= 1), expectedModCount);
        }

        public void forEachRemaining(java.util.function.Consumer<? super V> action) {
            int i;
            int hi;
            int mc;
            if (action == null)
                throw new java.lang.NullPointerException();

            java.util.HashMap<K, V> m = map;
            java.util.HashMap.Node<K, V>[] tab = m.table;
            if ((hi = fence) < 0) {
                mc = expectedModCount = m.modCount;
                hi = fence = (tab == null) ? 0 : tab.length;
            }else
                mc = expectedModCount;

            if ((((tab != null) && ((tab.length) >= hi)) && ((i = index) >= 0)) && ((i < (index = hi)) || ((current) != null))) {
                java.util.HashMap.Node<K, V> p = current;
                current = null;
                do {
                    if (p == null)
                        p = tab[(i++)];
                    else {
                        action.accept(p.value);
                        p = p.next;
                    }
                } while ((p != null) || (i < hi) );
                if ((m.modCount) != mc)
                    throw new java.util.ConcurrentModificationException();

            }
        }

        public boolean tryAdvance(java.util.function.Consumer<? super V> action) {
            int hi;
            if (action == null)
                throw new java.lang.NullPointerException();

            java.util.HashMap.Node<K, V>[] tab = map.table;
            if (((tab != null) && ((tab.length) >= (hi = getFence()))) && ((index) >= 0)) {
                while (((current) != null) || ((index) < hi)) {
                    if ((current) == null)
                        current = tab[((index)++)];
                    else {
                        V v = current.value;
                        current = current.next;
                        action.accept(v);
                        if ((map.modCount) != (expectedModCount))
                            throw new java.util.ConcurrentModificationException();

                        return true;
                    }
                } 
            }
            return false;
        }

        public int characteristics() {
            return ((fence) < 0) || ((est) == (map.size)) ? java.util.Spliterator.SIZED : 0;
        }
    }

    static final class EntrySpliterator<K, V> extends java.util.HashMap.HashMapSpliterator<K, V> implements java.util.Spliterator<java.util.Map.Entry<K, V>> {
        EntrySpliterator(java.util.HashMap<K, V> m, int origin, int fence, int est, int expectedModCount) {
            super(m, origin, fence, est, expectedModCount);
        }

        public java.util.HashMap.EntrySpliterator<K, V> trySplit() {
            int hi = getFence();
            int lo = index;
            int mid = (lo + hi) >>> 1;
            return (lo >= mid) || ((current) != null) ? null : new java.util.HashMap.EntrySpliterator<>(map, lo, (index = mid), (est >>>= 1), expectedModCount);
        }

        public void forEachRemaining(java.util.function.Consumer<? super java.util.Map.Entry<K, V>> action) {
            int i;
            int hi;
            int mc;
            if (action == null)
                throw new java.lang.NullPointerException();

            java.util.HashMap<K, V> m = map;
            java.util.HashMap.Node<K, V>[] tab = m.table;
            if ((hi = fence) < 0) {
                mc = expectedModCount = m.modCount;
                hi = fence = (tab == null) ? 0 : tab.length;
            }else
                mc = expectedModCount;

            if ((((tab != null) && ((tab.length) >= hi)) && ((i = index) >= 0)) && ((i < (index = hi)) || ((current) != null))) {
                java.util.HashMap.Node<K, V> p = current;
                current = null;
                do {
                    if (p == null)
                        p = tab[(i++)];
                    else {
                        action.accept(p);
                        p = p.next;
                    }
                } while ((p != null) || (i < hi) );
                if ((m.modCount) != mc)
                    throw new java.util.ConcurrentModificationException();

            }
        }

        public boolean tryAdvance(java.util.function.Consumer<? super java.util.Map.Entry<K, V>> action) {
            int hi;
            if (action == null)
                throw new java.lang.NullPointerException();

            java.util.HashMap.Node<K, V>[] tab = map.table;
            if (((tab != null) && ((tab.length) >= (hi = getFence()))) && ((index) >= 0)) {
                while (((current) != null) || ((index) < hi)) {
                    if ((current) == null)
                        current = tab[((index)++)];
                    else {
                        java.util.HashMap.Node<K, V> e = current;
                        current = current.next;
                        action.accept(e);
                        if ((map.modCount) != (expectedModCount))
                            throw new java.util.ConcurrentModificationException();

                        return true;
                    }
                } 
            }
            return false;
        }

        public int characteristics() {
            return (((fence) < 0) || ((est) == (map.size)) ? java.util.Spliterator.SIZED : 0) | (java.util.Spliterator.DISTINCT);
        }
    }

    static final class TreeNode<K, V> extends java.util.LinkedHashMap.Entry<K, V> {
        java.util.HashMap.TreeNode<K, V> parent;

        java.util.HashMap.TreeNode<K, V> left;

        java.util.HashMap.TreeNode<K, V> right;

        java.util.HashMap.TreeNode<K, V> prev;

        boolean red;

        TreeNode(int hash, K key, V val, java.util.HashMap.Node<K, V> next) {
            super(hash, key, val, next);
        }

        final java.util.HashMap.TreeNode<K, V> root() {
            for (java.util.HashMap.TreeNode<K, V> r = this, p; ;) {
                if ((p = r.parent) == null)
                    return r;

                r = p;
            }
        }

        static <K, V> void moveRootToFront(java.util.HashMap.Node<K, V>[] tab, java.util.HashMap.TreeNode<K, V> root) {
            int n;
            if (((root != null) && (tab != null)) && ((n = tab.length) > 0)) {
                int index = (n - 1) & (root.hash);
                java.util.HashMap.TreeNode<K, V> first = ((java.util.HashMap.TreeNode<K, V>) (tab[index]));
                if (root != first) {
                    java.util.HashMap.Node<K, V> rn;
                    tab[index] = root;
                    java.util.HashMap.TreeNode<K, V> rp = root.prev;
                    if ((rn = root.next) != null)
                        ((java.util.HashMap.TreeNode<K, V>) (rn)).prev = rp;

                    if (rp != null)
                        rp.next = rn;

                    if (first != null)
                        first.prev = root;

                    root.next = first;
                    root.prev = null;
                }
                assert java.util.HashMap.TreeNode.checkInvariants(root);
            }
        }

        final java.util.HashMap.TreeNode<K, V> find(int h, java.lang.Object k, java.lang.Class<?> kc) {
            java.util.HashMap.TreeNode<K, V> p = this;
            do {
                int ph;
                int dir;
                K pk;
                java.util.HashMap.TreeNode<K, V> pl = p.left;
                java.util.HashMap.TreeNode<K, V> pr = p.right;
                java.util.HashMap.TreeNode<K, V> q;
                if ((ph = p.hash) > h)
                    p = pl;
                else
                    if (ph < h)
                        p = pr;
                    else
                        if (((pk = p.key) == k) || ((k != null) && (k.equals(pk))))
                            return p;
                        else
                            if (pl == null)
                                p = pr;
                            else
                                if (pr == null)
                                    p = pl;
                                else
                                    if (((kc != null) || ((kc = java.util.HashMap.comparableClassFor(k)) != null)) && ((dir = java.util.HashMap.compareComparables(kc, k, pk)) != 0))
                                        p = (dir < 0) ? pl : pr;
                                    else
                                        if ((q = pr.find(h, k, kc)) != null)
                                            return q;
                                        else
                                            p = pl;







            } while (p != null );
            return null;
        }

        final java.util.HashMap.TreeNode<K, V> getTreeNode(int h, java.lang.Object k) {
            return ((parent) != null ? root() : this).find(h, k, null);
        }

        static int tieBreakOrder(java.lang.Object a, java.lang.Object b) {
            int d;
            if (((a == null) || (b == null)) || ((d = a.getClass().getName().compareTo(b.getClass().getName())) == 0))
                d = ((java.lang.System.identityHashCode(a)) <= (java.lang.System.identityHashCode(b))) ? -1 : 1;

            return d;
        }

        final void treeify(java.util.HashMap.Node<K, V>[] tab) {
            java.util.HashMap.TreeNode<K, V> root = null;
            for (java.util.HashMap.TreeNode<K, V> x = this, next; x != null; x = next) {
                next = ((java.util.HashMap.TreeNode<K, V>) (x.next));
                x.left = x.right = null;
                if (root == null) {
                    x.parent = null;
                    x.red = false;
                    root = x;
                }else {
                    K k = x.key;
                    int h = x.hash;
                    java.lang.Class<?> kc = null;
                    for (java.util.HashMap.TreeNode<K, V> p = root; ;) {
                        int dir;
                        int ph;
                        K pk = p.key;
                        if ((ph = p.hash) > h)
                            dir = -1;
                        else
                            if (ph < h)
                                dir = 1;
                            else
                                if (((kc == null) && ((kc = java.util.HashMap.comparableClassFor(k)) == null)) || ((dir = java.util.HashMap.compareComparables(kc, k, pk)) == 0))
                                    dir = java.util.HashMap.TreeNode.tieBreakOrder(k, pk);



                        java.util.HashMap.TreeNode<K, V> xp = p;
                        if ((p = (dir <= 0) ? p.left : p.right) == null) {
                            x.parent = xp;
                            if (dir <= 0)
                                xp.left = x;
                            else
                                xp.right = x;

                            root = java.util.HashMap.TreeNode.balanceInsertion(root, x);
                            break;
                        }
                    }
                }
            }
            java.util.HashMap.TreeNode.moveRootToFront(tab, root);
        }

        final java.util.HashMap.Node<K, V> untreeify(java.util.HashMap<K, V> map) {
            java.util.HashMap.Node<K, V> hd = null;
            java.util.HashMap.Node<K, V> tl = null;
            for (java.util.HashMap.Node<K, V> q = this; q != null; q = q.next) {
                java.util.HashMap.Node<K, V> p = map.replacementNode(q, null);
                if (tl == null)
                    hd = p;
                else
                    tl.next = p;

                tl = p;
            }
            return hd;
        }

        final java.util.HashMap.TreeNode<K, V> putTreeVal(java.util.HashMap<K, V> map, java.util.HashMap.Node<K, V>[] tab, int h, K k, V v) {
            java.lang.Class<?> kc = null;
            boolean searched = false;
            java.util.HashMap.TreeNode<K, V> root = ((parent) != null) ? root() : this;
            for (java.util.HashMap.TreeNode<K, V> p = root; ;) {
                int dir;
                int ph;
                K pk;
                if ((ph = p.hash) > h)
                    dir = -1;
                else
                    if (ph < h)
                        dir = 1;
                    else
                        if (((pk = p.key) == k) || ((k != null) && (k.equals(pk))))
                            return p;
                        else
                            if (((kc == null) && ((kc = java.util.HashMap.comparableClassFor(k)) == null)) || ((dir = java.util.HashMap.compareComparables(kc, k, pk)) == 0)) {
                                if (!searched) {
                                    java.util.HashMap.TreeNode<K, V> q;
                                    java.util.HashMap.TreeNode<K, V> ch;
                                    searched = true;
                                    if ((((ch = p.left) != null) && ((q = ch.find(h, k, kc)) != null)) || (((ch = p.right) != null) && ((q = ch.find(h, k, kc)) != null)))
                                        return q;

                                }
                                dir = java.util.HashMap.TreeNode.tieBreakOrder(k, pk);
                            }



                java.util.HashMap.TreeNode<K, V> xp = p;
                if ((p = (dir <= 0) ? p.left : p.right) == null) {
                    java.util.HashMap.Node<K, V> xpn = xp.next;
                    java.util.HashMap.TreeNode<K, V> x = map.newTreeNode(h, k, v, xpn);
                    if (dir <= 0)
                        xp.left = x;
                    else
                        xp.right = x;

                    xp.next = x;
                    x.parent = x.prev = xp;
                    if (xpn != null)
                        ((java.util.HashMap.TreeNode<K, V>) (xpn)).prev = x;

                    java.util.HashMap.TreeNode.moveRootToFront(tab, java.util.HashMap.TreeNode.balanceInsertion(root, x));
                    return null;
                }
            }
        }

        final void removeTreeNode(java.util.HashMap<K, V> map, java.util.HashMap.Node<K, V>[] tab, boolean movable) {
            int n;
            if ((tab == null) || ((n = tab.length) == 0))
                return ;

            int index = (n - 1) & (hash);
            java.util.HashMap.TreeNode<K, V> first = ((java.util.HashMap.TreeNode<K, V>) (tab[index]));
            java.util.HashMap.TreeNode<K, V> root = first;
            java.util.HashMap.TreeNode<K, V> rl;
            java.util.HashMap.TreeNode<K, V> succ = ((java.util.HashMap.TreeNode<K, V>) (next));
            java.util.HashMap.TreeNode<K, V> pred = prev;
            if (pred == null)
                tab[index] = first = succ;
            else
                pred.next = succ;

            if (succ != null)
                succ.prev = pred;

            if (first == null)
                return ;

            if ((root.parent) != null)
                root = root.root();

            if ((((root == null) || ((root.right) == null)) || ((rl = root.left) == null)) || ((rl.left) == null)) {
                tab[index] = first.untreeify(map);
                return ;
            }
            java.util.HashMap.TreeNode<K, V> p = this;
            java.util.HashMap.TreeNode<K, V> pl = left;
            java.util.HashMap.TreeNode<K, V> pr = right;
            java.util.HashMap.TreeNode<K, V> replacement;
            if ((pl != null) && (pr != null)) {
                java.util.HashMap.TreeNode<K, V> s = pr;
                java.util.HashMap.TreeNode<K, V> sl;
                while ((sl = s.left) != null)
                    s = sl;

                boolean c = s.red;
                s.red = p.red;
                p.red = c;
                java.util.HashMap.TreeNode<K, V> sr = s.right;
                java.util.HashMap.TreeNode<K, V> pp = p.parent;
                if (s == pr) {
                    p.parent = s;
                    s.right = p;
                }else {
                    java.util.HashMap.TreeNode<K, V> sp = s.parent;
                    if ((p.parent = sp) != null) {
                        if (s == (sp.left))
                            sp.left = p;
                        else
                            sp.right = p;

                    }
                    if ((s.right = pr) != null)
                        pr.parent = s;

                }
                p.left = null;
                if ((p.right = sr) != null)
                    sr.parent = p;

                if ((s.left = pl) != null)
                    pl.parent = s;

                if ((s.parent = pp) == null)
                    root = s;
                else
                    if (p == (pp.left))
                        pp.left = s;
                    else
                        pp.right = s;


                if (sr != null)
                    replacement = sr;
                else
                    replacement = p;

            }else
                if (pl != null)
                    replacement = pl;
                else
                    if (pr != null)
                        replacement = pr;
                    else
                        replacement = p;



            if (replacement != p) {
                java.util.HashMap.TreeNode<K, V> pp = replacement.parent = p.parent;
                if (pp == null)
                    root = replacement;
                else
                    if (p == (pp.left))
                        pp.left = replacement;
                    else
                        pp.right = replacement;


                p.left = p.right = p.parent = null;
            }
            java.util.HashMap.TreeNode<K, V> r = (p.red) ? root : java.util.HashMap.TreeNode.balanceDeletion(root, replacement);
            if (replacement == p) {
                java.util.HashMap.TreeNode<K, V> pp = p.parent;
                p.parent = null;
                if (pp != null) {
                    if (p == (pp.left))
                        pp.left = null;
                    else
                        if (p == (pp.right))
                            pp.right = null;


                }
            }
            if (movable)
                java.util.HashMap.TreeNode.moveRootToFront(tab, r);

        }

        final void split(java.util.HashMap<K, V> map, java.util.HashMap.Node<K, V>[] tab, int index, int bit) {
            java.util.HashMap.TreeNode<K, V> b = this;
            java.util.HashMap.TreeNode<K, V> loHead = null;
            java.util.HashMap.TreeNode<K, V> loTail = null;
            java.util.HashMap.TreeNode<K, V> hiHead = null;
            java.util.HashMap.TreeNode<K, V> hiTail = null;
            int lc = 0;
            int hc = 0;
            for (java.util.HashMap.TreeNode<K, V> e = b, next; e != null; e = next) {
                next = ((java.util.HashMap.TreeNode<K, V>) (e.next));
                e.next = null;
                if (((e.hash) & bit) == 0) {
                    if ((e.prev = loTail) == null)
                        loHead = e;
                    else
                        loTail.next = e;

                    loTail = e;
                    ++lc;
                }else {
                    if ((e.prev = hiTail) == null)
                        hiHead = e;
                    else
                        hiTail.next = e;

                    hiTail = e;
                    ++hc;
                }
            }
            if (loHead != null) {
                if (lc <= (java.util.HashMap.UNTREEIFY_THRESHOLD))
                    tab[index] = loHead.untreeify(map);
                else {
                    tab[index] = loHead;
                    if (hiHead != null)
                        loHead.treeify(tab);

                }
            }
            if (hiHead != null) {
                if (hc <= (java.util.HashMap.UNTREEIFY_THRESHOLD))
                    tab[(index + bit)] = hiHead.untreeify(map);
                else {
                    tab[(index + bit)] = hiHead;
                    if (loHead != null)
                        hiHead.treeify(tab);

                }
            }
        }

        static <K, V> java.util.HashMap.TreeNode<K, V> rotateLeft(java.util.HashMap.TreeNode<K, V> root, java.util.HashMap.TreeNode<K, V> p) {
            java.util.HashMap.TreeNode<K, V> r;
            java.util.HashMap.TreeNode<K, V> pp;
            java.util.HashMap.TreeNode<K, V> rl;
            if ((p != null) && ((r = p.right) != null)) {
                if ((rl = p.right = r.left) != null)
                    rl.parent = p;

                if ((pp = r.parent = p.parent) == null)
                    (root = r).red = false;
                else
                    if ((pp.left) == p)
                        pp.left = r;
                    else
                        pp.right = r;


                r.left = p;
                p.parent = r;
            }
            return root;
        }

        static <K, V> java.util.HashMap.TreeNode<K, V> rotateRight(java.util.HashMap.TreeNode<K, V> root, java.util.HashMap.TreeNode<K, V> p) {
            java.util.HashMap.TreeNode<K, V> l;
            java.util.HashMap.TreeNode<K, V> pp;
            java.util.HashMap.TreeNode<K, V> lr;
            if ((p != null) && ((l = p.left) != null)) {
                if ((lr = p.left = l.right) != null)
                    lr.parent = p;

                if ((pp = l.parent = p.parent) == null)
                    (root = l).red = false;
                else
                    if ((pp.right) == p)
                        pp.right = l;
                    else
                        pp.left = l;


                l.right = p;
                p.parent = l;
            }
            return root;
        }

        static <K, V> java.util.HashMap.TreeNode<K, V> balanceInsertion(java.util.HashMap.TreeNode<K, V> root, java.util.HashMap.TreeNode<K, V> x) {
            x.red = true;
            for (java.util.HashMap.TreeNode<K, V> xp, xpp, xppl, xppr; ;) {
                if ((xp = x.parent) == null) {
                    x.red = false;
                    return x;
                }else
                    if ((!(xp.red)) || ((xpp = xp.parent) == null))
                        return root;


                if (xp == (xppl = xpp.left)) {
                    if (((xppr = xpp.right) != null) && (xppr.red)) {
                        xppr.red = false;
                        xp.red = false;
                        xpp.red = true;
                        x = xpp;
                    }else {
                        if (x == (xp.right)) {
                            root = java.util.HashMap.TreeNode.rotateLeft(root, (x = xp));
                            xpp = ((xp = x.parent) == null) ? null : xp.parent;
                        }
                        if (xp != null) {
                            xp.red = false;
                            if (xpp != null) {
                                xpp.red = true;
                                root = java.util.HashMap.TreeNode.rotateRight(root, xpp);
                            }
                        }
                    }
                }else {
                    if ((xppl != null) && (xppl.red)) {
                        xppl.red = false;
                        xp.red = false;
                        xpp.red = true;
                        x = xpp;
                    }else {
                        if (x == (xp.left)) {
                            root = java.util.HashMap.TreeNode.rotateRight(root, (x = xp));
                            xpp = ((xp = x.parent) == null) ? null : xp.parent;
                        }
                        if (xp != null) {
                            xp.red = false;
                            if (xpp != null) {
                                xpp.red = true;
                                root = java.util.HashMap.TreeNode.rotateLeft(root, xpp);
                            }
                        }
                    }
                }
            }
        }

        static <K, V> java.util.HashMap.TreeNode<K, V> balanceDeletion(java.util.HashMap.TreeNode<K, V> root, java.util.HashMap.TreeNode<K, V> x) {
            for (java.util.HashMap.TreeNode<K, V> xp, xpl, xpr; ;) {
                if ((x == null) || (x == root))
                    return root;
                else
                    if ((xp = x.parent) == null) {
                        x.red = false;
                        return x;
                    }else
                        if (x.red) {
                            x.red = false;
                            return root;
                        }else
                            if ((xpl = xp.left) == x) {
                                if (((xpr = xp.right) != null) && (xpr.red)) {
                                    xpr.red = false;
                                    xp.red = true;
                                    root = java.util.HashMap.TreeNode.rotateLeft(root, xp);
                                    xpr = ((xp = x.parent) == null) ? null : xp.right;
                                }
                                if (xpr == null)
                                    x = xp;
                                else {
                                    java.util.HashMap.TreeNode<K, V> sl = xpr.left;
                                    java.util.HashMap.TreeNode<K, V> sr = xpr.right;
                                    if (((sr == null) || (!(sr.red))) && ((sl == null) || (!(sl.red)))) {
                                        xpr.red = true;
                                        x = xp;
                                    }else {
                                        if ((sr == null) || (!(sr.red))) {
                                            if (sl != null)
                                                sl.red = false;

                                            xpr.red = true;
                                            root = java.util.HashMap.TreeNode.rotateRight(root, xpr);
                                            xpr = ((xp = x.parent) == null) ? null : xp.right;
                                        }
                                        if (xpr != null) {
                                            xpr.red = (xp == null) ? false : xp.red;
                                            if ((sr = xpr.right) != null)
                                                sr.red = false;

                                        }
                                        if (xp != null) {
                                            xp.red = false;
                                            root = java.util.HashMap.TreeNode.rotateLeft(root, xp);
                                        }
                                        x = root;
                                    }
                                }
                            }else {
                                if ((xpl != null) && (xpl.red)) {
                                    xpl.red = false;
                                    xp.red = true;
                                    root = java.util.HashMap.TreeNode.rotateRight(root, xp);
                                    xpl = ((xp = x.parent) == null) ? null : xp.left;
                                }
                                if (xpl == null)
                                    x = xp;
                                else {
                                    java.util.HashMap.TreeNode<K, V> sl = xpl.left;
                                    java.util.HashMap.TreeNode<K, V> sr = xpl.right;
                                    if (((sl == null) || (!(sl.red))) && ((sr == null) || (!(sr.red)))) {
                                        xpl.red = true;
                                        x = xp;
                                    }else {
                                        if ((sl == null) || (!(sl.red))) {
                                            if (sr != null)
                                                sr.red = false;

                                            xpl.red = true;
                                            root = java.util.HashMap.TreeNode.rotateLeft(root, xpl);
                                            xpl = ((xp = x.parent) == null) ? null : xp.left;
                                        }
                                        if (xpl != null) {
                                            xpl.red = (xp == null) ? false : xp.red;
                                            if ((sl = xpl.left) != null)
                                                sl.red = false;

                                        }
                                        if (xp != null) {
                                            xp.red = false;
                                            root = java.util.HashMap.TreeNode.rotateRight(root, xp);
                                        }
                                        x = root;
                                    }
                                }
                            }



            }
        }

        static <K, V> boolean checkInvariants(java.util.HashMap.TreeNode<K, V> t) {
            java.util.HashMap.TreeNode<K, V> tp = t.parent;
            java.util.HashMap.TreeNode<K, V> tl = t.left;
            java.util.HashMap.TreeNode<K, V> tr = t.right;
            java.util.HashMap.TreeNode<K, V> tb = t.prev;
            java.util.HashMap.TreeNode<K, V> tn = ((java.util.HashMap.TreeNode<K, V>) (t.next));
            if ((tb != null) && ((tb.next) != t))
                return false;

            if ((tn != null) && ((tn.prev) != t))
                return false;

            if (((tp != null) && (t != (tp.left))) && (t != (tp.right)))
                return false;

            if ((tl != null) && (((tl.parent) != t) || ((tl.hash) > (t.hash))))
                return false;

            if ((tr != null) && (((tr.parent) != t) || ((tr.hash) < (t.hash))))
                return false;

            if (((((t.red) && (tl != null)) && (tl.red)) && (tr != null)) && (tr.red))
                return false;

            if ((tl != null) && (!(java.util.HashMap.TreeNode.checkInvariants(tl))))
                return false;

            if ((tr != null) && (!(java.util.HashMap.TreeNode.checkInvariants(tr))))
                return false;

            return true;
        }
    }

    private static final long serialVersionUID = 362498820763181265L;

    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final float DEFAULT_LOAD_FACTOR = 0.75F;

    static final int TREEIFY_THRESHOLD = 8;

    static final int UNTREEIFY_THRESHOLD = 6;

    static final int MIN_TREEIFY_CAPACITY = 64;

    transient java.util.HashMap.Node<K, V>[] table;

    transient java.util.Set<java.util.Map.Entry<K, V>> entrySet;

    transient int size;

    transient int modCount;

    int threshold;

    final float loadFactor;

    static final int hash(java.lang.Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static java.lang.Class<?> comparableClassFor(java.lang.Object x) {
        if (x instanceof java.lang.Comparable) {
            java.lang.Class<?> c;
            java.lang.reflect.Type[] ts;
            java.lang.reflect.Type[] as;
            java.lang.reflect.Type t;
            java.lang.reflect.ParameterizedType p;
            if ((c = x.getClass()) == (java.lang.String.class))
                return c;

            if ((ts = c.getGenericInterfaces()) != null) {
                for (int i = 0; i < (ts.length); ++i) {
                    if ((((((t = ts[i]) instanceof java.lang.reflect.ParameterizedType) && (((p = ((java.lang.reflect.ParameterizedType) (t))).getRawType()) == (java.lang.Comparable.class))) && ((as = p.getActualTypeArguments()) != null)) && ((as.length) == 1)) && ((as[0]) == c))
                        return c;

                }
            }
        }
        return null;
    }

    @java.lang.SuppressWarnings({ "rawtypes", "unchecked" })
    static int compareComparables(java.lang.Class<?> kc, java.lang.Object k, java.lang.Object x) {
        return (x == null) || ((x.getClass()) != kc) ? 0 : ((java.lang.Comparable) (k)).compareTo(x);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n < 0 ? 1 : n >= (java.util.HashMap.MAXIMUM_CAPACITY) ? java.util.HashMap.MAXIMUM_CAPACITY : n + 1;
    }

    public HashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new java.lang.IllegalArgumentException(("Illegal initial capacity: " + initialCapacity));

        if (initialCapacity > (java.util.HashMap.MAXIMUM_CAPACITY))
            initialCapacity = java.util.HashMap.MAXIMUM_CAPACITY;

        if ((loadFactor <= 0) || (java.lang.Float.isNaN(loadFactor)))
            throw new java.lang.IllegalArgumentException(("Illegal load factor: " + loadFactor));

        this.loadFactor = loadFactor;
        this.threshold = java.util.HashMap.tableSizeFor(initialCapacity);
    }

    public HashMap(int initialCapacity) {
        this(initialCapacity, java.util.HashMap.DEFAULT_LOAD_FACTOR);
    }

    public HashMap() {
        this.loadFactor = java.util.HashMap.DEFAULT_LOAD_FACTOR;
    }

    public HashMap(java.util.Map<? extends K, ? extends V> m) {
        this.loadFactor = java.util.HashMap.DEFAULT_LOAD_FACTOR;
        putMapEntries(m, false);
    }

    final void putMapEntries(java.util.Map<? extends K, ? extends V> m, boolean evict) {
        int s = m.size();
        if (s > 0) {
            if ((table) == null) {
                float ft = (((float) (s)) / (loadFactor)) + 1.0F;
                int t = (ft < ((float) (java.util.HashMap.MAXIMUM_CAPACITY))) ? ((int) (ft)) : java.util.HashMap.MAXIMUM_CAPACITY;
                if (t > (threshold))
                    threshold = java.util.HashMap.tableSizeFor(t);

            }else
                if (s > (threshold))
                    resize();


            for (java.util.Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
                K key = e.getKey();
                V value = e.getValue();
                putVal(java.util.HashMap.hash(key), key, value, false, evict);
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size) == 0;
    }

    public V get(java.lang.Object key) {
        java.util.HashMap.Node<K, V> e;
        return (e = getNode(java.util.HashMap.hash(key), key)) == null ? null : e.value;
    }

    final java.util.HashMap.Node<K, V> getNode(int hash, java.lang.Object key) {
        java.util.HashMap.Node<K, V>[] tab;
        java.util.HashMap.Node<K, V> first;
        java.util.HashMap.Node<K, V> e;
        int n;
        K k;
        if ((((tab = table) != null) && ((n = tab.length) > 0)) && ((first = tab[((n - 1) & hash)]) != null)) {
            if (((first.hash) == hash) && (((k = first.key) == key) || ((key != null) && (key.equals(k)))))
                return first;

            if ((e = first.next) != null) {
                if (first instanceof java.util.HashMap.TreeNode)
                    return ((java.util.HashMap.TreeNode<K, V>) (first)).getTreeNode(hash, key);

                do {
                    if (((e.hash) == hash) && (((k = e.key) == key) || ((key != null) && (key.equals(k)))))
                        return e;

                } while ((e = e.next) != null );
            }
        }
        return null;
    }

    public boolean containsKey(java.lang.Object key) {
        return (getNode(java.util.HashMap.hash(key), key)) != null;
    }

    public V put(K key, V value) {
        return putVal(java.util.HashMap.hash(key), key, value, false, true);
    }

    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        java.util.HashMap.Node<K, V>[] tab;
        java.util.HashMap.Node<K, V> p;
        int n;
        int i;
        if (((tab = table) == null) || ((n = tab.length) == 0))
            n = (tab = resize()).length;

        if ((p = tab[(i = (n - 1) & hash)]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            java.util.HashMap.Node<K, V> e;
            K k;
            if (((p.hash) == hash) && (((k = p.key) == key) || ((key != null) && (key.equals(k)))))
                e = p;
            else
                if (p instanceof java.util.HashMap.TreeNode)
                    e = ((java.util.HashMap.TreeNode<K, V>) (p)).putTreeVal(this, tab, hash, key, value);
                else {
                    for (int binCount = 0; ; ++binCount) {
                        if ((e = p.next) == null) {
                            p.next = newNode(hash, key, value, null);
                            if (binCount >= ((java.util.HashMap.TREEIFY_THRESHOLD) - 1))
                                treeifyBin(tab, hash);

                            break;
                        }
                        if (((e.hash) == hash) && (((k = e.key) == key) || ((key != null) && (key.equals(k)))))
                            break;

                        p = e;
                    }
                }

            if (e != null) {
                V oldValue = e.value;
                if ((!onlyIfAbsent) || (oldValue == null))
                    e.value = value;

                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++(modCount);
        if ((++(size)) > (threshold))
            resize();

        afterNodeInsertion(evict);
        return null;
    }

    final java.util.HashMap.Node<K, V>[] resize() {
        java.util.HashMap.Node<K, V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap;
        int newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= (java.util.HashMap.MAXIMUM_CAPACITY)) {
                threshold = java.lang.Integer.MAX_VALUE;
                return oldTab;
            }else
                if (((newCap = oldCap << 1) < (java.util.HashMap.MAXIMUM_CAPACITY)) && (oldCap >= (java.util.HashMap.DEFAULT_INITIAL_CAPACITY)))
                    newThr = oldThr << 1;


        }else
            if (oldThr > 0)
                newCap = oldThr;
            else {
                newCap = java.util.HashMap.DEFAULT_INITIAL_CAPACITY;
                newThr = ((int) ((java.util.HashMap.DEFAULT_LOAD_FACTOR) * (java.util.HashMap.DEFAULT_INITIAL_CAPACITY)));
            }

        if (newThr == 0) {
            float ft = ((float) (newCap)) * (loadFactor);
            newThr = ((newCap < (java.util.HashMap.MAXIMUM_CAPACITY)) && (ft < ((float) (java.util.HashMap.MAXIMUM_CAPACITY)))) ? ((int) (ft)) : java.lang.Integer.MAX_VALUE;
        }
        threshold = newThr;
        @java.lang.SuppressWarnings({ "rawtypes", "unchecked" })
        java.util.HashMap.Node<K, V>[] newTab = ((java.util.HashMap.Node<K, V>[]) (new java.util.HashMap.Node[newCap]));
        table = newTab;
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                java.util.HashMap.Node<K, V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if ((e.next) == null)
                        newTab[((e.hash) & (newCap - 1))] = e;
                    else
                        if (e instanceof java.util.HashMap.TreeNode)
                            ((java.util.HashMap.TreeNode<K, V>) (e)).split(this, newTab, j, oldCap);
                        else {
                            java.util.HashMap.Node<K, V> loHead = null;
                            java.util.HashMap.Node<K, V> loTail = null;
                            java.util.HashMap.Node<K, V> hiHead = null;
                            java.util.HashMap.Node<K, V> hiTail = null;
                            java.util.HashMap.Node<K, V> next;
                            do {
                                next = e.next;
                                if (((e.hash) & oldCap) == 0) {
                                    if (loTail == null)
                                        loHead = e;
                                    else
                                        loTail.next = e;

                                    loTail = e;
                                }else {
                                    if (hiTail == null)
                                        hiHead = e;
                                    else
                                        hiTail.next = e;

                                    hiTail = e;
                                }
                            } while ((e = next) != null );
                            if (loTail != null) {
                                loTail.next = null;
                                newTab[j] = loHead;
                            }
                            if (hiTail != null) {
                                hiTail.next = null;
                                newTab[(j + oldCap)] = hiHead;
                            }
                        }

                }
            }
        }
        return newTab;
    }

    final void treeifyBin(java.util.HashMap.Node<K, V>[] tab, int hash) {
        int n;
        int index;
        java.util.HashMap.Node<K, V> e;
        if ((tab == null) || ((n = tab.length) < (java.util.HashMap.MIN_TREEIFY_CAPACITY)))
            resize();
        else
            if ((e = tab[(index = (n - 1) & hash)]) != null) {
                java.util.HashMap.TreeNode<K, V> hd = null;
                java.util.HashMap.TreeNode<K, V> tl = null;
                do {
                    java.util.HashMap.TreeNode<K, V> p = replacementTreeNode(e, null);
                    if (tl == null)
                        hd = p;
                    else {
                        p.prev = tl;
                        tl.next = p;
                    }
                    tl = p;
                } while ((e = e.next) != null );
                if ((tab[index] = hd) != null)
                    hd.treeify(tab);

            }

    }

    public void putAll(java.util.Map<? extends K, ? extends V> m) {
        putMapEntries(m, true);
    }

    public V remove(java.lang.Object key) {
        java.util.HashMap.Node<K, V> e;
        return (e = removeNode(java.util.HashMap.hash(key), key, null, false, true)) == null ? null : e.value;
    }

    final java.util.HashMap.Node<K, V> removeNode(int hash, java.lang.Object key, java.lang.Object value, boolean matchValue, boolean movable) {
        java.util.HashMap.Node<K, V>[] tab;
        java.util.HashMap.Node<K, V> p;
        int n;
        int index;
        if ((((tab = table) != null) && ((n = tab.length) > 0)) && ((p = tab[(index = (n - 1) & hash)]) != null)) {
            java.util.HashMap.Node<K, V> node = null;
            java.util.HashMap.Node<K, V> e;
            K k;
            V v;
            if (((p.hash) == hash) && (((k = p.key) == key) || ((key != null) && (key.equals(k)))))
                node = p;
            else
                if ((e = p.next) != null) {
                    if (p instanceof java.util.HashMap.TreeNode)
                        node = ((java.util.HashMap.TreeNode<K, V>) (p)).getTreeNode(hash, key);
                    else {
                        do {
                            if (((e.hash) == hash) && (((k = e.key) == key) || ((key != null) && (key.equals(k))))) {
                                node = e;
                                break;
                            }
                            p = e;
                        } while ((e = e.next) != null );
                    }
                }

            if ((node != null) && (((!matchValue) || ((v = node.value) == value)) || ((value != null) && (value.equals(v))))) {
                if (node instanceof java.util.HashMap.TreeNode)
                    ((java.util.HashMap.TreeNode<K, V>) (node)).removeTreeNode(this, tab, movable);
                else
                    if (node == p)
                        tab[index] = node.next;
                    else
                        p.next = node.next;


                ++(modCount);
                --(size);
                afterNodeRemoval(node);
                return node;
            }
        }
        return null;
    }

    public void clear() {
        java.util.HashMap.Node<K, V>[] tab;
        (modCount)++;
        if (((tab = table) != null) && ((size) > 0)) {
            size = 0;
            for (int i = 0; i < (tab.length); ++i)
                tab[i] = null;

        }
    }

    public boolean containsValue(java.lang.Object value) {
        java.util.HashMap.Node<K, V>[] tab;
        V v;
        if (((tab = table) != null) && ((size) > 0)) {
            for (int i = 0; i < (tab.length); ++i) {
                for (java.util.HashMap.Node<K, V> e = tab[i]; e != null; e = e.next) {
                    if (((v = e.value) == value) || ((value != null) && (value.equals(v))))
                        return true;

                }
            }
        }
        return false;
    }

    public java.util.Set<K> keySet() {
        java.util.Set<K> ks = keySet;
        if (ks == null) {
            ks = new KeySet();
            keySet = ks;
        }
        return ks;
    }

    public java.util.Collection<V> values() {
        java.util.Collection<V> vs = values;
        if (vs == null) {
            vs = new Values();
            values = vs;
        }
        return vs;
    }

    public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
        java.util.Set<java.util.Map.Entry<K, V>> es;
        return (es = entrySet) == null ? entrySet = new EntrySet() : es;
    }

    @java.lang.Override
    public V getOrDefault(java.lang.Object key, V defaultValue) {
        java.util.HashMap.Node<K, V> e;
        return (e = getNode(java.util.HashMap.hash(key), key)) == null ? defaultValue : e.value;
    }

    @java.lang.Override
    public V putIfAbsent(K key, V value) {
        return putVal(java.util.HashMap.hash(key), key, value, true, true);
    }

    @java.lang.Override
    public boolean remove(java.lang.Object key, java.lang.Object value) {
        return (removeNode(java.util.HashMap.hash(key), key, value, true, true)) != null;
    }

    @java.lang.Override
    public boolean replace(K key, V oldValue, V newValue) {
        java.util.HashMap.Node<K, V> e;
        V v;
        if (((e = getNode(java.util.HashMap.hash(key), key)) != null) && (((v = e.value) == oldValue) || ((v != null) && (v.equals(oldValue))))) {
            e.value = newValue;
            afterNodeAccess(e);
            return true;
        }
        return false;
    }

    @java.lang.Override
    public V replace(K key, V value) {
        java.util.HashMap.Node<K, V> e;
        if ((e = getNode(java.util.HashMap.hash(key), key)) != null) {
            V oldValue = e.value;
            e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
        return null;
    }

    @java.lang.Override
    public V computeIfAbsent(K key, java.util.function.Function<? super K, ? extends V> mappingFunction) {
        if (mappingFunction == null)
            throw new java.lang.NullPointerException();

        int hash = java.util.HashMap.hash(key);
        java.util.HashMap.Node<K, V>[] tab;
        java.util.HashMap.Node<K, V> first;
        int n;
        int i;
        int binCount = 0;
        java.util.HashMap.TreeNode<K, V> t = null;
        java.util.HashMap.Node<K, V> old = null;
        if ((((size) > (threshold)) || ((tab = table) == null)) || ((n = tab.length) == 0))
            n = (tab = resize()).length;

        if ((first = tab[(i = (n - 1) & hash)]) != null) {
            if (first instanceof java.util.HashMap.TreeNode)
                old = (t = ((java.util.HashMap.TreeNode<K, V>) (first))).getTreeNode(hash, key);
            else {
                java.util.HashMap.Node<K, V> e = first;
                K k;
                do {
                    if (((e.hash) == hash) && (((k = e.key) == key) || ((key != null) && (key.equals(k))))) {
                        old = e;
                        break;
                    }
                    ++binCount;
                } while ((e = e.next) != null );
            }
            V oldValue;
            if ((old != null) && ((oldValue = old.value) != null)) {
                afterNodeAccess(old);
                return oldValue;
            }
        }
        V v = mappingFunction.apply(key);
        if (v == null) {
            return null;
        }else
            if (old != null) {
                old.value = v;
                afterNodeAccess(old);
                return v;
            }else
                if (t != null)
                    t.putTreeVal(this, tab, hash, key, v);
                else {
                    tab[i] = newNode(hash, key, v, first);
                    if (binCount >= ((java.util.HashMap.TREEIFY_THRESHOLD) - 1))
                        treeifyBin(tab, hash);

                }


        ++(modCount);
        ++(size);
        afterNodeInsertion(true);
        return v;
    }

    public V computeIfPresent(K key, java.util.function.BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        if (remappingFunction == null)
            throw new java.lang.NullPointerException();

        java.util.HashMap.Node<K, V> e;
        V oldValue;
        int hash = java.util.HashMap.hash(key);
        if (((e = getNode(hash, key)) != null) && ((oldValue = e.value) != null)) {
            V v = remappingFunction.apply(key, oldValue);
            if (v != null) {
                e.value = v;
                afterNodeAccess(e);
                return v;
            }else
                removeNode(hash, key, null, false, true);

        }
        return null;
    }

    @java.lang.Override
    public V compute(K key, java.util.function.BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        if (remappingFunction == null)
            throw new java.lang.NullPointerException();

        int hash = java.util.HashMap.hash(key);
        java.util.HashMap.Node<K, V>[] tab;
        java.util.HashMap.Node<K, V> first;
        int n;
        int i;
        int binCount = 0;
        java.util.HashMap.TreeNode<K, V> t = null;
        java.util.HashMap.Node<K, V> old = null;
        if ((((size) > (threshold)) || ((tab = table) == null)) || ((n = tab.length) == 0))
            n = (tab = resize()).length;

        if ((first = tab[(i = (n - 1) & hash)]) != null) {
            if (first instanceof java.util.HashMap.TreeNode)
                old = (t = ((java.util.HashMap.TreeNode<K, V>) (first))).getTreeNode(hash, key);
            else {
                java.util.HashMap.Node<K, V> e = first;
                K k;
                do {
                    if (((e.hash) == hash) && (((k = e.key) == key) || ((key != null) && (key.equals(k))))) {
                        old = e;
                        break;
                    }
                    ++binCount;
                } while ((e = e.next) != null );
            }
        }
        V oldValue = (old == null) ? null : old.value;
        V v = remappingFunction.apply(key, oldValue);
        if (old != null) {
            if (v != null) {
                old.value = v;
                afterNodeAccess(old);
            }else
                removeNode(hash, key, null, false, true);

        }else
            if (v != null) {
                if (t != null)
                    t.putTreeVal(this, tab, hash, key, v);
                else {
                    tab[i] = newNode(hash, key, v, first);
                    if (binCount >= ((java.util.HashMap.TREEIFY_THRESHOLD) - 1))
                        treeifyBin(tab, hash);

                }
                ++(modCount);
                ++(size);
                afterNodeInsertion(true);
            }

        return v;
    }

    @java.lang.Override
    public V merge(K key, V value, java.util.function.BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        if (value == null)
            throw new java.lang.NullPointerException();

        if (remappingFunction == null)
            throw new java.lang.NullPointerException();

        int hash = java.util.HashMap.hash(key);
        java.util.HashMap.Node<K, V>[] tab;
        java.util.HashMap.Node<K, V> first;
        int n;
        int i;
        int binCount = 0;
        java.util.HashMap.TreeNode<K, V> t = null;
        java.util.HashMap.Node<K, V> old = null;
        if ((((size) > (threshold)) || ((tab = table) == null)) || ((n = tab.length) == 0))
            n = (tab = resize()).length;

        if ((first = tab[(i = (n - 1) & hash)]) != null) {
            if (first instanceof java.util.HashMap.TreeNode)
                old = (t = ((java.util.HashMap.TreeNode<K, V>) (first))).getTreeNode(hash, key);
            else {
                java.util.HashMap.Node<K, V> e = first;
                K k;
                do {
                    if (((e.hash) == hash) && (((k = e.key) == key) || ((key != null) && (key.equals(k))))) {
                        old = e;
                        break;
                    }
                    ++binCount;
                } while ((e = e.next) != null );
            }
        }
        if (old != null) {
            V v;
            if ((old.value) != null)
                v = remappingFunction.apply(old.value, value);
            else
                v = value;

            if (v != null) {
                old.value = v;
                afterNodeAccess(old);
            }else
                removeNode(hash, key, null, false, true);

            return v;
        }
        if (value != null) {
            if (t != null)
                t.putTreeVal(this, tab, hash, key, value);
            else {
                tab[i] = newNode(hash, key, value, first);
                if (binCount >= ((java.util.HashMap.TREEIFY_THRESHOLD) - 1))
                    treeifyBin(tab, hash);

            }
            ++(modCount);
            ++(size);
            afterNodeInsertion(true);
        }
        return value;
    }

    @java.lang.Override
    public void forEach(java.util.function.BiConsumer<? super K, ? super V> action) {
        java.util.HashMap.Node<K, V>[] tab;
        if (action == null)
            throw new java.lang.NullPointerException();

        if (((size) > 0) && ((tab = table) != null)) {
            int mc = modCount;
            for (int i = 0; i < (tab.length); ++i) {
                for (java.util.HashMap.Node<K, V> e = tab[i]; e != null; e = e.next)
                    action.accept(e.key, e.value);

            }
            if ((modCount) != mc)
                throw new java.util.ConcurrentModificationException();

        }
    }

    @java.lang.Override
    public void replaceAll(java.util.function.BiFunction<? super K, ? super V, ? extends V> function) {
        java.util.HashMap.Node<K, V>[] tab;
        if (function == null)
            throw new java.lang.NullPointerException();

        if (((size) > 0) && ((tab = table) != null)) {
            int mc = modCount;
            for (int i = 0; i < (tab.length); ++i) {
                for (java.util.HashMap.Node<K, V> e = tab[i]; e != null; e = e.next) {
                    e.value = function.apply(e.key, e.value);
                }
            }
            if ((modCount) != mc)
                throw new java.util.ConcurrentModificationException();

        }
    }

    @java.lang.SuppressWarnings("unchecked")
    @java.lang.Override
    public java.lang.Object clone() {
        java.util.HashMap<K, V> result;
        try {
            result = ((java.util.HashMap<K, V>) (super.clone()));
        } catch (java.lang.CloneNotSupportedException e) {
            throw new java.lang.InternalError(e);
        }
        result.reinitialize();
        result.putMapEntries(this, false);
        return result;
    }

    final float loadFactor() {
        return loadFactor;
    }

    final int capacity() {
        return (table) != null ? table.length : (threshold) > 0 ? threshold : java.util.HashMap.DEFAULT_INITIAL_CAPACITY;
    }

    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        int buckets = capacity();
        s.defaultWriteObject();
        s.writeInt(buckets);
        s.writeInt(size);
        internalWriteEntries(s);
    }

    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, java.lang.ClassNotFoundException {
        s.defaultReadObject();
        reinitialize();
        if (((loadFactor) <= 0) || (java.lang.Float.isNaN(loadFactor)))
            throw new java.io.InvalidObjectException(("Illegal load factor: " + (loadFactor)));

        s.readInt();
        int mappings = s.readInt();
        if (mappings < 0)
            throw new java.io.InvalidObjectException(("Illegal mappings count: " + mappings));
        else
            if (mappings > 0) {
                float lf = java.lang.Math.min(java.lang.Math.max(0.25F, loadFactor), 4.0F);
                float fc = (((float) (mappings)) / lf) + 1.0F;
                int cap = (fc < (java.util.HashMap.DEFAULT_INITIAL_CAPACITY)) ? java.util.HashMap.DEFAULT_INITIAL_CAPACITY : fc >= (java.util.HashMap.MAXIMUM_CAPACITY) ? java.util.HashMap.MAXIMUM_CAPACITY : java.util.HashMap.tableSizeFor(((int) (fc)));
                float ft = ((float) (cap)) * lf;
                threshold = ((cap < (java.util.HashMap.MAXIMUM_CAPACITY)) && (ft < (java.util.HashMap.MAXIMUM_CAPACITY))) ? ((int) (ft)) : java.lang.Integer.MAX_VALUE;
                @java.lang.SuppressWarnings({ "rawtypes", "unchecked" })
                java.util.HashMap.Node<K, V>[] tab = ((java.util.HashMap.Node<K, V>[]) (new java.util.HashMap.Node[cap]));
                table = tab;
                for (int i = 0; i < mappings; i++) {
                    @java.lang.SuppressWarnings("unchecked")
                    K key = ((K) (s.readObject()));
                    @java.lang.SuppressWarnings("unchecked")
                    V value = ((V) (s.readObject()));
                    putVal(java.util.HashMap.hash(key), key, value, false, false);
                }
            }

    }

    java.util.HashMap.Node<K, V> newNode(int hash, K key, V value, java.util.HashMap.Node<K, V> next) {
        return new java.util.HashMap.Node<>(hash, key, value, next);
    }

    java.util.HashMap.Node<K, V> replacementNode(java.util.HashMap.Node<K, V> p, java.util.HashMap.Node<K, V> next) {
        return new java.util.HashMap.Node<>(p.hash, p.key, p.value, next);
    }

    java.util.HashMap.TreeNode<K, V> newTreeNode(int hash, K key, V value, java.util.HashMap.Node<K, V> next) {
        return new java.util.HashMap.TreeNode<>(hash, key, value, next);
    }

    java.util.HashMap.TreeNode<K, V> replacementTreeNode(java.util.HashMap.Node<K, V> p, java.util.HashMap.Node<K, V> next) {
        return new java.util.HashMap.TreeNode<>(p.hash, p.key, p.value, next);
    }

    void reinitialize() {
        table = null;
        entrySet = null;
        keySet = null;
        values = null;
        modCount = 0;
        threshold = 0;
        size = 0;
    }

    void afterNodeAccess(java.util.HashMap.Node<K, V> p) {
    }

    void afterNodeInsertion(boolean evict) {
    }

    void afterNodeRemoval(java.util.HashMap.Node<K, V> p) {
    }

    void internalWriteEntries(java.io.ObjectOutputStream s) throws java.io.IOException {
        java.util.HashMap.Node<K, V>[] tab;
        if (((size) > 0) && ((tab = table) != null)) {
            for (int i = 0; i < (tab.length); ++i) {
                for (java.util.HashMap.Node<K, V> e = tab[i]; e != null; e = e.next) {
                    s.writeObject(e.key);
                    s.writeObject(e.value);
                }
            }
        }
    }
}

