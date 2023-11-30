package exercise;
public class ArrayInversionCount {

    public static int solution(int[] A){
        // Bad Performance
        // Implement your solution here
        int count = 0;
        for(int i=0; i< A.length-1; i++){

            for(int j=A.length-1; j > i; j--){
                if(A[j] < A[i]){
                    count++;
                    if(count == 1000000000){
                        return -1;
                    }
                }
            }

        }

        return count;
    }

    public static void main(String[] args) {
        
    }
}
