import java.util.*;

/*
 * List
 * Array
 * Map, Set
 * Sum
 * Sorted
 * Diffs
 * Stack
 * Search
 */


/**
 * Iterations - Find longest sequence of zeros in binary representation of an integer.
 * Arrays - Rotation of the array means that each element is shifted right by one index
 * Time Complexity - Frog Jump
 * Counting Elements - FrogRiverOne / Permutation check (A permutation is a sequence containing each element from 1 to N once, and only once. เลขในอาร์เรย์ไม่ซ้ำ)
 * Prefix Sums - Sum of arrays from 0-N - PassingCars
 * Sorting
 * Stacks and Queues
 * Leader - Element that appear more than half of array size -> Sort -> It should be in the middle / Or remove pair of different elements
 * Maximum slice problem - BallsInBuckets
 * Prime and composite numbers - CountFactors - MinDistinct
 * Sieve Eratosthenes
 * Euclidean algorithm
 * Fibonacci numbers
 * Binary Search
 * Caterpillar method - most frequently/two pointers
 * Greedy algorithm
 * Dynamic programming
 */

public class Solution {

        public static int solution(int[] A) {
        System.out.println(" ----->> Input : " + Arrays.toString(A));


        int[] arr = new int[A.length];

        List<Character> lst = new ArrayList<Character>();
        Map<Character, Character> mp = new HashMap<Character, Character>();

        Set<Integer> st = new HashSet<Integer>(1);

        Stack<Integer> stFishUp = new Stack<Integer>();

        for(int i=1; i< A.length; i++){
        }

        while(true){
            break;
        }

        // int i = (int) d.doubleValue();


        System.out.println(" ---- >> Output "+ 1);
        

        return 1;
    }

    public static String solution(String A) {
        System.out.println(" ---- >> Input "+ A);

        System.out.println(" ---- >> Output "+ 1);
        return "";
    }

    public static void main(String[] args){
        int[] intArrayA = new int[]{ 3, 4, 3, 2, 3, -1, 3, 3 }; 
        // int[] intArrayB = new int[]{ 1, 1, 0, 0, 0 }; 
        // System.out.println(solution(intArrayA, intArrayB));
        System.out.println(solution(intArrayA));
        // System.out.println(solution(""));

    }

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
}
