package algorithms;

import java.util.HashSet;
import java.util.Set;

/*
打印一个字符串的全部排列

打印一个字符串的全部排列，要求不要出现重复的排列
 */
public class Print_All_Permutations {


    public static void permutation(char[] s,int from,int to) {
        if(to <= 1)
            return;
        if(from == to) {
            System.out.println(new String(s));
        } else {
            for(int i=from; i<=to; i++) {
                swap(s,i,from);
                permutation(s, from+1, to);
                swap(s,from,i);
            }
        }
    }


    public static void printPermutation(char[] chars,int i){
        if(i == chars.length - 1)
        {
            System.out.println(chars);
        }
        for(int j = i;j < chars.length;j ++){
            swap(chars,i,j);
            printPermutation(chars,i + 1);
            swap(chars,i,j);
        }

    }
    public static void printPermutationNotRepet(char[] chars,int i){
        if(i == chars.length - 1)
        {
            System.out.println(chars);
        }
        Set<Character> set = new HashSet<>();
        for(int j = i;j < chars.length;j ++){
            if(!set.contains(chars[j]))
            {
                set.add(chars[j]);
                swap(chars,i,j);
                printPermutationNotRepet(chars,i + 1);
                swap(chars,i,j);
            }
        }
    }
    public static void swap(char[] s,int i,int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public static void main(String[] args) {
        String test1 = "acc";
//        permutation(test1.toCharArray(),0,test1.length() - 1);
        printPermutation(test1.toCharArray(),0);
        System.out.println("======");
        printPermutationNotRepet(test1.toCharArray(),0);
    }
}
