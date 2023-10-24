import java.util.HashSet;
import java.util.Set;

public class UniqueSubstring {
    public static int solution(String A){
        
        

        for(int strLen=2; strLen< A.length(); strLen++){
            for(int i=0; i<= A.length()-strLen; i++){
                String sub = A.substring(i, i+strLen);
                System.out.println(sub);
            }
        }
        return 1;
    }

    public static void main(String[] args){
        // int[] intArrayB = new int[]{ 1, 1, 0, 0, 0 }; 
        // System.out.println(solution(intArrayA, intArrayB));
        // System.out.println(solution(intArrayA));
        System.out.println(solution("abaaba"));

    }
}
