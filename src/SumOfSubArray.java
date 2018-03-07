public class SumOfSubArray {

    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null)
            return 0;
        int max = array[0];
        int length = array.length;
        int[][] sumMatrix = new int[length][length];
        for(int i = 0;i < length; i ++)
            for (int j = 0;j <= i;j ++)
            {
                if(j == i)
                {
                    sumMatrix[i][j] = array[i];
                    if(sumMatrix[i][j] > max)
                        max = sumMatrix[i][j];
                }
                else
                {
                    sumMatrix[i][j] = array[i] + sumMatrix[i - 1][j];
                    if(sumMatrix[i][j] > max)
                        max = sumMatrix[i][j];
                }
            }
        return  max;
    }
    public static void main(String[] args)
    {
        int[] array = {6,-3,-2,7,-15,1,2,2};
        SumOfSubArray a = new SumOfSubArray();
        System.out.println(a.FindGreatestSumOfSubArray(array));
    }
}
