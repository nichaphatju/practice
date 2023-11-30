package lessons.caterpillar;
import java.util.HashSet;
import java.util.Set;

public class CountDistinctSlices {

    public int solution(int M, int[] A) {
        // Implement your solution here
        // Failed performance
        int count = 0;
        for(int i=0; i<A.length; i++){
            
            int head = i;
            Set<Integer> distinct = new HashSet<Integer>();
            while(head < A.length && !distinct.contains(A[head])){
                distinct.add(A[head]);
                count++;
                head++;

                if(count >= 1_000_000_000){
                    return 1_000_000_000;
                }
            }
        }

        return count;
    }

    public static int solution2(int M, int[] A) {
        // Implement your solution here
        int count = 0;
        Set<Integer> distinct = new HashSet<Integer>();
        int head = 0; // important, we keep head at the same place when we move tail

        for(int i=0; i<A.length; i++){
            
            while(head < A.length && !distinct.contains(A[head])){
                distinct.add(A[head]);
                head++;
            }

            // important, we count the size of current stored slice so far
            // because number of slices = number of unique integer
            // ex, 3,4,5 can be split into 3 slices (start from first index only)
            // -> 3, 3-4, 3-4-5 => that's whay we can add number of distinct to the count
            count += distinct.size();

            if(count >= 1_000_000_000){
                return 1_000_000_000;
            }

            // when moving tail, we remove it from the stored slice as well
            distinct.remove(A[i]);
        }

        return count;
    }

    public static void main(String[] args) {
        
    }
}
