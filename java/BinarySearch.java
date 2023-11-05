import java.util.Arrays;

// binary search

public class BinarySearch {

    public static int binSearch(int start, int end, int[] A, int searchVal){
        
        // System.out.println(" ---- >> Input "+ Arrays.toString(A));
        // System.out.println(" ---- >> Input "+ start);
        // System.out.println(" ---- >> Input "+ end);

        if(start < end){
            int mid = (int) Math.floor((end-start)/2) + start;
            Boolean nextSearch1stHalf = A[mid] > searchVal; // current val (mid) > search val => search left
            Boolean nextSearch2ndHalf = A[mid] < searchVal; // current val (mid) < search val => search right
            if(nextSearch1stHalf){
                return binSearch(start, mid, A, searchVal);
            }else if(nextSearch2ndHalf){
                return binSearch(mid, end, A, searchVal);
            }else{
                // In case search specific number
                return mid;
            }
        }

        return start;
    }

    public static void main(String[] args){
        // Array has to be sorted
        int[] inputA = new int[]{1, 2, 3, 4, 5};
        int[] inputB = new int[]{1, 2, 3, 4 , 5 ,6};

        System.out.println(" ---- >> Output "+ binSearch(0, inputA.length-1, inputA, 1));
        System.out.println(" ---- >> Output "+ binSearch(0, inputB.length-1, inputB, 1));
    }
}
