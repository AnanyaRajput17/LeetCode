class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int x: nums){
            sum+=x;
        }
        if(Math.abs(target)>sum) return 0;
        int offset = sum;
        int[][]  dp = new int[n][2*offset+1];
        for(int[] rows: dp){
            
                Arrays.fill(rows,-1);
            
        }
        return func(nums,dp,target ,n-1 ,offset);
        
    }
    public int func(int[]  nums , int[][] dp ,int target , int index,int offset){
        if(target > offset || target < -offset ) return 0;
        if(index==0){
            if(nums[index]==0&& target == 0) return 2;
            if(nums[index] == Math.abs(target))
            return 1;
            else return 0;
        }
        if(dp[index][target+offset]!=-1)return dp[index][target+offset];
        int add = func(nums,dp,target - nums[index],index-1 , offset);
        int sub = func(nums ,dp, target + nums[index],index-1 ,offset);
        return dp[index][target+offset] = add + sub;
    }
}