package problem48;

import java.util.Arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        if(len <= 1) return;
        int circles = len / 2;
        for (int i = 0; i < circles; i++) {
            //一圈一圈转
            int circleLen = len - 2 * i;
            for (int j = 0; j < circleLen - 1; j++) {
                int tmp = matrix[i + j][i];
                matrix[i + j][i] = matrix[len - 1 - i][i + j];
                matrix[len -1 -i][i + j] = matrix[len - 1 - i - j][len - 1 - i];
                matrix[len -1 - i -j][len -1 - i] = matrix[i][len - 1 - i - j];
                matrix[i][len - 1 - i - j] = tmp;
            }


        }
    }

    public static void main(String... args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        new RotateImage().rotate(matrix);
        for(int[] line : matrix){
            for(int element : line){
                System.out.print( element + "\t");
            }
            System.out.print("\n");
        }
    }
}
