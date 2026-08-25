class Solution {
    public int rob(int[] nums) {
       int n = nums.length;
       if(n<2) return nums[0];
       int[] dp = new int[n];
       int[] dp1 = new int[n];
       Arrays.fill(dp,-1);
        Arrays.fill(dp1,-1);
       return Math.max(func(dp,nums,1,n-1),func(dp1,nums,0,n-2));
       
    }  
    public int func(int[] dp,int[] nums , int start , int end) {
        if(end==start) return nums[end];
        if(end<start) return 0;
        if(dp[end]!=-1) return dp[end];
        int take = nums[end] + func(dp,nums,start , end-2);
        int nottake = func(dp,nums,start , end-1);
        return dp[end] = Math.max(take,nottake);
        
    } 
}