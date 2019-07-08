package problem52;


public class TotalNQueens {

    int[] columns;
    int[] rup;
    int[] lup;
    int[] queen;
    int queens;
    int ans;

    public int totalNQueens(int n) {
        columns = new int[ n + 1];
        queen = new int[n + 1];
        rup = new int[2 * n + 1];
        lup = new int[2 * n + 1];
        queens = n;
        ans = 0;

        solveQueens(0);

        return ans;
    }

    public void solveQueens(int i){
        if( i >= queens){
            addAnswer();
        }else{
            for(int j = 0; j < queens; j++){
                if(columns[j] == 0 && rup[i + j] == 0 && lup[i - j + queens - 1] ==0){
                    queen[i] = j;
                    columns[j] = 1;
                    rup[i + j] = 1;
                    lup[i - j + queens - 1] = 1;
                    solveQueens(i + 1);
                    columns[j] = 0;
                    rup[i + j] = 0;
                    lup[i - j + queens - 1] = 0;
                }
            }
        }
    }

    public void addAnswer(){
        ans ++;
    }

}
