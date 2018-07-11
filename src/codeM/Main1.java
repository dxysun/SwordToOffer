package codeM;

import java.util.*;

public class Main1 {

    public static void main(String[] args)
    {
        int n,m,k;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        int[][] rooms = new int[n + 1][m + 1];
        Queue<RoomRecord> records = new PriorityQueue<>(k,(o1,o2) -> o1.t.compareTo(o2.t));
        for(int i = 0;i < k;i ++)
        {
            RoomRecord record = new RoomRecord();
            record.x = in.nextInt();
            record.y = in.nextInt();
            record.z = in.nextInt();
            String str = in.nextLine();
            str = str.trim();
            str = str.replaceAll(":","");
            str = str.replaceAll("\\.","");
            record.t = Integer.valueOf(str);
            records.add(record);
        }


        int count = 0;
        int max = 0;

        int maxTime = 0;
        int i = 0;

        List<RoomRecord> roomRecordList = new LinkedList<>();
       /* while (!records.isEmpty())
        {
            RoomRecord r = records.poll();
            roomRecordList.add(r);
        }*/
        int[][] maxRomms = new int[n + 1][m + 1];
        while (!records.isEmpty())
        {
            RoomRecord r = records.poll();
            i ++;
            if(r.z == 0)
            {
                rooms[r.x][r.y] ++;
                if(rooms[r.x][r.y] == 1)
                {
                    count ++;
                    if(count >= max)
                    {
                        max = count;
                      //  maxTime = i;
                        for(int p = 1;p <= n;p ++)
                        {
                            for (int q = 1;q <= m;q ++)
                            {
                                maxRomms[p][q] = rooms[p][q];
                            }
                        }
                    }
                }
            }
            else
            {
                rooms[r.x][r.y] --;
                if(rooms[r.x][r.y] == 0)
                {
                    count --;
                }
            }
        }
       /* int j = 0;

        for(RoomRecord r : roomRecordList)
        {
            j ++;
            if(r.z == 0)
            {
                maxRomms[r.x][r.y] ++;
            }
            else
            {
                maxRomms[r.x][r.y] --;
            }
            if(j == maxTime)
            {
                break;
            }
        }
*/
        for(int p = 1;p <= n;p ++)
        {
            for (int q = 1;q <= m;q ++)
            {
                if(maxRomms[p][q] > 0)
                    System.out.print("1");
                else
                    System.out.print("0");
            }
            System.out.println();
        }
    }
}
class RoomRecord{
    int x;
    int y;
    int z;
    Integer t;

}
