package writeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class AlibabaV1 {



    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt())
        {
            int a = scanner.nextInt();
            list.add(a);
        }
        int length = list.size();
        int[] a = new int[length];
        for (int i = 0;i < length;i ++)
        {
            a[i] = list.get(i);
        }
        int res = resolve(a);
        System.out.println(res);
    }
    static int resolve(int[] a){

        int len = a.length;
        int[] bai = new int[len];
        int[] shi = new int[len];
        int[] ge = new int[len];
        for (int i = 0; i < len; i++) {
            bai[i] = a[i]/100;
            shi[i] = a[i]%100/10;
            ge[i] = a[i]%10;
        }
        final int P = 15;
        int[] treeArray = new int[P];
        for (int i = 0; i < treeArray.length; i++) {
            treeArray[i] = Integer.MIN_VALUE;
        }

        for(int i = 0 ; i < len;i++){
            double d = bai[i]-1;
            int loc = (int)Math.pow(2.0,d) - 1+shi[i]-1;
            treeArray[loc] = ge[i];
        }

        int sum = 0;
        for (int i = 0; i < P; i++) {
            if(treeArray[i] != Integer.MIN_VALUE){
                if(i*2+1 >= P || i*2+2>=P){
                    sum+=helper(treeArray,i);
                }
                if(treeArray[i*2+1] == Integer.MIN_VALUE && treeArray[i*2+2] == Integer.MIN_VALUE){

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
