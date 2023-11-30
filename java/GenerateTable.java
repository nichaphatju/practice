public class GenerateTable {
    
    public static String solution(int[] A, int K){

        StringBuilder sb = new StringBuilder();

        for(int i=0; i< A.length; i++){
            String numStr = String.valueOf(A[i]);
            System.out.println(numStr.length());
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{155}, 0));
    }
}
