package lessons.maximumsliceproblem;

public class MaximumSliceProblem {
    
    public static void goldenMaxSlice(int[] A){

        // Find the slice with the largest sum
        // return largest sum of that slice
        // O(n)

        int maxEnd = 0;
        int maxSlice = 0;
        for(int i=0; i<A.length; i++){
            // if sum include A[i] is less, we dont count the previous sum -> reset sum to 0 //important
            // won't work if all numbers are minus
            maxEnd = Math.max(0, maxEnd + A[i]);    // max sum of a slice from the previous point (that sum > 0) to A[i]
            
            System.out.println(maxEnd);
            maxSlice = Math.max(maxEnd, maxSlice);
        }

        System.out.println(maxSlice);

    }

    public static void main(String[] args) {
        
        int[] arr = new int[]{5,-7,3,5,-2,4,-1};
        goldenMaxSlice(arr);
    }
}
