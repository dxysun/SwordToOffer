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
    public static void swap2(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    // 时间复杂度O(N^2) 额外空间复杂度O(1) 不稳定
    public static void selectSort(int[] a)
    {
        if (a == null || a.length < 2) {
            return;
        }

       for(int i = 0;i < a.length - 1;i ++){
           int minIndex = i;
           for(int j = i + 1;j < a.length;j ++){
               minIndex = a[j] < a[minIndex] ? j : minIndex;
           }
           swap(a,i,minIndex);
       }

    }

    // 时间复杂度O(N^2) 额外空间复杂度O(1)  稳定
    public static void insertSort(int[] a)
    {
        if (a == null || a.length < 2) {
            return;
        }
      /* for(int i = 0;i < a.length - 1;i ++){
           for(int j = i + 1;j > 0 && a[j] < a[j - 1];j --){
               swap(a,j,j - 1);
           }
       }*/

      for(int i = 1;i < a.length;i ++){
          for(int j = i - 1;j >= 0 && a[j + 1] < a[j];j -- ){
              swap(a,j,j + 1);
          }
      }

    }

    // 时间复杂度O(N^2) 额外空间复杂度O(1)  稳定
    public static void bubbleSort(int[] a)
    {
        if (a == null || a.length < 2) {
            return;
        }
      /*  for(int i = 0;i < a.length - 1;i ++){
            for(int j = 0;j < a.length - 1 - i;j ++){
                if(a[j] > a[j + 1]){
                    swap(a,j,j + 1);
                }
            }
        }*/

      for(int i = a.length - 1; i > 0;i --){
          for(int j = 0;j < i;j ++){
              if(a[j] > a[j + 1]){
                  swap(a,j ,j + 1);
              }
          }
      }
    }


    //堆排序 时间复杂度O(N * logN)，额外空间复杂度O(1)  不稳定
    public static void heapSort(int[] a){
        if(a == null || a.length < 2){
            return;
        }
        for(int i = 0;i < a.length;i ++){
            heapInsert(a,i);
        }

        int size = a.length;
        swap(a,0,--size);
        while (size > 0){
            heapify(a, 0, size);
            swap(a, 0, --size);
        }
    }
    public static void heapInsert(int[] a,int i){
        while (a[i] > a[(i - 1)/2]){
            swap(a,i,(i - 1)/2);
            i = (i - 1)/2;
        }
    }

    public static void heapify(int[] a,int i,int size){
        int left = 2 * i + 1;

        while (left < size){
            int largest = left + 1 < size && a[left + 1] > a[left] ? left + 1 : left;
            largest = a[largest] > a[i] ? largest : i;
            if(largest == i)
                break;
            swap(a,largest,i);
            i = largest;
            left = largest * 2 + 1;
        }
    }

    // 快速排序 时间复杂度o(N * log(N))，额外空间复杂度o(log(N)) 不稳定
    public static void quickSort(int[] a){
        if(a == null || a.length < 2)
            return;
        quickSort(a,0,a.length - 1);
    }
    public static int[] partition(int[] a, int l, int r) {

        int less = l - 1;
        int more = r;
        while (l < more){
            if(a[l] < a[r]){
                swap(a,++less,l ++);
            }else if(a[l] > a[r]){
                swap(a,--more,l);
            }
            else {
                l ++;
            }
        }
        swap(a,more,r);

        return new int[]{less + 1,more};
    }
    public static void quickSort(int[] a,int l,int r )
    {
        if(l >= r)
            return;
        swap(a,l + (int) (Math.random() * (r - l + 1)), r);

        int[] p = partition(a, l, r);
        quickSort(a, l, p[0] - 1);
        quickSort(a, p[1] + 1, r);

    }

    // 时间复杂度o(N * log(N))，额外空间复杂度O(N) 稳定
    public static void mergeSort(int[] a){
        if(a == null || a.length < 2)
            return;
        mergeSort(a, 0, a.length - 1);
    }
    public static void mergeSort(int[] a,int l,int r)
    {
        if(l < r)
        {
            int mid = l + ((r - l) >> 1);
            mergeSort(a,l,mid);
            mergeSort(a,mid + 1,r);
            merge(a, l, mid, r);
        }
    }
    public static void merge(int[] a, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r){
            help[i ++] = a[p1] <= a[p2] ? a[p1 ++] : a[p2 ++];
        }
        while (p1 <= m ){
            help[i ++] = a[p1 ++];
        }
        while (p2 <= r){
            help[i ++] = a[p2 ++];
        }
        for(i = 0;i < help.length;i ++){
            a[l + i] = help[i];
        }

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


    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
//            bubbleSort(arr1);
//            insertSort(arr1);
//            selectSort(arr1);
//            heapSort(arr1);
//            quickSort(arr1);
            mergeSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
//        bubbleSort(arr);
//        insertSort(arr);
//        selectSort(arr);
//        heapSort(arr);
//        quickSort(arr);
        mergeSort(arr);
        printArray(arr);

     /*   int[] a = {38,38,97,76,13,27,49};

//        mergeSort(a,0,a.length - 1);
    //    shellSort(a);
//        minHeapSort(a);
        System.out.println(Arrays.toString(a));
*/
    }
}
