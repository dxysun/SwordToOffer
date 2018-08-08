package swordtooffer;

public class TreeNodeDepth {

    public static int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 0;
        int left  = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        int max = left > right ? left : right;
        return max + 1;
    }
    public static void main(String[] args)
    {

    }

}
