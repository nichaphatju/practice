import java.util.Arrays;

public class DivideIntoGroups {

    public static int solution(int[] A) {
        Arrays.sort(A);

        int lowerBound = 0;
        int upperBound = A[A.length-1] - A[0];  // max diff whole array
        int result = upperBound;

        while(lowerBound <= upperBound){
            System.out.println("lowerBound "+ lowerBound);
            System.out.println("upperBound "+ upperBound);
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
        System.out.println("MAXDIFF "+ maxDiff);
        int count=1;
        int min = A[0];
        int max = A[0];

        for(int i=1; i< A.length; i++){
            System.out.println(A[i]);
            
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
            System.out.println("min "+ min + "  max "+ max);
            
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

    

    public static void main(String[] args){
        int[] arr = new int[]{11, 5, 3, 12, 6, 8, 1, 7, 4};
        //System.out.println(solution(arr));

        int[] arr2 = new int[]{10, 14, 12, 1000, 11, 15, 13, 1};
        //System.out.println(solution(arr2));

        int[] arr3 = new int[]{4, 5, 7, 10, 10, 12, 12, 12};
        System.out.println(solution(arr3));
    }
}
