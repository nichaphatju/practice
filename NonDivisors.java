import java.util.Map;
import java.util.Set;

public class NonDivisors {
    public int[] solution(int[] A) {
        // Performance score = 0
        // Implement your solution here
        int[] result = new int[A.length];
        // Map<Integer, Set<Integer>> factors = new Map<Integer
        for(int i=0; i< A.length; i++){
            int countNondivisor = 0;
            for(int j=0; j<A.length ;j++){
                if(A[i] % A[j] != 0 ){
                    countNondivisor++;
                }
            }
            result[i] = countNondivisor;
        }
        return result;
    }

    public int[] solutionRevise(int[] A) {
        // Performance score = 0
        // Implement your solution here
        int[] result = new int[A.length];
        // Map<Integer, Set<Integer>> factors = new Map<Integer
        for(int i=0; i< A.length; i++){
            int countNondivisor = 0;
            for(int j=0; j<A.length ;j++){
                if(A[i] % A[j] != 0 ){
                    countNondivisor++;
                }
            }
            result[i] = countNondivisor;
        }
        return result;
    }
}
