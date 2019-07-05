package problem40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum2(candidates, target, 0, candidates.length - 1);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target, int fromIndex, int toIndex){
        List<List<Integer>> res = new ArrayList<>();
        if(fromIndex > toIndex) return res;

        for (int i = toIndex; i >= fromIndex ; i--) {
            int candidate = candidates[i];
            if(target < candidate) continue;
            //if(i != candidates.length -1 && candidate == candidates[i + 1]) continue;
            if(target == candidate){
                List<Integer> oneRes = new ArrayList<>();
                oneRes.add(candidate);
                if(!res.contains(oneRes)) res.add(oneRes);
            }else{
                int rest = target - candidate;
                List<List<Integer>> otherReses = combinationSum2(candidates, rest, fromIndex, i - 1);
                int otherResSize = otherReses.size();
                if(otherResSize > 0){
                    for (int j = 0; j < otherResSize; j++) {
                        List<Integer> otherRes = otherReses.get(j);
                        otherRes.add(candidate);
                        if(!res.contains(otherRes)) res.add(otherRes);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String...args){
        int[] nums = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = new CombinationSum2().combinationSum2(nums,target);
        for(List<Integer> oneRes : res){
            System.out.println(oneRes);
        }
    }
}
