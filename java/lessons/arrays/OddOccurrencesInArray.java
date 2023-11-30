package lessons.arrays;
import java.util.Arrays;

public class OddOccurrencesInArray {
    
    public static int solution(int[] A) {
        // 80% correct
        // Implement your solution here

        if(A.length == 1){
            return A[0];
        }

        Arrays.sort(A);

        int tmpCount = 0;
        int tmpNum = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] != tmpNum){
                if(tmpCount == 1){
                    return tmpNum;
                }
                tmpCount = 1;
            }else{
                tmpCount++;
            }
            
            tmpNum = A[i];
        }

        return tmpNum;
    }

    public int solution3(int[] A) {
        // 100%
        // Implement your solution here
        Arrays.sort(A);
        for(int i = 0; i < A.length; i = i+2){
            if(i == A.length-1)
            return A[i];

            if (A[i]!=A[i+1])
            return A[i];
        }
        return 0;
    }

    // One of efficient solutions is to use XOR
    // Example, int unpaired = A[0]; // initial
    // unpaired = unpaired ^ A[i]; // xor  
    /*
     * Explaination: XOR(^) means exclusive or:
     *  0 ^ 0 = 0
     *  0 ^ 1 = 1
     *  1 ^ 0 = 1
     *  1 ^ 1 = 0
     * Basically if two inputs are the same -> it'll return 0 
     * any value ^0 = 0
     * If it's different, it'll return the different value
     * 
     */

    public int solution2(int[] A) {
        // write your code in Java SE 8
        
        // Using the concept of "XOR" (^)
        // when there is a pair A and B 
        // A^B will be zero 
        // A^B^C (where C is not paired), 
        // then A^B^C = C
        
        // special case
        if(A.length == 0)
            return 0;
        
        int unpaired;
        unpaired = A[0]; // initial
        
        for(int i=1; i< A.length; i++){    
            unpaired = unpaired ^ A[i]; // xor    
        }
        
        return unpaired; // return the unpaired value
    }

    public static void main(String[] args) {
        
    }
}
