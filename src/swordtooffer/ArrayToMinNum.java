package swordtooffer;

public class ArrayToMinNum {

    public String PrintMinNumberV1(int [] numbers) {
        if(numbers == null)
            return null;
        int length = numbers.length;
        if(length == 1)
            return String.valueOf(numbers[0]);
        String min = String.valueOf(numbers[0]);
        for(int i = 1;i <length;i ++)
        {
            StringBuilder temp1 = new StringBuilder(min);
            temp1.append(numbers[i]);
            StringBuilder temp2 = new StringBuilder(String.valueOf(numbers[i]));
            temp2.append(min);
            if(temp1.toString().compareTo(temp2.toString()) < 0)
                min = temp1.toString();
            else
                min = temp2.toString();
        }
        return min;
    }

    public String PrintMinNumber(int [] numbers)
    {
        if(numbers == null)
            return "";
        int length = numbers.length;
        if(length == 0)
            return "";
        if(length == 1)
            return String.valueOf(numbers[0]);
        if(length == 2)
        {
            String t1 = String.valueOf(numbers[0]);
            String t2 = String.valueOf(numbers[1]);

            if((t1 + t2).compareTo(t2 + t1) < 0)
                return t1 + t2;
            else
                return t2 + t1;
        }
        String min = "";
        String minOfAll = null;
        for(int i = 0;i < length;i ++)
        {
            int[] a = new int[length - 1];
            int t = 0;
            min = String.valueOf(numbers[i]);
            for(int j = 0;j < length ;j ++)
            {
                if(i != j)
                {
                    a[t] = numbers[j];
                    t ++;
                }
            }
            String str = PrintMinNumber(a);
            String temp1 = min + str;
            String temp2 = str + min;
            if(temp1.compareTo(temp2) < 0)
            {
                min = temp1;
            }
            else
            {
                min = temp2;
            }
            if(minOfAll == null)
                minOfAll = min;
            else
            {
                if(min.compareTo(minOfAll) < 0)
                    minOfAll = min;
            }
        }
        return minOfAll;
    }
    public static void main(String[] args)
    {
        ArrayToMinNum a = new ArrayToMinNum();
//        int[] b = {3,32,321};
        int[] b = {5,1,3,2,4};
        System.out.println(a.PrintMinNumber(b));
    }
}
