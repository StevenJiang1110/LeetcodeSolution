package problem63;

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] dp = new int[row][column];

        for(int i = 0; i < row; i ++){
            for(int j = 0; j < column; j++){
                if(i ==0 && j==0){
                    if(obstacleGrid[0][0] == 1) return 0;
                    else dp[i][j] = 1;
                } else if( i == 0){
                    if(obstacleGrid[i][j] == 0) dp[i][j] = dp[i][j - 1];
                    else dp[i][j] = 0;
                }else if(j == 0){
                    if(obstacleGrid[i][j] == 0) dp[i][j] = dp[i - 1][j];
                    else dp[i][j] = 0;
                }else{
                    if(obstacleGrid[i][j] == 0) dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    else dp[i][j] = 0;
                }
            }
        }

        return dp[row - 1][column - 1];
    }
}
