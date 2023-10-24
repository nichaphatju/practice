import java.util.HashSet;
import java.util.Set;

public class FreeShelves {
    public static int solution(int[] A, int R){

        for(int i=0; i< A.length; i++){
            Set<Integer> remove = new HashSet<Integer>();
            int check = i;
            
            while(check < R){
                remove.add(check);
                check++;
            }

            

        }
        return 1;
    }

    public static void main(String[] args){
        int[] intArrayB = new int[]{ 1, 2, 3, 1, 2 }; 
        System.out.println(solution(intArrayB, 5));
        // System.out.println(solution(intArrayA));
        // System.out.println(solution(""));

    }
}