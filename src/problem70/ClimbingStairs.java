package problem70;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 0 || n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[n] = dp[n-1] = 1;

        for(int i = n-2; i >= 0; i--){
            dp[i] = dp[i+1] + dp[i + 2];
        }
        return dp[0];
    }
}
