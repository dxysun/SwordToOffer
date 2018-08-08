package swordtooffer;

public class TimesOfOne {

    public int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        for(int i = 0;i <= n;i ++)
        {
            sum += sumOfOne(i);
        }
        return sum;
    }
    public int sumOfOne(int data)
    {
        int sum = 0;
        while (data > 0)
        {
            int a = data%10;
            if(a == 1)
                sum ++;
            data /= 10;
        }
        return sum;
    }
    public static void main(String[] args)
    {
        TimesOfOne t = new TimesOfOne();
        System.out.println(t.NumberOf1Between1AndN_Solution(20));

    }
}
