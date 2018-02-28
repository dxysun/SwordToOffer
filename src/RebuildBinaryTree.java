/**
 *题目描述
 *输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 解题思路：
 * 根据前序遍历可知父节点，然后根据父节点的数值将中序遍历分为左子树序列和右子树序列
 * 再根据前序遍历找到父节点，然后递归下去，还原二叉树
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val)
    {
        this.val = val;
    }
}
public class RebuildBinaryTree {

    public static TreeNode constructBinaryTree(int [] pre, int [] mid,int length)
    {
        if(length == 0)
            return null;
        TreeNode node = new TreeNode(pre[0]);
        int l = 0;
        for(int i = 0;i < length;i ++)
        {
            if(mid[i] == node.val)
            {
                l = i;
                break;
            }
        }

        int[] mid_left = new int[length];
        int[] mid_right = new int[length];
        for(int j = 0;j < length;j ++)
        {
            if(j < l)
            {
                mid_left[j] = mid[j];
            }
            if(j > l)
            {
                mid_right[j - l - 1] = mid[j];
            }
        }
        int[] pre_left = new int[length];
        int[] pre_right = new int[length];
        for(int k = 1;k <= l;k ++)
        {
            pre_left[k - 1] = pre[k];
        }
        for(int t = l + 1;t < length;t ++)
        {
            pre_right[t - l - 1] = pre[t];
        }
        node.left = constructBinaryTree(pre_left,mid_left,l);
        node.right = constructBinaryTree(pre_right,mid_right,length - l - 1);
        return node;
    }
    public static void pre_out(TreeNode node)
    {
        if(node == null)
            return;
        System.out.print(node.val + " ");
        pre_out(node.left);
        pre_out(node.right);
    }

    public static void mid_out(TreeNode node)
    {
        if(node == null)
            return;
        mid_out(node.left);
        System.out.print(node.val + " ");
        mid_out(node.right);
    }
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode tree = constructBinaryTree(pre,in,pre.length);
        return tree;
    }
    public static void main(String[] args)
    {
        int[] pre_list = {1,2,4,7,3,5,6,8};
        int[] mid_list = {4,7,2,1,5,3,8,6};
        TreeNode node = reConstructBinaryTree(pre_list,mid_list);
        pre_out(node);
        System.out.println();
        mid_out(node);
    }
}

