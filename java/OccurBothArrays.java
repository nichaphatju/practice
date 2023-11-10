import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class OccurBothArrays {
    public static int solution(int[] A, int[] B){

        int num  = -1;

        Set<Integer> setA = new HashSet<>();

        for(int i=0; i<A.length;i++){
            setA.add(A[i]);
        }

        for(int i=0; i<B.length; i++){
            if(setA.contains(B[i])){
                num = num != -1 ? Math.min(num, B[i]) : B[i];
            }
        }

        return num;

    }

    public static void main(String[] args){
        int[] arrA = new int[]{1, 3, 2, 1};
        int[] arrB = new int[]{4, 2, 5, 3, 2, 4, 2, 5, 3, 2, 4, 2, 5, 3, 2, 4, 2, 5, 3, 2, 4, 2, 5, 3, 2, 4, 2, 5, 3, 2, 4, 2, 5, 3, 2, 4, 2, 5, 3, 2};

        // generate 100 random number between 0 to 100 
        int[]  randomIntsArray = IntStream.generate(() -> new Random().nextInt(100)).limit(1000).toArray();
        //generate 100 random number between 5 to 200
        int[]  randomIntsArray2 = IntStream.generate(() -> new Random().nextInt(100)+5).limit(1000).toArray();

        System.out.println(randomIntsArray.length);
        System.out.println(randomIntsArray2.length);
        System.out.println(solution(randomIntsArray, randomIntsArray2));
    }

}

