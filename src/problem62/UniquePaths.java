package problem62;

public class UniquePaths {

    int[][] paths;
    boolean[][] isVisited;

    public int uniquePaths(int m, int n) {
        paths = new int[m][n];
        isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                isVisited[i][j] = false;
            }
        }

        return findUniquePaths(0,0, m, n);
    }

    public int findUniquePaths(int x, int y, int m, int n){
        if(isVisited[x][y]) return paths[x][y];
        if(x == m - 1 && y == n - 1) return 1;
        int rightPaths = 0;
        int downPaths = 0;
        if(x + 1 < m) downPaths = findUniquePaths(x + 1, y, m, n);
        if(y + 1 < n) rightPaths = findUniquePaths(x, y + 1, m, n);
        paths[x][y] = rightPaths + downPaths;
        isVisited[x][y] = true;
        return paths[x][y];
    }
}
