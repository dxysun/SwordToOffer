package writeTest;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Tencent {
    public static void one() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] x = new int[4];
        int[] y = new int[4];
        while (in.hasNextInt()) {      //注意while处理多个case
            x[0] = in.nextInt();
            x[1] = in.nextInt();
            x[2] = in.nextInt();
            x[3] = in.nextInt();
            y[0] = in.nextInt();
            y[1] = in.nextInt();
            y[2] = in.nextInt();
            y[3] = in.nextInt();

            int length01 = (x[0] - x[1]) * (x[0] - x[1]) + (y[0] - y[1]) * (y[0] - y[1]);
            int length02 = (x[0] - x[2]) * (x[0] - x[2]) + (y[0] - y[2]) * (y[0] - y[2]);
            int length03 = (x[0] - x[3]) * (x[0] - x[3]) + (y[0] - y[3]) * (y[0] - y[3]);
            int length12 = (x[1] - x[2]) * (x[1] - x[2]) + (y[1] - y[2]) * (y[1] - y[2]);
            int length13 = (x[1] - x[3]) * (x[1] - x[3]) + (y[1] - y[3]) * (y[1] - y[3]);
            int length23 = (x[2] - x[3]) * (x[2] - x[3]) + (y[2] - y[3]) * (y[2] - y[3]);

            if (length01 == length02) {
                if (length01 + length02 == length12) {
                    if (length23 + length13 == length12) {
                        System.out.println("YES");
                        continue;
                    }
                }
            }
            if (length01 == length03) {
                if (length01 + length03 == length13) {
                    if (length12 + length23 == length13) {
                        System.out.println("YES");
                        continue;
                    }
                }
            }
            if (length02 == length03) {
                if (length02 + length03 == length23) {
                    if (length12 + length13 == length23) {
                        System.out.println("YES");
                        continue;
                    }
                }
            }
            System.out.println("NO");
        }
    }

    public static void OneV2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] a = new int[n];
        int j = 1;
        int init = -1;
        int sum = 0;
       /* for(int i = 0;i < n;i ++)
        {
            if(j > m)
            {
                init *= -1;
                j = 1;
            }
            a[i] = (i + 1)* init;
            j ++;
            sum += a[i];
        }*/

        int shang = n / (2 * m);


        BigInteger bigShang = BigInteger.valueOf(shang);
        BigInteger bigM = BigInteger.valueOf(m);
        BigInteger bigSum = bigShang.multiply(bigM.multiply(bigM));
        System.out.println(bigSum);

    }

    public static void dfs(int K, int A, int B, Stack<Integer> stack, int pre, int lenA, int lenB) {
        if ((lenA <= 0 || lenB <= 0) && (K < A || K < B)) {
       /*     System.out.println("lenA:" + lenA);
            System.out.println("lenB:" + lenB);
            System.out.println("K:"+K);*/
            if (K == 0 && (lenA == 0 || lenB == 0)) {
                Stack<Integer> s = new Stack<>();
                while (!stack.isEmpty()) {
                    s.push(stack.pop());
                }
                while (!s.isEmpty()) {
                    int t = s.pop();
                    System.out.print(t + " ");
                    stack.push(t);
                }
                System.out.println();
                System.out.println(lenA);
                System.out.println(lenB);
            }
            return;
        }
        if (pre <= A) {
            stack.push(A);
            dfs(K - A, A, B, stack, A, lenA - 1, lenB);
            stack.pop();
        }
        if (pre <= B) {
            stack.push(B);
            dfs(K - B, A, B, stack, B, lenA, lenB - 1);
            stack.pop();
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        int A = in.nextInt();
        int X = in.nextInt();
        int B = in.nextInt();
        int Y = in.nextInt();

        int[][] dp = new int[X + Y + 1][K + 1];
        for (int i = 0; i < X + Y + 1; i++)
            dp[i][0] = 1;

        for (int i = 1; i < X + Y + 1; i++) {
            for (int j = 1; j <= K; j++) {
                if (i <= X) {
                    if (j >= A)
                        dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - A]) % 1000000007;
                    else
                        dp[i][j] = dp[i - 1][j] % 1000000007;
                } else if (i <= X + Y) {
                    if (j >= B)
                        dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - B]) % 1000000007;
                    else
                        dp[i][j] = dp[i - 1][j] % 1000000007;
                }
            }
        }
        for (int i = 0; i < X + Y + 1; i++) {
            for (int j = 0; j <= K; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[X + Y][K]);
    }
}
