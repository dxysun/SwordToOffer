package writeTest;

import java.util.*;

public class AlibabaV2 {


    // write your code here
  //  public static Map<String, Integer> resolve(List<Integer> order, Map<String, List<Integer>> boms) {
    public static void resolve(List<Integer> order, Map<String, List<Integer>> boms) {

        Map<Map<String, Integer>, List<Integer>> result = new HashMap<>();
        Stack<String> stack = new Stack<>();
        int length = order.size();
        int[] a = new int[length];
        for(int i = 0;i < length;i ++)
        {
            a[i] = order.get(i);
        }
        setResult(a,boms,stack,result);

       /* for(Map.Entry<Map<String, Integer>, List<Integer>> entry:result.entrySet())
        {
            StringBuilder sb = new StringBuilder();
            for(Map.Entry<String, Integer> e:entry.getKey().entrySet())
            {
                sb.append(e.getKey() +"*"+e.getValue()+" ");

            }
            sb.append(":");
            for (Integer i: entry.getValue())
            {
                sb.append(i + " ");
            }
            System.out.println(sb.toString());
        }*/

    }
    static void setResult(int[] a,Map<String, List<Integer>> boms,Stack<String> stack,Map<Map<String, Integer>, List<Integer>> result)
    {
        if(!judge(a,boms))
        {
            Stack<String> s = new Stack<>();
            Map<String, Integer> map = new HashMap<>();
            while (!stack.isEmpty())
            {
                String str = stack.pop();
                s.push(str);
                if(map.containsKey(str))
                {
                   int b =  map.get(str);
                   b ++;
                   map.put(str,b);
                }
                else
                    map.put(str,1);
            }
            List<Integer> order = new ArrayList<>();
            for(int i:a)
            {
                order.add(i);
            }
            result.put(map,order);
            while (!s.isEmpty())
            {
                stack.push(s.pop());
            }
            return;
        }
        else
        {
            for(Map.Entry<String, List<Integer>> entry:boms.entrySet())
            {
                List<Integer> l = entry.getValue();
                boolean b1 = true;
                for(int i = 0;i < l.size();i ++)
                {
                    a[i] -= l.get(i);
                    if(a[i] < 0)
                    {
                        b1 = false;
                    }
                }
                if(b1)
                {
                    stack.push(entry.getKey());
                    setResult(a,boms,stack,result);
                    stack.pop();
                }
                for(int i = 0;i < l.size();i ++)
                {
                    a[i]  += l.get(i);
                }
            }
        }

    }
    static boolean judge(int[] a,Map<String, List<Integer>> boms)
    {
        boolean b = false;
        for(Map.Entry<String, List<Integer>> entry:boms.entrySet())
        {
            List<Integer> l = entry.getValue();
            boolean b1 = true;
            for(int i = 0;i < l.size();i ++)
            {
                int c = a[i] - l.get(i);
                if(c < 0)
                {
                    b1 = false;
                    break;
                }

            }
            if(b1)
            {
                b = true;
            }
        }
        return b;
    }
    public static void main(String[] args)
    {
        List<Integer> order = new ArrayList<>();
        Map<String, List<Integer>> boms = new HashMap<>();
        order.add(2);
        order.add(3);
        order.add(1);
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        l1.add(1);
        l1.add(1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(1);
        l2.add(0);
        List<Integer> l3 = new ArrayList<>();
        l3.add(0);
        l3.add(1);
        l3.add(1);
        boms.put("bom1",l1);
        boms.put("bom2",l2);
        boms.put("bom3",l3);
        resolve(order,boms);
    }

}
