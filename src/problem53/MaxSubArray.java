package problem53;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        return maxSubArrayConquer(nums,0, nums.length - 1);
    }

    //DP
    int[] sum;
    public int maxSubArrayDP(int[] nums){
        int len = nums.length;
        if (len <= 0) return 0;
        sum = new int[len];
        sum[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            sum[i] = Math.max(sum[i-1]+nums[i], nums[i]);
            if(sum[i] > res) res = sum[i];
        }
        return res;
    }

    //conquer

    public int maxSubArrayConquer(int[] nums, int left, int right){
        if(left > right) return Integer.MIN_VALUE;
        if(left == right) return nums[left];
        int mid = (left + right) / 2;
        int maxLeft = maxSubArrayConquer(nums, left, mid);
        int maxRight = maxSubArrayConquer(nums, mid + 1, right);
        int maxCross;
        if(mid + 1 > right || left > mid) maxCross = Integer.MIN_VALUE;
        else {
            int leftTmp = nums[mid];
            int leftCrossMax = nums[mid];
            for(int j = mid - 1; j >= left; j--){
                leftTmp += nums[j];
                if(leftTmp > leftCrossMax) leftCrossMax = leftTmp;
            }

            int rightTmp = nums[mid + 1];
            int rightCrossMax = nums[mid + 1];
            for(int j = mid + 2; j <= right; j++){
                rightTmp += nums[j];
                if(rightTmp > rightCrossMax) rightCrossMax = rightTmp;
            }
            maxCross = leftCrossMax + rightCrossMax;

        }

        return Math.max(Math.max(maxLeft, maxRight), maxCross);
    }

    public static void main(String... args){
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaxSubArray().maxSubArray(a));
    }


}
