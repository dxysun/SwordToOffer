package algorithms;

/*
给你一个数组arr，和一个整数aim。如果可以任意选择arr中的
数字，能不能累加得到aim，返回true或者false
 */
public class Money_Problem {


    public static boolean money1(int[] a,int aim){
        if(a == null)
            return false;

        return process1(a,0,0,aim);
    }

    private static boolean process1(int[] a,int i,int sum,int aim) {
        if(sum == aim)
            return true;
        if(i == a.length)
            return false;
        return process1(a,i + 1,sum,aim) || process1(a,i + 1,sum + a[i],aim);
    }

    public static boolean money2(int[] a,int aim){
        if(a == null)
            return false;
        int len = a.length;
        boolean[][] res = new boolean[len + 1][aim + 1];

        for(int i = 0;i < len + 1;i ++){
            res[i][aim] = true;
        }

        for(int i = len - 1;i >= 0;i --){
            for (int j = aim - 1;j >= 0;j --){

                res[i][j] = res[i + 1][j];
                if(j + a[i] <= aim){
                    res[i][j] = res[i + 1][j] || res[i + 1][j + a[i]];
                }

            }
        }

        return res[0][0];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 8 };
        int aim = 12;
        System.out.println(money1(arr, aim));
        System.out.println(money2(arr, aim));
    }
}
