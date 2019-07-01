package Problem22;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthese {
    public List<String> generateParenthesis(int n) {
        return generateParenthesis(n, 2 * n);
    }

    public List<String> generateParenthesis(int total, int used){
        List<String> results = new ArrayList<>();
        if(used == 0){
            if(total == 0) return results;
            results.add("");
            return results;
        }

        List<String> formerResults = generateParenthesis(total, used - 1);
        for(String formerResult : formerResults){
            int rightSize = formerResult.replace("(","").length();
            int leftSize = formerResult.length() - rightSize;

            if(leftSize < total) results.add(formerResult + "(");
            if(rightSize < leftSize) results.add(formerResult + ")");
        }

        return results;
    }

    public static void main(String...args){
        List<String> results = new GenerateParenthese().generateParenthesis(3);
        for(String s : results){
            System.out.println(s);
        }
    }
}
