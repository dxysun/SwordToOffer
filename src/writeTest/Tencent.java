package writeTest;

import java.util.Scanner;

public class Tencent
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] x = new int[4];
        int[] y = new int[4];
        while (in.hasNextInt()) {//注意while处理多个case
            x[0] = in.nextInt();
            x[1] = in.nextInt();
            x[2] = in.nextInt();
            x[3] = in.nextInt();
            y[0] = in.nextInt();
            y[1] = in.nextInt();
            y[2] = in.nextInt();
            y[3] = in.nextInt();

            int length01 = (x[0] - x[1])*(x[0] - x[1]) + (y[0] - y[1])*(y[0] - y[1]);
            int length02 = (x[0] - x[2])*(x[0] - x[2]) + (y[0] - y[2])*(y[0] - y[2]);
            int length03 = (x[0] - x[3])*(x[0] - x[3]) + (y[0] - y[3])*(y[0] - y[3]);
            int length12 = (x[1] - x[2])*(x[1] - x[2]) + (y[1] - y[2])*(y[1] - y[2]);
            int length13 = (x[1] - x[3])*(x[1] - x[3]) + (y[1] - y[3])*(y[1] - y[3]);
            int length23 = (x[2] - x[3])*(x[2] - x[3]) + (y[2] - y[3])*(y[2] - y[3]);

            if(length01 == length02)
            {
                if(length01 + length02 == length12)
                {
                    if(length23 + length13 == length12)
                    {
                        System.out.println("YES");
                        continue;
                    }
                }
            }
            if(length01 == length03)
            {
                if(length01 + length03 == length13)
                {
                    if(length12 + length23 == length13)
                    {
                        System.out.println("YES");
                        continue;
                    }
                }
            }
            if(length02 == length03)
            {
                if(length02 + length03 == length23)
                {
                    if(length12 + length13 == length23)
                    {
                        System.out.println("YES");
                        continue;
                    }
                }
            }
            System.out.println("NO");
        }
        
    }
}
