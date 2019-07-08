package problem47;

import java.util.ArrayList;
import java.util.List;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return permuteUnique(nums, nums.length);
    }

    public List<List<Integer>> permuteUnique(int[] nums, int n){

        List<List<Integer>> res = new ArrayList<>();

        if(n < 1) return res;
        if(n == 1){
            List<Integer> oneRes = new ArrayList<>();
            oneRes.add(nums[0]);
            res.add(oneRes);
            return res;
        }

        List<List<Integer>> formerReses = permuteUnique(nums, n -1);
        for(List<Integer> formerRes : formerReses){
            List<Integer> otherRes = new ArrayList<>(formerRes);
            otherRes.add(nums[n-1]);
            int len = otherRes.size();
            res.add(otherRes);
            for (int i = 0; i < len; i++) {
                if(otherRes.get((len-1)) != otherRes.get(i)){
                    List<Integer> oneRes = new ArrayList<>(otherRes);
                    int tmp = oneRes.get(len - 1);
                    oneRes.set(len-1, oneRes.get(i));
                    oneRes.set(i, tmp);
                    if(!res.contains(oneRes)) res.add(oneRes);
                }
            }
        }
        return res;

    }

    public static void main(String... agrs){
        int[] nums = {1,1,2,2};
        List<List<Integer>> res = new PermuteUnique().permuteUnique(nums,4);
        res.forEach(System.out::println);
    }
}
