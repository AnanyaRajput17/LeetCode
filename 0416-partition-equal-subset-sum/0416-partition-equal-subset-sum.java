class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        // If the sum is odd, we can't split it into two equal halves
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        int n = nums.length;

        // dp[n][target + 1] table
        // dp[i][j] will be true if sum 'j' can be formed using first 'i' elements
        boolean[][] dp = new boolean[n][target + 1];

        // Base Case 1: If target is 0, we can always achieve it (by picking nothing)
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Base Case 2: For the first element (index 0), 
        // we can only achieve the target if the element equals the target
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        // Fill the table iteratively
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                
                // Choice 1: Don't take the current element
                boolean notTake = dp[i - 1][j];

                // Choice 2: Take the current element (if it fits)
                boolean take = false;
                if (nums[i] <= j) {
                    take = dp[i - 1][j - nums[i]];
                }

                // If either choice works, mark this state as true
                dp[i][j] = take || notTake;
            }
        }

        // The answer is in the last cell
        return dp[n - 1][target];
    }
}