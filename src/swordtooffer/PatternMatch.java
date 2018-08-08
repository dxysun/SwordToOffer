package swordtooffer;

public class PatternMatch {


    /*
    题目描述
    请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
     而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有
     字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     */
    public static boolean match(char[] str, char[] pattern)
    {
        if(str == null)
            return false;
        if(str.length == 0 && pattern.length == 0)
            return true;
        if(str.length == 0)
        {
             String s = new String(str);
             if(s.equals(""))
            {
                if(pattern.length == 1)
                    return false;
                if(pattern.length == 2)
                {
                    if(pattern[1] == '*')
                        return true;
                    else
                        return false;
                }
            }
        }

        int j = 0;
        int i = 0;
        for(;i < pattern.length;i ++)
        {
            if(pattern[i] == str[j])
            {
                j ++;
                if(j >= str.length)
                {
                    i += 1;
                    break;
                }
            }
            else
            {
                if(pattern[i] == '.')
                {
                    j ++;
                    if(i + 1 < pattern.length)
                    {
                        if(pattern[i + 1] == '*')
                        {
                            i += 1;
                            while (j < str.length && str[j] == str[j - 1])
                            {
                                j ++;
                            }
                            if(j >= str.length)
                            {
                                i += 1;
                                break;
                            }

                        }
                    }
                    if(j >= str.length)
                    {
                        i += 1;
                        break;
                    }

                }
                else if(pattern[i] == '*')
                {
                    while (str[j] == str[j - 1])
                    {
                        j ++;
                    }
                }
                else
                {
                    if(pattern[i + 1] == '*')
                    {
                        i += 1;
                    }
                    else
                        return false;
                }
            }
        }

        if(j == str.length && i == pattern.length)
        {
            return true;
        }
        else
        {
            if(i + 2 ==  pattern.length)
            {
                if(pattern[i + 1] == '*')
                    return true;
                else
                    return false;
            }
            else
                return false;
        }

    }
    public static boolean matchCore(char[] str, char[] pattern,int i ,int j)
    {
        if(i == str.length && j == pattern.length)
            return true;
        if(i != str.length && j == pattern.length)
            return false;
        if(i == str.length)
        {
            if(j + 2 == pattern.length)
            {
                if(pattern[j + 1] == '*')
                    return true;
                else
                    return false;
            }
            else
                return false;
        }
        if(j + 1 < pattern.length && pattern[j + 1] == '*' )
        {
            if(str[i] == pattern[j] || (pattern[j] == '.' && i < str.length))
            {
                return matchCore(str,pattern,i + 1,j) || matchCore(str,pattern,i + 1,j + 2) || matchCore(str,pattern,i,j + 2);
            }
            else
                return matchCore(str,pattern,i,j + 2);
        }
        if(str[i] == pattern[j] || (pattern[j] == '.' && i < str.length))
            return matchCore(str,pattern,i + 1,j + 1);
        return false;

    }
    public static void main(String[] args)
    {
        String str = "aa";
        String pattern = "a";
     //   System.out.println(match(str.toCharArray(),pattern.toCharArray()));
        System.out.println(matchCore(str.toCharArray(),pattern.toCharArray(),0,0));

    }
}
