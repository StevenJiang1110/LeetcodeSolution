package problem57;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        if(len == 0){
            int[][] res = new int[1][2];
            res[0] = newInterval;
            return res;
        }
        LinkedList<int[]> list = new LinkedList<>();
        boolean flag = false;
        boolean insertFlag = false;
        for(int[] interval : intervals){
            if(!flag){
                if(!canMerge(interval, newInterval)){
                    if(interval[1] < newInterval[0]){
                        list.add(interval);
                    }else{
                        if(!insertFlag){
                            list.add(newInterval);
                            insertFlag = true;
                        }
                        list.add(interval);
                    }
                }else{
                    flag = true;
                    int[] interval1 = mergeTwoInterval(interval, newInterval);
                    insertFlag = true;
                    list.add(interval1);
                }
            }else{
                int[] current = list.getLast();
                if(canMerge(current, interval)){
                    int[] interval1 = mergeTwoInterval(current, interval);
                    list.removeLast();
                    list.addLast(interval1);
                }else{
                    list.add(interval);
                    flag = false;
                }
            }
        }

        if(!insertFlag){
            list.addLast(newInterval);
        }

        int[][] res = new int[list.size()][2];
        int i = 0;
        for(int[] oneInterval : list){
            res[i++] = oneInterval;
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
}
