package swordtooffer;

public class NumOfK {

    public int GetNumberOfK(int [] array , int k) {
          if(array == null)
              return 0;
          int length = array.length;
          int count = 0;
          boolean b = false;
          for(int i = 0;i < length;i ++)
          {
              if(array[i] == k)
              {
                  count ++;
                  b = true;
              }
              else
                  b = false;
              if(count > 0 && !b)
                  break;
          }
          return count;
    }
    public static void main(String[] args)
    {

    }
}
