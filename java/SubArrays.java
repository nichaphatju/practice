import java.util.Scanner;

public class SubArrays {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] A = new int[t];
        for (int k = 0; k < t; k++) {
            A[k] = in.nextInt();
        }
        findNegativeSum(A);
    }
    
    public static void findNegativeSum(int[] A){
        
        int count = 0;
        
        for(int i=0; i< A.length; i++){
            
            int sum = A[i];
            if(sum < 0){
                count++;
            }
            int subArr = 1;
            while(i+subArr < A.length){
                sum += A[i+subArr];
                if(sum < 0){
                    count++;
                }
                subArr++;
            }
            
        }
        System.out.println(count);
    }
}
