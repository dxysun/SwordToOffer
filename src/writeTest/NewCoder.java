package writeTest;

import java.util.Scanner;

public class NewCoder {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Double[] a = new Double[n];
        int count = 0;
        int m = 0;
        for(int i = 0;i < n;i ++){
            a[i] = in.nextDouble();

            String str = a[i].toString();

            if(str.contains("."))
            {
                System.out.println(str);
                m ++;
                double d = a[i];
                int temp = (int)d;
                if(temp % 2 == 0)
                {
                    count ++;
                }
            }
        }
        if(count == 0)
        {
            System.out.println("0");
            return;
        }
        System.out.println(m);
    }
}
