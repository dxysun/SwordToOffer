package swordtooffer;

import java.util.ArrayList;

public class TwoNumSum {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array == null)
            return list;
        int start = 0;
        int end = array.length - 1;
        while (start < end)
        {
            int s = array[start] + array[end];
            if(s == sum)
            {
                list.add(array[start]);
                list.add(array[end]);
                break;
            }
            else if(s > sum)
            {
                end --;
            }
            else
                start ++;
        }
        return list;
    }

    public static void main(String[] args)
    {
        TwoNumSum t = new TwoNumSum();
        int[] a = {1,2,4,7,11,15};
        System.out.print(t.FindNumbersWithSum(a,15));
    }
}
