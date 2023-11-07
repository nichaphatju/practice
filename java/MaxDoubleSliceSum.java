import java.util.Arrays;
import java.util.List;

public class MaxDoubleSliceSum {
    
    public static int solution(int[] A) {
        // Implement your solution here

        int tmpSliceLeft = 0, tmpSliceRight = 0;
        int maxSliceLeft = 0, maxSliceRight = 0;
        int maxSlice = maxSliceLeft + maxSliceRight;

        for(int x=1, y=A.length-2; x < y && y > x; x++, y--){

            System.out.println("x "+ x);
            System.out.println("y "+ y);

            tmpSliceLeft = Math.max(A[x], tmpSliceLeft + A[x]);
            tmpSliceRight = Math.max(A[y], tmpSliceRight + A[y]);

            System.out.println("tmpSliceLeft "+ tmpSliceLeft);
            System.out.println("tmpSliceRight "+ tmpSliceRight);

            maxSliceLeft = Math.max(maxSliceLeft, tmpSliceLeft);
            maxSliceRight = Math.max(maxSliceRight, tmpSliceRight);

            System.out.println("maxSliceLeft "+ maxSliceLeft);
            System.out.println("maxSliceRight "+ maxSliceRight);

            maxSlice = Math.max(maxSlice, maxSliceLeft + maxSliceRight);
        }
        return maxSlice;
    }

    public static int correctSolution(int[] A) {

        // (X, Y, Z)
        
        // max left and max right each point
        int maxLeft[] = new int[A.length];
        int maxRight[] = new int[A.length];
        
        // 1) find "maxLeft"
        // maxLeft[i] is the maximum sum "contiguous subsequence" ending at index i 
        // note: because it is "contiguous", we only need the ending index (important)
        for(int i=1; i< A.length ;i++){   // be careful: from i=1 (because of maxLeft[i-1])
            maxLeft[i] = Math.max(0, maxLeft[i-1]+A[i] ); //golden slice algorithm: Math.max(0, maxLeft[i-1]+A[i] )
        } 
        
        // 2) find "maxRight"
        // maxRight[i] is the maximum sum "contiguous subsequence" starting at index i 
        // note: because it is "contiguous", we only need the starting index (important)
        for(int i=A.length-2; i >=0; i--){   // be careful: from i=A.length-2 (because of maxLeft[i+1])
            maxRight[i] = Math.max(0, maxRight[i+1]+A[i] ); //golden slice algorithm: Math.max(0, maxRight[i+1]+A[i] )
        } 
        
        // 3) find the maximum of "maxLeft + maxRight"
        int maxDoubleSlice =0;
        for(int i=1; i < A.length-1; i++){ // where "i" means "Y" in this problem
            if(maxLeft[i-1] + maxRight[i+1] > maxDoubleSlice)   // be careful: left end at "i-1" and right begins at "i+1"
                maxDoubleSlice = maxLeft[i-1] + maxRight[i+1];  // be careful: "not" maxLeft[i] + maxRight[i]
        } 
        
        return maxDoubleSlice;
    }

    public static int solutionMaxSlice(int[] A) {
        // Implement your solution here

        int[] maxSliceLeft = new int[A.length];
        int[] maxSliceRight = new int[A.length];


        for(int i=1, j=A.length-2; i<A.length && j >= 0; i++, j--){
            maxSliceLeft[i] = Math.max(0, maxSliceLeft[i-1] + A[i]);    // max slice algorithm - from start to i-1
            maxSliceRight[j] = Math.max(0, maxSliceRight[j+1] + A[j]);    // max slice algorithm - from j+1 to end
        }

        //System.out.println("maxSliceLeft " + Arrays.toString(maxSliceLeft));
        //System.out.println("maxSliceRight " + Arrays.toString(maxSliceRight));

        int maxSliceSum = 0;

        for(int i=1; i<maxSliceLeft.length-1; i++){
            // at one point (i) - calculate sum from left and right (excluding A[i])
            maxSliceSum = Math.max(maxSliceSum, maxSliceLeft[i-1] + maxSliceRight[i+1]);
        }

        return maxSliceSum;
    }

    public static void main(String[] args){
        int[] intArrayA = new int[]{ 5, 17, 0, 3 }; 
        System.out.println(solutionMaxSlice(intArrayA));

        int[] intArrayB = new int[]{3, 2, 6, -1, 4, 5, -1, 2};
        System.out.println(solutionMaxSlice(intArrayB));

        int[] intArrayC = new int[]{5, 5, 5};
        System.out.println(solutionMaxSlice(intArrayC));

        int[] intArrayD = new int[]{5, 0, 1, 0, 5};
        System.out.println(solutionMaxSlice(intArrayD));

    }
}
