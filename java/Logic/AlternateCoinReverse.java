public class AlternateCoinReverse {

    /**
     * 
     * @param A
     * @return min times to flip coins to have all same side
     */
    public static int solution(int[] A){

        int coinFlip0 = 0;  /** Flip to start with 0 */
        int coinFlip1 = 0; /** Flip to start with 1 */

        for(int i=0; i< A.length; i++){
            if( i%2 == 0){
                // at even index
                if(A[i] == 1){
                    /** Try Flip to start with 0 -> expect 0, so count */
                    coinFlip0 += 1;
                }
                if(A[i] == 0){
                    /** Try Flip to start with 1 -> expect 1, so count */
                    coinFlip1 += 1;
                }
            }else{
                // at odd index
                if(A[i] == 0){
                    /** Try Flip to start with 0 -> Expect 1, so count */
                    coinFlip0 += 1;
                }
                if(A[i] == 1){
                    /** Try Flip to start with 1 -> Expect 0, so count */
                    coinFlip1 += 1;
                }
            }
            
        }

        return Math.min(coinFlip0, coinFlip1);
    }

    public static void main(String[] args){
        int[] arrA = new int[]{1, 0, 1, 0, 1, 1};
        System.out.println(solution(arrA));

        int[] arrB = new int[]{1, 1, 0, 1, 1};
        System.out.println(solution(arrB));

        int[] arrC = new int[]{0, 1, 0};
        System.out.println(solution(arrC));

        int[] arrD = new int[]{0, 1, 1, 0};
        System.out.println(solution(arrD));
    }
}
