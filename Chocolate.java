import java.util.HashSet;
import java.util.Set;

public class Chocolate {

    public static void main(String[] args){
        // int[] intArrayA = new int[]{ 4, 3, 2, 1, 5 }; 
        // int[] intArrayB = new int[]{ 1, 1, 0, 0, 0 }; 
        // Modulo **** 10%6 = 4 -> 6x1 = 6 -> 10-6 = 4
        // Modulo **** 6%10 = 6 -> 10 > 6
        // System.out.println(solution(10, 4));
        System.out.println(solutionRevise(10, 4));
        // System.out.println(solution(""));
    }

    public static int solution(int N, int M) {
        // Bad performance
        Set<Integer> set = new HashSet<>();
        
        int X =0;
        int numChocolate = 0;   // eat the 1st one
        
        while(!set.contains(X)){
            
            if(set.isEmpty()){
                set.add(0);
            } else{
                 // eat one more chocolate
                set.add(X); // record its number
            }
            int xm = X + M;
            System.out.println(" X + M " +xm);
            System.out.println(" %N " +xm%N);
            X = (X + M) % N;

            System.out.println(X);
            numChocolate++;
        }
        
        return numChocolate;
    }





    public static int solutionRevise(int N, int M) {
        //  Good performance

        // main idea: 
        // using "gcd(M, N)"
        // the number of eaten chocolates = N / gcd(M,N)
        return N/(gcd(N,M));
    }

    // using "Euclidean Algorithm" (important)
    public static int gcd(int a,int b){
        System.out.println(" a " +a);
        System.out.println(" b " +b);
        if(a % b == 0)
            return b;            // case 1
        else
            return gcd(b,a % b); // case 2 (key point)
    }
}
