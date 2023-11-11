import java.util.HashSet;
import java.util.Set;

// Counting Element
// find the earliest time when the frog can jump to the other side of the river (jumping from -1 to X+1)

public class FrogRiverOne {
    public int solution(int X, int[] A) {
        
        /** Store the position that has a leaf */
        Set<Integer> canJump = new HashSet<Integer>();
        
        for(int i=0; i< A.length; i++){
            if(A[i] <= X){
                canJump.add(A[i]);
                if(canJump.size() == X){
                    return i;
                }
            }
        }
        return -1;

    }
}