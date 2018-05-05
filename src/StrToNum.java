public class StrToNum {


    /*

    题目描述
将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
输入描述:
输入一个字符串,包括数字字母符号,可以为空
输出描述:
如果是合法的数值表达则返回该数字，否则返回0
     */

    public static int StrToInt(String str) {
        if(str == null || str.equals(""))
            return 0;
        char[] c = str.toCharArray();
        int a = 1;
        int i = 0;
        if(c[0] == '+' || c[0] =='-')
        {
            if(c[0] == '-')
            {
                a = -1;
            }
            i = 1;
        }
        int num = 0;
        int step = 1;
        for(int j = c.length - 1;j >= i;j --)
        {
            int b = c[j] - '0';
            if(b > 9 || b < 0)
                return  0;
            num += b * step;
            step *= 10;
        }
        return num*a;

    }
    public static void main(String[] args)
    {
        System.out.println(StrToInt("1a33"));

    }
}
