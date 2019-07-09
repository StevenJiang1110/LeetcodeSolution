package problem59;

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        boolean[][] isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isVisited[i][j] = false;
            }
        }

        int flag = 0;
        int[] step_x = {0,1,0,-1};
        int[] step_y = {1,0,-1,0};

        int xindex = 0;
        int yindex = 0;

        int num = 1;
        while (num <= n * n){
            matrix[xindex][yindex] = num;
            isVisited[xindex][yindex] = true;
            num ++;
            int nextx = xindex + step_x[flag];
            int nexty = yindex + step_y[flag];

            if(nextx >= n || nextx < 0 || nexty >=n || nexty < 0 || isVisited[nextx][nexty]){
                flag = (flag + 1) % 4;
                nextx = xindex + step_x[flag];
                nexty = yindex + step_y[flag];
            }

            xindex = nextx;
            yindex = nexty;
        }

        return matrix;
    }
}
