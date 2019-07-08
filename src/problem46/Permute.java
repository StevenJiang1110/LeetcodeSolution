package problem46;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, nums.length);
    }

    public List<List<Integer>> permute(int[] nums, int n){

        List<List<Integer>> res = new ArrayList<>();

        if(n < 1) return res;
        if(n == 1){
            List<Integer> oneRes = new ArrayList<>();
            oneRes.add(nums[0]);
            res.add(oneRes);
            return res;
        }

        List<List<Integer>> formerReses = permute(nums, n -1);
        for(List<Integer> formerRes : formerReses){
            List<Integer> otherRes = new ArrayList<>(formerRes);
            otherRes.add(nums[n-1]);
            int len = otherRes.size();
            for (int i = 0; i < len; i++) {
                List<Integer> oneRes = new ArrayList<>(otherRes);
                int tmp = oneRes.get(len - 1);
                oneRes.set(len-1, oneRes.get(i));
                oneRes.set(i, tmp);
                res.add(oneRes);
            }
        }
        return res;

    }
}
