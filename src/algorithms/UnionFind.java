package algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFind {

    public static class Node {
        // whatever you like
    }

    public static class UnionFindSet {
        public HashMap<Node, Node> fatherMap;
        public HashMap<Node, Integer> sizeMap;


        public UnionFindSet() {
            fatherMap = new HashMap<Node, Node>();
            sizeMap = new HashMap<Node, Integer>();
        }

        public void makeSets(List<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }
        private Node findHead(Node node) {
            Node father = fatherMap.get(node);
           /*
           // 非递归
           Node temp = node;
            while (father != temp){
                temp = father;
                father = fatherMap.get(father);
            }*/
         /*  // 递归
            if(father != node){
                father = findHead(father);
            }*/

            Stack<Node> stack = new Stack<>();
            while (father != fatherMap.get(father)){
                stack.push(father);
                father = fatherMap.get(father);
            }
            while (!stack.isEmpty()){
                fatherMap.put(stack.pop(),father);
            }

            fatherMap.put(node,father);
            return father;
        }

        public boolean isSameSet(Node a, Node b) {
            return findHead(a) == findHead(b);

        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node ha = findHead(a);
            Node hb = findHead(b);

            if(ha != hb){
                int sa = sizeMap.get(ha);
                int sb = sizeMap.get(hb);
                if(sa > sb){
                    fatherMap.put(hb,ha);
                    sizeMap.put(ha,sa + sb);
                }
                else {
                    fatherMap.put(ha,hb);
                    sizeMap.put(hb,sa + sb);
                }
            }

        }

    }


}
