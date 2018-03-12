import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstChar {

    public int FirstNotRepeatingChar(String str) {
        if(str == null)
            return 0;
        if(str.equals(""))
            return -1;
        Map<Character,Integer> m = new LinkedHashMap<>();
        Map<Character,Integer> map = new HashMap<>();
        ;
        char[] c = str.toCharArray();
        for(int i = 0;i < c.length;i ++)
        {
            if(map.containsKey(c[i]))
            {
                if(m.containsKey(c[i]))
                    m.remove(c[i]);
            }
            else
            {
                m.put(c[i],i);
            }
            map.put(c[i],i);
        }
        int i = 0;
        int pos = 0;
        for(Map.Entry<Character,Integer> entry : m.entrySet())
        {
            i ++;
            pos = entry.getValue();
            if(i == 1)
                break;
        }
        return pos;
    }
    public static void main(String[] args)
    {

        String str = "cbaddgbcsae";
        FirstChar f = new FirstChar();
        System.out.println(f.FirstNotRepeatingChar(str));

    }
}
