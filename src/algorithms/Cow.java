package algorithms;
/*

母牛每年生一只母牛，新出生的母牛成长三年后也能每年生一只
母牛，假设不会死。求N年后，母牛的数量。

如果每只母牛只能活10年，求N年后，母牛的数量。

 */
public class Cow {


    public static int cowNumber1(int n) {
        if(n < 1)
            return 0;
        if(n == 1 || n == 2 || n == 3){
            return n;
        }
        return cowNumber1(n - 1) + cowNumber1(n - 3);
    }

    public static int cowNumber2(int n) {
        if(n < 1)
            return 0;
        if(n == 1 || n == 2 || n == 3){
            return n;
        }

        int res = 3;
        int pre = 2;
        int prepre = 1;
        int tempRes = 0;
        for(int i = 4;i <= n;i ++){
            tempRes = res;
            res = res + prepre;
            prepre = pre;
            pre = tempRes;
        }
        return res;
    }

    public static int cowNumberLiveTen(int n) {
        if(n < 1)
            return 0;
        if(n == 1 || n == 2 || n == 3){
            return n;
        }

        int res = 3;
        int pre = 2;
        int prepre = 1;
        int tempRes = 0;
        int[] ten = new int[11];
        ten[1] = 1;
        ten[2] = 2;
        ten[3] = 3;
        for(int i = 4;i <= n;i ++){
            if(i > 10)
            {
                res = res - ten[i%10];
            }
            tempRes = res;
            res = res + prepre;
            prepre = pre;
            pre = tempRes;
            if (i <= 10){
                ten[i] = res;
            }
            if(i > 10)
            {
                ten[i%10] = res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
    /*    int n = 20;
        System.out.println(cowNumber1(n));
        System.out.println(cowNumber2(n));*/

        int n = 11;
        System.out.println(cowNumber1(n));
        System.out.println(cowNumber2(n));
        System.out.println(cowNumberLiveTen(n));
    }
}
