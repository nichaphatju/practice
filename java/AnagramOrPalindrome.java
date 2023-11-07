import java.util.HashMap;
import java.util.Map;

public class AnagramOrPalindrome {
    public static int solution(String S) {
        int sLen = S.length();
        if(sLen == 0){
            return 0;
        }

        /** Check frequency */
        Map<Character, Integer> countChar = new HashMap<Character, Integer>();
        for(int i=0; i< sLen; i++){
            Character ch = Character.valueOf(S.charAt(i));
            countChar.put(ch, countChar.getOrDefault(ch, 0)+1);
        }

        /** 
         * 
         * Anagram - all letters should have same frequency 
         * Palindrome - all letters should have even number of frequency except the middle character (only one)
         * 
         * */
        Boolean countOneChar = false;
        for(Character ch: countChar.keySet()){
            if(countChar.get(ch)%2 != 0){
                if(sLen % 2 == 0){
                    return 0;
                }else{
                    if(countOneChar){
                        return 0;
                    }else{
                        countOneChar = true;
                    }
                }
            }
        }

        return 1;
    }

    public static void main(String[] args){
        System.out.println(solution("dooernedeevrvn"));
        System.out.println(solution("aabcba"));
    }
}
