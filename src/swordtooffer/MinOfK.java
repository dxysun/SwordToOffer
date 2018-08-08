package swordtooffer;

import java.util.ArrayList;
import java.util.Arrays;

public class MinOfK {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input == null || k > input.length || k == 0)
            return list;
        int length = input.length;
        Arrays.sort(input);
        for(int i = 0;i < length;i ++)
        {
            list.add(input[i]);
            if(i + 1 == k)
                break;
        }
        return list;
    }
    public int partition(int[] data,int length,int start,int end)
    {
        int index = start + 1;

         int temp = data[end];
         data[end] = data[index];
         data[index] = temp;

         int small = start - 1;
         for(index = start;index < end;index ++)
         {
             if(data[index] < data[end])
             {
                 small ++;
                 if(small != index)
                 {
                     int t = data[index];
                     data[index] = data[small];
                     data[small] = t;
                 }
             }
         }
          small ++;
          int n = data[end];
          data[end] = data[small];
          data[small] = n;
          return small;

    }
    public void quickSort(int[] data,int length,int start,int end)
    {
        if(start == end)
            return;
        int index = partition(data,length,start,end);
        if(index > start)
        {
            quickSort(data,length,start,index - 1);
        }
        if(index < end)
        {
            quickSort(data,length,index + 1,end);
        }
    }
    public static void main(String[] args)
    {
        MinOfK a = new MinOfK();
        int[] b = {4,5,1,6,2,7,3,8};
       /* ArrayList<Integer> list = a.GetLeastNumbers_Solution(b, 4);
        for (int i: list) {
            System.out.println(i);
        }*/
       a.quickSort(b,b.length,0,b.length - 1);
       System.out.println(Arrays.toString(b));

    }
}
