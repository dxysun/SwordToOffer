package algorithms;

import java.util.Stack;
/*
实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返
回栈中最小元素的操作。
【要求】
1．pop、push、getMin操作的时间复杂度都是O(1)。
2．设计的栈类型可以使用现成的栈结构。
 */
public class GetMinStack {


    public Stack<Integer> stackData = new Stack<>();
    public Stack<Integer> stackMins = new Stack<>();


    public void push(Integer data) {

        if (stackMins.isEmpty()) {
            stackMins.push(data);
        } else {
            if (data < stackMins.peek()) {
                stackMins.push(data);
            } else {
                stackMins.push(stackMins.peek());
            }
        }
        stackData.push(data);
    }

    public Integer pop(){
        if(stackData.isEmpty()){
            return null;
        }
        stackMins.pop();
        return stackData.pop();
    }

    public Integer getmin(){
        if(stackMins.isEmpty())
            return null;
        return stackMins.peek();
    }

    public static void main(String[] args) {

            GetMinStack stack1 = new GetMinStack();
            stack1.push(3);
            System.out.println(stack1.getmin());
            stack1.push(4);
            System.out.println(stack1.getmin());
            stack1.push(1);
            System.out.println(stack1.getmin());
            System.out.println(stack1.pop());
            System.out.println(stack1.getmin());

            System.out.println("=============");

            GetMinStack stack2 = new GetMinStack();
            stack2.push(3);
            System.out.println(stack2.getmin());
            stack2.push(4);
            System.out.println(stack2.getmin());
            stack2.push(1);
            System.out.println(stack2.getmin());
            System.out.println(stack2.pop());
            System.out.println(stack2.getmin());

    }


}
