package algorithms.binarytree;

/*
判断一棵二叉树是否是平衡二叉树
左右子树高度小于等于1

 */
public class IsBalancedTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBalance(Node head){
        if(head == null)
            return false;
        boolean[] res = {true};
        judgeBalance(head,1,res);
        return res[0];
    }



    private static int judgeBalance(Node head,int level,boolean[] b) {
        if(head == null)
            return  level;
        int lh = judgeBalance(head.left,level + 1,b);
        if(!b[0]){
            return level;
        }

        int rh = judgeBalance(head.right,level + 1,b);
        if(!b[0]){
            return level;
        }

        if(Math.abs(lh - rh) > 1)
        {
            b[0] = false;
        }
        return Math.max(lh,rh);
    }

    public static class ReturnNodeInfo{
        int level;
        boolean isBalnce;

        public ReturnNodeInfo(int level, boolean isBalnce) {
            this.level = level;
            this.isBalnce = isBalnce;
        }
    }
    public static boolean isBalance2(Node head){
        if(head == null)
            return false;
        return judgeBalance2(head).isBalnce;

    }

    private static ReturnNodeInfo judgeBalance2(Node head) {
        if(head == null)
            return new ReturnNodeInfo(0,true);

        ReturnNodeInfo leftinfo = judgeBalance2(head.left);
        if(!leftinfo.isBalnce)
            return new ReturnNodeInfo(leftinfo.level + 1,false);
        ReturnNodeInfo rightinfo = judgeBalance2(head.right);
        if(!rightinfo.isBalnce)
            return new ReturnNodeInfo(rightinfo.level + 1,false);

        if(Math.abs(leftinfo.level - rightinfo.level) > 1)
            return new ReturnNodeInfo(leftinfo.level - rightinfo.level > 0 ? leftinfo.level + 1 : rightinfo.level + 1,false);
        else
            return new ReturnNodeInfo(leftinfo.level - rightinfo.level > 0 ? leftinfo.level + 1: rightinfo.level + 1,true);
    }

    public static int TreeDepth(Node root) {
        if(root == null)
            return 0;
        int left  = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        int max = left > right ? left : right;
        return max + 1;

    }
    public static boolean IsBalanced_Solution(Node root) {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        int left  = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if(Math.abs(left-right)>1)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

//        head.right.right.right = new Node(8);
//        head.right.right.right.left= new Node(9);

        System.out.println(isBalance(head));
        System.out.println(isBalance2(head));
        System.out.println(IsBalanced_Solution(head));
    }

}
