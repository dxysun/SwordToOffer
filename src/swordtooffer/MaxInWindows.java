package swordtooffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;

public class MaxInWindows {

    /*

    题目描述
    给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
    例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一
    共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组
    {2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
    {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
     {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> ret = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        if (size > num.length || size < 1)
            return ret;
        for (int i = 0; i < size; i++)
            heap.add(num[i]);
        ret.add(heap.peek());
        for (int i = 1, j = i + size - 1; j < num.length; i++, j++) {
            heap.remove(num[i - 1]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }

        return ret;

    }

    public static ArrayList<Integer> maxInWindowsV2(int [] num, int size)
    {
        ArrayList<Integer> ret = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();

        if (size > num.length || size < 1)
            return ret;

        for(int i = 0;i < size;i ++ )
        {
            while (!queue.isEmpty() && num[i] >= num[queue.peekLast()])
            {
                queue.pollLast();
            }
            queue.addLast(i);
        }
        for(int i = size;i < num.length;i ++)
        {
            ret.add(num[queue.peekFirst()]);
            while (!queue.isEmpty() && num[i] >= num[queue.peekLast()])
            {
                queue.pollLast();
            }
            if(!queue.isEmpty() && i - queue.peekFirst() >= size)
            {
                queue.pollFirst();
            }
            queue.addLast(i);
        }
        ret.add(num[queue.peekFirst()]);
        return ret;

    }

    public static void main(String[] args)
    {
        int[] a = {16,14,12,10,8,6,4};
        ArrayList<Integer> ret = maxInWindowsV2(a,5);
        System.out.println();
        ret.forEach(System.out::println);
    }
}
