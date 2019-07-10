package problem75;

public class SortColors {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if(len == 0) return;

        int p0 = 0;
        int p1 = 0;
        int p2 = 0;

        for (int num : nums){
            nums[p2++] = 2;
            if(num < 2) nums[p1++] = 1;
            if(num < 1) nums[p0++] = 0;
        }
    }
}
