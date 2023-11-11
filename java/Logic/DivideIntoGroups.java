import java.util.Arrays;

public class DivideIntoGroups {

    /**
     * 
     * @param A
     * @return
     * 
     * Divide numbers into 3 groups and return least of max different value between max and min number within the same group
     * 
     */
    public static int solution(int[] A) {
        Arrays.sort(A);

        int lowerBound = 0;         // low diff value
        int upperBound = A[A.length-1] - A[0];  // max diff value - from max value - min value of the given array
        int result = upperBound;    // set default result to max possible diff

        while(lowerBound <= upperBound){
           // System.out.println("lowerBound "+ lowerBound);
           // System.out.println("upperBound "+ upperBound);
            int middle = (lowerBound + upperBound) /2;  // average max diff
            if(isFeasible(A, middle)){  // try
                result = middle;
                upperBound = middle -1; // try less diff val
            }else{
                lowerBound = middle +1; // If not possible, try bigger diff value
            }
        }
        return result;
    }

    public static boolean isFeasible(int[] A, int maxDiff){
        //System.out.println("MAXDIFF "+ maxDiff);
        int count=1;
        int min = A[0];
        int max = A[0];

        for(int i=1; i< A.length; i++){
           // System.out.println(A[i]);
            
            // only max will move
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
            //System.out.println("min "+ min + "  max "+ max);
            
            // separate group when diff more than max average diff
            if(max-min > maxDiff){
                count++;
                min = A[i];     // change min (new group)
                max = A[i];     // change max (new group)
            }
        }
        // return If got 3 groups
        return count <=3;
    }

    // Caterpillar method
    // Not tested
    public static int solutionAttempt(int[] A){
        Arrays.sort(A);
        int minVal = A[0];
        int diff = A[A.length-1] - minVal;
        int tmpDiff = 0;

        int sp1 = 1;
        int sp2 = 2;
        while(sp2 < A.length){
           // System.out.println(minVal + " : " + A[sp1] + " : "+ A[sp2]);
            int diff2 = A[A.length-1] - A[sp2];
            int diff1 = sp2-1 == sp1 ? 0: A[sp2-1] - A[sp1];
            int diff0 = sp1-1 == 0 ? 0: A[sp1-1] - minVal;
            //System.out.println(diff0 + " : "+ diff1 + " : " + diff2);
            tmpDiff = Math.max(diff2, diff1);
            tmpDiff = Math.max(diff0, tmpDiff);
            diff = Math.min(tmpDiff, diff);
            if(diff2 >= diff1){
                sp2++;
            }else{
                sp1++;
            }
        
        }

        return diff;
    }

    public static void main(String[] args){
        int[] arr = new int[]{11, 5, 3, 12, 6, 8, 1, 7, 4};
        System.out.println(solution(arr));
        System.out.println(solutionAttempt(arr));

        int[] arr2 = new int[]{10, 14, 12, 1000, 11, 15, 13, 1};
        System.out.println(solution(arr2));
        System.out.println(solutionAttempt(arr2));

        int[] arr3 = new int[]{4, 5, 7, 10, 10, 12, 12, 12};
        System.out.println(solution(arr3));
        System.out.println(solutionAttempt(arr3));
    }
}
