package problem60;

import java.util.*;

public class PermutationSequence {

    LinkedList<Integer> leftNumbers;
    int[] facs;

    public String getPermutation(int n, int k) {
        facs = new int[n + 1];
        calcatuteFacs(n);
        leftNumbers = new LinkedList<>();
        for (int i = 0; i < n + 1; i++) {
            leftNumbers.add(i);
        }

        char[] cs = new char[n];

        for(int i = n - 1; i >= 1; i--){
            int index = (int)Math.ceil((double)k / facs[i]);
            k = k - (index - 1) * facs[i];
            int number = leftNumbers.remove(index);
            cs[n - 1- i] = (char)('0' + number);
        }

        cs[n -1] = (char)(leftNumbers.get(1) + '0');

        return new String(cs);

    }

    public void calcatuteFacs(int n){
        facs[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            facs[i] = i * facs[i - 1];
        }
    }

    public static void main(String...args){
        System.out.println(new PermutationSequence().getPermutation(4,9));
    }
}
