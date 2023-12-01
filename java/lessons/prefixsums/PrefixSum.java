package lessons.prefixsums;

import java.util.Arrays;

public class PrefixSum {
    
    public static void main(String[] args) {
        int[] mushrooms = new int[]{2,3,7,5,1,3,9};
        int k = 4; // start position   
        int m = 6; // maximum moves

        int[] ps = prefix_sum(mushrooms);

        // Mushroom picker finds the best way to pick most mushrooms using prefix sum strategy
        int n = mushrooms.length;
        int result = 0;

        int maxMoveLeft = Math.min(m, k);

        for(int p =0; p <= maxMoveLeft; p++){
            // try moving left from 0 step to max steps
            int leftPos = k-p;     // left position after make p moves from current position to the left
            
            // after moved to left p steps -> we need to move back to right, 
            // it'll take another p steps to return to the first position from p so it become (2*p)
            // so max moves (m) must be minus with 2*p ( all steps taken )
            // right position will be k - left moves or k (dont move to the right in case max left move is more than max right)

            int rightPos = Math.min(n-1, Math.max(k, k+(m-(2*p))));   // right position after make  moves from current position to the right or until the end
            result = Math.max(result, count_total(ps, leftPos, rightPos));
        }

        int maxMoveRight = Math.min(m, n-k-1);  // move til the end or max moves

        for(int p =0; p <= maxMoveRight; p++){
            // try moving right from 0 step to max steps
            int rightPos = k+p;                          // right position after make p moves from current position to the right
            int leftPos = Math.max(0, Math.min(k, k- (m -2 *p)));   // left position after made right moves from current position to the left or until the start
            result = Math.max(result, count_total(ps, leftPos, rightPos));
        }

        System.out.println(result);

    }

    public static int count_total(int[] ps,int left,int right){

        // [2,3,7,5,1,3,9]
        // ps = [0,2,5,12,17,18,21,30]
        // ex. from pos 2 to 5 = ps[6] - ps[2]
        return ps[right+1] - ps[left];
    }

    public static int[] prefix_sum(int[] A){
        int n = A.length;

        // prefix sum arrays will have 1 more element:
        // the first element represent prefix sum of A[0]
        // the last element represent prefix sum of A[length-1]
        int[] p = new int[n+1];

        System.out.println(p);

        // loop over A from index 1 to A.length (1 over to get i-1) prefix
        for(int i=1; i<= A.length; i++){
            p[i] = p[i-1] + A[i-1];
        }

        // Prefix sum
        System.out.println(Arrays.toString(p));

        return p;
    }

}
