package algorithms;

import java.util.Arrays;

/*
返回任一个局部最小值
 */
public class FindOneLessValueIndex {


    public static int getLessIndex(int[] arr) {
        if(arr == null || arr.length == 1)
            return -1;
        if(arr[0] < arr[1])
            return arr[0];
        if(arr[arr.length - 1] < arr[arr.length - 2])
            return arr[arr.length - 1];

        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right){
            mid = left + ((right - left) >> 1);

            if(arr[mid - 1] < arr[mid] ){
                right = mid - 1;
            }else if(arr[mid + 1] < arr[mid]){
                left = mid + 1;
            }
            else
                return mid;
        }
        return left;
    }
    public static void main(String[] args) {
        int[] arr = { 6, 5, 3, 4, 6, 7, 8 };
        System.out.println(Arrays.toString(arr));
        int index = getLessIndex(arr);
        System.out.println("index: " + index + ", value: " + arr[index]);

    }
}
