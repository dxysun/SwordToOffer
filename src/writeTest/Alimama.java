package writeTest;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

/*
历史关键词列表范例：
连衣裙 99
衣裙连 10
苹果 80
手机 90

查询关键词范例：
连衣裙
 */
/*
阿里妈妈广告直通车是一个基于关键词(比如，“连衣裙”，“手机”)的竞价营销平台，商家在后台可以设置参与竞价的关键词。已知历史上所有关键词，和它的受欢迎程度(提前量化为1-99的数字，数值越大越受欢迎)。现在希望提供一个功能：当商家完成关键词录入之后，按热度倒序排列的相似关键词。

假设：
1. 当且仅当文字完全一致而顺序不同的关键词相似，比如“连衣裙”和“衣裙连”相似；
2. 关键词采用GBK编码，内存可以放下所有历史关键词，需要对历史关键词做预处理，加快检索过程；
 */
public class Alimama {
    public  static List<String>  list = new ArrayList<>();

    public static void permutation(char[] s,int from,int to) {
        if(to <= 1)
            return;
        if(from == to) {
            list.add(new String(s));
        } else {
            for(int i=from; i<=to; i++) {
                swap(s,i,from);
                permutation(s, from+1, to);
                swap(s,from,i);
            }
        }
    }

    public static void swap(char[] s,int i,int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {

        Scanner in = new Scanner(System.in);
        String keyList = in.nextLine();
        LinkedHashMap<String,Integer> keyMap = new LinkedHashMap<>();
        while (in.hasNext()){
            String temp = in.nextLine();
//            String temp = new String();
//            System.out.println(temp);
            if(temp.contains(" ")){
                String[] s = temp.split(" ");
                keyMap.put(s[0],Integer.valueOf(s[1]));
            }

            if(temp.contains("查询关键词范例")){
                break;
            }
        }
        String key = in.nextLine();
//        String key = new String(key1.getBytes("GBK"));
        char[] chars = key.toCharArray();
        permutation(key.toCharArray(),0,chars.length - 1);

        for(String str : list){
            if(keyMap.containsKey(str)){
                System.out.println(str +" " +keyMap.get(str));
            }
        }
    }
}
