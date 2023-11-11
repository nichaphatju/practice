public class IndexNotVisited {
    public static int solution(int[] A){
        return visit(0, A, A.length);
    }

    public static int visit(int ind, int[] A, int count){

        if(ind >= A.length){
            return count;
        }
        count--;

        if(ind + A[ind] != ind){
            return visit((ind + A[ind]), A, count);
        }
        return count;
    }

    public static void main(String[] args) {
        // int[] arrA = new int[]{1,2,3};
        // System.out.println(solution(arrA));

        int[] arrB = new int[]{3,-5,0,-1,-3};
        System.out.println(solution(arrB));
    }
}
