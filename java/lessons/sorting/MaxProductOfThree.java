package lessons.sorting;
import java.util.Arrays;

public class MaxProductOfThree {
    public int solution(int[] A) {

        // main idea: 
        // max_1 = positive * positive * positive
        // max_2 = negative * negative * positive
        // max = Math.max(max_1, max_1)
        // just need to sort the integer array
        
        // sort the array
        Arrays.sort(A);

        // max_1 = 1st biggest * 2nd biggest * 3rd biggest 
        int max_1 = A[A.length-1] * A[A.length-2] * A[A.length-3];
        
        // max_2 = 1st smallest * 2nd smallest * 1st biggest
        int max_2 = A[0] * A[1] * A[A.length-1];

        // take the maximum        
        int max = Math.max(max_1, max_2);
        
        return max;
    }

    public int maxProduct(int []arr, int n){
        // if size is less than 3, no triplet exists
    if (n < 3)
        return -1;

    // Construct four auxiliary vectors
    // of size n and initialize them by -1
    int[] leftMin = new int[n];
    int[] rightMin = new int[n];
    int[] leftMax = new int[n];
    int[] rightMax = new int[n];
    Arrays.fill(leftMin, -1);
    Arrays.fill(leftMax, -1);
    Arrays.fill(rightMax, -1);
    Arrays.fill(rightMin, -1);

    // will contain max product
    int max_product = Integer.MIN_VALUE;

    // to store maximum element on left of array
    int max_sum = arr[0];

    // to store minimum element on left of array
    int min_sum = arr[0];

    // leftMax[i] will contain max element
    // on left of arr[i] excluding arr[i].
    // leftMin[i] will contain min element
    // on left of arr[i] excluding arr[i].
    for (int i = 1; i < n; i++)
    {
        leftMax[i] = max_sum;
        if (arr[i] > max_sum)
            max_sum = arr[i];

        leftMin[i] = min_sum;
        if (arr[i] < min_sum)
            min_sum = arr[i];
    }

    // reset max_sum to store maximum element on
    // right of array
    max_sum = arr[n - 1];

    // reset min_sum to store minimum element on
    // right of array
    min_sum = arr[n - 1];

    // rightMax[i] will contain max element
    // on right of arr[i] excluding arr[i].
    // rightMin[i] will contain min element
    // on right of arr[i] excluding arr[i].
    for (int j = n - 2; j >= 0; j--)
    {
        rightMax[j] = max_sum;
        if (arr[j] > max_sum)
            max_sum = arr[j];

        rightMin[j] = min_sum;
        if (arr[j] < min_sum)
            min_sum = arr[j];
    }

    // For all array indexes i except first and
    // last, compute maximum of arr[i]*x*y where
    // x can be leftMax[i] or leftMin[i] and
    // y can be rightMax[i] or rightMin[i].
    for (int i = 1; i < n - 1; i++)
    {
        int max1 = Math.max(arr[i] * leftMax[i] * rightMax[i],
                    arr[i] * leftMin[i] * rightMin[i]);

        int max2 = Math.max(arr[i] * leftMax[i] * rightMin[i],
                    arr[i] * leftMin[i] * rightMax[i]);

        max_product = Math.max(max_product, Math.max(max1, max2));
    }

    return max_product;
    }
}
