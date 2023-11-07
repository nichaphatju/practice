public class Rectangle {
    public static int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {

        /** 
         * 
         * K=0, L=2, M=5, N=10
         * P=3, Q=1, R=20, S=15
         * 
         * X -> K, M (Left, Right line)| P, R (Left, Right line)
         * Y -> N, L (Top, Bottom line)| S, Q (Top, Bottom line)
         * 
         * Point   A  - B   - C   - D 
         * rec1 = K,N - M,N - K,L - M,L
         * rec2 = P,S - R,S - P,Q - R,Q
         * 
        **/

        int x = 0;
        int y = 0;

        if(K > P && K < R){
            // left of A inside B
            x = M < R ? M - K : R - K;
        }
        if(M > P && M < R){
            // right of A inside B
            x = K > P ? M - K : M - P;
        }
        if(N > Q && N < S){
            // top of A inside B
            y =  L > Q ? N - L : N - Q ;
        }
        if(L > Q && L < S){
            // bottom of A inside B
            y = N < S ? N - L : N - Q;
        }
        
        return x*y;
    }

    public static void main(String[] args){

        System.out.println(solution(0, 2, 5, 10, 3, 1, 20, 15));

        System.out.println(solution(0, 2, 8, 10, 1, 1, 20, 15));

        System.out.println(solution(0, -5, 5, 10, 3, 1, 20, 15));

        System.out.println(solution(4, 3, 15, 10, 3, 1, 20, 15));

        System.out.println(solution(6, 14, 10, 20, 3, 1, 20, 15));
        
        System.out.println(solution(4, 2, 6, 10, 3, 1, 20, 15));

    }
}
