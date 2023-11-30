public class MinAvgTwoSlice {

    public static int solution(int[] A) {
        // First attempt
        // Bad performance
        // Implement your solution here

        int me = 0;
        int[] sumEachPoint = new int[A.length];
        for(int i=0; i<A.length; i++){
            me = me + A[i];
            sumEachPoint[i] = me;
        }
        
        int ans = Integer.MAX_VALUE;
        double avgTmp = Integer.MAX_VALUE;

        //System.out.println(Arrays.toString(sumEachPoint));
        int x = 2; // size of slice at least 2
        while(x <= A.length){
            double z = x;
            //System.out.println("X "+ x);
            for(int i=0; i<A.length-x+1; i++){
                double scal = sumEachPoint[i+(x-1)];
                if(i > 0){
                    scal -= sumEachPoint[i-1];
                }
                double avg = scal/z;
                if(avg < avgTmp){
                    ans = i;
                    avgTmp =  avg;
                    //System.out.println(" i " + i + " " + avgTmp);
                }
            }
            x++;
        }

        return ans;

    }

    public static int solution2(int[] A){
        // Because the set of any set of 4 or more will always consist of set of 2,3 and the average of subset is always equal or less than the average of the set.
        // So we dont need to consider the set of 4 or more
        // only need to consider set of 2 or 3
        // 100%

        // Implement your solution here
        int ans = A.length;
        double minAvg = Integer.MAX_VALUE;
        for(int i=0; i<A.length-1; i++){
            // check set of 2
            double sum2=A[i]+A[i+1];
            if(sum2/2.0d < minAvg){
                ans = i;
                minAvg = sum2/2.0d;
            }

            // check set of 3
            if(i < A.length-2){
                double sum3=A[i]+A[i+1]+A[i+2];
                if(sum3/3.0d < minAvg){
                    ans = i;
                    minAvg = sum3/3.0d;
                }
            }

        }

        return ans;

    }

    public static void main(String[] args) {
        
    }
}
