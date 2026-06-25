class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans=0;
        for(int i = 0;i<n ;i++){
            int tc=0;
            for(int j = i;j< n ;j++){
                if(nums[j]==target){
                    tc++;
                }
                int l = j-i+1;
            if(tc>l/2) ans++;
        }
        }
        return ans;
    }
}