package writeTest;

import java.util.*;

public class TouTiao {


    public static void print() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        while (in.hasNext()) {
            String str = in.nextLine();
            char[] c = str.toCharArray();
            int length = c.length;
            int i = 0;
            char preOperae = '*';
            int res = 0;
            int pre = 0;
            for (i = 0; i < length; i++) {
                if (c[i] == '+') {
                    int temp1 = 0;
                    int j = i + 1;
                    for (j = i + 1; j < length; j++) {
                        if (c[j] != '+' && c[j] != '-' && c[j] != '*') {
                            temp1 = temp1 * 10 + 6;
                        } else
                            break;
                    }
                    pre = temp1;
                    preOperae = '+';
                    i = j - 1;
                    res += temp1;
                } else if (c[i] == '-') {
                    int temp1 = 0;
                    int j = i + 1;
                    for (j = i + 1; j < length; j++) {
                        if (c[j] != '+' && c[j] != '-' && c[j] != '*') {
                            temp1 = temp1 * 10 + 6;
                        } else
                            break;
                    }
                    pre = temp1;
                    preOperae = '-';
                    i = j - 1;
                    res -= temp1;
                } else if (c[i] == '*') {
                    if (i > 1) {
                        if (preOperae == '+') {
                            res -= pre;
                            int temp1 = 0;
                            int j = i + 1;
                            for (j = i + 1; j < length; j++) {
                                if (c[j] != '+' && c[j] != '-' && c[j] != '*') {
                                    temp1 = temp1 * 10 + 6;
                                } else
                                    break;
                            }
                            i = j - 1;
                            pre *= temp1;
                            res += pre;
                            pre = temp1;
                        } else if (preOperae == '-') {
                            res += pre;
                            int temp1 = 0;
                            int j = i + 1;
                            for (j = i + 1; j < length; j++) {
                                if (c[j] != '+' && c[j] != '-' && c[j] != '*') {
                                    temp1 = temp1 * 10 + 6;
                                } else
                                    break;
                            }
                            i = j - 1;
                            pre *= temp1;
                            res -= pre;
                            pre = temp1;
                        } else {
                            int temp1 = 0;
                            int j = i + 1;
                            for (j = i + 1; j < length; j++) {
                                if (c[j] != '+' && c[j] != '-' && c[j] != '*') {
                                    temp1 = temp1 * 10 + 6;
                                } else
                                    break;
                            }
                            i = j - 1;
                            res *= temp1;
                            pre = temp1;
                        }
                    } else {
                        int temp1 = 0;
                        int j = i + 1;
                        for (j = i + 1; j < length; j++) {
                            if (c[j] != '+' && c[j] != '-' && c[j] != '*') {
                                temp1 = temp1 * 10 + 6;
                            } else
                                break;
                        }
                        pre = temp1;
                        preOperae = '*';
                        i = j - 1;
                        res *= temp1;
                    }
                } else {
                    res = res * 10 + 6;
                }
            }
            System.out.println(res);
        }
    }

    public static void QuestionOne() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        Map<Integer, Integer> map = new TreeMap<>();
        Map<Integer, Integer> newmap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if (map.containsKey(a[i])) {
                int t = map.get(a[i]);
                t++;
                map.put(a[i], t);
                newmap.put(a[i], t);
            } else {
                map.put(a[i], 1);
                newmap.put(a[i], 1);
            }

        }
        System.out.println(map.size());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k != 0) {
                if (newmap.containsKey(entry.getKey())) {
                    if (newmap.containsKey(entry.getKey() + k))
                        newmap.remove(entry.getKey() + k);
                }
            } else {
                if (newmap.containsKey(entry.getKey()) && newmap.get(entry.getKey()) != 1) {
                    newmap.put(entry.getKey() + k, 1);
                }
            }
        }
        newmap.forEach((t, v) -> System.out.println(t + "   " + v));
        System.out.println(newmap.size());
    }

    /*
    题目描述
对于严格递增的正整数数列A=a1、a2、……、an，如果一个正整数T满足：
1）对于数列A中的任意元素x，如果x+T不大于an，则x+T也是数列A中的元素
2）对于数列A中的任意元素x，如果x-T不小于a1，则x-T也是数列A中的元素
那么称T为数列A的周期，如果同时满足：
3）所有小于T的正整数，都不是A的周期
则称T为A的最小周期
输入描述:
每组测试样本的输入格式为：
第一行是一个正整数N
从第二行开始，每行有若干个正整数，依次存放n、a1、a2、……、an，一共有N行，也就是N个数列。
输出描述:
输出有N行，每行打印出对应数列的最小周期。
示例1
输入
3
3 1 2 3
3 2 4 6
3 3 4 6
输出
1
2
3
说明
数据范围：
N：0<N<10
an：an<10^9
n：
0<n<10^3（50%）
0<n<10^4（30%）
0<n<10^6（20%）
     */

    public static void OneV2() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int n = in.nextInt();
            long[] a = new long[n + 1];
            for(int k = 1;k <= n;k ++)
            {
                a[k] = in.nextLong();
            }
            long T = 1;
            int start = 1;
            for (int j = 1; j <= n; j++) {

                if (j == 2) {
                    T = a[2] - a[1];
                    start = 2;
                }
                if (j > 2) {
                    if (a[start] + T == a[j]) {
                        start++;
                    } else {
                        if(start > 2)
                        {
                            start = 1;
                            T = a[j - 1] - a[start];
                            j --;
                        }
                        else
                        {
                            start = 1;
                            T = a[j] - a[start];
                        }
                        start++;
                    }
                }
            }

            System.out.println(T);

        }
    }

    /*
    题目描述
    现有n1+n2种面值的硬币，其中前n1种为普通币，可以取任意枚，后n2种为纪念币，每种最多只能取一枚，每种硬币有一个面值，问能用多少种方法拼出m的面值？
    输入描述:
    第一行三个整数n1, n2, m，分别表示普通币种类数，纪念币种类数和目标面值
    第二行n1个整数，第i种普通币的面值a[i]。保证a[i]为严格升序。
    第三行n2个整数，第i种纪念币的面值b[i]。保证b[i]为严格升序。
    对于30%的测试，保证1<=n1+n2<=10，1<=m<=100，1<=a[i]<=100 1<=b[i]<=100
    对于100%的测试，保证1<=n1+n2<=100, 1<=m<=100000, 1<=a[i]<=100000 1<=b[i]<=100000
    输出描述:
    输出一行，包含一个数字x，表示方法总数对1000000007（1e9+7）取模的结果。
    注意：不要忘记取模！
    示例1
    输入
    3 1 5
    1 2 3
    1
    输出
    9
    说明
    (x)代表面值为x的普通币，[x]代表面值为x的纪念币，样例所有方法数如下：
    (1)(1)(1)(1)(1)
    (1)(1)(1)(2)
    (1)(1)(3)
    (1)(2)(2)
    (2)(3)
    (1)(1)(1)(1)[1]
    (1)(1)[1](2)
    (1)[1](3)
    [1](2)(2)
    备注:
    两个方法，它们任意一种或以上的硬币数量不同，则认为是两种拼法。


     */
    public int resolveNumber2(int[] arr1, int[] arr2, int m) {
        int MOD = 1000000007;
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int num : arr1) {
            for (int i = num; i <= m; i++)
                dp[i] = (dp[i] + dp[i - num]) % MOD;
        }
        for (int num : arr2) {
            for (int i = m; i >= num; i--)
                dp[i] = (dp[i] + dp[i - num]) % MOD;
        }
        return dp[m];
    }

    /*
    题目描述
    小a在玩一个很简单的游戏，游戏的内容是控制一个小人在一块矩形的空地内走，一旦小人走出矩阵范围，游戏就失败。游戏机有上，下，左，右四个按键，每按一下小人就向相应的方向走一步。这个游戏过于简单，小a说：“这种游戏我闭着眼睛玩都输不了”。于是他便闭上眼睛,进行一连串的操作。但若他中途输了的话就会停止。
    那么问题来了:给定小a的操作，进行Q次询问，你能算出每次询问小人能走多少步吗？
    输入描述:
    第一行为长度L的字符串S，每个字符依次代表小a的一次操作。'u'代表向上，'d'代表向下，'l'代表向左，'r'代表向右。字符串S不会包含其他字符。
    第二行是整数Q，代表Q次询问
    接下来Q行，每行有四个整数，N，M，X，Y，保证1<=X<=N，1<=Y<=M，矩阵大小为N*M，小人初始位置为(X, Y)。
    对于30%的测试，0<X<=1000，0<Y<=1000，0<L<=1000，0<Q<=1000
    对于100%的测试，0<X<=100000(1e5)，0<Y<=100000(1e5)，0<L<=100000(1e5)，0<Q<=30000(3e4)
    输出描述:
    每次询问要求你打印一个整数s（单独一行），代表小人所走的步数。
    示例1
    输入
    uuurrdddddl
    3
    5 6 3 3
    5 6 4 2
    6 6 4 2
    输出
    3
    10
    11
    说明
    上下左右关系以下图为例，一个N=3，M=2的矩阵是这样的：
    (1,1)(1,2)
    (2,1)(2,2)
    (3,1)(3,2)
    备注:
    小人踏出矩阵外的那一步也要算入结果哦
     */
    public static void ThreeV2() {
        Scanner in = new Scanner(System.in);
        String S = in.nextLine();
        char[] c = S.toCharArray();
        int Q = in.nextInt();
        for (int i = 0; i < Q; i++) {
            int N = in.nextInt();
            int M = in.nextInt();
            int X = in.nextInt();
            int Y = in.nextInt();
            long step = 0;
            for (int j = 0; j < c.length; j++) {
                if (c[j] == 'u') {
                    X -= 1;
                    step++;
                    if (X < 1)
                        break;
                }
                if (c[j] == 'd') {
                    X += 1;
                    step++;
                    if (X > N)
                        break;
                    ;

                }
                if (c[j] == 'l') {
                    Y -= 1;
                    step++;
                    if (Y < 1)
                        break;

                }
                if (c[j] == 'r') {
                    Y += 1;
                    step++;
                    if (Y > M)
                        break;

                }
            }
            System.out.println(step);

        }
    }

    /*
    题目描述
    升序数组中第一个是1， 后续为若干连续的素数，对于数组里面的元素m和n（m < n）都对应了一个有理数m / n, 现在给定这个数组和一个K，要求返回第K小的有理数。
    输入描述:
    每组测试样本的输入格式为：
    第一行是一个正整数N
    从第二行开始，每行有若干个正整数，依次存放K、a1、……、an，一共有N行，也就是N组参数。
    K是输入参数表示需要寻找的顺序第K小的有理数， a1 - an 是以1开始后续n - 1个素数。
    输出描述:
    输出有N行，每行两个数字m和n，空格隔开，分别表示第K小有理数的分子和分母。
    示例1
    输入
    1
    3 1 2 3 5
    输出
    2 5
    备注:
    m、n必须为a1 - an中的满足条件的两个数。
    数据范围为：
    10 <= N <= 20000
    10 <= K <= 20000
    1 <= m < n < 20000
     */
    public static void FourV2() {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.nextLine();
        s = s.replaceAll(" ", "");
        String st[] = s.split("");
//System.out.println(k);
//String a [] = {"1","2","3","5"};
        fun(st, k - 1);
    }


    public static void fun(String a[], int b) {
        int n = 1, k = 1;

        for (int i = a.length - 1; i > 0; i--) {
            n = n * i;
            k = k * Integer.parseInt(a[i]);
        }
        int d[] = new int[n];
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                d[c] = (k * Integer.parseInt(a[i])) / Integer.parseInt(a[j]);
                c++;

            }
        }
        Arrays.sort(d);
        int p = d[b];
        for (int i = 2; i <= p; i++) {
            if (p % i == 0 && k % i == 0) {
                p = p / i;
                k = k / i;
                i = i - 1;
            }
        }
        System.out.println(p + " " + k);
    }


