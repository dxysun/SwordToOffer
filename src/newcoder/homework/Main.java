package newcoder.homework;

import java.util.*;

public class Main {


    /*

给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
输入描述:
输入为一行，M(32位整数)、N(2 ≤ N ≤ 16)，以空格隔开。


输出描述:
为每个测试实例输出转换后的数，每个输出占一行。如果N大于9，则对应的数字规则参考16进制（比如，10用A表示，等等）
示例1
输入
7 2
输出
111
     */

    public static void binaryConversion(){
        char[] str = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        Scanner in  = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        Stack<Integer> stack = new Stack<>();

        if(M < 0)
        {
            M = -M;
            System.out.print("-");
        }

        while (M != 0){
            stack.push(M%N);
            M /= N;
        }

        while (!stack.isEmpty()){

            System.out.print(str[stack.pop()]);
        }
    }
/*

输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
输入描述:
输入为一行，n(1 ≤ n ≤ 1000)


输出描述:
输出一个整数,即题目所求
示例1
输入
10
输出
2
 */
    public static void numOfZero(){
        Scanner in  = new Scanner(System.in);
        int N = in.nextInt();
        int count = 0;
        for (int i = 5; N / i > 0; i *= 5) {
            count += N / i;
        }
        System.out.println(count);


    }

    public static void main(String[] args){
        String str = "a";
        str.hashCode();
        Integer b = 0;
        b.hashCode();
//        binaryConversion();
        numOfZero();
    }
}
