import java.util.HashSet;
import java.util.Set;

public class DistinctSlice {
    
    public static int solution(int M, int[] A){

        /** Bad Performance */
        int count = 0;
        for(int i=0; i<A.length; i++){
            Set<Integer> slice = new HashSet<Integer>();
            for(int j=i; j< A.length; j++){
                if(!slice.contains(A[j])){
                    count++;
                    slice.add(A[j]);
                }else if(slice.contains(A[j])){
                    break;
                }
            }

        }

        return count;
    }

    /** Caterpillar algorithm
     * Concept: Front & Back indicator [Head * Tail of a caterpillar moving towards right side of an array]
     * This method -> i = Back, front = Front
     * Moving forward (back++) when found the duplicate number at the front
     */
    public static int solutionCaterpillar(int M, int[] A){

        int count = 0;
        Set<Integer> cat = new HashSet<>();
        int front = 0;
        for(int i=0; i<A.length; i++){
            System.out.println(String.valueOf(" >>> " +A[i]));

            while (front < A.length && !cat.contains(A[front])) {
                cat.add(A[front]);
                front++;
                System.out.println(String.valueOf(" >> " +cat));
            }
            
            count += cat.size();
            if(count >= 1000000000){
                return 1000000000;
            }
            cat.remove(A[i]);
            System.out.println(String.valueOf(cat));
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(solutionCaterpillar(6, new int[]{3,4,5,5,2}));
    }
}
