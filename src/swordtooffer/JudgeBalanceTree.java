package swordtooffer;

public class JudgeBalanceTree {

    public int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        int left  = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        int max = left > right ? left : right;
        return max + 1;

    }
    public boolean IsBalanced_Solution(TreeNode root) {
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
}
