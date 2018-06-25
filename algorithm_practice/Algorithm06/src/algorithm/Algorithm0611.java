package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algorithm0611 {
    public static void main (String[] args) {
        //给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。
        //
        //注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
        long start = System.currentTimeMillis();
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};

        for (int i : Solution.findSubstring(s,words)) {
            System.out.print(i+",");
        }
        long end = System.currentTimeMillis();
        System.out.println("\n区块时间是:" + (end - start) + "毫秒!");
        //输出: [0,9]
    }
}

class Solution {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indexes = new ArrayList<>();
        if(words.length == 0) {
            return indexes;
        }
        //记录数组中每个单元所出现的个数
        Map<String,Integer> counts = new HashMap<>(16);
        for(String word:words) {
            //因为计数时map会自动负载掉已存在的相同key，所以调用getOrDefault（方法）
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        int n = s.length();
        int num = words.length;
        int len = words[0].length();

        //i是迭代字符串的起始位置，当i>=n-num*len+1的时候  所剩字符已小于要求的字符串 长度，结束
        for (int i = 0;i < n - num * len + 1;i++) {

            Map<String,Integer> seen = new HashMap<>(16);
            int j = 0;
            //该循环迭代寻找字符串，i为起始索引
            while(j < num) {
                //每次找的是从i开始，长度为len的一个字符串

                String word = s.substring(i + j * len,i + (j + 1) * len);
                if(counts.containsKey(word)) {
                    //将迭代到的字符串及个数放入Map中，与要求的Map进行对比
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if(seen.get(word)>counts.get(word)) {
                        break;
                    }
                }else {
                    break;
                }
                j++;
            }
            if(j == num) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}


