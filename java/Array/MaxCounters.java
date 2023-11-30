import java.util.Arrays;

public class MaxCounters {

    /*
     * 
     * If A[K] < N+1 -> add 1 increment
     * If A[K] == N+1 -> set all elements to max current value
     * return a new array after processed the operations
     * 
     */
    
    public int[] solution(int N, int[] A) {
        // First attempt
        // Bad performance
        // Implement your solution here

        int[] result = new int[N];
        int tmpMax = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] < (N+1)){
                result[A[i]-1]++;
                tmpMax = Math.max(result[A[i]-1], tmpMax);
            }else if(A[i] == (N+1)){
                // This is basically looping inside an array (O(n))
                Arrays.fill(result, tmpMax);
            }
            //System.out.println(Arrays.toString(result));
        }

        return result;
    }

    public int[] solution2(int N, int[]A){
        int[] result = new int[N];
        int tmpMax = 0;
        int tmpMaxCounter = 0;

        for(int i=0;i <A.length; i++){
            if(A[i] < (N+1)){
                // increase to max counter when meet the element (if there was previous max counter)
                result[A[i]-1] = Math.max(result[A[i]-1]+1, tmpMaxCounter+1);
                tmpMax = Math.max(tmpMax, result[A[i]-1]);
            }else if(A[i] == N+1){
                // max counter
                // Change from looping inside to keep value as a temp
                tmpMaxCounter = tmpMax;
            }
        }

        // in case some elements weren't met after max counter
        for(int i=0; i<result.length; i++){
            result[i] = Math.max(result[i], tmpMaxCounter);
        }


        return result;
    }

    public static void main(String[] args) {
        
    }
}
