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

        /*** LIST, ARRAY, LOOP */
        int[] arr = new int[A.length];
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        List<Character> lst = new ArrayList<Character>();
        // Sorting
        Collections.sort(lst);

        /*
        *
        * This wont work with primitive arrays
        * Collections.reverse(Arrays.asList(yourArray));
        *
        */

        System.out.println(Arrays.toString(lst.toArray()));
        System.out.println(Arrays.deepToString(lst.toArray()));

        // Hashmap does not maintain insertion order
        Map<Character, Character> mp = new HashMap<Character, Character>();
        
        // Treemap is similar to a HashMap,
        // will iterate according to the "natural ordering" of the keys according to their compareTo() method
        // Slowest
        TreeMap<String, Integer> a2 = new TreeMap<>();

        // LinkedHashMap : Note that insertion order is not affected if a key is re-inserted into the map
        Map<String, Integer> lMap = new LinkedHashMap<>();

        // getOrDefault(Object key, V defaultValue)
        /****
         * TreeMap<String, Integer> a2 = new TreeMap<>();
            for(String s : a1)
            a2.put(s, a2.getOrDefault(s, 0) + 1);
         * mp.getOrDefault(key, 0);
         * a2.getOrDefault(key, 0);
         * 
         */
        
        
        Set<Integer> set = new HashSet<Integer>(1);
        /**
         * COPY NEW SET INSTEAD OF USING POINTER
         * Set<T> copy = new HashSet<>(original);
         * 
         *  Set<T> copy = new HashSet<>();
         *   copy.addAll(original)
         */

        Stack<Integer> stFishUp = new Stack<Integer>();
        Stack<Character> st = new Stack<Character>();

        for(int i=1; i< A.length; i++){
        }

        while(true){
            break;
        }

        /*** NUMBERS ***/
        String n = String.valueOf(3);
        if(Character.isDigit(n.charAt(0))){
            int dg = Character.getNumericValue(n.charAt(0));
        }
        // int i = (int) d.doubleValue();
        /*
            try {
                intValue = Integer.parseInt(string);
                
                Integer.valueOf()
                Double.parseDouble()
                Float.parseFloat()

                return true;
            } catch (NumberFormatException e) {
                System.out.println("Input String cannot be parsed to Integer.");
            }

        */

        System.out.println(" ---- >> Output "+ 1);
        

        return 1;
    }

    /** STRING */
    public static String stringFunction(String A) {
        System.out.println(" ---- >> Input "+ A);

        StringBuilder sb = new StringBuilder(A);
        sb.append("123");
        sb.deleteCharAt(1);
        String resultString = sb.toString();

        // String newStr = string.replace("*", "");



        System.out.println(" ---- >> Output "+ 1);
        return "";
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

        List<Integer> numbers = Arrays.asList(5, 3, 2, 4, 1, 10);
        numbers.sort(null);
        System.out.println(numbers);
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
