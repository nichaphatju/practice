import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TempSolutionClass {
    public static void main(String[] args){
        int[] intArrayA = new int[]{ 4, 3, 2, 1, 5 }; 
        int[] intArrayB = new int[]{ 1, 1, 0, 0, 0 }; 
        System.out.println(solution(intArrayA, intArrayB));
        // System.out.println(solution(""));
        // System.out.println(solution(""));


    }

    public static int solution(int[] A, int[] B) {
        System.out.println(" ----->> Input : " + Arrays.toString(A));
        // List<Integer> fishDwn = new ArrayList<>();
        int fistSurvive = A.length;
        Stack<Integer> stFishUp = new Stack<Integer>();
        // int[] fishDwn;
        for(int i=0; i< A.length; i++){
            if(B[i] == 1){
                stFishUp.push(A[i]);
            }
            else if(B[i] == 0){                     //upstream
                while(!stFishUp.isEmpty()){
                    if(stFishUp.peek() > A[i]){
                        fistSurvive--;
                        break;
                    }else if(stFishUp.peek() < A[i]){
                        fistSurvive--;
                        stFishUp.pop();
                    }
                }
            }
        }
        System.out.println(" ----->> Output : "+fistSurvive);
        return fistSurvive;
    }
}

// System.out.println(" ----->> Input : " + A);
//         // List<Integer> num = new ArrayList<>();
//         int[] largestFishU = new int[A.length];
//         int[] largestFishD = new int[A.length];
//         Boolean isFirstUp = true;
//         Boolean isFirstDown = true;
//         int largestFishUp = 0; //0
//         int largestFishDown = 0; //1
//         for(int i=A.length-1; i>0; i--){
//             if(B[i] == 0){
//                 if(isFirstUp){
//                     isFirstUp = false;
//                     largestFishU[i] = A[i];
//                 }else{
//                     largestFishUp = Math.max(largestFishUp, A[i]);
//                     largestFishU[i] = Math.max(largestFishU[i+1], A[i]);
                    
//                 }
//                 if((i+1) >= largestFishD.length){
//                     largestFishD[i] = 0;
//                 }else{
//                     largestFishD[i] = largestFishD[i+1];
//                 }
                
                
//             }else{
//                 if(isFirstDown){
//                     isFirstDown = false;
//                     largestFishD[i] = A[i];
//                 }else{
//                     largestFishDown = Math.max(largestFishDown, A[i]);
//                     largestFishD[i] = Math.max(largestFishD[i+1], A[i]);
                    
//                 }
//                 if(largestFishU.length < (i-2)){
//                     largestFishU[i] = 0;
//                 }else{
//                     largestFishU[i] = largestFishU[i+1];
//                 }
//             }
//         }
//         System.out.println(" ----->> largestFishU : " + largestFishUp);
//         System.out.println(Arrays.toString(largestFishU));
//         System.out.println(" ----->> largestFishDown : " + largestFishDown);
//         System.out.println(Arrays.toString(largestFishD));
//         int fistSurvive = 0;
//         for(int i=0; i<B.length; i++){
//             Boolean isFirstUpB = true;
//             Boolean isFirstDownB = true;
//             if(B[i] == 1){
//                 if(isFirstDownB){
//                     isFirstDownB = false;
//                 }else
//                 if(A[i] > largestFishU[i]){
//                     fistSurvive += 1;
//                 }
//             }else{
//                 if(isFirstUpB){
//                     isFirstUpB = false;
//                 }else
//                 if(A[i] > largestFishD[i]){
//                     fistSurvive += 1;
//                 }
//             }
//         }

//         System.out.println(" ----->>  Output : " + fistSurvive);