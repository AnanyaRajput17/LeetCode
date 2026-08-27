class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n= grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row:dp) Arrays.fill(row,-1);
        return func(dp,grid,m-1,n-1);        
    }
    public int func(int[][] dp ,int[][] grid , int i,int j){
        if(i==0 && j==0) return grid[i][j];
        if(i<0 || j<0) return (int) 1e9;
        if(dp[i][j]!=-1)return dp[i][j];
       
        int up = grid[i][j] + func(dp,grid,i-1,j);
       
        int left = grid[i][j] + func(dp,grid,i,j-1);
        return dp[i][j]=Math.min(up,left);
    }
}