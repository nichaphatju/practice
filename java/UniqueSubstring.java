import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class UniqueSubstring {
    public static int solution(String A){
        
        Map<String, Integer> countStr = new LinkedHashMap<>();
        // Map<String, Integer> mpIndex = new LinkedHashMap<>();

        for(int strLen=2; strLen< A.length(); strLen++){
            for(int i=0; i<= A.length()-strLen; i++){
                String sub = A.substring(i, i+strLen);
                //System.out.println(sub);
                countStr.put(sub, countStr.getOrDefault(sub, 0)+1);
            }
        }

        System.out.println(countStr);
        for(String str: countStr.keySet()){
            if(countStr.get(str) == 1){
                return str.length();
            }
        }

        return -1;
    }

    public static int findUniqueSubstringIndex(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                String substring = s.substring(0, i+1);
                if (s.indexOf(substring) != -1) {
                    return i;
                }
            }
        }
        return -1; // Return -1 if no unique substring found
    }

    public static void main(String[] args){
        // int[] intArrayB = new int[]{ 1, 1, 0, 0, 0 }; 
        // System.out.println(solution(intArrayA, intArrayB));
        // System.out.println(solution(intArrayA));
        System.out.println(solution("abaaba"));

    }
}
