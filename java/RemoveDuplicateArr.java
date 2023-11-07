public class RemoveDuplicateArr {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int count = 0;
        for(int i=0; i<len; i++){
            System.out.println(nums[i]);
            //newList.add(nums[i]);
            if(i < len-1 && nums[i] == nums[i+1]){
                continue;
            }
            nums[count] = nums[i];
            count++;
        }
        return count;
    }
}
