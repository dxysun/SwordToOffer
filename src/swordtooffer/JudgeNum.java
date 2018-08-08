package swordtooffer;

public class JudgeNum {

    /*

    题目描述
   请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
   例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
   但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     */
    public static boolean isNumeric(char[] str) {

        if(str == null)
            return false;
        int len = str.length;
        int numOfDot = 0;
        boolean afterE = false;
        for(int i = 0;i < len;i ++)
        {
            if(str[i] == '+' || str[i] == '-')
            {
                if(i != 0)
                {
                    if(str[i - 1] != 'e' && str[i - 1] != 'E')
                        return false;
                }

            }
            else if(str[i] == '.')
            {
                if(afterE)
                    return false;
                numOfDot ++;
                if(numOfDot > 1)
                    return false;
            }
            else if(str[i] == 'e' || str[i] == 'E')
            {
                afterE = true;
                if(i + 1 >= len)
                    return false;
                if(str[i + 1] != '-' && str[i + 1] != '+')
                {
                    if(str[i + 1] - '0' > 9 || str[i + 1] - '0' < 0)
                        return false;
                }
            }
            else
            {
                if(str[i] - '0' > 9 || str[i] - '0' < 0)
                    return false;

            }
        }
        return true;

    }
    public static void main(String[] args)
    {

    }
}
