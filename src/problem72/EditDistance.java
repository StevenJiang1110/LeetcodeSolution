package problem72;

public class EditDistance {

    int[][] dp;

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 == 0) return len2;
        if(len2 == 0) return len1;
        dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1 + 1; i++) {
            for (int j = 0; j < len2 + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return findMinDistance(word1,word2,len1, len2);
    }

    public int findMinDistance(String word1, String word2, int x, int y){
        if(dp[x][y] != -1) return dp[x][y];
        if(x == 0){
            dp[x][y] = y;
            return y;
        }
        if(y == 0){
            dp[x][y] = x;
            return x;
        }

        if(word1.charAt(x - 1) == word2.charAt(y - 1)){
            dp[x][y] = findMinDistance(word1, word2, x-1, y-1);
            return dp[x][y];
        }else{
            int dis1 = 1 + findMinDistance(word1, word2, x-1, y-1);
            int dis2 = 1 + findMinDistance(word1, word2, x, y - 1);
            int dis3 = 1 + findMinDistance(word1,word2,x - 1, y);
            dp[x][y] = Math.min(Math.min(dis1,dis2),dis3);
            return dp[x][y];
        }
    }
}
