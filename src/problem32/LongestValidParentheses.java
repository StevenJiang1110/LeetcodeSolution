package problem32;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {

        int[] dp = new int[s.length() + 1];
        int count = 0;
        int max = 0;
        int i = 0;

        for( char c : s.toCharArray()){
            i ++;
            if(c == '('){
                count ++;
            }else if(c == ')' && count > 0){
                count --;
                int prev = dp[i - 1];
                dp[i] = dp[i - 1] + dp[i - prev - 2] + 2;
                max = Math.max(max, dp[i]);
            }
        }

        return max;

    }
}
