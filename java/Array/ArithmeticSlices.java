public class ArithmeticSlices {

    /**
     * 
     * @param nums
     * @return
     * 
     * Arithmetic = consists of at least three elements and if the difference between any two consecutive elements is the same.
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3) return 0;
        int count = 0;

        for(int i=0; i<nums.length-2; i++){
            int veloTmp = nums[i+1] - nums[i]; 

            for(int j=i+1; j<nums.length-1; j++){
                int velo2 = nums[j+1] - nums[j];
                if(veloTmp == velo2){
                    count++;
                }else{
                    break;
                }
            }


        }

        return count;
    }
}
