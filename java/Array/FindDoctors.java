import java.util.HashSet;
import java.util.Set;

public class FindDoctors {

    /**
     * 
     * @param A
     * @return number of doctor who work for more than 1 hospital
     */
    public static int solution(int[][] A){
        Set<Integer> docIds = new HashSet<Integer>();
        int allschedules = 0;
        int docWorkMore = 0;

        for(int h=0; h<A.length ; h++){
            Set<Integer> docWorksHere = new HashSet<Integer>();
            for(int s=0; s< A[h].length; s++){
                if(docWorksHere.contains(A[h][s])){
                    docWorkMore++;
                }
                docWorksHere.add(A[h][s]);
                docIds.add(A[h][s]);
                allschedules++;
            }
        }
        int diff = allschedules - docIds.size();
        return diff - docWorkMore;
    }

    public static void main(String[] args){
        int[][] intArrayA = new int[][]{
            { 1, 1, 9, 3 },
            { 2, 5, 1, 8 },
            { 6, 8, 0, 10}}; 
        // int[] intArrayB = new int[]{ 1, 1, 0, 0, 0 }; 
        // System.out.println(solution(intArrayA, intArrayB));
        System.out.println(solution(intArrayA));
        // System.out.println(solution(""));

    }
}
