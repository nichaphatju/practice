import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListSize {
    
    public static int solution(int[] A){

        if(A[0] == -1) return 0;

        /** First node is not (-1) -> point to next element's index, so count 1 */
        int listSize = 1;

        List<Integer> tmpListTest = new ArrayList<Integer>();
        tmpListTest.add(A[0]);

        listSize = next(0, A, listSize, tmpListTest);

        System.out.println(String.valueOf(tmpListTest));

        return listSize;

    }

    public static int next(int index, int[] A, int listSize, List<Integer> tmpListTest){
        if(A[index] == -1) return listSize;

        /** Next element's index get from current element (Linkedlist)*/
        index = A[index];

        /** For testing only */
        tmpListTest.add(A[index]);

        listSize++;
        return next(index, A, listSize, tmpListTest);
    }


    public static void main(String[] args) {
        int[] arrA = new int[]{1, 4, -1,  3, 2};    // [1,4,2,-1]
        System.out.println(solution(arrA));

        int[] arrB = new int[]{4, -1, 3, 2, 1};     // [4, 1, -1]
        System.out.println(solution(arrB));

        // int[] arrC = new int[]{4, 0, 3, -1, 1};
        // System.out.println(solution(arrC));
    }
}
