import java.util.ArrayList;
import java.util.Stack;

public class JudgeStack {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA != null && popA != null)
        {
            boolean res = true;
            Stack<Integer> stack = new Stack<>();
            int length = pushA.length;
            int i = 0, j = 0;
            for(i = 0;i < length;i ++)
            {
                if(!stack.isEmpty())
                {
                    if(popA[i] == stack.peek())
                    {
                        System.out.println(stack.pop());
                        continue;
                    }
                }
                boolean b = false;
                while(j < length)
                {
                    stack.push(pushA[j]);
                    j ++;
                    if(popA[i] == stack.peek())
                    {
                        b = true;
                        break;
                    }
                }
                if(b)
                {
                    stack.pop();
                }
                else
                {
                    if(popA[i] == stack.peek())
                    {
                        stack.pop();
                    }
                    else
                    {
                        res = false;
                        break;
                    }
                }
            }
            return res;
        }
        else
        {
            return  false;
        }
    }

    public static boolean IsPopOrderV2(int [] pushA,int [] popA)
    {
        boolean res = false;
        int length = pushA.length;
        if(pushA != null && popA != null)
        {
            Stack<Integer> stack = new Stack<>();
            int j = 0;
            for (int i = 0;i < length;i ++)
            {
                while(stack.isEmpty() || popA[i] != stack.peek())
                {
                    if (j >= length)
                    {
                        break;
                    }
                    stack.push(pushA[j]);
                    j ++;
                }
                if(popA[i] != stack.peek())
                    break;
                stack.pop();
            }
            if(stack.isEmpty())
                res = true;
        }
        return res;
    }
    public static void main(String[] args)
    {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,3,5,2,1};
        System.out.println(IsPopOrderV2(pushA,popA));
    }
}
