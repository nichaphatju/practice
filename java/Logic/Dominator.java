import java.util.*;

/**
 * Iterations
 * Arrays
 * Time Complexity
 * Counting Elements
 * Prefix Sums - Sum of arrays from 0-N
 * Sorting
 * Stacks and Queues
 * **Leader
 * Maximum slice problem
 * Prime and composite numbers
 * Sieve Eratosthenes
 * Euclidean algorithm
 * Fibonacci numbers
 * Binary Search
 * Caterpillar method
 * Greedy algorithm
 * Dynamic programming
 */

 // Leader
public class Dominator {

    // The dominator of array A is the value that occurs in more than half of the elements of A.

        public static int solution(int[] A) {
        System.out.println(" ----->> Input : " + Arrays.toString(A));
        if(A.length == 0){
            return -1;
        }
        int halfEle = (int) Math.ceil(A.length/2);
        Map<Integer, Integer> mapExist = new HashMap<Integer, Integer>();
        Boolean hasDominator = false;
        for(int i=0; i< A.length; i++){
            if(mapExist.containsKey(A[i])){
                int currentExist = mapExist.get(A[i]);
                // occur more than half
                if((currentExist + 1) > halfEle){
                    hasDominator = true;
                }
                mapExist.put(A[i],currentExist+1);
            }else{
                mapExist.put(A[i], 1);
            }
        }

        if(!hasDominator && A.length > 1){
            return -1;
        }
        for(int k : mapExist.keySet()){
            Boolean isDominator = mapExist.get(k) > halfEle;
            if(isDominator){
                for(int i=0; i< A.length; i++){
                    if(A[i] == k){
                        return i;
                    }
                }
            }
        }

        System.out.println(" ---- >> Output "+ halfEle);

        return halfEle;
    }

    public static int solution2(int[] A){

        if(A.length == 0) return -1;
        int dominator = -1;
        int maxCount = 0;
        int half = (int) Math.ceil(A.length/2); // this will result 7 since 2 is integer
        Map<Integer, Integer> mapCount = new HashMap<Integer, Integer>();
        for(int i=0; i<A.length; i++){
            mapCount.put(A[i], mapCount.getOrDefault(A[i], 0)+1);

            if(mapCount.get(A[i]) > half){  // use > condition
                if(mapCount.get(A[i]) > maxCount){
                    maxCount = mapCount.get(A[i]);
                    dominator = A[i];
                }
            }

        }
        return dominator;

    }

    public static String solution(String A) {
        System.out.println(" ---- >> Input "+ A);

        System.out.println(" ---- >> Output "+ 1);
        return "";
    }

    public static void main(String[] args){
        int[] intArrayA = new int[]{ 3, 4, 3, 2, 3, -1, 3, 3, 2, 2, 2, 2, 3, 3, 3 }; 
        // int[] intArrayB = new int[]{ 1, 1, 0, 0, 0 }; 
        // System.out.println(solution(intArrayA, intArrayB));
        System.out.println(solution2(intArrayA));
        // System.out.println(solution(""));

    }
}
