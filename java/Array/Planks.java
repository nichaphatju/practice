import java.util.HashSet;
import java.util.Set;

public class Planks {

    public static int solution(int[] A, int[] B, int[] C) {
        // Not Passed
        // Implement your solution 
        
        int count = 0;

        Set<Integer> planksUsed = new HashSet<Integer>();

        for(int i=0; i< C.length; i++){
            int nail = C[i];

            //System.out.println(nail);

            int start = 0;
            int end = A.length-1;

            count++;
            // search plank
            //System.out.println(start + " " + end);
            while(start <= end){
                if(nail >= A[start] && nail <= B[start]){                    
                    // can use this
                    planksUsed.add(A[start]);
                    if(start >= 1 && B[start-1] == nail){
                        planksUsed.add(A[start-1]);
                    }
                    if(start < A.length-1 && A[start+1] == nail){
                        planksUsed.add(A[start+1]);
                    }
                    start++;
                }else{
                    int mid = start + (int)Math.floor((end - start)/2);
                    // System.out.println(nail);
                    if(B[start] < nail){
                        // System.out.println("start");
                        start = mid+1;
                    }else if(B[start] > nail){
                        end = mid-1;
                        // System.out.println("end");
                    }else{
                        break;
                    }
                }
                
                // start++;

                // System.out.println(planksUsed);
                // System.out.println(count);

                if(planksUsed.size() == A.length){
                    return count;
                }
            }

            
        }

        return -1;

    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 4, 5, 8}, new int[]{4, 5, 9, 10} , new int[]{4, 6, 7, 10, 2}));
    }
}
