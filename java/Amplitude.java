import java.util.Arrays;

public class Amplitude {
    public static int solution(int[] A){
        Arrays.sort(A);
        int amplitude = A[A.length-1] - A[0];
        return amplitude;
    }

    public static void main(String[] args){
        int[] arrA = new int[]{10, 2, 44, 15, 39, 20};
        System.out.println(solution(arrA));
    }
}
