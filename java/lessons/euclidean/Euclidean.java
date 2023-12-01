package lessons.euclidean;

public class Euclidean {
    
    /*
     * Concept: To find the greatest common divisor of 2 integers via Euclidean
     * divide A by B
     * then if there's no fraction -> got the answer
     * if there's fraction -> divide the previous dominator with the fraction -> keep doing until no fraction
     * 
     */

    public static void main(String[] args) {
        // gcd - Great common divisor of 2 positive integers
        int A = 17;
        int B = 16;

        // result of modulo is the fraction,numerator
        // 5%20 = 5
        // 20%5 = 0

        int gcd = gcd(A, B);

        System.out.println(gcd);
    }

    public static int gcd(int A, int B){
        if(A%B == 0){
            // if A divisible by B -> B is the greatest common divisor
            return B;
        }else{
            // else if there's fraction -> เอาตัวหารไปหารด้วยเศษต่อตามวิธีของ euclidean
            System.out.println(A%B);
            return gcd(B, A%B);
        }
    }
}
