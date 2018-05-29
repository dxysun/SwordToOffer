package codeM;

import java.util.Scanner;

public class ShuMa {

    /*
题目描述
给定两个整数 l 和 r ，对于所有满足1 ≤ l ≤ x ≤ r ≤ 10^9 的 x ，把 x 的所有约数全部写下来。
对于每个写下来的数，只保留最高位的那个数码。求1～9每个数码出现的次数。
输入描述:
一行，两个整数 l 和 r (1 ≤ l ≤ r ≤ 10^9)。
输出描述:
输出9行。

第 i 行，输出数码 i 出现的次数。
示例1
输入
1 4
输出
4
2
1
1
0
0
0
0
0

     */

    static int[] res = new int[10];
    public static int getHigh(int num)
    {
        while (num/10 > 0)
        {
            num /= 10;
        }
        return num;
    }


    public static void getYueShu(int num)
    {

        res[1] ++;
        if(num != 1)
            res[getHigh(num)] ++;

        for(int i = 2;i <= num/2;i ++)
        {
            if(num%i == 0)
            {
                res[getHigh(i)] ++;
            }
        }
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();
        for(int i = l;i <= r;i ++)
        {
            getYueShu(i);
        }
        for(int j = 1;j <= 9;j ++)
        {
            System.out.println(res[j]);
        }
    }
}
