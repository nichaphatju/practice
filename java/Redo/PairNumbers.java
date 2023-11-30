package Redo;

import java.util.HashMap;
import java.util.Map;

public class PairNumbers {
    
    /*
     * 
     * return number of pair of number that first digit of first value = last digit of second value
     * 
     */

    public static int solution(int[] A){

        Map<Integer, Integer> mpCount = new HashMap<Integer,Integer>();
        int countDup = 0;
        for(int i=0; i<A.length; i++){
            String numStr = String.valueOf(A[i]);
            Integer fd = Character.getNumericValue(numStr.charAt(0));
            /**
             * In case 11 shouldn't count twice
             */
            Integer ld = Character.getNumericValue(numStr.charAt(numStr.length()-1));
            if(fd == ld){
                countDup++;
            }
            mpCount.put(fd, mpCount.getOrDefault(fd, 0)+1);
        }

        int count = 0;
        for(int i=0; i<A.length; i++){
            String numStr = String.valueOf(A[i]);
            Integer ld = Character.getNumericValue(numStr.charAt(numStr.length()-1));
            count += mpCount.getOrDefault(ld, 0);
        }

        //In case 11 shouldn't count twice - countDup
        return count-countDup;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{18, 19, 92, 20, 11}));    // 11 shouldn't be count twice?
        System.out.println(solution(new int[]{18, 19, 92, 20, 11, 22})); 
        System.out.println(solution(new int[]{122, 21 , 23 ,19}));
    }

}