/*
题目描述
有一台用电容组成的计算器，其中每个电容组件都有一个最大容量值（正整数）。
对于单个电容，有如下操作指令：
指令1：放电操作 - 把该电容当前电量值清零
指令2：充电操作 - 把该电容当前电量补充到其最大容量值
对于两个电容A和B，有如下操作指令：
指令3：转移操作 - 从A中尽可能多的将电量转移到B，转移不会有电量损失，如果能够充满B的最大容量，那剩余的电量仍然会留在A中

现在已知有两个电容，其最大容量分别为a和b，其初始状态都是电量值为0，希望通过一系列的操作可以使其中某个电容（无所谓哪一个）中的电量值等于c（c也是正整数），这一系列操作所用的最少指令条数记为M，如果无论如何操作，都不可能完成，则定义此时M=0。
显然对于每一组确定的a、b、c，一定会有一个M与其对应。
输入描述:
每组测试样本的输入格式为：
第一行是一个正整数N
从第二行开始，每行都是3个正整数依次组成一组a、b、c，一共有N组
输出描述:
输出为N行，每行打印每一组的对应的M
示例1
输入
2
3 4 2
2 3 4
输出
4
0
说明
对于（3，4，2）,最少只需要4个指令即可完成：
（设最大容量为3的是A号电容，另一个是B号电容）
充电 A转移 A->B充电 A转移 A->B
此时A中当前电量为2，操作完成，所以输出4。
对于（2，3，4），显然不可能完成，输出0。
备注:
数据范围：
N：0<N<100
a、b、c：
0<a、b、c<10^5（50%）
0<a、b、c<10^7（30%）
0<a、b、c<10^9（20%）
 */



   public static void ThreeOfOne()
   {
       Scanner in = new Scanner(System.in);

       int count = 0;

       while (in.hasNextLine()) {//注意while处理多个case
           String str = in.nextLine();

           boolean b1 = false;
           boolean b2 = false;
           if(str.contains("//"))
           {
               count ++;
           }
           char[] c = str.toCharArray();
           for(int  i = 0;i < c.length - 1;i ++)
           {
               if(!b2)
               {
                   if(c[i] == '"')
                   {
                       b2 = true;
                       continue;
                   }
                   if(!b1)
                   {
                       if(c[i] == '/' && c[i + 1] == '*')
                       {
                           b1 = true;
                       }
                   }
                   else
                   {
                       if(c[i] == '*' && c[i + 1] == '/')
                       {
                           b1 = false;
                           count ++;
                       }
                   }

               }
               else
               {
                   if(c[i] == '"')
                   {
                       b2 = false;
                   }
               }

           }
       }
       System.out.println(count);

   }
   public static void ThreeOfTwo()
   {

       Scanner in = new Scanner(System.in);

       while (in.hasNext())
       {
           int m = in.nextInt();
           int n = in.nextInt();
           String[] lib = new String[m];
           String[] pre = new String[n];
           in.nextLine();
           for(int i = 0;i < m;i ++)
           {
               lib[i] = in.nextLine();
           }
           in.nextLine();
           for(int i = 0;i < n;i ++)
           {
               pre[i] = in.nextLine();
           }


           for(int i = 0;i < n; i ++)
           {
               boolean b = true;
               for(int j = 0;j < m;j ++)
               {
                   if(pre[i].startsWith(lib[j]))
                   {
                       System.out.println("1");
                       b = false;
                       break;
                   }
               }
               if(b)
                   System.out.println("-1");
           }
           System.out.println();
           in.nextLine();

       }

   }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        for(int i = 0;i < N;i ++)
        {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] ms = new int[m];
            for(int j = 0;j < m;j ++)
            {
                ms[j] = in.nextInt();
            }

            int[] as = new int[n];

            int posm = 0;
            int count = n;
            int posn = 0;
            while (count > 1)
            {
                int taotai = getTaotai(ms[posm],as,posn);
            //    System.out.println(taotai);
                posm ++;
                if(posm == m)
                    posm = 0;
                as[taotai] = 1;
                posn = taotai + 1;
                if(posn == n)
                    posn = 0;
                while (as[posn] != 0)
                {
                    posn ++;
                    if(posn == n)
                        posn = 0;
                }
                count --;
            }
            for(int p = 0;p < n;p ++)
            {
                if(as[p] == 0)
                {
                    System.out.println(p);
                    break;
                }

            }

        }



    }
    public static int getTaotai(int m,int[] as,int posn)
    {
        int count = 0;
        while (count < m)
        {
            if(posn == as.length)
                posn = 0;
            if(as[posn] == 0)
            {
                count ++;
            }
            posn ++;

        }
        return posn - 1 ;
    }

}
