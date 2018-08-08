package swordtooffer;

public class MultiplyArray {


    /*
        题目描述
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
         */

    public int[] multiply(int[] A) {


        if(A == null)
            return  null;
        int len = A.length;
        int[] B = new int[len];
        for(int i = 0;i < len;i ++)
        {
            int sum1 = 1;
            int sum2 = 1;
            for(int j = i - 1;j >= 0;j --)
            {
                sum1 *= A[j];
            }
            for(int k = i + 1;k <= len - 1;k ++)
            {
                sum2 *= A[k];
            }
            B[i] = sum1 * sum2;
        }
        return B;
    }

    public int[] multiplyV2(int[] A)
    {
        if(A == null)
            return  null;
        int len = A.length;
        int[] B = new int[len];
        B[0] = 1;
        for(int i = 1;i < len;i ++)
        {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        for(int j = len - 2;j >= 0;j --)
        {
            temp *= A[j + 1];
            B[j] *= temp;
        }
        return B;
    }
    public static void main(String[] args)
    {

    }
}
