package problem35;

import java.util.Arrays;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if(index >= 0) return index;
        else return -index-1;
    }

    public static void main(String... args){
        int[] nums = {1,3,5,6};
        int target = 0;
        System.out.println(new SearchInsert().searchInsert(nums,target));
    }
}
