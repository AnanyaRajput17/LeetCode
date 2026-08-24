class Solution {
    public int rob(int[] nums) {
      int n = nums.length;
      int prev = nums[0];
      int prev2=0;
        for(int i =1;i<n;i++){
              int take = nums[i];
                if(i>1){
                 take+=prev2;
            }
           int nontake = prev ;
         
           int curr = Math.max(take,nontake);
           prev2 = prev;
           prev = curr;
        }
        return prev;
    }
}