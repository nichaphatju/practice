import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlocksOfLetters {
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
        blocks.add(tmpCharCount);
        maxLen = Math.max(maxLen, tmpCharCount);

        System.out.println(String.valueOf(blocks));

        int tmpAdd = 0;
        for(int i=0; i< blocks.size(); i++){
            tmpAdd = tmpAdd + (maxLen - blocks.get(i));
        }

        return tmpAdd;
    }

    public static void main(String[] args){
        System.out.println(solution("babaa"));
        System.out.println(solution("bbbab"));
        System.out.println(solution("bbbaaabbb"));
    }
}
