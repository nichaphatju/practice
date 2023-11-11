import java.util.Arrays;

public class TripletTriangle {

    public static int solution(int[] A){

        // Caterpillar
        /**
         * 0 <= P<Q<R<N 
         * A[P] + A[Q] > A[R]
         * A[Q] + A[R] > A[P]
         * A[R] + A[P] > A[Q]
         * 
         */
        Arrays.sort(A);
        int count = 0;
        int mid = 0;
        int front = 0;
        for(int i=0; i<A.length-2; i++){
            /** i = P
             *  mid = Q
             *  front = R
             */
            System.out.println(" P = " +i);
            mid = i+1;
            front = i+2;

            /** Definition of triangle - summary of 2 side wille always bigger than the left side */
            while(front <= A.length-1 && mid <= A.length-2){
                System.out.println("( "+ mid+ "," +front+")");
                if(A[i] + A[mid] > A[front] && A[i] + A[front] > A[mid] && A[front] + A[mid] > A[i]){
                    count++;
                    System.out.println(" Triangle ");
                }

                if(front < A.length-1){
                    front++;
                }else{
                    mid++;
                }
                
            }

        }

        return count;
    }

    public static int solutionCaterpillar(int[] A){
        Arrays.sort(A);

        int triangles = 0;

        for(int i=0; i<A.length-2; i++){
            int front = i+2;

            for(int mid = i+1; mid< A.length-1; mid++){
                System.out.println("-->> ( "+i + ", "+ mid+ "," +front+")");
                /** check criteria then moving front */
                while (front < A.length && A[i] + A[mid] > A[front]) {
                    System.out.println(" Triangle ");
                    front++;
                }

                System.out.println("( "+ mid+ "," +front+")");
                /** 
                 * front - mid - 1 = numbers between front and mid (exclusive front and mid) 
                 * ex. at triangle (0,2,6) no triangle means out of while loop and the latest triangle would be (0,2,5) -> 6-2-1 = 3
                 * since we keep moving front when we found triangle, so we dont want to count (0,2,2) (0,2,6)
                 * 
                 * */
                triangles += front - mid - 1;
                System.out.println(triangles);
            }
        }

        return triangles;
    }

    public static void main(String[] args) {
        System.out.println(solutionCaterpillar(new int[]{10, 2, 5,1, 8, 12}));
        // System.out.println(solution(new int[]{5,3,2}));
    }
}
