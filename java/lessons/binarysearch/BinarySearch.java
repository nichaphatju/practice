package lessons.binarysearch;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] A = new int[]{0, 1, 1, 0, 1, 0, 1};   //1 is a hole in the roof
        int k = 5;  // number of boards
        int n = A.length;
        int beg = 1;
        int end = n;
        int result = -1;

        // Arrays.sort(A);
        // choose the size of the boards that allows all the holes to be covered
        while (beg <= n) {
            int mid = (beg+end)/2;      // try side half of the roof size first -> then increase/reduce
            if(check(A, mid) <= k){     // if board used less than or equal number of board, we might be able to use this size
                end = mid-1;            // try with smaller size
                result = mid;
            }else{
                // if we have to use more board than what we have to cover the holes -> we need to try add board size
                beg = mid+1;
            }
            
        }

        System.out.println(result);
    }

    public static int check(int[] A, int size){
        int boardsUsed = 0;
        int last = -1;
        for(int i=0; i<A.length; i++){
            // check the roof -> if it's a hole (1) and current position is not covered by the previous board; count the board used
            // if it's not a hole or it's covered by the previous board (last>=i) -> dont count
            if(A[i] == 1 && last < i){
                boardsUsed++;
                last = i + size -1;
            }
        }
        return boardsUsed;
    }


    public static void binarySearch(int[] A, int x){
        int n = A.length;
        int beg = 0;
        int end = n-1;
        int result = -1;

        // A need to be sorted

        while(beg <= end){
            int mid = (beg+end)/2;
            if(A[mid] <= x){
                beg = mid +1;
                result = mid;
            }else{
                end = mid-1;
            }
        }
        System.out.println(result);
    }
    
}
