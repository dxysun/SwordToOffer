package swordtooffer;

import java.util.Arrays;

public class InversePairsNum {

    public int InversePairs(int [] array) {
        if(array == null)
            return 0;
        int length = array.length;
        if(length == 0)
            return 0;
        int[] copy = Arrays.copyOf(array,length);
        long count = InversePairsSort(array,copy,0,length - 1);

        System.out.println(Arrays.toString(copy));
        System.out.println(Arrays.toString(array));
        return (int)count%1000000007;
    }
    public long InversePairsSort(int[] array,int[] copy ,int start,int end)
    {

        if(start == end)
        {
            copy[start] = array[end];
            return 0;
        }
        int length = (end - start)/2;
      /*  long left = InversePairsSort(array,copy,start,start + length);
        long right = InversePairsSort(array,copy,start + length + 1,end);*/
        long left = InversePairsSort(copy,array,start,start + length);
        long right = InversePairsSort(copy,array,start + length + 1,end);

        int i = start + length;
        int j = end;
        int copyIndex = end;
        long count = 0;
        while(i >= start && j >= start + length + 1)
        {
            if(array[i] > array[j])
            {
                copy[copyIndex -- ] = array[i --];
                count += j - start - length;
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
            }
            else
            {
                copy[copyIndex --] = array[j --];
            }

        }
        while (i >= start)
        {
            copy[copyIndex -- ] = array[i --];
        }
        while(j >= start + length + 1)
        {
            copy[copyIndex --] = array[j --];
        }

       /* for(int t = start;t <= end;t ++)
        {
            array[t] = copy[t];
        }*/
        return (left + right + count)%1000000007;

    }
    public static void main(String[] args)
    {

        InversePairsNum a = new InversePairsNum();
        int[] b = {7,2,4,3 ,5,6,1,0};
        System.out.println(a.InversePairs(b));
    }
}
