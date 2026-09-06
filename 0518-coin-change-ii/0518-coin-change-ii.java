import java.util.Arrays;

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        
        // Create a memoization table [coin_index][amount_remaining]
        int[][] memo = new int[n][amount + 1];
        
        // Fill with -1 to indicate uncomputed subproblems
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return func(coins, n - 1, amount, memo);
    }
    
    public int func(int[] coins, int n, int amount, int[][] memo) {
        // Base case: Only the first coin (index 0) is left
        if (n == 0) {
            if (amount % coins[0] == 0) return 1;
            else return 0;
        }
        
        // If we have already calculated the answer for this exact state, return it immediately
        if (memo[n][amount] != -1) {
            return memo[n][amount];
        }
        
        // Option 1: Do not take the current coin
        int nontake = func(coins, n - 1, amount, memo);
        
        // Option 2: Take the current coin (if it fits)
        int take = 0;
        if (coins[n] <= amount) {
            take = func(coins, n, amount - coins[n], memo);
        }
        
        // Save the result in our memo table before returning it
        return memo[n][amount] = take + nontake;
    } 
}