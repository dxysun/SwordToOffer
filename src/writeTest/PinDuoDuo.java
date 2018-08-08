package writeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class PinDuoDuo {

    // abcdefghijklmnop
    public static void test1(){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        char[] chars = str.toCharArray();
        int len = chars.length;
        char[][] c = new char[len/4 + 1][len/4 + 1];

        int row = len/4 + 1;
        int col = len/4 + 1;
        int x = 0;
        int y = 0;
        int state = 0;
        for(int i = 0;i < len;i ++){
            if(state == 0){
                c[x][y ++] = chars[i];
                if(y == col){
                    state = 1;
                }
            }
            if(state == 1){
                c[x ++][y - 1] = chars[i];
                if(x == row){
                    state = 2;
                }
            }
            if(state == 2){
                c[x - 1][--y] = chars[i];
                if(y == 0){
                    state = 3;
                }
            }
            if(state == 3){
                c[--x][y] = chars[i];
                if(x == 0){
                    state = 4;
                }
            }
        }

        for(int i = 0;i < row;i ++){
            for(int j = 0;j < col;j ++){
                if(c[i][j] != 0)
                    System.out.print(c[i][j]);
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    // 00011
    public static void test2(){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        int sum = 0;
        for(int i = 0;i < str.length() - 1;i ++){
            int l = judgeStr(0,i,str);

            int r = judgeStr(i + 1,str.length() - 1,str);
            sum += l * r;
        }
        System.out.println(sum);
    }


    public static int judgeStr(int l,int r,String s){
        String str = s.substring(l,r + 1);
        if(str.length() == 1){
            return 1;
        }
        int count = 0;

        if(!str.startsWith("0"))
            count ++;
        int len = str.length();
        for(int i = 0; i < len - 1;i ++){
            String str1 =  str.substring(0,i + 1) + "." + str.substring(i + 1,len);
            if(str1.startsWith("0")){
                if(str1.charAt(1) == '.'){
                    if(!str1.endsWith("0"))
                    {
                        count ++;
                    }
                }
            }
            else
            {
                if(!str1.endsWith("0"))
                {
                    count ++;
                }
            }
        }
        return count;
    }

    /*

5 0
1 2 3
0 4
0 4
0 4
1 2 3
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int userIndex = in.nextInt();
        in.nextLine();
        ArrayList<ArrayList<Integer>> userList = new ArrayList<>();
        for(int i = 0;i < N;i ++){
            String str = in.nextLine();
            String[] a = str.trim().split(" ");
            Arrays.sort(a);
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0;j < a.length;j ++)
            {
                list.add(Integer.valueOf(a[j]));
            }
            userList.add(list);
        }
        int known = -1;
        int max = 0;
        ArrayList<Integer> myList = userList.get(userIndex);

        for(int i = 0;i < userList.size();i ++){
            if(i != userIndex){
                ArrayList<Integer> list = userList.get(i);
                if(!list.contains(userIndex)){
                    int j = 0;
                    int k = 0;
                    int count = 0;
                    while (k < list.size() && j < myList.size()){
                        if(myList.get(j).equals(list.get(k))){
                            count ++;
                            j ++;
                            k ++;
                        }
                        else
                        {
                            if(myList.get(j) > list.get(k))
                            {
                                k ++;
                            }
                            else
                            {
                                j ++;
                            }
                        }
                    }
                    if(count > max){
                        max = count;
                        known = i;
                    }
                }
            }
        }
        System.out.println(known);

    }
}
