class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return func(nums,target ,n-1 );
        
    }
    public int func(int[]  nums , int target , int index){
        if(index==0){
            if(nums[index]==0&& target == 0) return 2;
            if(nums[index] == Math.abs(target))
            return 1;
            else return 0;
        }
        int add = func(nums,target - nums[index],index-1);
        int sub = func(nums , target + nums[index],index-1 );
        return add + sub;
    }
}