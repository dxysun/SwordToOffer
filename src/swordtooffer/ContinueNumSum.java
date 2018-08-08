package swordtooffer;

import java.util.ArrayList;

public class ContinueNumSum {


    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int temp = 0;
        for(int i = sum/2 + 1;i >= 1;i --)
        {
            temp = sum / i;
            if(sum % i == 0)
            {

                int start = 0;
                int end = 0;
                if((i & 1) == 0)
                {
                    if((temp & 1) != 0)
                    {
                        int mid = temp / 2;
                        start = mid - i + 1;
                        end = mid + i;
                    }
                }
                else
                {
                    int len = i / 2;
                    if((i & 1) != 0)
                    {
                        start = temp - len;
                        end = temp + len;
                    }
                }
                if(start < 0 )
                    continue;
                if(start != 0 && end != sum)
                {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for(int k = start;k <= end;k ++)
                    {
                        arrayList.add(k);
                    }
                    res.add(arrayList);
                }
            }
            else
            {
                if(temp + temp + 1 == sum)
                {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(temp);
                    arrayList.add(temp +1);
                    res.add(arrayList);
                }

            }
        }
        res.sort((o1,o2)->o1.get(0) - o2.get(0));
        return res;
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequenceV2(int sum)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(sum < 3)
            return res;
        int start = 1;
        int end = 2;
        int mid = (sum + 1)/2;
        int curSum = start +  end;
        while (start < mid)
        {
            if(curSum == sum)
            {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for(int k = start;k <= end;k ++)
                {
                    arrayList.add(k);
                }
                res.add(arrayList);
            }
            while (curSum > sum && start < mid)
            {
                curSum -= start;
                start ++;
                if(curSum == sum)
                {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for(int k = start;k <= end;k ++)
                    {
                        arrayList.add(k);
                    }
                    res.add(arrayList);
                }
            }
            end ++;
            curSum += end;
        }
        return res;

    }
    public static void main(String[] args)
    {
        ContinueNumSum c = new ContinueNumSum();
        ArrayList<ArrayList<Integer>> res = c.FindContinuousSequenceV2(9);
        for(ArrayList<Integer> a : res)
        {
            a.forEach(b->System.out.print(b + " "));
            System.out.println();
        }

    }
}
