import java.util.HashSet;
import java.util.Set;

// Counting Element

public class FrogRiverOne {
    public int solution(int X, int[] A) {
        
        Set<Integer> jumped = new HashSet<Integer>();
        for(int i=0; i< A.length; i++){
            if(A[i] <= X){
                jumped.add(A[i]);
                if(jumped.size() == X){
                    return i;
                }
            }
        }
        return -1;

    }
}