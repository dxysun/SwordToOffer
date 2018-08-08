package swordtooffer;

public class LeftRotateStr {

    public static String LeftRotateString(String str,int n) {
        if(str == null)
            return null;
        int length = str.length();
        char[] newStr = new char[length];
        char[] s = str.toCharArray();
        int i = 0;
        for(i = n;i < length;i ++)
        {
            newStr[i - n] = s[i];
        }
        for(int j = 0;j < n;j ++,i ++)
        {
            newStr[i - n] = s[j];
        }
        return String.valueOf(newStr);
    }
    public static void main(String[] args)
    {
        System.out.println(LeftRotateString("abcXYZdef",3));

    }
}
