package problem49;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int len = strs.length;
        if(len <= 0) return res;

        int resIndex = 0;
        for(String str : strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String sortedString = new String(array);
            if(map.containsKey(sortedString)){
                int index = map.get(sortedString);
                res.get(index).add(str);
            }else{
                map.put(sortedString, resIndex);
                resIndex ++;
                List<String> oneRes = new ArrayList<>();
                oneRes.add(str);
                res.add(oneRes);
            }
        }
        return res;
    }

}
