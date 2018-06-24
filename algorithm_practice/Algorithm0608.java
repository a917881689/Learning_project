package algorithm;

public class Algorithm0608 {
    public static void main(String[] args) {

//        Look a = new Look();
//        int[] i = {0,3,5,7,9};
//        System.out.println(a.lookup(i,6));
//        int[] array = {0,3,3,3,3,5,7,9};
//        Repeat r = new Repeat();
//        int[] array2 = r.repeat(array);
//
//        System.out.println(array2[0]+""+array2[1]);

        int[] array = {0,1,2,4,5,6,7,8};
        Continuity c = new Continuity();
        for (int i:c.continuity(array)) {
            System.out.println(i);
        }

    }

}
class Continuity {
    //连续字符串
    public int [] continuity(int[] array) {
        int length = 0;
        int begin = -1;
        int end = -1;
        for (int i = 0;i < array.length;i++) {
            System.out.println("-");
            int begin2;
            int end2;
            if (i<array.length-1 && array[i]+1 == array[i+1]) {
                begin2 = i;
                while (i<array.length-1 && array[i]+1 == array[i+1]) {
                    System.out.println("+");
                    i++;
                }
                end2 = i+1;
                if (end2-begin2 > length) {
                    begin = begin2;
                    end = end2;
                }
            }
        }
        if (end != -1) {
            int[] array2 = new int[end-begin];
            for (int i = begin;i < end;i++) {
                array2[i-begin] = array[i];
            }
            return array2;
        }else {
            int[] array2 = {-1,-1};
            return array2;
        }

    }
}
class Repeat {
    public int[] repeat (int[] array) {
        //第一个重复值边界
        int [] result = new int [2];
        for (int i = 0;i < array.length;i++) {
            if (array[i] == array[i+1]) {
                result[0] = i;
                while (array[i] == array[i+1]) {
                    i++;
                }
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
class Look {
    public int lookup (int [] array,int target) {
        return lookup(array,target,0,array.length-1);
    }
    public int lookup (int [] array,int target,int begin,int end) {
        int num = (begin+end)/2;
        if (begin == num) {
            return -1;
        }
        if (array[num] == target) {
            return num;
        }
        if (array[num] > target) {
            return lookup(array,target,begin,num);
        }
        return lookup(array,target,num,end);

    }
}

