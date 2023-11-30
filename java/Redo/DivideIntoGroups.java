package Redo;

import java.util.Arrays;

public class DivideIntoGroups {
    
    /*
     * 
     * Divide an array into three non-empty group. Each group should have smallest difference between the largest and smallest value
     * 
     */

    public static int solution(int[] A){

        int dv2 = 2;  // group3 include dv2->end
        int dv1 = 1; // group2 include dv1->(dv2-1)
        //group1 include 0->(dv1-1)

        int tmpDiff = Integer.MAX_VALUE;

        Arrays.sort(A);
        // if dv1 reach dv2 -> means we got the min diff
        // if dv2 reach end of array -> means maximum number is very big
        while(dv2 < A.length && dv1 < dv2){

            int diffG3 = A[A.length-1] - A[dv2];
            int diffG2 = A[dv2-1] - A[dv1];
            int diffG1 = A[dv1-1] - A[0];

            int maxDiff = Math.max(diffG3, diffG2);
            maxDiff = Math.max(maxDiff, diffG1);
            tmpDiff = Math.min(tmpDiff, maxDiff);

            if(diffG3 > diffG2){
                // diffG3 more > move dv2 closer
                dv2++;
            }else{
                //otherwise > move dv1 closer
                dv1++;
            }
        }


        return tmpDiff;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11, 5, 3, 12, 6, 8, 1, 7, 4};
        System.out.println(solution(arr));

        int[] arr2 = new int[]{10, 14, 12, 1000, 11, 15, 13, 1};
        System.out.println(solution(arr2));

        int[] arr3 = new int[]{4, 5, 7, 10, 10, 12, 12, 12};
        System.out.println(solution(arr3));

        int[] arr4 = new int[]{4, 5, 6};
        System.out.println(solution(arr4));

        int[] arr5 = new int[]{3, 4, 5, 6, 7, 8};
        System.out.println(solution(arr5));

        int[] arr6 = new int[]{3, 4, 5, 5, 5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5, 6, 7, 8};
        System.out.println(solution(arr6));
    }
}
