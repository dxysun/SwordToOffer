import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main2 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        int[] p = new int[n];

        for (int k = 0;k < n; k ++) {//注意while处理多个case
            p[k] = in.nextInt();
        }
        Arrays.sort(p);
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for(int j = 0;j < p.length;j ++)
        {
            count += p[j];
            if(count >= s)
            {
                stack.push(p[j]);
                break;
            }
            stack.push(p[j]);
        }

        int num = 0;
        count = 0;
        while (!stack.isEmpty())
        {
            int t = stack.pop();
            count += t;
            if(count >= s)
            {
                num ++;
                break;
            }
            num ++;
        }
        System.out.println(num);
    }
}
