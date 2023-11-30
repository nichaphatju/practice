package Redo;

public class SortedTwoLettersWord {
    
    /*
     * 
     * return number of letters to be deleted to obtain text format A comes before B
     */

    public static int solution(String S){

        if(S.length() == 0) return 0;

        int countAAfterB = 0;
        int countBBeforeA = 0;

        int tmpCountB = 0;
        int tmpCountA = 0;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == 'B'){
                tmpCountB++;
                countAAfterB += tmpCountA;
                tmpCountA = 0;
            }else{
                tmpCountA++;
                countBBeforeA += tmpCountB;
                tmpCountB = 0;
            }

        }
        countAAfterB += tmpCountA;
        // count last tmp only from A cuz we dont care if B is after
        //countBBeforeA += tmpCountB;

        return Math.min(countBBeforeA, countAAfterB);
    }

    public static void main(String[] args) {
        System.out.println(solution("BAAABAB"));
        System.out.println(solution("BBABAA"));
        System.out.println(solution("AABBBB"));
        System.out.println(solution("BBBBBB"));
        System.out.println(solution("AAA"));
        System.out.println(solution("ABABABABAA"));
    }
}
