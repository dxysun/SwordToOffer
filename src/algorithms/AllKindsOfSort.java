package algorithms;

import java.util.Arrays;

public class AllKindsOfSort {


    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void selectSort(int[] a)
    {
        int length = a.length;
        int flag = 0;
        for(int i = 0;i < length;i ++)
        {
            flag = i;
            for(int j = i + 1;j < length;j ++)
            {
                if(less(a[j],a[flag]))
                {
                    flag = j;
                }
            }
            swap(a,i,flag);
        }
    }
    public static void insertSort(int[] a)
    {
        int length = a.length;
        /*for(int i = 1;i < length;i ++)
        {
            int j = i;
            int temp = a[i];
            if(a[j - 1] > temp)
            {
                while (j >= 1 && a[j - 1] > temp  )
                {
                    a[j] = a[j - 1];
                    j --;
                }
                a[j] = temp;
            }
        }*/
        for(int i = 1;i < length;i ++)
        {
            for(int j = i;j > 0 && less(a[j],a[j - 1]);j --)
            {
                swap(a,j,j - 1);
            }
        }
    }
    public static void bubbleSort(int[] a)
    {
        int length = a.length;
        for(int i = 0;i < a.length - 1;i ++)
        {
            for(int j = 0;j < length - 1;j ++)
            {
                if(less(a[j + 1],a[j]))
                {
                    swap(a,j,j + 1);
                }
            }
            length --;
        }
    }
    public static void mergeSort(int[] a,int start,int end)
    {
        if(start < end)
        {
            int mid = (start + end) / 2;
            mergeSort(a,start,mid);
            mergeSort(a,mid + 1,end);

            int[] left = new int[mid - start + 1];
            int[] right = new int[end - mid];
            int l = -1,r = -1;
            for(int i = start;i <= mid;i ++)
            {
                left[++ l] = a[i];
            }
            for(int j = mid + 1;j <= end;j ++)
            {
                right[++ r] = a[j];
            }
            int newEnd = end;
            while (l >= 0 && r >= 0 )
            {
                if(left[l] > right[r])
                    a[newEnd --] = left[l --];
                else
                    a[newEnd --] = right[r --];
            }
            if(l >= 0)
            {
                while (l >= 0)
                {
                    a[newEnd --] = left[l --];
                }
            }
            if(r >= 0)
            {
                while (r >= 0)
                {
                    a[newEnd --] = right[r --];
                }
            }
        }
    }
    public static void quickSort(int[] a,int low,int high )
    {
        if(low >= high)
            return;
        int i,j,index;
        i = low;
        j = high;
        index = a[i];
        while (i < j)
        {
            while (i < j && a[j] >= index)
                j --;
            if(i < j)
                a[i ++] = a[j];
            while (i < j && a[i] <= index)
                i ++;
            if(i < j)
                a[j --] = a[i];
        }
        a[i] = index;
        quickSort(a,low,i - 1);
        quickSort(a,i + 1,high);
    }
    public static void shellSort(int[] a)
    {
        int length = a.length;
        int i,j,step,temp;
       /* for(step = length/2;step > 0;step /= 2)
        {
            for(i = 0;i <length;i ++)
            {
                temp = a[i];
                for(j = i + step;j < length;j += step)
                {
                    if(temp > a[j])
                    {
                        a[j - step] = a[j];
                    }
                    else
                        break;
                }
                a[j - step] = temp;
            }
        }*/

        /*for(step = length/2;step > 0;step /= 2)
        {
            for(i = 0;i <length;i ++)
            {
                temp = i;
                for(j = i + step;j < length;j += step)
                {
                    if(less(a[j],a[temp]))
                    {
                        temp = j;
                    }
                }
                swap(a,i,temp);
            }
        }*/

        for(step = length/2;step > 0;step /= 2)
        {
            for(i = step;i <length;i ++)
            {
                for(j = i;j >= step && less(a[j],a[j - step]);j -= step)
                {
                    swap(a,j,j - step);
                }
            }
        }
    }
    public static void adjustMinHeap(int[] a,int pos,int length)
    {
        int temp;
        int child;
        for(temp = a[pos]; 2 * pos + 1 <= length;pos = child)
        {
            child = 2 * pos + 1;
            if(child < length && a[child] > a[child + 1])
                child ++;
            if(a[child] < temp)
                a[pos] = a[child];
            else
                break;
        }
        a[pos] = temp;
    }
    public static void minHeapSort(int[] a)
    {
        int i;
        int length = a.length;
        for(i = length/2;i >= 0;i --)
            adjustMinHeap(a,i,length - 1);
        for(i = length - 1;i >= 0;i --)
        {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            adjustMinHeap(a,0,i - 1);
        }
        int start = 0;
        int end = length - 1;
        while (start < end)
        {
            int t = a[start];
            a[start] = a[end];
            a[end] = t;
            start ++;
            end --;
        }

    }
    public static void main(String[] args)
    {
        int[] a = {38,65,97,76,13,27,49};
//        selectSort(a);
//        insertSort(a);
//        bubbleSort(a);
//        mergeSort(a,0,a.length - 1);
//        quickSort(a,0,a.length - 1);
    //    shellSort(a);
        minHeapSort(a);
        System.out.println(Arrays.toString(a));

    }
}
