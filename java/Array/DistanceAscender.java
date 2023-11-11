import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * Find closest distance from i to left or right position which left or right element is greater than A[i]
 * 
 */
public class DistanceAscender {
    public static int[] solution(int[] A){
        /** Bad performance */

        int[] distance = new int[A.length];

        for(int i=0; i< A.length; i++){
            int diff = Integer.MAX_VALUE;
            if(i > 0){
                for(int j=i-1; j >= 0; j--){
                    if(A[j] > A[i]){
                        if(Math.abs(j-i) < diff){
                            diff = Math.abs(j-i);
                            distance[i] = Math.abs(j-i);
                        }
                        break;
                    }
                }
            }
            if(distance[i] == 1) break;
            if(i < A.length-1){
                for(int k=i+1; k <A.length; k++){
                    if(A[k] > A[i]){
                        if(Math.abs(k-i) < diff){
                            diff = Math.abs(k-i);
                            distance[i] = Math.abs(k-i);
                        }
                        break;
                    }
                }
            }
        }

        return distance;

    }

    public static int[] solution2(int[] A){

        int[] ret = new int[A.length];

        for(int i=0; i< A.length; i++){

            int leftInd = i-1;
            int rightIdx = i+1;
            int closest = Integer.MAX_VALUE;
            int l = 0;
            int loop = Math.max(i-0, A.length-1-i);

            while (l <= loop) {

                if(leftInd >= 0 && A[leftInd] > A[i]){
                    closest = Math.min(closest,  Math.abs(i - leftInd));
                    break;
                }

                if(rightIdx <= A.length-1 && A[rightIdx] > A[i]){
                    closest = Math.min(closest,  Math.abs(i - rightIdx));
                    break;
                }

                leftInd--;
                rightIdx++;
                l++;
            }

            ret[i] = closest == Integer.MAX_VALUE ? 0 : closest;

        }

        return ret;
    }

    /** Find only left closest, then reverse A to get right closest then reverse back again */
    public static int[] solution3(int[] A){
        // Better performance

        // find left closest
        int[] retL = leftClosestASC(A);

        // reverse A to find right closest
        for(int i=0; i< A.length/2; i++){
            int tmp = A[i];
            A[i] = A[A.length-i-1];
            A[A.length-i-1] = tmp;
        }
        int[] retR = leftClosestASC(A);

        // after get right closest, but in reverse form, reverse back to get right closest
        for(int i=0; i< A.length/2; i++){
            int tmp = retR[i];
            retR[i] = retR[A.length-i-1];
            retR[A.length-i-1] = tmp;
        }

        int[] ret = new int[A.length];

        // compare between left and right closest
        for(int i=0; i< retL.length; i++){
            ret[i] = Math.min(retL[i], retR[i]);
            ret[i] = ret[i] == Integer.MAX_VALUE ? 0 : ret[i];
        }


        return ret;
    }

    public static int[] leftClosestASC(int[] A){
        int n = A.length;
        if(n == 0) return A;
        int[] ret = new int[A.length];

        // keep index of left elements
        int[] stack = new int[A.length];
        int stackSize = 0;

        for(int i=0; i< A.length; i++){

            System.out.println("----- " + i + " ------");
            System.out.println(stackSize);

            while (stackSize > 0 && A[stack[stackSize-1]] <= A[i]) {
                /* if previous element <= current element val, keep searching the next prev ones
                * stackSize will store distance to the biggest number so far -> so no need to check previous further than this val 
                * since it's doesn't matter if there's a smaller number that greater than current val cus only need the closest distance.
                */
                stackSize -= 1;
            }
            // otherwise means found the one (if stackSize is not 0)
            if(stackSize == 0){
                // No element on the left / greater val not found  - set to max val
                ret[i] = Integer.MAX_VALUE;
                System.out.println("Greater val not found");
            }else{
                // Set diff distance between current index and index kept in stack (prev index)
                ret[i] = i - stack[stackSize-1];
            }
            System.out.println(stackSize);

            
            stack[stackSize] = i;
            stackSize += 1;

        }

        return ret;

    }

    public static int[] getDistanceAsc(int[] inputArray){
        // Check parameters
        // if (inputArray == null) throw new ArgumentNullException("inputArray can't be null");
        // if (inputArray.length > MAX_RANGE) throw new ArgumentOutOfRangeException("inputArray should be inferior or equal to " + MAX_RANGE);

        int[] outputArray = new int[inputArray.length];

        for (int k = 0; k < inputArray.length; k++)
        {
            int j = k;  // j is a posivite index which increase to get the next ascender.
            int m = k;  // m is a posivite index which decrease to get the next ascender.
            int minDistance = Integer.MAX_VALUE;
            int currentDistance = Integer.MAX_VALUE;

            while (j < inputArray.length -1)
            {
                j++;
                m--;

                if (m >= 0 && inputArray[m] > inputArray[k])
                {
                    currentDistance = Math.absExact(k - m);

                    if (currentDistance < minDistance)
                        minDistance = currentDistance;

                    if (minDistance == 1)
                        break;
                }

                if (inputArray[j] > inputArray[k])
                {
                    currentDistance = Math.abs(k - j);

                    if (currentDistance < minDistance)
                        minDistance = currentDistance;

                    break;
                }
            }

            outputArray[k] = (minDistance != Integer.MAX_VALUE) ? minDistance : 0;
        }

        return outputArray;

    }

    public static void main(String[] args){
        int[] arrA = new int[]{4, 3, 1, 4, -1, 2, 1, 5, 7};
        System.out.println(Arrays.toString(solution3(arrA)));
    }
}
