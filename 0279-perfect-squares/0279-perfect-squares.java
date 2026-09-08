class Solution {
    public int numSquares(int n) {
        int m = (int) Math.sqrt(n);
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
       return func(n,(int)Math.sqrt(n),dp);
    }
    public int func(int target,int n,int[][] dp){
        if(target == 0) return 0;
        if(n==1) 
           {
             return target;
           }
        int nontake = func(target , n-1 , dp);
        if(dp[target][n]!=-1) return dp[target][n];
        int take = (int)1e9;
        int square = n*n;
        if(square<=target){
            take = 1+ func(target - square , n,dp);
        }
        return dp[target][n] = Math.min(take , nontake);
    }
}