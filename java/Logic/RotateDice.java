import java.util.Arrays;

public class RotateDice {
    
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3}));
        System.out.println(solution(new int[]{1,1,6}));
        System.out.println(solution(new int[]{1,6,2,3}));
    }

    public static int solution(int[] A){
        
        int minCount = Integer.MAX_VALUE;
        Arrays.sort(A);
        for(int i=0; i<A.length; i++){
            int pip = A[i];
            int count = 0;
            for(int j=A.length-1; j>=0; j--){
                if(pip == 1 && A[j] == 6){
                    count += 2;
                }else if(pip == 2 && A[j] == 5){
                    count += 2;
                }else if(pip == 3 && A[j] == 4){
                    count += 2;
                }else if(A[j] != pip){
                    count += 1;
                }
                if(count > minCount){
                    break;
                }
            }
            
            minCount = count;

        }

        return minCount;
    }
}
