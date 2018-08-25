package algorithms;

/*
打印一个字符串的全部子序列，包括空字符串
 */

public class Print_All_Subsquences {
    public static void printAllSubsquence(String str) {
        if(str == null)
            return;
        char[] chars = str.toCharArray();
        process(chars,0);
    }
    public static void process(char[] chars,int i){
        if(i == chars.length)
        {
            System.out.println(new String(chars));
            return;
        }
        process(chars,i + 1);
        char temp = chars[i];
        chars[i] = 0;
        process(chars,i + 1);
        chars[i] = temp;
    }


    public static void main(String[] args) {
        String test = "abc";
        printAllSubsquence(test);

    }

}
