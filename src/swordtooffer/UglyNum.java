package swordtooffer;

public class UglyNum {

    public int GetUglyNumber_SolutionV1(int index) {
        int i = 0;
        int count = 1;
        while(i < index)
        {
            if(isUgly(count))
            {
                i ++;
            }
            count ++;
        }
        return count - 1;
    }
    public boolean isUgly(int num)
    {
        while (num >=0 )
        {
            if(num == 1)
                break;
            if(num % 2 == 0)
                num /= 2;
            else if(num % 3 == 0)
                num /= 3;
            else if(num % 5 == 0)
                num /= 5;
            else
                return false;
        }

        if(num == 1)
            return true;
        else
            return false;
    }
    public int GetUglyNumber_Solution(int index)
    {
        if(index <= 0)
            return 0;
        if(index == 1)
        {
            return 1;
        }
        int[] a = new int[index + 1];
        a[0] = 1;
        int next = 1;
        int m2 = 0;
        int m3 = 0;
        int m5 = 0;
        while (next < index)
        {
            int min = Math.min(a[m2] * 2,a[m3] * 3);
            min = Math.min(min,a[m5] * 5);
            a[next] = min;
            while(a[m2] * 2 <= a[next])
                m2 ++;
            while(a[m3] * 3 <= a[next])
                m3 ++;
            while(a[m5] * 5 <= a[next])
                m5 ++;
            next ++;
        }
        return a[index - 1];
    }

    public static void main(String[] args)
    {
          // 1 2 3 4 5 6 8 9 10 12 15 16 18 20 24 25 30
        UglyNum u = new UglyNum();
        System.out.println();
        System.out.println(u.GetUglyNumber_Solution(1500));
    }
}
