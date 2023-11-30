package lessons.primeandcompositenumbers;
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

// **** Perimeter of rectangle = 2*(W+L)
// เส้นรอบรูป

class MinPerimeter {
    public int solution(int N) {
        // Implement your solution here
        int sqrtN = (int) Math.sqrt(N);
        Map<Integer, Integer> mapAB = new HashMap<Integer, Integer>();
        for(int i=1; i<=sqrtN ; i++){
            if(N%i == 0){
                mapAB.put(i, N/i);
            }
        }
        int leastPerimeter = (N*2) + 2;
        for(Integer A: mapAB.keySet()){
            int perimeter = 2 * (A + mapAB.get(A));
            leastPerimeter = Math.min(perimeter, leastPerimeter);
        }

        return leastPerimeter;
    }

    public static void main(String[] args){
        int[] intArrayA = new int[]{ 3, 4, 3, 2, 3, -1, 3, 3 }; 
        // int[] intArrayB = new int[]{ 1, 1, 0, 0, 0 }; 
        // System.out.println(solution(intArrayA, intArrayB));
        // System.out.println(solution(intArrayA));
        // System.out.println(solution(""));

    }
}