import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SortString {


    public static void printStr(char[] c,int start,int length,ArrayList<String> list)
    {
        if(start == length - 1)
        {
            list.add(String.valueOf(c));
        }
        else
        {

            for(int j = start;j < length;j ++)
            {
                if(start == j || c[j] != c[start])
                {
                    char temp = c[j];
                    c[j] = c[start];
                    c[start] = temp;
                    printStr(c,start + 1,length,list);
                    temp = c[j];
                    c[j] = c[start];
                    c[start] = temp;
                }

            }
        }
    }
    public static ArrayList<String> Permutation(String str) {
        char[] c = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        printStr(c,0,c.length,list);
        list.sort(Comparator.naturalOrder());
        return list;
    }
    public static void main(String[] args)
    {
        String str = "abcd";
        ArrayList<String> l = Permutation(str);
        l.forEach(s->
                System.out.println(s)
        );
    }
}
