package algorithms;

public class SmallSum {


    /*
小和问题和逆序对问题
小和问题
在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组
的小和。
例子：
[1,3,4,2,5]
1左边比1小的数，没有；
3左边比3小的数，1；
4左边比4小的数，1、3；
2左边比2小的数，1；
5左边比5小的数，1、3、4、2；
所以小和为1+1+3+1+1+3+4+2=16
逆序对问题
在一个数组中，左边的数如果比右边的数大，则折两个数构成一个逆序对，请打印所有逆序
对。
     */

    public static int mergeSort(int[] a){
        if (a == null || a.length < 2) {
            return 0;
        }
        return mergeSort(a,0,a.length - 1);

    }
    public static int mergeSort(int[] a,int l,int r){
        if(l < r){
            int mid = l + ((r - l) >> 1);

            return mergeSort(a,l,mid) +
                    mergeSort(a,mid + 1,r) +
                    merge(a,l,mid,r);
        }
        return 0;
    }
    public static int merge(int[] a,int l,int m,int r){
        int[] help = new int[r - l + 1];
        int i = 0;
        int pl = l;
        int pr = m + 1;
        int sum = 0;
        while (pl <= m && pr <= r){
            sum += a[pl] < a[pr] ? a[pl] * (r - pr + 1) : 0;
            if(a[pl] > a[pr])
            {
                System.out.println(a[pl] + " " + a[pr]);
            }
            help[i ++] = a[pl] < a[pr] ? a[pl ++] : a[pr ++];
        }
        while (pl <= m){
            help[i ++] = a[pl ++];
        }
        while (pr <= r){
            help[i ++] = a[pr ++];
        }
        for(i = 0;i < help.length;i ++){
            a[l + i] = help[i];
        }
        return sum;
    }
    public static void main(String[] args) {
//        int[] a = new int[]{1,3,4,2,5};
        int [] a = new int[]{9,7,5,8,3,1};
        int sum = mergeSort(a);
        System.out.println(sum);

    }
}
