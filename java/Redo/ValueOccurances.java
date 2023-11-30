package Redo;

import java.util.HashMap;
import java.util.Map;

public class ValueOccurances {
    
    /*
     * 
     * Find minimum number of moves (insert or delete) to make every value X in the arrays occurs exactly X times
     */

    public static int solution(int[] A){
        
        int countMove = 0;
        int[] arr = new int[A[A.length-1]+1];
        for(int i=0; i< A.length; i++){
            arr[A[i]] = arr[A[i]]+1;
        }

        for(int i=0; i< arr.length; i++){
            // X is i
            // occurance is arr[i]
            if(arr[i] != 0){
                if(arr[i] > i){
                    // occur more than X - delete only
                    countMove+= (arr[i] - i);
                }else if( i > arr[i]){
                    // occur less than x - insert or delete
                    int move = Math.min(i - arr[i], arr[i]);
                    countMove+= move;
                }
            }
        }

        return countMove;
    }

    public static int solution2(int[] A){
        // Use map
        
        int countMove = 0;
        Map<Integer, Integer> mpCount = new HashMap<Integer, Integer>();
        for(int i=0; i< A.length; i++){
            mpCount.put(A[i], mpCount.getOrDefault(A[i], 0) + 1);
        }

        for(int i=0; i< A.length; i++){
            Integer occur = mpCount.get(A[i]);
            if(occur > A[i]){
                // occur more than X - delete only
                countMove+= (occur - A[i]);
            }else if( A[i] > occur){
                // occur less than x - insert or delete
                int move = Math.min(A[i] - occur, occur);
                countMove+= move;
            }               
        }

        return countMove;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,1,3,4,4,4}));
        System.out.println(solution(new int[]{1,2,2,2,5,5,5,8}));
        System.out.println(solution(new int[]{1,1,1,1,3,3,4,4,4,4,4}));
        System.out.println(solution(new int[]{10,10,10}));
    }
}
