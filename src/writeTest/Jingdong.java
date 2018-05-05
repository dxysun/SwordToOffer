package writeTest;

import java.util.Scanner;
import java.util.Stack;

public class Jingdong {

    /*
    对于一个字符串, 从前开始读和从后开始读是一样的, 我们就称这个字符串是回文串。

例如"ABCBA","AA", "A"是回文串, 而"ABCD", "AAB"不是回文串。

牛牛特别喜欢回文串, 他手中有一个字符串s, 牛牛在思考能否从字符串中移除部分(0个或多个)字符使其变为回文串，并且牛牛认为空串不是回文串。

牛牛发现移除的方案可能有很多种, 希望你来帮他计算一下一共有多少种移除方案可以使s变为回文串。

对于两种移除方案, 如果移除的字符依次构成的序列不一样就是不同的方案。

输入描述:
输入包括一个字符串s(1 <= length(s) <= 50),s中只包含大写字母。
输出描述:
对于每个测试用例, 输出一个正整数表示方案数。


分析
dp[l][r]表示区间 [l, r] 内的回文串数目。
于是dp[l][r] = dp[l][r - 1] + dp[l + 1][r],
根据s[l] ?= s[r], 来看是+1还是减掉重复的部分。

时间复杂度
O(n^2)
     */

    public static void one() {
        long[][] dp = new long[55][55];
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        char[] c = str.toCharArray();
        char[] s = new char[55];
        int len = c.length ;
        for (int j = 1;j <= len; j++)
        {
            s[j] = c[j - 1];
        }

        for (int i = 1; i <= len; i++) {
            for (int l = 1; l + i - 1 <= len; l++) {
                int r = l + i - 1;
                dp[l][r] += dp[l + 1][r];
                dp[l][r] += dp[l][r - 1];
                if (s[l] == s[r])
                    dp[l][r] += 1;
                else
                    dp[l][r] -= dp[l + 1][r - 1];
            }
        }
        System.out.println(dp[1][len]);

    }

    /*
    小Q的数学老师给了小Q一个整数N, 问小Q能否将W分解为两个整数X和Y相乘, 并且满足X为奇数, Y为偶数,即能否找到奇数X和偶数Y满足X * Y = N。
    小Q被这个问题难住了, 希望能你来帮助他计算。
    输入描述:
    输入的第一行包含一个正整数t(1 <= t <= 1000), 表示测试样例数。
    接下来的t行, 每行一个正整数N(2 <= N < 2^63), 表示给出的N。保证N不是2的幂次。
    输出描述:
    如果能找到这样的X,Y,则依次输出X,Y,如果有多解输出Y最小的那组解,以空格分割,否则输出"No"。
     */
    public static void two() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long N = in.nextLong();

            if ((N & 1) != 0) {
                System.out.println("No");
                continue;
            }
            long y = 0;
            long x = -1;
            boolean b = false;
            for (y = 2; y < N / 2; y += 2) {
                if (N % y == 0) {
                    x = N / y;
                    if ((x & 1) != 0) {
                        b = true;
                        break;
                    }
                }
            }
            if (b) {
                System.out.println(x + " " + y);
            } else
                System.out.println("No");
        }
    }
    //()()()()，(()),)(()()   交换一次且仅一次后正常匹配

    public static void three() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String str = in.nextLine();
        for (int i = 0; i < t; i++) {
            String s = in.nextLine();
            char[] c = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            int count = 0;
            boolean b = true;
            if (c.length == 2) {
                if (c[0] == '(' && c[1] == ')') {
                    System.out.println("No");
                    continue;
                }
            }
            int l = 0;
            int r = 0;
            for (int j = 0; j < c.length; j++) {
                if (c[j] == '(')
                    l++;
                else
                    r++;
            }
            if (l != r) {
                System.out.println("No");
                continue;
            }
            for (int j = 0; j < c.length; j++) {
                if (stack.isEmpty()) {
                    stack.push(c[j]);
                } else {
                    if (stack.peek() == '(') {
                        if (c[j] == ')') {
                            stack.pop();
                        } else {
                            stack.push(c[j]);
                        }
                    } else if (stack.peek() == ')') {
                        if (c[j] == ')') {
                            b = false;
                            break;
                        } else {
                            stack.push(c[j]);
                        }
                    }
                }
            }
            if (!b) {
                System.out.println("No");
                continue;
            }
            if (stack.isEmpty()) {
                System.out.println("Yes");
            } else {
                if (stack.size() == 2) {
                    char c1 = stack.pop();
                    char c2 = stack.pop();
                    if (c1 == '(' && c2 == ')') {
                        System.out.println("Yes");
                    } else
                        System.out.println("No");

                } else {
                    System.out.println("No");

                }
            }
        }

    }

    public static void main(String[] args) {
        one();

    }
}
