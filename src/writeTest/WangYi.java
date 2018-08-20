package writeTest;

import java.util.Arrays;
import java.util.Scanner;

public class WangYi {

/*
6 3
1 3 5 2 5 4
1 1 0 1 0 0
 */
    public static void test1(){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int[] a = new int[n];
        int[] t = new int[n];
        for(int i = 0;i < n;i  ++){
            a[i] = in.nextInt();
        }
        for(int i = 0;i < n;i  ++){
            t[i] = in.nextInt();
        }

        int sum = 0;
        int max = 0;
        for(int i = 0;i < n;i ++){
            if(t[i] == 1){
                sum += a[i];
            }
        }
        int tempsum = sum;
        max = sum;
        for(int i = 0;i < n;i ++){
            if(t[i] == 0){
                for(int j = 0;i + j < n && j < k;j ++){
                    if(t[i + j] == 0){
                        sum += a[i + j];
                        if(sum > max)
                            max = sum;
                    }
                }
                sum = tempsum;
            }
        }
        System.out.println(max);

    }

/*

5
2 7 3 4 9
3
1 25 11
 */
    public static void test2(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n;i  ++){
            a[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] q = new int[m];
        for(int i = 0;i < m;i  ++){
            q[i] = in.nextInt();
        }

        int[] sum = new int[n];
        for(int i = 0;i < n;i ++){
            if( i == 0)
                sum[i] = a[i];
            else {
                sum[i] = sum[i - 1] + a[i];
            }
        }

        int[] res = new int[m];
        for(int i = 0;i < m;i ++){
            res[i] = findInSum(sum,q[i]);
        }
        for(int i = 0;i < m;i ++){
            System.out.println(res[i] + 1);
        }

    }



    private static int findInSum(int[] sum, int q) {
        return find(sum,0,sum.length - 1,q);
    }

    private static int find(int[] sum, int l, int r, int q) {
        if(l > r)
        {
            if(q > sum[r])
                return r + 1;
            else
                return r;
        }
        if(l < 0)
            return l;
        if(r == l && q == sum[l])
            return l;
        if(r - l == 1){
            if(sum[r] == q)
                return r;
            if(sum[l] == q)
                return l;
            if(q < sum[l])
                return l;
        }
        int mid = (l + r)/2;
        if(q > sum[mid]){
            return find(sum,mid + 1,r,q);
        }
        else if(q < sum[mid]) {
            return find(sum,l,mid - 1,q);
        }
        else
            return mid;

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();//a
            int m = in.nextInt();//z
            int k = in.nextInt();
            double max = getMax(n, m);//计算最多的字符串数量
            if(k>max){
                System.out.println(-1);
            }else {
                helper(n,m,k);
                System.out.println();
            }
        }

    }
    public static void helper(int n,int m,int k){
        if(n == 0 && m == 0){
            return;
        }
        if(n == 0){//a个数为0时，就把z全输出
            for(int i = 0;i<m;i++){
                System.out.print("z");
            }
            return;
        }else if (m == 0) {
            for(int i = 0;i<n;i++){
                System.out.print("a");
            }
            return;
        }
        double max = getMax(n-1, m);
        if(max>=k){//如果比k大，就放a
            System.out.print("a");
            helper(n-1, m, k);
        }else {//如果比k小，就放z
            System.out.print("z");
            helper(n, m-1, (int)Math.round(k-max));
        }
    }

    public static double getMax(int n,int m){//计算n个a与m个z组成的字符串总量
        double max = 1;
        for(int i = 0;i<n;i++){
            max *= (m+n-i);
        }
        for(int i = 0;i<n;i++){
            max /= i+1;
        }
        return max;
    }
}
