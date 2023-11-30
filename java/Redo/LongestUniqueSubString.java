package Redo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestUniqueSubString {
    
    /*
     * 
     * Find longest unique substring of the given string
     * 
     */

    public static int solution(String S){

        Map<String, Integer> setStr = new HashMap<String, Integer>();
        for(int i=0; i< S.length(); i++){
            int j = S.length()-1;
            while(j > i){
                String sub = S.substring(i, j);
                setStr.put(sub, setStr.getOrDefault(sub, 0)+1);
                j--;
            }
        }

        int len = Integer.MIN_VALUE;
        for(String st: setStr.keySet()){
            if(setStr.get(st) == 1){
                len = Math.max(len, st.length());
            }
        }

        return len;

    }

    public static void main(String[] args) {
        System.out.println(solution("null"));
    }

}
