package algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TwoTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }


    public static int minNumberInRotateArray(int [] array) {
        if(array.length == 0)
            return 0;
        int result = 0;
        for(int i = 0;i < array.length - 1; i ++)
        {
            if(array[i] > array[i + 1])
            {
                result = array[i + 1];
                break;
            }
        }
        return result;
    }

    public static int JumpFloorII(int target) {
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;
        int[] a = new int[target];
        a[0] = 1;
        a[1] = 2;
        int sum = 3;
        for(int i = 2;i < target;i ++)
        {
            a[i] = sum + 1;
            sum += a[i];
        }
        return a[target - 1];

    }

    public static TreeNode createTree()
    {
        Scanner scan = new Scanner(System.in);
        TreeNode node = new TreeNode();
        if (scan.hasNextInt()) {
            // 判断输入的是否是整数
            int i = scan.nextInt();
            node.val = i;
            node.left = createTree();
            node.right = createTree();
        } else {
            // 输入错误的信息
            System.out.println("输入的不是整数！");
            return null;
        }
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

    public static void after_out(TreeNode node)
    {

        if(node == null)
            return;
        after_out(node.left);
        after_out(node.right);
        System.out.print(node.val + " ");

    }

    public static TreeNode constructBinaryTree(int [] pre, int [] mid, int length)
    {
        if(length == 0)
            return null;
        TreeNode node = new TreeNode();
        node.val = pre[0];
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
            //  System.out.print(pre[t] + " ");
        }
        node.left = constructBinaryTree(pre_left,mid_left,l);
        node.right = constructBinaryTree(pre_right,mid_right,length - l - 1);
        return node;
    }
    public static void print_tree_queue(TreeNode node)
    {
        Queue<TreeNode> queueList = new LinkedList<>();
        queueList.offer(node);
        while(!queueList.isEmpty())
        {
            TreeNode n = queueList.poll();
            System.out.print(n.val + " ");
            if(n.left != null)
                queueList.offer(n.left);
            if(n.right != null)
                queueList.offer(n.right);
        }

    }

    public static void print_tree_stack_pre(TreeNode node)
    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;

        while (!stack.isEmpty() || cur != null)
        {
            System.out.print(cur.val + " ");
            stack.push(cur);
            cur = cur.left;

            while (!stack.isEmpty() && cur == null)
            {
                cur = stack.pop();
                cur = cur.right;
            }
        }
    }
    public static void print_tree_stack_mid(TreeNode node)
    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        while(!stack.isEmpty() || cur != null)
        {
            stack.push(cur);
            cur = cur.left;
            while(!stack.isEmpty() && cur == null)
            {
                cur = stack.pop();
                System.out.print(cur.val + " ");
                cur = cur.right;
            }
        }
    }

    public static void print_tree_stack_after(TreeNode node)
    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        TreeNode pre = null;
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

    public static void main(String[] args)
    {
//        int[] a = {3,4,5,1,2};
//        // 1 2 4
//        System.out.println(a.length);
//        System.out.println(JumpFloorII(3));
//        int d = 6;
//        int[] c = new int[d];
//        System.out.println(c.length);
//        TreeNode node = createTree();
//        pre_out(node);
//        System.out.println();
//        mid_out(node);
//        System.out.println();
//        after_out(node);

/*        int[] pre_list = {1,2,4,7,3,5,6,8};
        int[] mid_list = {4,7,2,1,5,3,8,6};
        // 7 4 2 5 8 6 3 1
        TreeNode tree = constructBinaryTree(pre_list,mid_list,8);
        after_out(tree);
        System.out.println();*/
//        print_tree_queue(tree);
//        print_tree_stack_pre(tree);
//        print_tree_stack_after(tree);
//        pre_out(tree);
//        System.out.println();
//        mid_out(tree);

        int a = -7;
        System.out.println(a%2);
        String b = "hello";

        System.out.println(b.codePointCount(0,b.length()));
    }
}

