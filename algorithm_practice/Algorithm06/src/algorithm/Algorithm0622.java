package algorithm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @Author: yoSakura
 * @Date: 2018/6/22 10:59
 */
public class Algorithm0622 {
    public static void main(String[] args) {

        // 数组末尾数值+1
        // algorithm();
        // 验证给定的字符串是否为数字。
//        algorithm1("1e.66");
//        algorithm1("0");
//        algorithm1("222e10");
//        algorithm1(".e9");
//        algorithm1("1e.");
//        algorithm1("-1.");
//        algorithm1("07L");
//        algorithm1("+e3");
//        algorithm1("6e6.5");
        DateFormat dateF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateF.format(new Date()));
        System.out.println(dateF.format(System.currentTimeMillis()));
        Calendar calendar = Calendar.getInstance();
        System.out.printf("%d/%d/%d  %d/%d/%d",calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE),
                calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),calendar.get(Calendar.SECOND));

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
        for (int i = 0;i < str.length();i++) {
            if (i == 0 && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
                continue;
            }
            list.add(str.charAt(i));
        }
        ArrayList<Character> list2 = new ArrayList<>();

        int count1 = -1;
        int count2 = -1;
        int count3 = -1;
        int count4 = -1;

        for (int i = 0;i < list.size();i++) {
            char c = list.get(i);
            if (c >= '0' && c <= '9') {
                list2.add(c);
            }else if (c == '.') {
                if (count1 == -1) {
                    count1 = list2.size();
                    count3 = i;
                }else {
                    return false;
                }
            }else if (c == 'e' || c == 'E') {
                if (count2 == -1 && i != 0 && i+1 != list.size()) {
                    count2 = list2.size();
                    count4 = i;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
//        else if (str.charAt(i) == 'l' || str.charAt(i) == 'L' || str.charAt(i) == 'f' || str.charAt(i) == 'F') {
//            if (i+1 == str.length()) {
//                count3 = i;
//            }else {
//                return false;
//            }
//        }
        if (count2 != -1 && (count1 == 0 || count1 == list2.size())) {
            return false;
        }else if (count2 != -1 && count1 != -1 && count3 > count4) {
            return false;
        }else if (list2.size() >= 1){
            return true;
        }
        return false;
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
