package program;
import java.util.*;

public class SetOfStacks {

    /*
    题目描述
    请实现一种数据结构SetOfStacks，由多个栈组成，其中每个栈的大小为size，
    当前一个栈填满时，新建一个栈。该数据结构应支持与普通栈相同的push和pop操作。

    给定一个操作序列int[][2] ope(C++为vector&ltvector&ltint>>)，每个操作的第
    一个数代表操作类型，若为1，则为push操作，后一个数为应push的数字；若为2，
    则为pop操作，后一个数无意义。请返回一个int[][](C++为vector&ltvector&ltint>>)，
    为完成所有操作后的SetOfStacks，顺序应为从下到上，默认初始的SetOfStacks为空。保证数据合法。
     */

    /*

    测试用例:
[[1,97868],[1,69995],[1,28525],[1,72341],[1,86916],[1,5966],[2,58473],[2,93399],[1,84955],
[1,16420],[1,96091],[1,45179],[1,59472],[1,49594],[1,67060],[1,25466],[1,50357],[1,83509],
[1,39489],[2,51884],[1,34140],[1,8981],[1,50722],[1,65104],[1,61130],[1,92187],[2,2191],
[1,2908],[1,63673],[2,92805],[1,29442]],2

对应输出应该为:

[[97868,69995],[28525,72341],[84955,16420],[96091,45179],[59472,49594],
[67060,25466],[50357,83509],[34140,8981],[50722,65104],[61130,2908],[29442]]

你的输出为:

[[97868,69995],[28525,72341],[86916,5966],[84955,16420],[96091,45179],[59472,49594],
[67060,25466],[50357,83509],[34140,8981],[50722,65104],[61130,92187],[2908,63673]]

[[2908,29442],[65104,61130],[8981,50722],[83509,34140],[25466,50357],[49594,67060],
[45179,59472],[16420,96091],[72341,84955],[69995,28525],[97868]]
     */
    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        // write code here
        ArrayList<ArrayList<Integer>> list =  new ArrayList<>();
        if(ope == null || size == 0)
            return list;
        Deque<Integer> stack  = new LinkedList<>();
        for(int i = 0;i < ope.length;i ++)
        {
            if(ope[i][0] == 1)
            {
                stack.push(ope[i][1]);
            }
            if(ope[i][0] == 2)
            {
                if(!stack.isEmpty())
                    stack.pop();
            }
        }
        while (!stack.isEmpty())
        {
            ArrayList<Integer> l = new ArrayList<>();
            int count = 0;
            while (!stack.isEmpty() && count < size)
            {
                l.add(stack.pollLast());
                count ++;
            }
            list.add(l);
        }
        return list;
    }
}
