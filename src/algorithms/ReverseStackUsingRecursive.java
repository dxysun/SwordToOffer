package algorithms;

import java.util.Stack;
/*
给你一个栈，请你逆序这个栈，不能申请额外的数据结构，只能
使用递归函数。如何实现？
 */
public class ReverseStackUsingRecursive {


    public static void reverse(Stack<Integer> stack) {
        if(stack == null || stack.isEmpty())
            return;
        Integer last = getLastAndRemove(stack);
        reverse(stack);
        stack.push(last);
    }

    private static Integer getLastAndRemove(Stack<Integer> stack) {
        Integer res = stack.pop();
        if(stack.isEmpty())
            return res;
        else {
            Integer last = getLastAndRemove(stack);
            stack.push(res);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }

    }
}
