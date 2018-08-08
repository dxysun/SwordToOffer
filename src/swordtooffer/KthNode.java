package swordtooffer;

public class KthNode {

    /*
    题目描述
给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
     */
    private int num = 0;
    private TreeNode node;

    TreeNode KthNode(TreeNode pRoot, int k)
    {

        if(pRoot == null || k == 0)
            return null;
         KthNodeCore(pRoot,k);

        return node;
    }

    void KthNodeCore(TreeNode pRoot, int k)
    {
        if(pRoot == null || num > k)
            return;

        KthNodeCore(pRoot.left,k);
        num ++;
        if(num == k)
        {
            node = pRoot;
        }
        KthNodeCore(pRoot.right,k);

    }
}
