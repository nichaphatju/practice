import java.util.HashMap;
import java.util.Map;

public class AnagramOrPalindrome {

    /**
     * 
     * @param S
     * @return 1 if S is anagram of some palindrome
     */

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
         * Anagram - all letters of 2 string should have same frequency ex. mary and army, rocketboys and octobersky
         * Palindrome - all letters should have even number of frequency except the middle character (only one) (Second part is reversion of the first part)
         * 
         * */
        Boolean countOneChar = false;
        for(Character ch: countChar.keySet()){
            if(countChar.get(ch)%2 != 0){
                // if string length is even, there shouldn't be any character with only one frequency.
                if(sLen % 2 == 0){
                    return 0;
                }else{
                // if string length is odd, there should be only one character with only one frequency.
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
