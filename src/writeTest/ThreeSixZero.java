package writeTest;

import java.util.Scanner;

public class ThreeSixZero {


    /*
    沫璃有一个画板，画板可以抽象成有100行每行100个像素点的正方形。沫璃在画板上画画，她一共画了n次，每次将一个矩形涂上颜色。沫璃想知道一共有多少个像素点被她涂过颜色。若一个像素点被涂了k次，那么认为有k个像素点被涂过颜色。

输入
第一行一个数T(T<=100)，表示数据组数。

对于每组数据，第一行一个整数n , (1<=n<=100)

接下来n行，每行4个整数x1, y1, x2, y2 (1 <= x1 <= x2 <= 100, 1 <= y1 <= y2 <= 100)，表示矩形的两个对角所对应的像素点的坐标。

输出
对于每组数据，输出一行，表示沫璃一共涂了多少个像素点。
     */
    public void One()
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0;i < t;i ++)
        {
            int n = in.nextInt();
            int[][] a = new int[n][4];
            int count = 0;
            for(int j = 0;j < n;j ++)
            {
                a[j][0] = in.nextInt();
                a[j][1] = in.nextInt();
                a[j][2] = in.nextInt();
                a[j][3] = in.nextInt();

                int width = Math.abs(a[j][2] - a[j][0]) + 1;
                int heigh = Math.abs(a[j][3] - a[j][1]) + 1;
                count += width * heigh;
            }
            System.out.println(count);
        }

    }

    /*
    沫璃邀请她的朋友参加周末的派对。沫璃买了3种颜色的气球，现在她要有这些气球来装饰餐桌，每个餐桌只用恰好3个气球装饰，要求3个气球的颜色不能完全一样，可以是2种或者1种颜色。沫璃想知道这些气球最多能装饰多少张餐桌。

     输入
第一行一个数T(T<=100)，表示数据组数。

对于每组数据，第一行3个整数r，g，b，分别表示三种颜色的气球个数 (0<=r, g, b<=2*10^9)

输出
对于每组数据，输出一行，一个整数表示最多能装饰的餐桌数量。
     */

    /*
    给你一个图，0节点连接这一个联通块a，1节点连接着一个联通块b,ab仅由01这条边相连。

现在我们定义奇异路径为恰好经过0-1这条边一次的路径，其他边可以经过任意次，且路径不带方向，1-2-3与3-2-1认为是两条路径。重边也算多条路。

在这个图中有无数条奇异路径，问第k短的奇异路径长度是多少？

输入
输入若干行，第一行有三个正整数n,m,k,表示有n个节点，0~n-1,有m条边，问第k长，接下来有m行u,v,表示边，保证0-1边只出现一次,保证a,b联通块只通过0-1相连。

输出
输出一行表示答案
     */

    public static int dfs(int r,int g,int b,int count)
    {
        if(r > 0 && g > 0 && b > 0)
        {
            count ++;
            int max = 0;
            int a1 = dfs(r - 1,g - 1,b - 1,count);
            if(a1 > max)
                max = a1;
            int a2 = dfs(r - 2,g - 1,b,count);
            if(a2 > max)
                max = a2;
            int a3 = dfs(r - 1,g - 2,b,count);
            if(a3 > max)
                max = a3;
            int a4 = dfs(r,g - 2,b - 1,count);
            if(a4 > max)
                max = a4;
            int a5 = dfs(r,g - 1,b - 2,count);
            if(a5 > max)
                max = a5;
            int a6 = dfs(r - 1,g,b - 2,count);
            if(a6 > max)
                max = a6;
            int a7 = dfs(r - 2,g,b - 1,count);
            if(a7 > max)
                max = a7;
            return max;

        }
        else
        {
            if(r == 0 && g == 0 && b == 0)
                return count;
            else if(r + g + b < 3)
                return count;
            else
            {
                if(r == 0)
                {
                    if(g == 0 || b == 0)
                    {
                        return 0;
                    }
                    else
                    {
                        int max = 0;
                        count ++;
                        int a1 = dfs(r,g - 2,b - 1,count);
                        if(a1 > max)
                            max = a1;
                        int a2 = dfs(r,g - 1,b - 2,count);
                        if(a2 > max)
                            max = a2;
                        return max;
                    }
                }
                if(g == 0)
                {
                    if(r == 0 || b == 0)
                    {
                        return 0;
                    }
                    else
                    {
                        int max = 0;
                        count ++;
                        int a1 = dfs(r - 2, g ,b - 1,count);
                        if(a1 > max)
                            max = a1;
                        int a2 = dfs(r - 1, g ,b - 2,count);
                        if(a2 > max)
                            max = a2;
                        return  max;
                    }
                }
                if(b == 0)
                {
                    if(g == 0 || r == 0)
                    {
                        return 0;
                    }
                    else
                    {
                        int max = 0;
                        count ++;
                        int a1 = dfs(r - 1,g - 2,b,count);
                        if(a1 > max)
                            max = a1;
                        int a2 = dfs(r - 2,g - 1,b,count);
                        if(a2 > max)
                            max = a2;
                        return max;
                    }
                }
                return 0;
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0;i < t;i ++)
        {
            int r = in.nextInt();
            int g = in.nextInt();
            int b = in.nextInt();
            int c = dfs(r,g,b,0);
            System.out.println(c);

        }


    }
}
