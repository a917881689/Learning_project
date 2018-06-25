package algorithm;

import java.util.ArrayList;

/**
 * @Author: yoSakura
 * @Date: 2018/6/13 12:41
 */
public class Algorithm0613 {
    public static void main (String[] args) {
        long start = System.currentTimeMillis();

        Solution0613 s = new Solution0613();
        System.out.println(s.isMatch("b","*?*?*"));
        System.out.println(s.isMatch("ho","ho**"));
        System.out.println(s.isMatch("ab","*?*?*"));
        System.out.println(s.isMatch("hi","*?"));
        System.out.println(s.isMatch("abce","abc*??"));
        System.out.println(s.isMatch("bbbab","*??a?"));
        System.out.println(s.isMatch("mississippi","m*iss*"));
        System.out.println(s.isMatch("acdcb","a*c?b"));
        System.out.println(s.isMatch("bbbaba","bb**??"));
        System.out.println(s.isMatch("bababb","?a*?b?"));
        System.out.println(s.isMatch("abaab","*?a?"));
        System.out.println(s.isMatch("ab","a*?b"));


        long end = System.currentTimeMillis();
        System.out.println("区块时间是:" + (end - start) + "毫秒!");
    }
}
class Solution0613 {
    public boolean isMatch(String s, String p) {

        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();
        for (int i = 0;i < s.length();i++) {
            list.add(s.charAt(i));
        }
        for (int i = 0,j = -3;i < p.length();i++) {
            if (p.charAt(i) == '*') {
                if (i != j+1) {
                    list2.add(p.charAt(i));
                }
                j = i;
            }else{
                list2.add(p.charAt(i));
            }
        }
        return  isMatch(list,0,list2,0);
    }
    public static int count = 0;
    public boolean isMatch (ArrayList<Character> list,int i,ArrayList<Character> list2,int j) {
        count++;

        if (i >= list.size() && j >= list2.size()) {
            return true;
        }else if (i >= list.size() && list2.get(j) == '*' && j+1 == list2.size() ) {
            return true;
        }else if (i >= list.size() || j >= list2.size()){
            return false;
        }

        if (list2.get(j) == '*') {
            if (j+1 >= list2.size()) {
                return true;
            }
            if (list2.get(j+1) == '?'){
                if (qr(list2,i) != -1 && j+qr(list2,i) < list.size()) {
                    return true;
                }
                if(isMatch(list,i+1,list2,j+2)){
                    return true;
                }else {
                    while (i < list.size()) {
                        if(isMatch(list,i+1,list2,j+1)){
                            return true;
                        }
                        i++;
                    }
                }
            }else{
                int rs = query(list2.get(j+1),list,i,list.size()-1);
                while(true) {
                    if (rs == -1) {
                        return false;
                    }
                    if(isMatch(list,rs,list2,j+1)) {
                        return true;
                    }else {
                        rs = query(list2.get(j+1),list,i,rs-1);
                    }
                }
            }
        }else if (list2.get(j) == '?') {
            return isMatch(list,i+1,list2,j+1);
        }else if (list.get(i).equals(list2.get(j))) {
            return isMatch(list,i+1,list2,j+1);
        }
        return false;

    }
    public int qr (ArrayList<Character> list,int n) {
        int count = 0;
        boolean flag = true;
        for (int i = n;i < list.size();i++) {
            if (list.get(i) != '*' && list.get(i) != '?') {
                flag = false;
                break;
            }else if (list.get(i) != '?'){
                count++;
            }
        }
        if (flag){
            return count;
        }else {
            return -1;
        }
    }
    public int query (char c,ArrayList<Character> list,int n,int str) {
        if (c == '*') {
            return n;
        }
        if (c == '?') {
            return n-233;
        }
        for (int i = str;i >= n;i--) {
            if (list.get(i) == c) {
                return i;
            }
        }
        return -1;
    }
}
