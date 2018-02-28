/**
 * 解题思路：
 * java 移位操作
 * <<  左移运算符,丢弃左边指定位数，右边补0,相当于乘以2
 * >>  右移运算符,丢弃右边指定位数，左边补上符号位，相当于除以2
 * >>> 丢弃右边指定位数，左边补上0
 * NumberOf1V2(int n)
 * n与1与，如果结果不为零，则最后一位为1，n无符号右移不断与1与即可得到1的总数
 * NumberOf1(int n)
 * 1不断左移与n与，结果不为零，即相应位为1，进而得到1的总数
 */
public class NumberOfOne {

    public static int NumberOf1(int n)
    {
        int count = 0;
        boolean b = true;
        int flag = 1;
        while(b)
        {
            if((n & flag) != 0)
            {
                count ++;
            }
            flag = flag << 1;
            if(flag == 0)
                b = false;
        }
        return count;
    }

    public static int NumberOf1V2(int n)
    {
        int count = 0;
        boolean b = true;
        while(b)
        {
            if((n & 1) != 0)
            {
                count ++;
            }
            n = n >>> 1;
            if(n == 0)
                b = false;
        }
        return count;
    }
    public static void main(String[] args)
    {
        System.out.println(NumberOf1(7));
        System.out.println(NumberOf1V2(7));
    }
}
