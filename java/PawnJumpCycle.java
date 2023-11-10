import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PawnJumpCycle {
    

    /** Haven't tested */
    public static int solution(int[] A){
        int countCycle = 0;
        Stack<Integer> st = new Stack<Integer>();

        return jump(0, A, st, countCycle);
    }

    public static int jump(int ind, int[] A, Stack<Integer> steps, int count){
        if(steps.contains(A[ind])){
            while(steps.peek() != A[ind]){
                count++;
                steps.pop();
            }
            return count+1;
        }

        steps.add(A[ind]);
        return jump(A[ind], A, steps, count);

    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,3,1,1,3}));
        // System.out.println(solution(new int[]{2,3,1,1,3}));
    }
}
