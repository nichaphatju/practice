package lessons.greedy;
public class MaxNonOverlapSegments {
    
    public static int solution(int[] A, int[] B) {
        // Implement your solution here
        int count = 0;
        int currentPosition = -1;

        for(int i=0; i<A.length; i++){
            if(A[i] > currentPosition){
                count++;
                currentPosition = B[i]; //  set position to end of current segment
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,3,7,9,9}, new int[]{5,6,8,9,10}));
    }

}
