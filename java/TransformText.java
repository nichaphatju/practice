import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Transform text
// Test 3



public class TransformText {
    public static String solution(String S, String T){
    int M = T.length();
    int N = S.length();
    int lenDiff = M - N;
    if(lenDiff > 1){
        return "IMPOSSIBLE";
    }
    // System.out.println(T);
    
    String addS = T.charAt(0) + S;
    String removeS = S.substring(0, N-1);

    // System.out.println(addS);
    // System.out.println(addS.equals(T));
    // System.out.println(removeS);

    if(T.equals(S)){
        return "EQUAL";
    }else if(addS.equals(T)){
        return "INSERT "+T.charAt(0);
    }else if(removeS.equals(T)){
        return "REMOVE "+S.charAt(N-1);
    }else if(lenDiff == 0){
        List<Character> ketUnmatch = new ArrayList<Character>();
        Map<Character, Character> unmatchChar = new HashMap<Character, Character>();
        for(int i=0; i <M; i++){
            if(S.charAt(i) != T.charAt(i)){
                ketUnmatch.add(S.charAt(i));
                unmatchChar.put(S.charAt(i), T.charAt(i));
                unmatchChar.put(T.charAt(i), S.charAt(i));
            }
        }
        System.out.println(unmatchChar);
        if(ketUnmatch.size() == 2){
            Character tmpCh = null;
            for(int i=0; i<ketUnmatch.size(); i++){
                System.out.println(unmatchChar.get(ketUnmatch.get(i)));
                if(i == 0){
                    tmpCh = unmatchChar.get(ketUnmatch.get(i));
                }else if(tmpCh == ketUnmatch.get(i)){
                    return "SWAP "+ tmpCh + " " + unmatchChar.get(ketUnmatch.get(i));
                }
                
            }

        }
    }

    return "IMPOSSIBLE";
    }

    public static void main(String[] args){
        // int[] intArrayA = new int[]{ 4, 3, 2, 1, 5 }; 
        // int[] intArrayB = new int[]{ 1, 1, 0, 0, 0 }; 
        // System.out.println(solution(intArrayA, intArrayB));
        // System.out.println("Result BAAABAB " +solution("BAAABAB"));
        // System.out.println("Result BBA " +solution("BBA"));
        // System.out.println("Result BBABA " +solution("BBABA"));
        // System.out.println("Result AAABAABB " +solution("AAABAABB"));
        // System.out.println("Result AABBAA " +solution("AABBAA"));
        System.out.println(solution("form", "form"));
        System.out.println(solution("from", "form"));
        System.out.println(solution("gain", "again"));
        System.out.println(solution("parks", "park"));
        System.out.println(solution("o", "odd"));
        System.out.println(solution("fift", "fifth"));

    }
}
