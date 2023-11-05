import java.util.*;

public class MaximumProfit {
    public static int solution(int[] A) {
        // Implement your solution here
        //System.out.println(" ----->> Input : " + Arrays.toString(A));
        int[] maxPriceAfter = new int[A.length];
        int maxPrice = 0;
        for(int i=A.length-1; i>=0; i--){
            if(i < (A.length-1)){
                maxPrice = Math.max(A[i+1], maxPrice);
            }
            maxPriceAfter[i] = maxPrice;
        }
        //System.out.println(" ----->> maxPriceAfter : " + Arrays.toString(maxPriceAfter));

        int maxPriceResult = 0;
        for(int i=0; i<A.length; i++){
            if(maxPriceAfter[i] > A[i]){
                maxPriceResult = Math.max(maxPriceResult, maxPriceAfter[i] - A[i]);
            }
        }

        //System.out.println(" ----->> maxPriceResult  "+maxPriceResult);

        return maxPriceResult;
    }

    public static void main(String[] args){
        int[] intArrayA = new int[]{ 3, 4, 3, 2, 3, -1, 3, 3 }; 
        // int[] intArrayB = new int[]{ 1, 1, 0, 0, 0 }; 
        // System.out.println(solution(intArrayA, intArrayB));
        System.out.println(solution(intArrayA));
        // System.out.println(solution(""));

    }
}
