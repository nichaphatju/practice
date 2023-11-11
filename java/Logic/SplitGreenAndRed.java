public class SplitGreenAndRed {
    
    public static int solution(int X, int[] A){

        int countX = 0;
        int[] countXArr = new int[A.length];
        for(int i=0; i<A.length; i++){
            if(A[i] == X){
                countX++;
            }
            countXArr[i] = countX;
        }

        if(countX == 0) return A.length;
        int countOtherNum = A.length - countX;
        
        for(int i=1; i<A.length; i++){
            int otherNum = i - countXArr[i-1];
            int otherNum2ndPart = countOtherNum - otherNum; 
            if(countXArr[i-1] > 0 && countXArr[i-1] == otherNum2ndPart){
                return i;
            }
        }
    
        return A.length;

    }

    public static void main(String[] args){
        int[] arrA = new int[]{5, 5, 1, 7, 2, 3, 5};
        System.out.println(solution(5, arrA));

        int[] arrB = new int[]{6, 5, 4, 3, 2, 1};
        System.out.println(solution(7, arrB));

        int[] arrC = new int[]{6, 5, 4, 3, 2, 1};
        System.out.println(solution(5, arrC));
    }
}
