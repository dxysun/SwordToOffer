package writeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alibaba {

    public static void main(String[] main)
    {
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
