package algorithms;

/*
给定两个数组w和v，两个数组长度相等，w[i]表示第i件商品的
重量，v[i]表示第i件商品的价值。 再给定一个整数bag，要求
你挑选商品的重量加起来一定不能超 过bag，返回满足这个条件
下，你能获得的最大价值。

 */
public class Knapsack {

    public static int maxValue1(int[] w, int[] v, int bag) {
        return process1(w, v, 0, 0, 0, bag);
    }

    private static int process1(int[] w, int[] v, int i, int wdata, int vdata, int bag) {

        if (i == w.length - 1) {
            return wdata + w[i] > bag ? vdata : vdata + v[i];
        }

        if (wdata + w[i] > bag) {
            return process1(w, v, i + 1, wdata, vdata, bag);
        }
        return Math.max(process1(w, v, i + 1, wdata, vdata, bag), process1(w, v, i + 1, wdata + w[i], vdata + v[i], bag));
    }

    public static int maxValue2(int[] w, int[] v, int bag) {
        return process2(w, v, 0, 0, bag);

    }

    private static int process2(int[] w, int[] v, int i, int wdata, int bag) {
//        System.out.println(wdata);
        if (wdata > bag)
            return 0;
        if (i == w.length)
            return 0;
        return wdata + w[i] <= bag ? Math.max(process2(w, v, i + 1, wdata, bag), v[i] + process2(w, v, i + 1, wdata + w[i], bag)) :
                process2(w, v, i + 1, wdata, bag);
    }


    public static int maxValueDp(int[] w,int[] v,int bag){
        int len = w.length;

        int[][] dp = new int[len + 1][bag + 1];

        for(int i = len - 1;i >= 0;i --){
            for(int j = bag - 1;j >= 0;j --){
                dp[i][j] = dp[i + 1][j];
                if(w[i] + j <= bag){
                    dp[i][j] = Math.max(dp[i][j],v[i] + dp[i + 1][j + w[i]]);
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        int[] c = {3, 2, 4, 7};
        int[] p = {5, 6, 3, 19};
        int bag = 11;
        System.out.println(maxValue1(c, p, bag));

        System.out.println(maxValue2(c, p, bag));

        System.out.println(maxValueDp(c, p, bag));
    }


}
