public class WholeSquare {
    
    public static int solution(int A, int B){

        int count = 0;

        for(int i=A; i<=B; i++){
            if(Math.sqrt(i) % 1 == 0){
                count++;
            }
        }

        return count;
    }

    public static void main (String[] args){
        System.out.println(solution(4, 17));
    }
}
