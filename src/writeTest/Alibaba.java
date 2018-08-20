package writeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
某物流派送员p，需要给a、b、c、d4个快递点派送包裹，请问派送员需要选择什么的路线，才能完成最短路程的派送。假设如图派送员的起点坐标(0,0)，派送路线只能沿着图中的方格边行驶，每个小格都是正方形，且边长为1，如p到d的距离就是4。随机输入n个派送点坐标，求输出最短派送路线值（从起点开始完成n个点派送并回到起始点的距离）。
输入
4
2,2
2,8
4,4
7,2
输出30
输入
3
2,2
2,8
6,6
输出28
 */
public class Alibaba {
    private static  class P{
        int x;
        int y;
        boolean isVisited;

        public P(int x,int y){
            this.x = x;
            this.y = y;
        }
        public int getDistance(P p){
            return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
        }
    }
    static P start = new P(0,0);
    static int minPath = Integer.MAX_VALUE;

    public static int getMinDistance(P s,P[] points,int sum,int count){
        if(count == points.length){
            minPath = Math.min(minPath,sum + s.getDistance(start));
            return minPath;
        }

        for(int i = 0;i < points.length;i ++){
            if(!points[i].isVisited){
                sum += points[i].getDistance(s);
                if(sum < minPath){
                    points[i].isVisited = true;
                    getMinDistance(points[i], points, sum, count+1);
                }
                sum -= points[i].getDistance(s);
                points[i].isVisited = false;

            }
        }
        return minPath;

    }


    public static void main(String[] main)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        P[] points = new P[n];
        for(int i = 0;i < n;i ++){
            String str = in.nextLine();
            String[] s = str.trim().split(",");
            points[i] = new P(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
        }
        System.out.println(getMinDistance(start,points,0,0));
    }





    public static void test(){
        // 读取输入的内容
        List<Integer> input = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while(str != null && !str.isEmpty()){
            Integer value = Integer.parseInt(str);
            if(value==0)
                break;
            input.add(value);
            str = sc.nextLine();
        }
        int[] A = new int[input.size()];
        for (int i = 0; i < A.length; i++) {
            A[i] = input.get(i).intValue();
        }
        int res = resolve(A);
        System.out.println(res);
    }
    static int resolve(int[] A){
        // 将三位数拆分，分别用数组bai，数组shi，数组ge存储对应位上的值
        int len = A.length;
        int[] bai = new int[len];
        int[] shi = new int[len];
        int[] ge = new int[len];
        for (int i = 0; i < len; i++) {
            bai[i] = A[i]/100;
            shi[i] = A[i]%100/10;
            ge[i] = A[i]%10;
        }
        final int P = 15;
        int[] treeArray = new int[P];
        for (int i = 0; i < treeArray.length; i++) {
            treeArray[i] = Integer.MIN_VALUE;
        }
        // 用数组treeArray构建二叉树，保存ge数组的值
        for(int i = 0 ; i < len;i++){
            int loc = bai[i]*(bai[i]-1)/2+shi[i]-1;
            treeArray[loc] = ge[i];
        }
        // 遍历数组treeArray，找出所有叶子结点
        int sum = 0;
        for (int i = 0; i < P; i++) {
            if(treeArray[i] != Integer.MIN_VALUE){
                if(i*2+1 >= P || i*2+2>=P){
                    //是叶子结点
                    sum+=helper(treeArray,i);
                }
                if(treeArray[i*2+1] == Integer.MIN_VALUE){
                    // 是叶子节点
                    sum+=helper(treeArray,i);
                }
            }
        }
        return sum;
    }
    // 根据叶子节点求出根节点到该叶子结点的路径长度
    static int helper(int[] treeArray,int index){
        // 是根节点
        if(index == 0){
            return treeArray[index];
        }
        if(index %2==1){
            // 是左节点
            return treeArray[index]+helper(treeArray,(index-1)/2);
        }else{
            // 是右节点
            return treeArray[index]+helper(treeArray,(index-2)/2);
        }
    }
}
