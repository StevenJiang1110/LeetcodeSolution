package problem54;

import java.util.ArrayList;
import java.util.List;

public class SpirialOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int line = matrix.length;
        if(line == 0) return res;
        int column = matrix[0].length;
        if(column == 0) return res;

        int flag = 0;
        int[] step_x = {0,1,0,-1};
        int[] step_y = {1,0,-1,0};

        int xIndex = 0;
        int yIndex = 0;
        boolean[][] isVisited = new boolean[line][column];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                isVisited[i][j] = false;
            }
        }

        int n = line * column;
        while( n > 0){
            res.add(matrix[xIndex][yIndex]);
            isVisited[xIndex][yIndex] = true;
            n --;
            int next_x = xIndex + step_x[flag];
            int next_y = yIndex + step_y[flag];

            if(next_x >= line || next_x < 0 || next_y >= column || next_y < 0 || isVisited[next_x][next_y]){
                flag = (flag + 1) % 4;
                next_x = xIndex + step_x[flag];
                next_y = yIndex + step_y[flag];
            }

            xIndex = next_x;
            yIndex = next_y;
        }
        return res;
    }
}
