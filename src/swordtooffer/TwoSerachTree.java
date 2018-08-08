package swordtooffer;

public class TwoSerachTree {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)
            return false;
        int length = sequence.length;
        int mid = sequence[length - 1];
        int i = 0;
        for(i = 0;i <= length - 2;i ++)
        {
            if(sequence[i] > mid)
                break;
        }
        for(int j = i;j < length - 1;j ++)
        {
            if(sequence[j] < mid)
                return false;
        }
        return judgeTree(sequence,0,i - 1) && judgeTree(sequence,i,length - 2);
    }
    public boolean judgeTree(int[] sequence,int start,int end)
    {
        System.out.println("start:" + start);
        System.out.println("end:" + end);
        if(end - start<= 0)
            return true;
        int mid = sequence[end];
        int  i = start;
        for(;i <= end - 1; i ++)
        {
            if(sequence[i] > mid)
                break;
        }
        for(int j = i;j <=end - 1;j ++)
        {
            if(sequence[j] < mid)
                return false;
        }
        if(start + 1 == i)
            return true;
        return judgeTree(sequence, start,i - 1) && judgeTree(sequence, i,end - 1);
    }
    public static void main(String[] args)
    {
        TwoSerachTree tree = new TwoSerachTree();
        int[] a = {5, 7, 6, 9, 11, 10, 8};
        int[] b = {2, 4, 6, 3};
        int[] c = {6,4,12,15,16,14,10};
        System.out.println(tree.VerifySquenceOfBST(c)
        );
    }
}
