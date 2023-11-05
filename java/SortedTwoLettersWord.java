import java.util.HashSet;
import java.util.Set;

public class SortedTwoLettersWord {

    public static int solution(String S) {
        
        int countA = 0;
        int countB = 0;

        Set<Integer> AAfterB = new HashSet<Integer>();
        Set<Integer> BBeforeA = new HashSet<Integer>();

        for(int i=0; i<S.length(); i++){
            //System.out.println(S.charAt(i));
            if(S.charAt(i) == 'A'){
                countA++;
                
                if(i-1 >= 0){
                    if(S.charAt(i-1) == 'B'){
                        AAfterB.add(i);
                        int check = i-1;
                        while(check >= 0 && S.charAt(check) == 'B'){
                            BBeforeA.add(check);
                            check--;
                        }
                    }
                }

            }else{
                countB++;
            }

        }
        if(countA == countB){
            return countB;
        }
        if(countA > countB){
            return BBeforeA.size();
        }

        return AAfterB.size();

    }

    public static void main(String[] args) {
        System.out.println("Result BAAABAB " +solution("BAAABAB"));
        System.out.println("Result BBA " +solution("BBA"));
        System.out.println("Result BBABA " +solution("BBABA"));
        System.out.println("Result AAABAABB " +solution("AAABAABB"));
        System.out.println("Result AABBAA " +solution("AABBAA"));
        System.out.println("Result BBABAA " +solution("BBABAA"));
        System.out.println("Result AABBBB " +solution("AABBBB"));
    }
}
