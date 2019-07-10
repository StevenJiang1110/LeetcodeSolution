package problem74;

public class SearchMatrix {

    int matrixLine;
    int matrixColumn;

    public boolean searchMatrix(int[][] matrix, int target) {
        int line = matrix.length;
        if(line == 0) return false;
        int column = matrix[0].length;
        if(column == 0) return false;

        matrixLine = line;
        matrixColumn = column;
        return binarySearch(matrix, target, 0, line * column - 1);
    }

    public boolean binarySearch(int[][] matrix, int target, int begin, int end){
        if(begin > end) return false;
        int mid = (begin + end) / 2;

        int line = mid / matrixColumn;
        int column = mid % matrixColumn;

        if(matrix[line][column] == target) return true;
        else if(matrix[line][column] > target) return binarySearch(matrix, target, begin, mid - 1);
        else return binarySearch(matrix,target,mid + 1, end);
    }
}
