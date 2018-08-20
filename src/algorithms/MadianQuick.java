package algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MadianQuick {

    public static class MaxComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static class MinComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }



    public static class MedianHolder {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxComparator());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinComparator());


        private void modifyTwoHeapsSize() {
            if (maxHeap.size() - minHeap.size() == 2) {
                minHeap.add(maxHeap.poll());
            }
            if (minHeap.size() - maxHeap.size() == 2) {
                maxHeap.add(minHeap.poll());
            }

        }

        public void addNumber(int num) {
            if (maxHeap.isEmpty()) {
                maxHeap.add(num);
                return;
            }
            if (maxHeap.peek() >= num) {
                maxHeap.add(num);
            } else {
                if (minHeap.isEmpty()) {
                    minHeap.add(num);
                    return;
                }
                if (num < minHeap.peek()) {
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }
            }

            modifyTwoHeapsSize();
        }

        public Integer getMedian() {
            int sum = maxHeap.size() + minHeap.size();
            if (sum == 0)
                return 0;
            Integer max = maxHeap.peek();
            Integer min = minHeap.peek();
            if ((sum & 1) == 0) {  //偶数
                return (max + min) / 2;
            } else {
                return maxHeap.size() > minHeap.size() ? max : min;
            }

        }
    }

    // for test
    public static int[] getRandomArray(int maxLen, int maxValue) {
        int[] res = new int[(int) (Math.random() * maxLen) + 1];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * maxValue);
        }
        return res;
    }

    // for test, this method is ineffective but absolutely right
    public static int getMedianOfArray(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        int mid = (newArr.length - 1) / 2;
        if ((newArr.length & 1) == 0) {
            return (newArr[mid] + newArr[mid + 1]) / 2;
        } else {
            return newArr[mid];
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean err = false;
        int testTimes = 200000;
        for (int i = 0; i != testTimes; i++) {
            int len = 30;
            int maxValue = 1000;
            int[] arr = getRandomArray(len, maxValue);
            MedianHolder medianHold = new MedianHolder();
            for (int j = 0; j != arr.length; j++) {
                medianHold.addNumber(arr[j]);
            }
            if (medianHold.getMedian() != getMedianOfArray(arr)) {
                System.out.println(arr.length);
                System.out.println(i);
                System.out.println(medianHold.getMedian());
                System.out.println(medianHold.maxHeap.size());
                System.out.println(medianHold.minHeap.size());
                System.out.println();
                System.out.println(medianHold.maxHeap.peek());
                System.out.println(medianHold.minHeap.peek());
                System.out.println();
                System.out.println(getMedianOfArray(arr));
                err = true;
                printArray(arr);
                break;
            }
        }
        System.out.println(err ? "Oops..what a fuck!" : "today is a beautiful day^_^");

    }
}
