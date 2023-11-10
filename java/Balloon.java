import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Balloon {
    public static int solution(String S){

        Map<Character, Integer> countChar = new HashMap<Character, Integer>();
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == 'B' || S.charAt(i) == 'A' || S.charAt(i) == 'L' || S.charAt(i) == 'O' || S.charAt(i) == 'N'  )
                countChar.put(S.charAt(i), countChar.getOrDefault(S.charAt(i), 0)+1);
            else
                countChar.put('Z', countChar.getOrDefault('Z', 0)+1);
        }
        int[] test = new int[26];
        test['a'-'a']++;
        System.out.println(Arrays.toString(test));

        int countB = countChar.getOrDefault('B', 0);
        int countA = countChar.getOrDefault('A', 0);
        int countL = countChar.getOrDefault('L', 0);
        int countO = countChar.getOrDefault('O', 0);
        int countN = countChar.getOrDefault('N', 0);
        int countZ = countChar.getOrDefault('Z', 0);
        // System.out.println(countZ);

        if(countB > 0 && countA > 0 && countL > 1 && countO > 1 && countN > 0){

            int maxPos = Math.min(countL/2, countO/2);
            maxPos = Math.min(countB, maxPos);
            maxPos = Math.min(countA, maxPos);
            maxPos = Math.min(countN, maxPos);
            double x = 7;
            int timeToRemove = (int) Math.ceil(countZ/x);
            // System.out.println(timeToRemove);
            int maxMove = Math.min(timeToRemove, maxPos);   // In case we *have to* delete something before next move

            return maxMove;
        }
        
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("BAONXXOLL"));
        System.out.println(solution("BAOOLLNNOLOLGBAX"));
        System.out.println(solution("QAWABAWONL"));
        System.out.println(solution("ONLABLABLOON"));
        System.out.println(solution("BAOOLLNNOXXXXXXXXLOLGBAX"));
    }
}
