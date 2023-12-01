package Redo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SmallestSubString {

    public static int solution(String S){

        int maxSubStrLen = S.length()-1;
        int ans = 0;

        
        Map<String, Integer> countSubstr = new LinkedHashMap<>();
        Map<String, Integer> indexOfSubstr = new LinkedHashMap<>();
        for(int i=0; i<S.length(); i++){
            int subStrLen = 1;
            while(subStrLen < maxSubStrLen){
                String substr = S.substring(i, Math.min(S.length(),i+subStrLen));
                // if(i==3){
                //     System.out.println(substr);
                // }
                countSubstr.put(substr, countSubstr.getOrDefault(substr, 0)+1);
                if(!indexOfSubstr.containsKey(substr)){
                    indexOfSubstr.put(substr, i);
                }
                subStrLen++;
            }
            System.out.println(countSubstr);
            
        }

        
        List<String> candidates = new ArrayList<>();
        for(String str: countSubstr.keySet()){
            if(countSubstr.get(str) == 1){
                candidates.add(str);
            }
        }

        int tmp = Integer.MAX_VALUE;
        for(int i=0; i<candidates.size(); i++){
            if(candidates.get(i).length() < tmp){
                tmp = candidates.get(i).length();
                ans = tmp;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(solution("abaaba"));
        System.out.println(solution("zyzyzyz"));
    }
    
}
