package problem30;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;

public class FindSubString {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<>();
        int wordNumber = words.length;
        int stringLen = s.length();
        if(stringLen == 0 || wordNumber == 0) return res;
        int wordLength = words[0].length();
        int subStringLen = wordNumber * wordLength;
        if(stringLen < subStringLen) return res;
        BitSet bitSet = new BitSet(subStringLen);
        for(int i = 0; i < stringLen - subStringLen + 1; i++){
            String subString = s.substring(i, i + subStringLen);
            bitSet.clear();
            boolean failureFlag = false;
            for(String word : words){
                int startIndex = 0;
                boolean findFlag = false;
                while(subString.indexOf(word, startIndex) != -1){
                    int index = subString.indexOf(word, startIndex);
                    if(index % wordLength == 0){
                        if(!bitSet.get(index)){
                            bitSet.set(index, index + wordLength);
                            findFlag = true;
                            break;
                        }
                    }
                    startIndex = index + 1;
                }
                if(!findFlag){
                    failureFlag = true;
                    break;
                }
            }
            if(!failureFlag){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String...args){

        String s = "abababab";
        String[] words = {"a","b", "a"} ;
        List<Integer> indexes = new FindSubString().findSubstring(s, words);

        for( int  index: indexes){
            System.out.println(index);
        }
    }
}
