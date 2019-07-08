package problem51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveQueens {

    int[] columns;
    int[] rup;
    int[] lup;
    int[] queen;
    int queens;
    List<List<String>> ans;

    public List<List<String>> solveNQueens(int n) {
        columns = new int[ n + 1];
        queen = new int[n + 1];
        rup = new int[2 * n + 1];
        lup = new int[2 * n + 1];
        queens = n;
        ans = new ArrayList<>();

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
        List<String> oneRes = new ArrayList<>();
        String s = new String(new char[queens]).replace("\0", ".");
        for(int i = 0; i < queens; i++){
            char[] c = s.toCharArray();
            int index = queen[i];
            c[index] = 'Q';
            String line = new String(c);
            oneRes.add(line);
        }
        ans.add(oneRes);
    }

    public static void main(String... args){
        List<List<String>> ans = new SolveQueens().solveNQueens(4);
        for(List<String> oneRes : ans){
            System.out.println(oneRes);
        }
    }
}
