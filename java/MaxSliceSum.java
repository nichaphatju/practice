public class MaxSliceSum {

    public static int lesson(int[] A) {
        int maxEnd = 0;
        int maxSlice = 0;

        for(int i=0; i< A.length; i++){
            // maxEnd = SUM of slice til now
            maxEnd = Math.max(0, maxEnd + A[i]);    // maximum slice ending in position i
            System.out.println("maxEnd " +maxEnd);

            maxSlice = Math.max(maxSlice, maxEnd);      // max slice compare with previous slice
            System.out.println(" maxSlice "+maxSlice);

        }

        return maxSlice;
    }

    public static int solution(int[] A) {
        // Implement your solution here
        int tmpMax = A[0];
        int maxSlice = A[0];
        for(int i=1; i< A.length; i++){
            tmpMax = Math.max(A[i], tmpMax + A[i]);
            maxSlice = Math.max(tmpMax, maxSlice);
        }
        return maxSlice;
    }

    public static void main(String[] args){
        int[] intArrayA = new int[]{ 3, 2, -6, 4, 0 }; 
        System.out.println(solution(intArrayA));

        int[] intArrayB = new int[]{ -2, 1 }; 
        System.out.println(solution(intArrayB));
    }

}
