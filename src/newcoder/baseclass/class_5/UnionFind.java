package newcoder.baseclass.class_5;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFind {

    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<V> {
        public HashMap<V, Element<V>> elementMap;
        public HashMap<Element<V>, Element<V>> fatherMap;
        public HashMap<Element<V>, Integer> sizeMap;

        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();

            for (V v : list) {
                Element<V> e = new Element<>(v);
                elementMap.put(v, e);
                fatherMap.put(e, e);
                sizeMap.put(e, 1);
            }
        }

        public boolean isSanmeSet(V v1, V v2) {
            if (elementMap.containsKey(v1) && elementMap.containsKey(v2)) {
                return getHead(elementMap.get(v1)) == getHead(elementMap.get(v2));
            }
            return false;

        }

        public void Union(V v1, V v2) {
            if (elementMap.containsKey(v1) && elementMap.containsKey(v2)) {
                Element<V> head1 = getHead(elementMap.get(v1));
                Element<V> head2 = getHead(elementMap.get(v2));
                if(head1 != head2){
                    int head1Size = sizeMap.get(head1);
                    int head2Size = sizeMap.get(head2);
                    if (head1Size > head2Size) {
                        fatherMap.put(head2,head1);
                        sizeMap.put(head1,head1Size + head2Size);
                        sizeMap.remove(head2);
                    } else {
                        fatherMap.put(head1,head2);
                        sizeMap.put(head2,head1Size + head2Size);
                        sizeMap.remove(head1);
                    }
                }

            }
        }

        private Element<V> getHead(Element<V> element) {

            Stack<Element<V>> stack = new Stack<>();

            while (element != fatherMap.get(element)) {
                stack.push(element);
                element = fatherMap.get(element);
            }
            while (!stack.isEmpty()){
                fatherMap.put(stack.pop(),element);
            }
            return element;
        }


    }

}
