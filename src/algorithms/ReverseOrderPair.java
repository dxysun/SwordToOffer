package algorithms;

import java.util.Arrays;

/*

逆序对问题
在一个数组中，左边的数如果比右边的数大，则折两个数构成一个逆序对，请打印所有逆序
对。
 */
public class ReverseOrderPair {


    static int count = 0;
    public static void mergeSort(int[] a){
        if(a == null || a.length < 2)
            return;

        mergeSort(a,0,a.length - 1);
    }

    private static void mergeSort(int[] a, int l, int r) {
        if(l < r){
            int mid = l + ((r - l) >> 1);
            mergeSort(a,l,mid);
            mergeSort(a,mid + 1,r);
            merge(a,l,mid,r);
        }
    }

    private static void merge(int[] a, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = help.length - 1;
        int pl = mid;
        int pr = r;
        while (pl >= l && pr >= mid + 1){
            if(a[pl] > a[pr])
            {
                for(int j = mid + 1;j <= pr;j ++)
                {
                    System.out.println(a[pl] + " " + a[j]);
                    count ++;
                }
            }

            help[i --] = a[pl] > a[pr] ? a[pl --] : a[pr --];
        }
        while (pl >= l){
            help[i --] = a[pl --];
        }
        while (pr >= mid  + 1){
            help[i --] = a[pr --];
        }
        for (i = 0;i < help.length;i ++){
            a[l + i] = help[i];
        }

    }


    public static void main(String[] args) {
        int [] a = new int[]{9,7,5,8,3,1};
        mergeSort(a);
        System.out.println(count);
        System.out.println(Arrays.toString(a));
    }
}
class InversePairs {

    public static int iPairs(int[] array) {
        if (array == null)
            throw new IllegalArgumentException();
        // 创建辅助数组
        int length = array.length;
        int[] copy = new int[length];
        System.arraycopy(array, 0, copy, 0, length);
        int numberOfInversePairs = iPairs(array, copy, 0, length - 1);
        return numberOfInversePairs;
    }

    /**
     * @author Thanos
     * @param array 未归并数组
     * @param copy 用于存储归并后数据的数组
     * @param begin 起始位置
     * @param end 结束位置
     * @return 逆序数
     */
    public static int iPairs(int[] array, int[] copy, int begin, int end) {
        if(begin == end)
            return 0;
        int mid = (begin + end) / 2;
        // 递归调用
        int left = iPairs(copy, array, begin, mid);
        int right = iPairs(copy, array, mid + 1, end);
        // 归并
        int i = mid, j = end, pos = end;
        int count = 0; // 记录相邻子数组间逆序数

        while(i >= begin && j >= mid + 1)
        {
            if(array[i] > array[j]) {
                copy[pos--] = array[i--];
                count += j - mid;
                for(int k = mid + 1;k <= j;k ++)
                {
                    System.out.println(array[i + 1] + " " + array[k]);
                }
            } else
                copy[pos--] = array[j--];
        }

        while(i >= begin)
            copy[pos--] = array[i--];
        while(j >= mid + 1)
            copy[pos--] = array[j--];

        return left + right + count;
    }

    public static void main(String... args) {
        int test[] = { 7, 5, 1, 6, 4 };
        int [] a = new int[]{9,7,5,8,3,1};
        int count = iPairs(a);
        System.out.println(count + " ");
    }

}
