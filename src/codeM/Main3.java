package codeM;

/*
题目描述
定义lowbit(x) =x&(-x)，即2^(p-1) (其中p为x的二进制表示中，从右向左数第一个1的位置)，例如lowbit(10)=2，lowbit(3)=1。
定义函数f(l, r)为（其中0 <= l, r <= n）：

输入n，求f(l, r)的最大值。
输入描述:
n以二进制形式给出，一行一个二进制01串n，表示l，r的上界。
1 <= 字符串n的长度 <= 20,000
数据保证没有前缀0。
输出描述:
一行一个整数表示答案。
 */

public class Main3 {

    public static int lowbit(int x)
    {
        return x &(-x);

    }
    public static int f(int l,int r)
    {
        if(l >= r)
            return 0;
        else if(r - lowbit(r) >= l)
        {
            return f(l,r - lowbit(r)) + 1;
        }
        else
        {
            return f(l,r - 1) + 1;
        }
    }

    public static void main(String[] args)
    {
        System.out.println(lowbit(10));

    }
}
