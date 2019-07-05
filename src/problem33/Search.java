package problem33;

public class Search {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }

    public int search(int[] nums, int beginIndex, int endIndex, int target){
        if(endIndex < beginIndex) return -1;
        int middleIndex = (beginIndex + endIndex)/2;
        if(nums[middleIndex] == target) return middleIndex;
        if(nums[middleIndex] >= nums[beginIndex]){
            if(nums[beginIndex] <= target && target<= nums[middleIndex]){
                return search(nums, beginIndex, middleIndex-1, target);
            }else{
                return search(nums, middleIndex +1, endIndex, target);
            }
        }else{
            if(nums[middleIndex] <= target && target <= nums[endIndex]){
                return search(nums, middleIndex +1, endIndex, target);
            }else{
                return search(nums, beginIndex, middleIndex-1, target);
            }
        }
    }
}
