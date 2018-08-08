package swordtooffer;

import java.util.PriorityQueue;

public class GetMedian {

    /*
    题目描述
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。


     */

    //大顶堆
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    //小顶堆
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    private int len = 0;
    public void Insert(Integer num) {

        if(len % 2 == 0)
        {
            left.add(num);
            right.add(left.poll());
        }
        else
        {
            right.add(num);
            left.add(right.poll());
        }
        len ++;


    }

    public Double GetMedian() {
        if(len % 2 == 0)
            return (left.peek() + right.peek()) / 2.0;
        else
            return (double)right.peek();

    }
}
