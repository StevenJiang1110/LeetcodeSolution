package problem27;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int currentSize = -1;
        int len = nums.length;
        for(int i = 0; i < len ; i ++){
            if(nums[i] != val){
                currentSize++;
                nums[currentSize] = nums[i];
            }
        }
        return currentSize + 1;
    }
}
