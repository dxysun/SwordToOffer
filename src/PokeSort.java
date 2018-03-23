public class PokeSort {


    public static boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0)
            return false;
        int[] a = new int[14];
        int length = numbers.length;
        int count = 0;
        int min = 14;
        for(int i = 0;i < length;i ++)
        {
            if(numbers[i] != 0)
            {
                a[numbers[i]] = 1;
                if(numbers[i] < min)
                    min = numbers[i];
            }
            else
                count ++;
        }
        for(int j = min;j < min + 5;j ++)
        {
              if(a[j] != 1 && count > 0)
              {
                  a[j] = 1;
                  count --;
              }
              else
              {
                  if(a[j] != 1)
                      return false;
              }
        }
        return true;
    }
    public static void main(String[] args)
    {
        int[] a = {1,3,0,2,5};
        System.out.println(isContinuous(a));

    }
}
