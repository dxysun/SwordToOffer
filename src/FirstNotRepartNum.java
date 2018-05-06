import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNotRepartNum {

    /*

    题目描述
    请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
    第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
    输出描述:
    如果当前字符流没有存在出现一次的字符，返回#字符。
     */
    static LinkedHashMap<Character,Integer> first = new LinkedHashMap<>();

    //Insert one char from stringstream
    public static void Insert(char ch)
    {
        if(first.containsKey(ch))
            first.remove(ch);
        else
            first.put(ch,1);

    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
        for(Map.Entry<Character,Integer> entry : first.entrySet())
        {
            return entry.getKey();
        }
        return '#';
    }
    public static void main(String[] args)
    {
        String s = "google";
        char[] c = s.toCharArray();
        for(char ch : c)
        {
            Insert(ch);
        }

        System.out.println(FirstAppearingOnce());
    }
}
