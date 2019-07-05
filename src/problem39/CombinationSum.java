package problem39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(candidates, 0, candidates.length -1, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int fromIndex, int toIndex, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if(toIndex < fromIndex) return res;

        for (int i = toIndex; i >= fromIndex ; i --) {
            if(target < candidates[i]) continue;
            int multiple = target / candidates[i];
            for (int j = multiple; j >=1; j--) {
                int rest = target - j * candidates[i];

                //System.out.println("rest:" + rest + "\t" + target + "\t" + j + "\t" + candidates[i]);

                if(rest == 0){
                    List<Integer> oneRes = new ArrayList<>(j);
                    for (int k = 0; k < j; k++) {
                        oneRes.add(candidates[i]);
                    }
                    //System.out.println("one res:" + oneRes);
                    res.add(oneRes);
                }else{
                    List<List<Integer>> restRes = combinationSum(candidates, fromIndex, i - 1, rest);
                    int restResSize = restRes.size();
                    if(restResSize > 0){

                        for (int k = 0; k < restResSize; k++) {
                            List<Integer> otherRes = restRes.get(k);
                            for (int l = 0; l < j; l++) {
                                otherRes.add(candidates[i]);
                            }
                            res.add(otherRes);
                        }
                    }
                }
            }
        }
        return res;
    }


    public static void main(String... args){
        int[] nums = {2,3,5};
        int target = 8;
        List<List<Integer>> res = new CombinationSum().combinationSum(nums,target);
        for(List<Integer> oneRes : res){
            System.out.println(oneRes);
        }
    }
}
