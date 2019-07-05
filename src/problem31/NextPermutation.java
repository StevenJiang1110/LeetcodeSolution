package problem31;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int numsLen = nums.length;
        int j;
        for(j = numsLen - 2 ; j >= 0; j--){
            boolean flag = false;
            for(int i = numsLen -1; i > j; i--){
                if(nums[j] < nums[i]){
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        Arrays.sort(nums,j+1, numsLen);
    }
}
