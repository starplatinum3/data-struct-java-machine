//package top.starp.hashMap;
//
////https://zhuanlan.zhihu.com/p/66974753
//public class HashMap {
//    // 供外部调用的方法
//    public V put(K key, V value) {
//        return putVal(hash(key), key, value, false, true);
//    }
//
//
//    final V putVal(int hash, K keySrc, V value, boolean onlyIfAbsent,
//                   boolean evict) {
//        Node<K,V>[] tab; Node<K,V> dst; int n, i;
//        // 这里如果发现动态数组为null则会初始化数组。因此第一次放入值时会在这里初始化数组
//        if ((tab = table) == null || (n = tab.length) == 0)
//            n = (tab = resize()).length;
//        // 通过hash发现要放入的元素的数组位置为null，则直接把该元素放在这里即可
//        if ((dst = tab[i = (n - 1) & hash]) == null)
//            tab[i] = newNode(hash, keySrc, value, null);
//        else {
//            // 如果要放入的位置已经有元素了
//            Node<K,V> src; K dstKey;
//            // 判断原位置第一个元素是否和新元素key完全一致
//            if (dst.hash == hash &&
//                    ((dstKey = dst.key) == keySrc || (keySrc != null && keySrc.equals(dstKey))))
//                src = dst;
//            else if (dst instanceof TreeNode)
//                // 说明是红黑树，按照红黑树方法放入新节点
//                src = ((TreeNode<K,V>)dst).putTreeVal(this, tab, hash, keySrc, value);
//            else {
//                // 说明是列表，按照列表方法放入新节点
//                for (int binCount = 0; ; ++binCount) {
//                    if ((src = dst.next) == null) {
//                        dst.next = newNode(hash, keySrc, value, null);
//                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
//                            // 如果放入列表后列表过长，则将列表转为红黑树
//                            treeifyBin(tab, hash);
//                        break;
//                    }
//                    if (src.hash == hash &&
//                            ((dstKey = src.key) == keySrc || (keySrc != null && keySrc.equals(dstKey))))
//                        break;
//                    dst = src;
////                    一个个往后迭代
//                }
//            }
//
//            // 这里说明新值和旧值的key完全相同，进行覆盖操作
//            if (src != null) { // existing mapping for key
//                V oldValue = src.value;
//                if (!onlyIfAbsent || oldValue == null)
//                    src.value = value;
//                afterNodeAccess(src);
//                return oldValue;
//            }
//        }
//        ++modCount;
//        if (++size > threshold)
//            resize();
//        afterNodeInsertion(evict);
//        return null;
//    }
//}
