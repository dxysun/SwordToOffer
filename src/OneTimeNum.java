import java.util.HashMap;
import java.util.Map;

public class OneTimeNum {

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> resMap = new HashMap<>();
        for(int i = 0;i < array.length;i ++)
        {
            if(map.containsKey(array[i]))
            {
                resMap.remove(array[i]);
            }
            else
            {
                map.put(array[i],1);
                resMap.put(array[i],1);
            }

        }
        int j = 0;
        for(Map.Entry<Integer,Integer> entry : resMap.entrySet())
        {
            if(j == 0)
                num1[0] = entry.getKey();
            else
                num2[0] = entry.getKey();
            j ++;
        }

    }
    public static void main(String[] args)
    {
        OneTimeNum o = new OneTimeNum();
        int[] a = {2,4,3,6,3,2,5,5};
        int[] b = {0};
        int[] c = {0};
        o.FindNumsAppearOnce(a,b,c);
        System.out.println(b[0] + "  " + c[0]);
    }
}
