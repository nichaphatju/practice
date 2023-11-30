package lessons.timecomplexity;
public class TapeEquilibrium {
    public static int solution(int[] A) {
        // Implement your solution here
        int sum = 0;
        for(int i=0; i<A.length; i++){
            sum += A[i];
        }

        System.out.println(sum);
        int currentVal = 0;
        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i<A.length-1; i++){
            currentVal += A[i];
            int rightVal = sum - currentVal;
            //System.out.println(rightVal);
            int diff = Math.abs(rightVal - currentVal);
            System.out.println(diff);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    public static void main(String[] args){
        int[] intArrayA = new int[]{ -1000, 1000 }; 
        // int[] intArrayB = new int[]{ 1, 1, 0, 0, 0 }; 
        System.out.println(solution(intArrayA));
        // System.out.println(solution(""));
        // System.out.println(solution(""));


    }

}
