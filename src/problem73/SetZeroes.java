package problem73;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        int line = matrix.length;
        if(line == 0) return;
        int column = matrix[0].length;
        if(column == 0) return;

        boolean[] lines = new boolean[line];
        boolean[] columns = new boolean[column];

        for (int i = 0; i < line; i++) {
            lines[i] = false;
        }

        for (int i = 0; i < column; i++) {
            columns[i] = false;
        }

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                if(matrix[i][j] == 0){
                    lines[i] = true;
                    columns[j] = true;
                }
            }
        }

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                if(lines[i] || columns[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
