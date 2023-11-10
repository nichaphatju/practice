public class StableVelocity {

    /**
     * 
     * @param A
     * @return Arithmetic Slices
     */

    public static int solution(int[] A){
        if(A.length < 3) return 0;
        int count = 0;

        for(int i=0; i<A.length-2; i++){
            int veloTmp = A[i+1] - A[i]; 

            for(int j=i+1; j<A.length-1; j++){
                int velo2 = A[j+1] - A[j];
                if(veloTmp == velo2){
                    count++;
                }else{
                    break;
                }
            }


        }

        return count;
    }

    public static int solution2(int[] A){
        if(A.length < 3) return 0;

        int count = 0;
        int tmpCount = 0;

        for(int i=2; i<A.length; i++){
            if(A[i-1] - A[i-2] == A[i] - A[i-1]){
                tmpCount++;
            }else{
                tmpCount = 0;
            }

            count += tmpCount;

        }

        return count;
    }

    public static void main(String[] args){
        int[] arrA = new int[]{-1, 1, 3, 3, 3 ,2 ,3 ,2 ,1, 0};
        System.out.println(solution2(arrA));


        int[] arrB = new int[]{-1, 1, 3, 3, 3 ,2 ,10 ,9 ,8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(solution2(arrB));
    }
}
