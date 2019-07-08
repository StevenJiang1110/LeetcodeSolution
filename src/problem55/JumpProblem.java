package problem55;

public class JumpProblem {

    boolean[] isVisited;
    boolean[] jump;

    public boolean canJump(int[] nums) {
        int len = nums.length;
        if(len == 0) return false;
        isVisited = new boolean[len];
        jump = new boolean[len];
        for (int i = 0; i < len; i++) {
            isVisited[i] = false;
            isVisited[i] = false;
        }
        return canJump(nums, 0);
    }

    public boolean canJump(int[] nums, int n){
        int len = nums.length;
        //if(n >= len) return true;
        if(isVisited[n]) return jump[n];

        if(n + nums[n] >= len - 1){
            isVisited[n] = true;
            jump[n] = true;
        }else{
            for (int i = 1; i <= nums[n]; i++) {
                if(canJump(nums, n + i)){
                    jump[n] = true;
                    break;
                }
            }
        }
        isVisited[n] = true;
        return jump[n];
    }
}
