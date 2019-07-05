package problem34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        int[] res = {-1, -1};
        if(index < -1) return res;
        for(int i = index; i>=0; i--){
            if(nums[i] == target){
                res[0] = i;
            }else{
                break;
            }
        }
        int len = nums.length;
        for(int i = index; i < len; i++){
            if(nums[i] == target){
                res[1] = i;
            }else{
                break;
            }
        }
        return res;
    }

    public static void main(String... args){
        int[] nums = {1,2,3};
        int target = 2;
        int[] res = new SearchRange().searchRange(nums, target);

        String[] strings = {"aa", "bb", "cc"};

        List reslist = Arrays.asList(strings);
        reslist.forEach(System.out::println);
        ArrayList<?> arrayList = new ArrayList<>();
        Object obj;
        String s;
    }
}
