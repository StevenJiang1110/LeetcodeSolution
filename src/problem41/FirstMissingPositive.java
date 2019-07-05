package problem41;

import java.util.HashSet;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(num > 0) set.add(num);
        }

        int len = set.size() + 2;
        for (int i = 1; i < len; i++) {
            if(!set.contains(i)) return i;
        }
        return len;
    }
}
