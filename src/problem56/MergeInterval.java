package problem56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if(len == 0) return intervals;

        LinkedList<int[]> list = new LinkedList<>();
        for(int[] interval : intervals){
            int listLen = list.size();
            boolean flag = false;
            for (int i = 0; i < listLen; i++) {
                int[] current = list.get(i);
                if(canMerge(interval, current)){
                    int[] newInterval = mergeTwoInterval(interval, current);
                    list.set(i, newInterval);

                    int lastIndex = i;
                    for (int j = i + 1; j < listLen; j++) {
                        if(canMerge(newInterval, list.get(j))){
                            lastIndex = j;
                        }else{
                            break;
                        }
                    }

                    int[] lastInterval = list.get(lastIndex);
                    for(int j = i; j <= lastIndex; j++){
                        list.remove(i);
                    }

                    int[] realInterval = mergeTwoInterval(newInterval, lastInterval);
                    list.add(i, realInterval);

                    flag = true;
                    break;
                }else if(interval[1] < current[0]){
                    list.add(i, interval);
                    flag = true;
                    break;
                }
            }

            if(!flag){
                list.add(interval);
            }
        }

        int listSize = list.size();
        int[][] res = new int[listSize][2];
        for (int i = 0; i < listSize; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public boolean canMerge(int[] interVal1, int[] interval2){
        if(interVal1[0] > interval2[1] || interval2[0] > interVal1[1]){
            return false;
        }
        return true;
    }

    public int[] mergeTwoInterval(int[] interval1,int[] interval2){
        int[] newInterval = new int[2];
        newInterval[0] = Math.min(interval1[0], interval2[0]);
        newInterval[1] = Math.max(interval1[1], interval2[1]);
        return newInterval;
    }


    public static void main(String...args){
        int[][] a = {{1,3},{2,6},{8,10},{15,18}};
        //Arrays.sort(a);
        for(int[] interval : a){
            for(int num : interval){
                System.out.print(num + "\t");
            }
            System.out.println("\n");
        }

    }
}
