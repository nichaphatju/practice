package lessons.sorting;
import java.util.Arrays;

public class Distinct {

    /**
     * 
     * @param A
     * @return number of distinct values of an array
     * Sorting solution
     * 
     */

    public static int solution(int[] A){
        Arrays.sort(A);
        int count = 0;
        int tmp = Integer.MIN_VALUE;
        for(int i=0; i<A.length; i++){
            if(tmp != A[i]){
                count++;
            }
            tmp = A[i];
            
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,3,4,1,1,1}));
    }
}
