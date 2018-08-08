package swordtooffer;

import java.util.Stack;

public class ReverseSentences {
    public static String ReverseSentence(String str) {
        if(str == null)
            return null;
        if(str.equals(" "))
            return str;
        char[] a = str.toCharArray();
        String sb = "";
        Stack<String> stack = new Stack<>();
        for (int i = 0;i < a.length;i ++)
        {
            if(a[i] == ' ')
            {
                stack.push(sb);
                sb = "";
            }
            else
            {
                sb += a[i];
            }
        }
        stack.push(sb);
        sb = "";
        while (!stack.isEmpty())
        {
            sb += stack.pop();
            sb += " ";
        }
        sb = sb.substring(0,sb.length() - 1);
        return sb;

    }
    public static void main(String[] args)
    {
        System.out.print("|" +ReverseSentence("asfa ")+"|");

    }

}
