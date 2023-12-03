package exercise;

public class SumDigits {
    
    public static void main(String[] args) {
        int N = 12;
        int i = 1;
        int ans = N;
        while(true){
            if(check(i) == N){
                ans = i;
                break;
            }
            i++;
        }

        System.out.println(ans);
    }

    public static int check(int n){
        int sum = 0;
        while(n != 0){
            sum = sum + n%10;       // n%10 => result is the right most digit of n (fraction after divide by 10) -> count next digit from right to left adding to sum
            n = n/10;               // int -> so decimal will be removed - n will be remain digits except right most digit
            System.out.println("n " + n + " SUM " + sum);
        }

        /*
         * Example: if n = 1234
         * n 123 SUM 4
         * n 12 SUM 7
         * n 1 SUM 9
         * n 0 SUM 10
         * Result = 10
         * 
         */

        return sum;
    }

}
