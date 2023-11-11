import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValueOccurances {
    public static int solution(int[] A) {
        System.out.println(" ----->> Input : " + Arrays.toString(A));

        Map<Integer, Integer> countNum = new HashMap<Integer, Integer>();
        for(int i=0; i<A.length; i++){
            countNum.put(A[i], countNum.getOrDefault(A[i], 0)+1);
        }

        System.out.println(countNum);
        int count = 0;
        for(Integer numTarget: countNum.keySet()){
            Integer numCount = countNum.get(numTarget);
            
            Integer diffNumCount = Math.min(Math.abs(numTarget - numCount), numCount);
            //System.out.println("diffNumCount >>>> " + diffNumCount);
            count += diffNumCount;
        }

        return count;

    }

    public static void main(String[] args) {
        int[] intArrayA = new int[]{ 1, 1, 3, 4, 4, 4 }; 
        System.out.println(solution(intArrayA));

        int[] intArrayB = new int[]{ 1, 2, 2, 2, 5, 5, 5, 8 }; 
        System.out.println(solution(intArrayB));

        int[] intArrayC = new int[]{ 1, 1, 1, 1, 3, 3, 4, 4, 4, 4, 4 }; 
        System.out.println(solution(intArrayC));

        int[] intArrayD = new int[]{ 10, 10, 10 }; 
        System.out.println(solution(intArrayD));

        int[] intArrayE = new int[]{ 11, 11, 11, 11, 13, 13, 14, 14, 14, 14, 4 }; 
        System.out.println(solution(intArrayE));
    }
}
