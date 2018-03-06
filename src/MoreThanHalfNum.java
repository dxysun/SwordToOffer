import java.util.Arrays;

public class MoreThanHalfNum {
    public static int MoreThanHalfNum_Solution(int [] array) {
        if(array == null)
            return 0;
        int length = array.length;
        int max = array[0];
        int min = array[0];
        for(int i = 0;i < length;i ++)
        {
            if(array[i] > max)
                max = array[i];
            if(array[i] < min)
                min = array[i];
        }
        int[] newArrry = new int[max - min + 1];

        for (int i: array) {
            newArrry[i - min] ++;
        }
        int maxNum = 0;
        int num = 0;
        for(int i = 0;i < newArrry.length;i ++)
        {
            if(newArrry[i] > maxNum)
            {
                maxNum = newArrry[i];
                num = i + min;
            }
        }
        if(maxNum <= length/2)
            num = 0;
        return num;
    }
    public static void main(String[] args)
    {
        int[] a = {1,2,3,-2,-2,-2,5,4,-2};
        System.out.println(MoreThanHalfNum_Solution(a));
    }
}
