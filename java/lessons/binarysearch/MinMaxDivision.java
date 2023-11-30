package lessons.binarysearch;
public class MinMaxDivision {

    /*
     * 
     * Find minimum value of sum of K groups
     * Every element of an array is not greater than M
     * try to have min of max sum of each group
     * 
     */

    public static int solution(int K, int M, int[] A) {

        // Use Binary search
        
        int minSum =0;      // minSum - possible minimum sum of the group (contain only 1 val) - the biggest val
        int maxSum =0;       // maxSum - sum of all elements in the group
        for(int i=0; i<A.length; i++){
            maxSum = maxSum + A[i];          
            minSum = Math.max(minSum, A[i]);
        }
        
        int possibleResult = maxSum; // set default to max sum, then search for the less ones
        
        while(minSum <= maxSum){
            // Binary Search concept - use mid as an indicator - in this case mid = average
            int midSum = (minSum + maxSum) /2;
            System.out.println(midSum);
            
            // check if it can be divided by using 
            // the minMaxSum = "mid", into K blocks ?
            boolean ok = checkDivisable(midSum, K, A);
            System.out.println(ok);
            
            // if "ok", means that we can try "smaller"
            // otherwise ("not ok"), we have to try "bigger"
            if(ok == true){
                possibleResult = midSum; // mid is "ok"
                // we can try "smaller"
                maxSum = midSum - 1; 
            }
            else{ // "not ok"
            // we have to try "bigger"
                minSum = midSum + 1;
            }
            // go back to "binary search" until "min > max"
        }
        
        return possibleResult;
    }
    
    // check if it can be divided by using the minMaxSum = "mid", into K blocks ?
    public static boolean checkDivisable(int mid, int k, int[] a){
        // try this sum (mid)
        // try to make k groups
        int numBlockAllowed = k;
        int currentBlockSum = 0;
        
        for(int i=0; i< a.length; i++){
            currentBlockSum = currentBlockSum + a[i];
            
            if(currentBlockSum > mid){ // reach expected sum -> count as a group (without a[i])
                numBlockAllowed--;
                currentBlockSum = a[i]; // reset sum -> next block
            }
            
            if(numBlockAllowed == 0){
                return false; // cannot achieve minMaxSum = "mid"
            }
        }
        
        // this sum is possible
        return true;   
    }

    public static void main(String[] args) {
        System.out.println(solution(3,5,new int[]{2,1,5,1,2,2,2}));
    }
}
