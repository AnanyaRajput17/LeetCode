class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int[][] memo = new int[n][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        int ans = func(coins, n - 1, amount, memo);
      
        if (ans >= (int) 1e9) return -1;
        return ans;
    }
    
    public int func(int[] coins, int n, int amount, int[][] memo) {
       
        if (n == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            else return (int) 1e9;
        }
        
        
        if (memo[n][amount] != -1) return memo[n][amount];
        

        int nontake = func(coins, n - 1, amount, memo);
        
       
        int take = (int) 1e9;
        if (coins[n] <= amount) {
            take = 1 + func(coins, n, amount - coins[n], memo);
        }
        
        
        return memo[n][amount] = Math.min(take, nontake);
    } 
}