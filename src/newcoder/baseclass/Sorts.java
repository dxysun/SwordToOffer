package newcoder.baseclass;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Sorts {

    public static Map<Integer, Integer> reverseOrder = new LinkedHashMap<>();

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

//        a[i] = a[i] ^ a[j];
//        a[j] = a[i] ^ a[j];
//        a[j] = a[i] ^ a[j];
    }


    public static void mergeSort(int[] a) {
        if (a == null || a.length < 2)
            return;
        mergeSort(a, 0, a.length - 1);
    }

    public static void mergeSortNotDigui(int[] a) {
        if (a == null || a.length < 2)
            return;
        int interval = 1;
        while (interval < a.length) {
            int i = 0;
            for (i = 0; i < a.length; i += (interval + 1)) {
                int r = i + interval;
                if (r > a.length - 1)
                    r = a.length - 1;
                merge(a, i, (i + r) / 2, r);
            }
            interval = 2 * interval + 1;     // 需要设置好间隔
        }
        merge(a, 0, interval / 2, a.length - 1);   //merge最后一次
    }

    public static void mergeSort(int[] a, int l, int r) {
        if (l == r)
            return;

        int mid = l + ((r - l) >> 1);
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        merge(a, l, mid, r);

    }

    public static void merge(int[] a, int l, int mid, int r) {
        int[] help = new int[r - l + 1];

        int index = 0;
        int indexL = l;
        int indexR = mid + 1;
        while (indexL <= mid && indexR <= r) {
            if (a[indexL] > a[indexR]) {
                reverseOrder.put(a[indexL], a[indexR]);
            }

            help[index++] = a[indexL] < a[indexR] ? a[indexL++] : a[indexR++];
        }

        while (indexL <= mid) {
            help[index++] = a[indexL++];
        }
        while (indexR <= r) {
            help[index++] = a[indexR++];
        }
        for (int i = 0; i < help.length; i++) {
            a[l + i] = help[i];
        }

    }

    public static void bubbleSort(int[] a) {
        if (a == null || a.length < 2)
            return;
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    public static void selectSort(int[] a) {
        if (a == null || a.length < 2)
            return;
        for (int i = 0; i < a.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < a.length; j++) {
                minPos = a[j] < a[minPos] ? j : minPos;
            }
            swap(a, i, minPos);
        }

    }

    public static void insertSort(int[] a) {
        if (a == null || a.length < 2)
            return;

        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0 && a[j] > a[j + 1]; j--) {
                swap(a, j, j + 1);
            }
        }
    }

    public static void quickSort(int[] a) {
        if (a == null || a.length < 2)
            return;
        quickSort(a, 0, a.length - 1);
    }

    public static void quickSort(int[] a, int l, int r) {
        if (l < r) {
            swap(a, l + (int) (Math.random() * (r - l + 1)), r);
            int[] res = partition(a, l, r);
            quickSort(a, l, res[0] - 1);
            quickSort(a, res[1] + 1, r);
        }
    }


    public static int[] partition(int[] a, int l, int r) {

        int index = l;
        int less = l - 1;
        int more = r;
        while (index < more) {
            if (a[index] < a[r]) {
                swap(a, ++less, index++);
            } else if (a[index] > a[r]) {
                swap(a, --more, index);
            } else {
                index++;
            }
        }
        swap(a, more, r);

        return new int[]{less + 1, more};
    }

    public static void heapSort(int[] a) {
        if (a == null || a.length < 2)
            return;

        for (int i = 0; i < a.length; i++) {
            heapInsert(a, i);
        }

        int size = a.length;
      //  swap(a, 0, --size);
        while (size > 0) {
            swap(a, 0, --size);
            heapify(a, 0, size);
        }

    }

    public static void heapInsert(int[] a, int i) {
        while (a[(i - 1) / 2] < a[i]) {
            swap(a, (i - 1) / 2, i);
            i = (i - 1) / 2;
        }
    }

    public static void heapify(int[] a, int i, int size) {

        int l = 2 * i + 1;
        while (l < size) {
            int bigger_pos = l + 1 < size && a[l + 1] > a[l] ? l + 1 : l;

            if (a[i] < a[bigger_pos]) {
                swap(a, i, bigger_pos);
            } else {
                break;
            }
            i = bigger_pos;
            l = 2 * i + 1;
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


    public static void main(String[] args) {

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        mergeSortNotDigui(arr);
        printArray(arr);
    }
}
