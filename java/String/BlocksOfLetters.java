import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlocksOfLetters {

    /**
     * 
     * @param S
     * @return
     * 
     * Find number of additional letters to be added to a string to contain blocks of equal lengths
     */

    public static int solution(String S){

        int tmpCharCount = 1;
        int maxLen = Integer.MIN_VALUE;
        List<Integer> blocks = new ArrayList<Integer>();
        for(int i=1; i<S.length(); i++){
            if(S.charAt(i-1) == S.charAt(i)){
                tmpCharCount++;
            }else{
                blocks.add(tmpCharCount);
                maxLen = Math.max(maxLen, tmpCharCount);
                tmpCharCount = 1;
            }
        }
        // blocks contains list of number of consecutive same character
        blocks.add(tmpCharCount);
        // maxLen = max length of consecutive character in S
        maxLen = Math.max(maxLen, tmpCharCount);

        System.out.println(String.valueOf(blocks));

        int tmpAdd = 0;
        for(int i=0; i< blocks.size(); i++){
            tmpAdd = tmpAdd + (maxLen - blocks.get(i));
        }

        return tmpAdd;
    }

    public static void main(String[] args){
        System.out.println(solution("babaa"));  // (3) one letter each should be added to 'b', 'a', and 'b' to be 'bbaabbaa'
        System.out.println(solution("bbbab"));  // (4) 2 letters each should be added to last 2 'a' and 'b' to be bbbaaabbb
        System.out.println(solution("bbbaaabbb")); // (0)
    }
}
