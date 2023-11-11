import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BestShuffle {
    
    public static int solution(int A, int B, int C, int D){
        int sum = 0;
        // Integer[] arr = new Integer[]{A, B, C, D};
        // Arrays.sort(arr, Collections.reverseOrder());
        final int[] arr = new int[]{A, B, C, D};

        /**
         * Shuffle
         * A, B, C, D
         * A, B, D, C
         * A, C, B, D
         * A, C, D, B
         * A, D, B, C
         * A, D, C, B
         * *4 = 24 PATTERNS 
         */

        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int[] generatedPermuted = arr.clone();

        sum = permute(maxSum, n, arr, generatedPermuted);
        return sum;
    }

    public static void possibleCombine(int[] A){
        System.out.println(Arrays.toString(A));

        int id=0;
        for(int i=0; i <= 24; i++){
            int[] arrPermute = swap(A, id, A.length);
            System.out.println(Arrays.toString(arrPermute));
            id++;
            if(id >= 4) id = 0;
        }

    }

    public static int[] swap(int[] arr, int i, int n){

        int tmp = arr[i];
        arr[i] = arr[n-1];
        arr[n-1] = tmp;
        return arr;

    }

    public static int permute(int maxSum, int n, int[] arr, int[] generatedPermuted){
        System.out.println(n);
        if(n == 1){
            // System.out.println(Arrays.toString(arr));
            // generatedPermuted = arr;
            System.out.println(" arr " +Arrays.toString(generatedPermuted));
            return maxSum;
        }else{
            /** RecursiveHeapsAlgorithm */
            for(int i=0; i< arr.length; i++){
                if(n%2 == 0){
                    // In this question will only match this - n=4 
                    swap(arr, generatedPermuted, i, n-1);
                }else{
                    swap(arr, generatedPermuted, 0, n-1);
                }
                System.out.println(" arr ->" + Arrays.toString(arr));
                System.out.println(" generatedPermuted ->" + Arrays.toString(generatedPermuted));
                /*** Check each permutations */
                if(Math.abs(generatedPermuted[0] - generatedPermuted[1]) + Math.abs(generatedPermuted[1] - generatedPermuted[2]) + Math.abs(generatedPermuted[2] - generatedPermuted[3]) > maxSum){
                    maxSum = Math.abs(generatedPermuted[0] - generatedPermuted[1]) + Math.abs(generatedPermuted[1] - generatedPermuted[2]) + Math.abs(generatedPermuted[2] - generatedPermuted[3]);
                    generatedPermuted = arr;
                }
            }
            return permute(maxSum, n-1, arr, generatedPermuted);
        }
    }

    public static void swap(int[] arr, int[] arrTmp, int a, int b){
        int tmp = arr[a];
        int tmpB = arr[b];
        // arr[a] = arr[b];
        // arr[b] = tmp;
        arrTmp[a] = tmpB;
        arrTmp[b] = tmp;
    }

    public static void main(String[] args) {
        // System.out.println(solution(5, 3, -1, 5));
        // System.out.println(solution(1, 2, 3, 4));

        possibleCombine(new int[]{1,2,3,4});
    }

}
