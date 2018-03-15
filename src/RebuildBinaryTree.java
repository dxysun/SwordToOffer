import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
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

    public static void dfsTree(TreeNode root,int sum,int target,ArrayList<TreeNode> a)
    {

        if(root == null)
            return;
        sum += root.val;

        if(sum == target )
        {
            System.out.println(root.val);
            a.add(root);
        }
        dfsTree(root.left,sum,target, a);
        dfsTree(root.right,sum,target, a);
    }

    public static void dfsFindTree(TreeNode root,int sum,int target,ArrayList<TreeNode> a)
    {

        if(root == null)
            return;

        if(sum == target )
        {
            System.out.println(root.val);
            a.add(root);
        }
        dfsTree(root.left,sum,target, a);
        dfsTree(root.right,sum,target, a);
    }

    public static void print_tree_stack_after(TreeNode node,int target)
    {
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        TreeNode cur = node;
        TreeNode pre = null;
        sum += cur.val;
        if(sum == target)
        {
            ArrayList<Integer> t = new ArrayList<>();
            t.add(cur.val);
            list.add(t);
            return;
        }
        stack.push(cur);
        while(!stack.isEmpty())
        {
            if((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right)))
            {
                System.out.print(cur.val + " ");
                pre = stack.pop();
                if(!stack.isEmpty())
                    cur = stack.peek();
            }
            else
            {
                if(cur.right != null)
                {

                    stack.push(cur.right);
                }
                if(cur.left != null)
                {

                    stack.push(cur.left);
                }
                cur = stack.peek();
            }
        }
    }

    public static void printTreeStack(TreeNode node,int target)
    {
        Stack<TreeNode> stack  = new Stack<>();
        TreeNode cur = node;
        int sum = 0;
        while (!stack.isEmpty() || cur != null)
        {
            sum += cur.val;
            System.out.print(cur.val + " ");
            if(sum == target)
            {
                System.out.println();
                System.out.println(cur.val);
                Stack<TreeNode> s = new Stack<>();
                while (!stack.isEmpty())
                {
                    TreeNode t = stack.pop();
                    System.out.println(t.val);
                    s.push(t);
                }
                while (!s.isEmpty())
                {
                    TreeNode t = s.pop();
                    stack.push(t);
                }
            }
            stack.push(cur);
            cur = cur.left;
            while (!stack.isEmpty() && cur == null)
            {
                cur = stack.pop();
                sum -= cur.val;
                cur = cur.right;
            }
        }

    }

    public static ArrayList<ArrayList<Integer>> printTree(TreeNode root,int target)
    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int sum = 0;
        while(!stack.isEmpty() || temp != null )
        {
            stack.push(temp);
            sum += temp.val;
            if(temp.left == null && temp.right == null && sum == target)
            {
                ArrayList<Integer> l = new ArrayList<>();
                Stack<TreeNode> s = new Stack<>();
                while (!stack.isEmpty())
                {
                    TreeNode t = stack.pop();
                    s.push(t);
                }
                while (!s.isEmpty())
                {
                    TreeNode t = s.pop();
                    l.add(t.val);
                    stack.push(t);
                }
                list.add(l);
            }
            if(temp.left != null)
                temp = temp.left;
            else
            {
                if(temp.right != null)
                    temp = temp.right;
                else
                {
                    TreeNode t1 = stack.pop();
                    sum -= t1.val;
                    if(!stack.isEmpty())
                    {
                        temp = stack.peek();
                    }
                    while(!stack.isEmpty() && (temp.right == null || temp.right == t1))
                    {
                        t1 = stack.pop();
                        sum -= t1.val;
                        if(stack.isEmpty())
                        {
                            temp = null;
                            break;
                        }
                        temp = stack.peek();
                    }
                    if(!stack.isEmpty() && temp != null)
                        temp = temp.right;
                }
            }
        }
        return list;
    }
    public static void main(String[] args)
    {
        /*int[] pre_list = {1,2,4,11,3,5,6,8};
        int[] mid_list = {4,11,2,1,5,3,8,6};*/
        int[] pre_list = {10,5,4,7,12};
        int[] mid_list = {4,5,7,10,12};
        Queue<Integer> q = new LinkedList<>();
        TreeNode node = reConstructBinaryTree(pre_list,mid_list);
        pre_out(node);
        System.out.println();
        mid_out(node);
        System.out.println();
        System.out.println(TreeNodeDepth.TreeDepth(node));

       /* ArrayList<ArrayList<Integer>> list = printTree(node,18);
        for (ArrayList<Integer> l:
                list
             ) {
            for (Integer i:
                    l
                 ) {
                System.out.print(i + " ");
            }
            System.out.println();
        }*/
       /* for (TreeNode n:
                a
             ) {
            System.out.println(n.val);

        }*/

//        System.out.println();
//        mid_out(node);
    }
}

