package algorithms;

import java.util.Scanner;
import java.util.Stack;

public class StackExample {

    public static int compare(char c1,char c2)
    {
        if((c1 == '*' || c1 == '/') && (c2 == '+' || c2 == '-'))
        {
            return 1;
        }
        else if( c1 == c2)
        {
            return 0;
        }
        else
            return -1;
    }
    public static int cal(int a,char c,int b)
    {
        if(c == '+')
            return a + b;
        else if(c == '-')
            return a - b;
        else if(c == '*')
            return a * b;
        else
            return a / b;
    }

    public static int calExp(char[] a)
    {
        Stack<Character> operate = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        operate.push('#');
        int num = 0;
        for (int i = 0;i < a.length;i ++)
        {
            if(Character.isDigit(a[i]))
            {
                num = num *10 + (a[i] - '0');
            }
            else
            {
//                System.out.println("push num:" + num);
                nums.push(num);
                num = 0;
                char c = operate.peek();
                if(c != '#')
                {
                    if(compare(a[i],c) > 0)
                    {
//                        System.out.println("push oper:" + a[i]);
                        operate.push(a[i]);
                    }
                    else
                    {
                        int n1 = nums.pop();
                        int n2 = nums.pop();
                        c = operate.pop();
                        int res = cal(n2,c,n1);
                        nums.push(res);
//                        System.out.println("push oper:" + a[i]);
                        operate.push(a[i]);
                    }
                }
                else
                {
//                    System.out.println("push oper:" + a[i]);
                    operate.push(a[i]);
                }
            }
        }
//        System.out.println("after for num:" + num);
        nums.push(num);
        while (!operate.isEmpty())
        {
            char c = operate.pop();
            if(c == '#')
                break;
            else
            {
                int n1 = nums.pop();
                int n2 = nums.pop();

//                System.out.println("n1:"+n1);
//                System.out.println("n2:"+n2);
//                System.out.println("c1:"+c);
                int res = cal(n2,c,n1);
//                System.out.println("res:"+res);
                nums.push(res);
            }
        }
        return  nums.peek();
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        String s = scanner.nextLine();
        while (scanner.hasNext())
        {
            int res = 0;
            String str = scanner.nextLine();
            char[] c = str.toCharArray();
            System.out.println(calExp(c));
        }

    }
}
