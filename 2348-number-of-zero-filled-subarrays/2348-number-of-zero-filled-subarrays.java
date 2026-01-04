class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0 , n =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) n++;
            else{
                count = count+(n * (n+1)/2);
                n =0;
            }
            
        }
        if(n>0){
            count = count+(n * (n+1)/2);
        }
        return count;
    }
}