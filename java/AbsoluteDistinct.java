import java.util.HashSet;
import java.util.Set;

public class AbsoluteDistinct {
    public static int solution(int[] A) {

        Set<Integer> distinctAbs = new HashSet<Integer>();
        for(int i=0, j= A.length-1; i <= j; i++, j--){
            distinctAbs.add(Math.abs(A[i]));
            distinctAbs.add(Math.abs(A[j]));

        }

        return distinctAbs.size();

    }

    public static void main(String[] args){
        int[] arrA = new int[]{-5, -3, -1, 0, 3, 6};
        System.out.println(solution(arrA));
    }
}
