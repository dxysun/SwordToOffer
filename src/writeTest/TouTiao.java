package writeTest;

import java.util.*;

public class TouTiao {


    public static void print()
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        while(in.hasNext()) {
            String str = in.nextLine();
            char[] c = str.toCharArray();
            int length = c.length;
            int i = 0;
            char preOperae = '*';
            int res = 0;
            int pre = 0;
            for(i = 0;i < length ;i ++)
            {
                if(c[i] == '+')
                {
                    int temp1 = 0;
                    int j = i + 1;
                    for(j = i + 1;j < length;j ++)
                    {
                        if(c[j] != '+' && c[j] != '-' && c[j] != '*')
                        {
                            temp1 = temp1 * 10 + 6;
                        }
                        else
                            break;
                    }
                    pre = temp1;
                    preOperae = '+';
                    i = j - 1;
                    res += temp1;
                }
                else if(c[i] == '-')
                {
                    int temp1 = 0;
                    int j = i + 1;
                    for(j = i + 1;j < length;j ++)
                    {
                        if(c[j] != '+' && c[j] != '-' && c[j] != '*')
                        {
                            temp1 = temp1 * 10 + 6;
                        }
                        else
                            break;
                    }
                    pre = temp1;
                    preOperae = '-';
                    i = j - 1;
                    res -= temp1;
                }
                else if(c[i] == '*')
                {
                    if(i > 1)
                    {
                        if(preOperae == '+')
                        {
                            res -= pre;
                            int temp1 = 0;
                            int j = i + 1;
                            for(j = i + 1;j < length;j ++)
                            {
                                if(c[j] != '+' && c[j] != '-' && c[j] != '*')
                                {
                                    temp1 = temp1 * 10 + 6;
                                }
                                else
                                    break;
                            }
                            i = j - 1;
                            pre *= temp1;
                            res += pre;
                            pre = temp1;
                        }
                        else if(preOperae == '-')
                        {
                            res += pre;
                            int temp1 = 0;
                            int j = i + 1;
                            for(j = i + 1;j < length;j ++)
                            {
                                if(c[j] != '+' && c[j] != '-' && c[j] != '*')
                                {
                                    temp1 = temp1 * 10 + 6;
                                }
                                else
                                    break;
                            }
                            i = j - 1;
                            pre *= temp1;
                            res -= pre;
                            pre = temp1;
                        }
                        else
                        {
                            int temp1 = 0;
                            int j = i + 1;
                            for(j = i + 1;j < length;j ++)
                            {
                                if(c[j] != '+' && c[j] != '-' && c[j] != '*')
                                {
                                    temp1 = temp1 * 10 + 6;
                                }
                                else
                                    break;
                            }
                            i = j - 1;
                            res *= temp1;
                            pre = temp1;
                        }
                    }
                    else
                    {
                        int temp1 = 0;
                        int j = i + 1;
                        for(j = i + 1;j < length;j ++)
                        {
                            if(c[j] != '+' && c[j] != '-' && c[j] != '*')
                            {
                                temp1 = temp1 * 10 + 6;
                            }
                            else
                                break;
                        }
                        pre = temp1;
                        preOperae = '*';
                        i = j - 1;
                        res *= temp1;
                    }
                }
                else
                {
                    res = res * 10 + 6;
                }
            }
            System.out.println(res);
        }
    }

    public static void  QuestionOne()
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a  = new int[n];
        Map<Integer,Integer> map = new TreeMap<>();
        Map<Integer,Integer> newmap = new TreeMap<>();
        for(int i = 0;i < n;i ++) {
            a[i] = in.nextInt();
            if(map.containsKey(a[i]))
            {
                int t = map.get(a[i]);
                t ++;
                map.put(a[i],t);
                newmap.put(a[i],t);
            }
            else
            {
                map.put(a[i],1);
                newmap.put(a[i],1);
            }

        }
        System.out.println(map.size());

        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if(k != 0)
            {
                if(newmap.containsKey(entry.getKey()))
                {
                    if(newmap.containsKey(entry.getKey() + k))
                        newmap.remove(entry.getKey() + k);
                }
            }
            else
            {
                if(newmap.containsKey(entry.getKey()) && newmap.get(entry.getKey()) != 1)
                {
                    newmap.put(entry.getKey() + k,1);
                }
            }
        }
        newmap.forEach((t,v)->System.out.println(t +"   "+ v));
        System.out.println(newmap.size());
    }


    public static void main(String[] args) {
        print();

    }

}
