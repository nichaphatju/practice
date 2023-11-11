import java.util.Arrays;

public class Compare2Strings {
    public static int solution(String S1, String S2){
        
        if(S1.length() == 0 && S2.length() != 0){
            return -1;
        }else if(S1.length() != 0 && S2.length() == 0){
            return 1;
        }else if(S1.length() == 0 && S2.length() == 0){
            return 0;
        }

        if(S1.compareToIgnoreCase(S2) > 0){
            return -1;
        }else if(S1.compareToIgnoreCase(S2) < 0){
            return 1;
        }

        return  0;
    }

    public static void main(String[] args){
        System.out.println(solution("abc", "AbA"));
        System.out.println(solution("a", "aa"));
        System.out.println(solution("abc", "Abc"));
    }
}
