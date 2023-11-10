public class FindFactors {
    
    public static int solution (int N){
        int count = 0;
        int maxVal = N;
        for(int i=1; i< maxVal; i++){
            if(N%i == 0){
                // System.out.println(i);
                count++;
                int f = N/i;
                if(f != i) count++;
                maxVal = f;
            }
        }
        return count;
    }

    public static int solutionBestPractice(int N) {
        int factors = 0;
        int squareRootN = (int) Math.sqrt(N);
        if(Math.pow(squareRootN, 2) != N) {
          squareRootN++; //round up for any non-perfect squares
        }
        else { //perfect squares have an additional factor
          factors++;
        }
        
        // Main prime numbers are 3, 5, 7, 9, 11, 19
        /** checking up to square root of N */
        /**
         * Square root of prime numbers are always irrational (cannot be written in the form n/d)
         */
        for(int i=1; i<squareRootN; i++) {
          if(N % i == 0) {
            factors += 2;
          }
        }
    
        return factors;
      }



    public static void main(String[] args) {
        System.out.println(solution(16));
        System.out.println(solution(2147483647));
        System.out.println(solutionBestPractice(2147483647));
        System.out.println(solution(2147483644));
    }

}
