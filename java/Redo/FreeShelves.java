package Redo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FreeShelves {

    /*
     * 
     * Find the first index of K shelves to be freed and still contain the most unique products
     * 
     */

    public static int solution(int[] A, int K){

        Map<Integer,Set<Integer>> prodLeft = new HashMap<Integer, Set<Integer>>();
        Map<Integer,Set<Integer>> prodRight = new HashMap<Integer, Set<Integer>>();
        // Count prod left
        // No need to check first index -> will always have 0 left prod
        for(int i=1;i <A.length-K+1 ; i++){
            Set<Integer> prevProds = new HashSet<>(prodLeft.getOrDefault(i-1, new HashSet<>()));
            prevProds.add(A[i-1]);
            prodLeft.put(i, prevProds);           
        }

        // System.out.println(prodLeft);
        // System.out.println(Arrays.toString(uniquePrdLeft));

        // No need to check last index -> will always have 0 right prod
        // count untill K only 
        for(int j=A.length-2;j >= K; j--){
            int leftInd = (j - K) + 1;      // Left index, ex if K=3 > Remove 3 elements start from index 3 -> it will be 3-5 -> j=5,K=3,leftInd=(5-3)+1=3
            Set <Integer> leftProd = prodLeft.getOrDefault(leftInd, new HashSet<>());
            Set <Integer> rightProd = new HashSet<>(prodRight.getOrDefault(j, new HashSet<>()));
            if(!leftProd.contains(A[j+1]) && !rightProd.contains(A[j+1])){
                rightProd.add(A[j+1]);
            }
            prodRight.put(j, rightProd);
        }
        // System.out.println(prodLeft);
        // System.out.println(prodRight);

        // int[] prodLeftOnShelves = new int[A.length];
        int tmpMax = Integer.MIN_VALUE;
        int ind = 0;
        for(int i=0; i<A.length-K+1 ; i++){
            // Left index, ex if K=3 > Remove 3 elements start from index 3 -> it will be 3-5 -> j=5,K=3,leftInd=(5-3)+1=3
            int prd = prodLeft.getOrDefault(i, new HashSet<>()).size() + prodRight.getOrDefault(i+K-1, new HashSet<>()).size();
            // System.out.println(i + " " + prd);
            if(prd > tmpMax){
                tmpMax = prd;
                ind = i;
            }
        }



        return ind;
    }

    public static void main(String[] args) {
        int[] intArrayB = new int[]{ 1, 2, 3, 2, 1, 2 }; 
        System.out.println(solution(intArrayB, 3));

        int[] shelves = {1, 2, 2, 3, 4, 4, 4, 5, 6, 6, 6, 6};
        int R = 3;
        int optimalShelf = solution(shelves, R);

        System.out.println(optimalShelf);

        int[] intArrayC = new int[]{ 9, 8 ,2, -1, -1, -1, 5, 7, 8, 8, 8, 8, 8, 8, 9 }; 
        System.out.println(solution(intArrayC, 8));
    }
}
