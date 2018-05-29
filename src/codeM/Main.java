package codeM;

import java.util.Scanner;

public class Main {



    /*

    美团在吃喝玩乐等很多方面都给大家提供了便利。最近又增加了一项新业务：小象生鲜。这是新零售超市，
    你既可以在线下超市门店选购生鲜食品，也可以在手机App上下单，最快30分钟就配送到家。
新店开张免不了大优惠。我们要在小象生鲜超市里采购n个物品，每个物品价格为ai，有一些物品可以选择八折优惠（称为特价优惠）。
有m种满减优惠方式，满减优惠方式只有在所有物品都不选择特价优惠时才能使用，且最多只可以选择最多一款。
每种满减优惠描述为(bi,ci)，即满bi减ci（当消费>=bi时优惠ci）。
求要买齐这n个物品（必须一单买齐），至少需要多少钱（保留两位小数）。
输入描述:
第一行，两个整数n,m。
接下来n行，每行一个正整数ai，以及一个0/1表示是否可以选择特价优惠（1表示可以）。
接下来m行，每行两个正整数bi,ci，描述一款满减优惠。

1 <= n,m <=10
1 <= ai <= 100
1 <= ci < bi <= 1000
输出描述:
一行一个实数，表示至少需要消耗的钱数（保留恰好两位小数）。
示例1
输入
2 1
6 1
10 1
12 2
输出
12.80
示例2
输入
2 2
6 1
10 1
5 1
16 6
输出
10.00
     */

    public static void manjian()
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] an = new int[n][2];
        int[][] am = new int[m][2];

        for(int i = 0;i < n;i ++)
        {
            an[i][0] = in.nextInt();
            an[i][1] = in.nextInt();
        }
        for(int i = 0;i < m;i ++)
        {
            am[i][0] = in.nextInt();
            am[i][1] = in.nextInt();
        }

        double tejia = 0;
        double sum = 0;
        for(int i = 0;i < n;i ++)
        {
            if(an[i][1] == 1)
            {
                tejia += an[i][0] * 0.8;
            }
            else
            {
                tejia += an[i][0];
            }
            sum += an[i][0];
        }

        double manjian_max = 0;
        int pos = -1;
        for(int i = 0;i < m;i ++)
        {
            if(am[i][0] > manjian_max)
            {
                manjian_max = am[i][0];
                pos = i;
            }
        }
        double manjian = sum - am[pos][1];
        double res = tejia > manjian ? manjian : tejia;
        System.out.println(String.format("%.2f", res));
    }


    /*
    题目描述
小美和小团最近沉迷可乐。可供TA们选择的可乐共有k种，比如可口可乐、零度可乐等等，每种可乐会带给小美和小团不同的快乐程度。
TA们一共要买n瓶可乐，每种可乐可以买无限多瓶，小美会随机挑选其中的m瓶喝，剩下的n-m瓶小团喝。
请问应该如何购买可乐，使得小美和小团得到的快乐程度的和的期望值最大？
现在请求出购买可乐的方案。
输入描述:
第一行三个整数n，m，k分别表示要买的可乐数、小美喝的可乐数以及可供选择的可乐种数。
接下来k行，每行两个整数a，b分别表示某种可乐分别给予小美和小团的快乐程度。
对于所有数据，1 <= n <= 10,000, 0 <= m <= n, 1 <= k <= 10,000, -10,000 <= a, b <= 10,000
输出描述:
一行k个整数，第i个整数表示购买第i种可乐的数目。
如果有多解，请输出字典序最小的那个。
对于两个序列 a1, a2, ..., ak, b1, b2, ..., bk，a的字典序小于b，当且仅当存在一个位置i <= k满足：
ai < bi且对于所有的位置 j < i，aj = bj；
示例1
输入
2 1 2
1 2
3 1
输出
0 2
说明
一共有三种购买方案：
1. 买2瓶第一类可乐，小美和小团各喝一瓶，期望得到的快乐程度和为1+2=3；
2. 买1瓶第一类可乐和1瓶第二类可乐，小美和小团各有二分之一的概率喝到第一类可乐，另有二分之一的概率喝到第二类可乐，期望得到的快乐程度和为1*0.5+3*0.5+2*0.5+1*0.5=3.5；
3. 买2瓶第二类可乐，小美和小团各喝一瓶，期望得到的快乐程度和为3+1=4。

     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] a = new int[k + 1][3];
        int xm = 0;
        int xt = 0;
        int pos = -1;

        for(int i = 1;i <= k;i ++)
        {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
            a[i][2] = i;
            if(a[i][0] + a[i][1] > xm + xt)
            {
                xm = a[i][0];
                xt = a[i][1];
                pos = i;
            }
        }
        for(int i = 1;i <= k;i ++)
        {
            int p = i;
            for(int j = i;j <= k;j ++)
            {
                if(a[j][0] + a[j][1] > a[p][0] + a[p][1])
                {
                    p = j;
                }
                if(a[j][0] + a[j][1] == a[p][0] + a[p][1])
                {
                    if(a[j][2] < a[p][2])
                        p = j;
                }
            }

            int temp1 = a[i][0];
            int temp2 = a[i][1];
            int temp3 = a[i][2];
            a[i][0] = a[p][0];
            a[i][1] = a[p][1];
            a[i][2] = a[p][2];
            a[p][0] = temp1;
            a[p][1] = temp2;
            a[p][2] = temp3;
        }

        int[] arr = new int[k + 1];
        arr[a[0][2]] = n;
        double hope = a[0][0] * m + a[0][1] * (n - m);
        double newhope = hope;


        while (newhope >= hope)
        {

        }

        for(int i = 1;i <= k;i ++)
        {
            System.out.println(a[i][0]+" " + a[i][1]);
        }

        System.out.println("xm:" + xm);
        System.out.println("xt:" + xt);






        hope = m / n * xm + (n - m)/n * xt;
        System.out.println("hope:" + hope);
        arr[pos] = n;
        for(int i = 1;i <= k;i ++)
        {
            System.out.print(arr[i]+" ");
        }



    }
}
