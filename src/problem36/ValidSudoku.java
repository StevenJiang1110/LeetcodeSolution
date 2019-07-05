package problem36;

import java.util.BitSet;

public class ValidSudoku {

    public final static int line = 9;
    public final static int column = 9;

    public boolean isValidSudoku(char[][] board) {
        BitSet set = new BitSet(10);

        for(int i = 0; i < line; i++){
            set.clear();
            for(int j = 0; j < column; j++){
                if(board[i][j] == '.') continue;
                int k = board[i][j];
                if(set.get(k)) return false;
                else set.set(k);
            }
        }


        for(int j = 0; j < column; j++){
            set.clear();
            for(int i = 0; i < column; i++){
                if(board[i][j] == '.') continue;
                int k = board[i][j];
                if(set.get(k)) return false;
                else set.set(k);
            }
        }


        for(int i = 0 ; i < line/3; i ++){
            for(int j = 0; j < column/3; j++){
                set.clear();
                int startLineIndex = 3 * i;
                int startColumnIndex = 3 * j;
                for(int m = startLineIndex; m < startLineIndex + line / 3; m ++){
                    for(int n = startColumnIndex; n < startColumnIndex + column / 3; n++){
                        if(board[m][n] == '.') continue;
                        int k = board[m][n];
                        if(set.get(k)) return false;
                        else set.set(k);
                    }
                }
            }
        }

        return true;
    }

    public static void main(String... args){
        String[][] board = {
                {"5","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}
        };

        char[][] boards = new char[line][column];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                boards[i][j] = board[i][j].charAt(0);
            }
        }

        System.out.println(new ValidSudoku().isValidSudoku(boards));
    }
}
