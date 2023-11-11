import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
    public int solution(int[] A){
        Set<Integer> Aset = new HashSet<Integer>();
        for(int i=0; i<A.length; i++){
            Aset.add(A[i]);
        }
        int missingVal = A[A.length-1]+1;
        if(A.length == 0){
            missingVal = 1;
        }
        for(int i=1; i<=A.length; i++){
            if(!Aset.contains(i)){
                missingVal = i;
                break;
            }
        }
        return missingVal;
    }

    public static void main(String[] args){
        int[] intArrayA = new int[]{ 3, 4, 3, 2, 3, -1, 3, 3 }; 
        // int[] intArrayB = new int[]{ 1, 1, 0, 0, 0 }; 
        // System.out.println(solution(intArrayA, intArrayB));
        // System.out.println(solution(intArrayA));
        // System.out.println(solution(""));

    }
    
}
