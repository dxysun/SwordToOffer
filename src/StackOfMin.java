import java.util.Stack;

public class StackOfMin {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int min = 0;
    int count = 0;
    public void push(int node) {
        if(count == 0)
        {
            min = node;
            count ++;
        }
        else if(node < min)
        {
            min = node;
        }
        stack.push(node);
    }

    public void pop() {
        int pNum = stack.pop();
        if(pNum == min)
        {
            min = stack.peek();
            while (!stack.isEmpty())
            {
                int popNum = stack.pop();
                if(popNum < min)
                    min = popNum;
                minStack.push(popNum);
            }
            while (!minStack.isEmpty())
            {
                stack.push(minStack.pop());
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
    public static void main(String[] args)
    {

    }
}
