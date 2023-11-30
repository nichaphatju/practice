package lessons.primeandcompositenumbers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountFactors {

    // main idea:
    // check from 1 to "sqrt_of_N"      // max factors of number N wont be greater than sqrt N because sqrtN*sqrtN = N
    // then, taking its pair into consideration
    // ---> numFactor = numFactor * 2;
        
    // int sqrtN = (int) Math.sqrt(N); 
    // int numFactor =0; // number of factors
        

    public static int solution(int N) {
        // Implement your solution here
        int D = 1;
        Set<Integer> factors = new HashSet<Integer>();
        // If prime number and we use N/2, this will run til the end (N/2)
        // run to sqrt instead (Max num that can divide N because sqrtN*sqrtN = N) for better performance
        int sqrtN = (int) Math.sqrt(N); 
        while(D <= sqrtN){
            if(N%D == 0){
                int M = N/D;
                if(!factors.contains(M)){
                    factors.add(D);
                    factors.add(M);
                }else{
                    break;
                }
            }
            D++;
        }

        return factors.size();
    }

    public static void main(String[] args){
        // int[] intArrayA = new int[]{ 3, 4, 3, 2, 3, -1, 3, 3 }; 
        // int[] intArrayB = new int[]{ 1, 1, 0, 0, 0 }; 
        // System.out.println(solution(intArrayA, intArrayB));
        System.out.println(solution(8));
        System.out.println(solution(1));
        // System.out.println(solution(""));

    }
}
