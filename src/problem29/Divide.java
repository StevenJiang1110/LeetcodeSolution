package problem29;

import java.util.ArrayList;
import java.util.List;

public class Divide {
    List<Integer> buildDivisorList(int divisor){
        List<Integer> divisorList = new ArrayList<>();
        int currentNumber = divisor;
        while(true){
            divisorList.add(currentNumber);
            if(currentNumber > 0){
                if(Integer.MAX_VALUE - currentNumber >= currentNumber){
                    currentNumber = currentNumber + currentNumber;
                }else{
                    break;
                }
            }else{
                if(Integer.MIN_VALUE - currentNumber <= currentNumber){
                    currentNumber = currentNumber + currentNumber;
                }else{
                    break;
                }
            }
        }
        return divisorList;
    }

    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;

        List<Integer> divisorList = buildDivisorList(divisor);
        List<Integer> minusDivisorList = buildDivisorList(-divisor);

        int listLength = divisorList.size();
        int res;
        int currentDividend;

        if(dividend == Integer.MIN_VALUE){
            if(divisor == Integer.MIN_VALUE) return 1;
            if(divisor == -1) return Integer.MAX_VALUE;
            if(divisor > 0){
                res = 0;
                currentDividend = dividend;
                listLength = minusDivisorList.size();
                for(int j = listLength - 1; j >= 0; j--){
                    if(currentDividend - minusDivisorList.get(j) <= 0){
                        res -= 1 << j;
                        currentDividend -= minusDivisorList.get(j);
                    }
                }
                return res;
            }else{
                res = 0;
                currentDividend = dividend;
                for(int j = listLength - 1; j >= 0; j--){
                    if(currentDividend - divisorList.get(j) <= 0){
                        res += 1 << j;
                        currentDividend -= divisorList.get(j);
                    }
                }
                return res;
            }

        }else if (divisor == Integer.MIN_VALUE){
            return 0;
        }else{
            int num1 = Math.abs(dividend);
            boolean sign1 = num1 == dividend;
            int num2 = Math.abs(divisor);
            boolean sign2 = num2 == divisor;
            int signbit = 1;
            if(sign1 != sign2) signbit = -1;


            res = 0;
            currentDividend = dividend * signbit;
            if(currentDividend > 0){
                for(int j = listLength - 1; j >= 0; j--){
                    if(currentDividend - divisorList.get(j) >= 0){
                        res += 1 << j;
                        currentDividend -= divisorList.get(j);
                    }
                }
                return res * signbit;
            }else{
                for(int j = listLength - 1; j >= 0; j--){
                    if(currentDividend - divisorList.get(j) <= 0){
                        res += 1 << j;
                        currentDividend -= divisorList.get(j);
                    }
                }
                return res * signbit;
            }
        }
    }

    public static void main(String...agrs){
        System.out.println(new Divide().divide(Integer.MIN_VALUE,2));
    }
}
