public class Zigma {
    public static void main(String[] args){
        int[] intArrayA = new int[]{ 1, 2, 3, 4, 5, 6 }; 
        // int[] intArrayB = new int[]{ 1, 1, 0, 0, 0 }; 
        // System.out.println(solution(intArrayA, intArrayB));
        System.out.println(solution(intArrayA));
        // System.out.println(solution(""));

    }

    public static int solution(int[] A) {

        int total = A.length * (A.length + 1)/2;
        return total;
    }


}
