package algorithm;

import java.util.ArrayList;
import java.util.List;
/**
 * @Author: yoSakura
 * @Date: 2018/6/20 13:41
 */
public class Algorithm0620 {
    public static void main(String[] args) {
        Interval intervals = new Interval(0,5);
        Interval intervals2 = new Interval(6,8);
        List<Interval> arrayList = new ArrayList<>();
        Interval inte = new Interval(11,12);
        arrayList.add(intervals);
        arrayList.add(intervals2);
        Solution0620 s = new Solution0620();
        List<Interval> insert = s.insert(arrayList,inte);
        for (Interval i: insert) {
            System.out.println(i);
        }
    }

}
class Solution0620 {
    public List<Interval> insert (List<Interval> intervals, Interval newInterval) {

        int start = newInterval.start;
        int end = newInterval.end;
        int num = 0;
        List<Interval> list = new ArrayList<>();
        if (intervals.size() <= 0) {
            list.add(newInterval);
            return list;
        }
        boolean flag = false;
        for (int i = 0;i < intervals.size();i++) {
            if(start < intervals.get(i).start && end < intervals.get(i).start){
                System.out.println("1");
                list.add(new Interval(start,end));
                list.add(new Interval(intervals.get(i).start,intervals.get(i).end));
                flag = true;
            }else if ((start <= intervals.get(i).start)){
                System.out.println("2");
                if(end <= intervals.get(i).end){
                    list.add(new Interval(start,intervals.get(i).end));
                }else {
                    list.add(new Interval(start,end));
                }
                flag = true;
            }else if ((start <= intervals.get(i).end)){
                System.out.println("3");
                if(end <= intervals.get(i).end){
                    list.add(new Interval(intervals.get(i).start,intervals.get(i).end));
                }else {
                    list.add(new Interval(intervals.get(i).start,end));
                }
                flag = true;
            }else {
                list.add(new Interval(intervals.get(i).start,intervals.get(i).end));
            }
            if(flag) {
                int e = list.get(list.size()-1).end;
                int j = list.size()-1;
                while (i+1 < intervals.size() && e >= intervals.get(i+1).start) {
                    if(e <= intervals.get(i+1).end){
                        list.get(j).end =  intervals.get(i+1).end;
                    }
                    i++;
                }
                num = i;
                break;
            }
        }
        if(flag) {
            for (int i = num+1; i < intervals.size();i++) {
                list.add(new Interval(intervals.get(i).start,intervals.get(i).end));
            }
        }else {
            list.add(newInterval);
        }
        return list;
    }
}



class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return "{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
