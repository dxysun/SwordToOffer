package swordtooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class PrintTwoTreePath {



    public static void printPath(TreeNode root, int curNum, int target, LinkedList<TreeNode> path, ArrayList<ArrayList<Integer>> list)
    {
        curNum += root.val;
        path.push(root);
        if(root.left == null && root.right == null && curNum == target)
        {
            ArrayList<Integer> l = new ArrayList<>();
            int len = path.lastIndexOf(path.getLast());
            for(int i = len;i >= 0;i --)
            {
                l.add(path.get(i).val);
            }
            list.add(l);
        }
        if(root.left != null)
        {
            printPath(root.left,curNum,target,path,list);
        }
        if(root.right != null)
        {
            printPath(root.right,curNum,target,path,list);
        }
        path.pop();
    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        Stack<TreeNode> satck = new Stack<>();
        LinkedList<TreeNode> path = new LinkedList<>();
        printPath(root,0,target,path,list);
        return list;
    }
    public static void main(String[] args)
    {
        int[] pre_list = {1,2,4,11,3,5,6,8};
        int[] mid_list = {4,11,2,1,5,3,8,6};
        TreeNode node =  RebuildBinaryTree.reConstructBinaryTree(pre_list,mid_list);
        ArrayList<ArrayList<Integer>> list = FindPath(node,18);
        for (ArrayList<Integer> l:
                list
                ) {
            for (Integer i:
                    l
                    ) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
