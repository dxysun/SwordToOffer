package writeTest;

import java.util.*;

public class AlibabaV2 {


    // write your code here
  //  public static Map<String, Integer> resolve(List<Integer> order, Map<String, List<Integer>> boms) {
    public static void resolve(List<Integer> order, Map<String, List<Integer>> boms) {

        Map<Map<String, Integer>, List<Integer>> result = new HashMap<>();
        Stack<String> stack = new Stack<>();
        int length = order.size();
        int[] a = new int[length];
        for(int i = 0;i < length;i ++)
        {
            a[i] = order.get(i);
        }
        setResult(a,boms,stack,result);

       /* for(Map.Entry<Map<String, Integer>, List<Integer>> entry:result.entrySet())
        {
            StringBuilder sb = new StringBuilder();
            for(Map.Entry<String, Integer> e:entry.getKey().entrySet())
            {
                sb.append(e.getKey() +"*"+e.getValue()+" ");

            }
            sb.append(":");
            for (Integer i: entry.getValue())
            {
                sb.append(i + " ");
            }
            System.out.println(sb.toString());
        }*/

    }
    static void setResult(int[] a,Map<String, List<Integer>> boms,Stack<String> stack,Map<Map<String, Integer>, List<Integer>> result)
    {
        if(!judge(a,boms))
        {
            Stack<String> s = new Stack<>();
            Map<String, Integer> map = new HashMap<>();
            while (!stack.isEmpty())
            {
                String str = stack.pop();
                s.push(str);
                if(map.containsKey(str))
                {
                   int b =  map.get(str);
                   b ++;
                   map.put(str,b);
                }
                else
                    map.put(str,1);
            }
            List<Integer> order = new ArrayList<>();
            for(int i:a)
            {
                order.add(i);
            }
            result.put(map,order);
            while (!s.isEmpty())
            {
                stack.push(s.pop());
            }
            return;
        }
        else
        {
            for(Map.Entry<String, List<Integer>> entry:boms.entrySet())
            {
                List<Integer> l = entry.getValue();
                boolean b1 = true;
                for(int i = 0;i < l.size();i ++)
                {
                    a[i] -= l.get(i);
                    if(a[i] < 0)
                    {
                        b1 = false;
                    }
                }
                if(b1)
                {
                    stack.push(entry.getKey());
                    setResult(a,boms,stack,result);
                    stack.pop();
                }
                for(int i = 0;i < l.size();i ++)
                {
                    a[i]  += l.get(i);
                }
            }
        }

    }
    static boolean judge(int[] a,Map<String, List<Integer>> boms)
    {
        boolean b = false;
        for(Map.Entry<String, List<Integer>> entry:boms.entrySet())
        {
            List<Integer> l = entry.getValue();
            boolean b1 = true;
            for(int i = 0;i < l.size();i ++)
            {
                int c = a[i] - l.get(i);
                if(c < 0)
                {
                    b1 = false;
                    break;
                }

            }
            if(b1)
            {
                b = true;
            }
        }
        return b;
    }
    public void test()
    {
        List<Integer> order = new ArrayList<>();
        Map<String, List<Integer>> boms = new HashMap<>();
        order.add(2);
        order.add(3);
        order.add(1);
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        l1.add(1);
        l1.add(1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(1);
        l2.add(0);
        List<Integer> l3 = new ArrayList<>();
        l3.add(0);
        l3.add(1);
        l3.add(1);
        boms.put("bom1",l1);
        boms.put("bom2",l2);
        boms.put("bom3",l3);
        resolve(order,boms);
    }

    /*
    编译器版本: Java 1.8.0_66
请使用标准输入输出(System.in, System.out)；已禁用图形、文件、网络、系统相关的操作，
如java.lang.Process , javax.swing.JFrame , Runtime.getRuntime；不要自定义包名称，
否则会报错，即不要添加package answer之类的语句；您可以写很多个类，但是必须有一个类名为Main，
并且为public属性，并且Main为唯一的public class，Main类的里面必须包含一个名字为'main'的静态方法（函数），这个方法是程序的入口
时间限制: 3S (C/C++以外的语言为: 5 S)   内存限制: 128M (C/C++以外的语言为: 640 M)
输入:
第一行：起点位置坐标及机器人朝向，如：
1 0 EAST
代表机器人初始坐标为x=1,y=0，机器人面朝东方
第二行：终点位置坐标及机器人朝向，如：
0 2 WEST
代表机器人需要移动至点x=0,y=2，且面朝西方
接下来输入的是地图：
首先是两个数字r,c，代表有地图数据有多少行与多少列，如：
2 3
0 1 0
0 0 0
其中，左上角为坐标原点，从左向右为x轴增大的方向是东方，从上到下为y轴增大的方向是南方。
地图中1代表有障碍物，机器人不能前往，0代表无障碍物机器人可以前往 地图中相邻的每两个点之间的距离为1m。
0 <= l,w <= 128
输出:
第一行：起点位置坐标及机器人朝向，如：
1 0 EAST
代表机器人初始坐标为x=1,y=0，机器人面朝东方
第二行：终点位置坐标及机器人朝向，如：
0 2 WEST
代表机器人需要移动至点x=0,y=2，且面朝西方
接下来输入的是地图：
首先是两个数字r,c，代表有地图数据有多少行与多少列，如：
2 3
0 1 0
0 0 0
其中，左上角为坐标原点，从左向右为x轴增大的方向是东方，从上到下为y轴增大的方向是南方。
地图中1代表有障碍物，机器人不能前往，0代表无障碍物机器人可以前往 地图中相邻的每两个点之间的距离为1m。
0 <= l,w <= 128
输入范例:
0 0 NORTH
2 0 SOUTH
2 3
0 1 0
0 0 0
输出范例:
0 0 NORTH
1 1 SOUTH
2 2
0 1
0 0


     */


    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int startX = in.nextInt();
        int startY = in.nextInt();
        String startDes = in.nextLine();
        int endX = in.nextInt();
        int endY = in.nextInt();
        String endDes = in.nextLine();
        int row = in.nextInt();
        int col = in.nextInt();
        int[][] a = new int[row][col];
        for(int i = 0;i < row;i ++)
        {
            for(int j = 0;j < col;j ++)
            {
                a[row][col] = in.nextInt();
            }
        }




    }

}
