package problem26;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 0) return 0;
        int currentNumber = nums[0] - 1;
        int currentSize = -1;
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(nums[i] > currentNumber){
                currentSize ++;
                currentNumber = nums[i];
                nums[currentSize] = currentNumber;
            }
        }
        return currentSize + 1;
    }

    public static void main(String... args){
        int[] nums = {1,1,2};

    }
}
