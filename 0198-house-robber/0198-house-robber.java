class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return func(dp,nums,n-1);
    }
    public int func(int[] dp,int[] nums , int index){
        if(index==0) return nums[0];
        if(index<0) return 0;
        if(dp[index]!=-1) return dp[index];
        int pick = nums[index]+func(dp,nums,index-2);
        int nonpick = func(dp,nums,index-1);
        return dp[index]= Math.max(pick,nonpick);
    }
}