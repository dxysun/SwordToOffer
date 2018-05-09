import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class PrintTwoTree {
    /*
    题目描述
    请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        if(pRoot == null)
            return a;

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        stack.push(pRoot);

        while (!stack.isEmpty() || !stack1.isEmpty())
        {
            ArrayList<Integer> b = new ArrayList<>();

            if(stack.isEmpty())
            {
                while (!stack1.isEmpty())
                {
                    TreeNode node = stack1.pop();
                    b.add(node.val);
                    if(node.right != null)
                        stack.push(node.right);
                    if(node.left != null)
                        stack.push(node.left);
                }
            }
            else
            {
                while (!stack.isEmpty())
                {
                    TreeNode node = stack.pop();
                    b.add(node.val);
                    if(node.left != null)
                        stack1.push(node.left);
                    if(node.right !=  null)
                        stack1.push(node.right);
                }
            }

            a.add(b);
        }
        return a;
    }

    /*
    题目描述
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     */

    ArrayList<ArrayList<Integer> > PrintV2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        if(pRoot == null)
            return a;

        Queue<TreeNode> stack = new LinkedList<>();
        Queue<TreeNode> stack1 = new LinkedList<>();
        stack.add(pRoot);

        while (!stack.isEmpty() || !stack1.isEmpty())
        {
            ArrayList<Integer> b = new ArrayList<>();

            if(stack.isEmpty())
            {
                while (!stack1.isEmpty())
                {
                    TreeNode node = stack1.poll();
                    b.add(node.val);
                    if(node.left != null)
                        stack.add(node.left);
                    if(node.right != null)
                        stack.add(node.right);

                }
            }
            else
            {
                while (!stack.isEmpty())
                {
                    TreeNode node = stack.poll();
                    b.add(node.val);
                    if(node.left != null)
                        stack1.add(node.left);
                    if(node.right !=  null)
                        stack1.add(node.right);
                }
            }

            a.add(b);
        }
        return a;

    }
    public static void main(String[] args)
    {

    }
}
