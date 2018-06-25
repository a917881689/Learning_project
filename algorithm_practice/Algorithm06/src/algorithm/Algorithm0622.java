package algorithm;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * @Author: yoSakura
 * @Date: 2018/6/22 10:59
 */
public class Algorithm0622 {
    public static void main(String[] args) {

        //数组末尾数值+1
        //algorithm();
        //验证给定的字符串是否为数字。
        algorithm1("0.1");
        algorithm1("0");
        algorithm1("222e10");
        algorithm1("1 a");
    }
    public static void algorithm () {
        Solution1 s = new Solution1();
        for(int i:s.plusOne(new int[]{9,9,9,9})) {
            System.out.println(i);
        }
    }
    public static void algorithm1 (String str) {
        Solution1 s = new Solution1();
        System.out.println(s.isNumber(str));
    }
}
class Solution1 {
    public boolean isNumber(String s) {
        String str = s.trim();
        ArrayList<Character> list = new ArrayList<>();
        int count1 = 0;
        for (int i = 0;i < str.length();i++) {
            list.add(s.charAt(i));
        }
    }

    public int[] plusOne(int[] digits) {
        digits[digits.length-1] = digits[digits.length-1]+1;
        return plusTwo(digits,digits.length-1);

    }
    public int[] plusTwo (int[] digits,int i) {
        if(i == 0 && digits[i] >= 10) {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            for(int j = 0;j < digits.length;j++) {
                result[j+1] = 0;
            }
            return result;
        }
        if(digits[i] >= 10) {
            digits [i] = 0;
            digits [i-1] += 1;
            return plusTwo(digits,i-1);
        }
        return digits;
    }
}
