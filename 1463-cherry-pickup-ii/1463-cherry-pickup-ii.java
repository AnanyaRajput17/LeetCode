class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int [m][n][n];
        for(int[][] row1: dp){
            for(int[] row : row1){
                Arrays.fill(row,-1);
            }
        }
        return func(dp,grid,0,0,n-1,m,n);
        
    }
    public int func(int[][][] dp , int[][] grid , int i , int j1 ,int j2,int m,int n){
        if(j1<0 || j1 >=n || j2<0 || j2>=n ) return (int)-1e9;
        if(i==m-1){
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1]+ grid[i][j2];
        }
        int maxcherry = 0;
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        for(int k1 = -1 ;k1<2;k1++){
            for(int k2 = -1 ;k2<2;k2++){
                int cherry = 0;
                if(j1==j2){
                      cherry = grid[i][j1];
                      
                }
                else {
                    cherry = grid[i][j2] + grid[i][j1];
                   
                }
                cherry+= func(dp,grid,i+1,j1+k1,j2+k2,m,n);
                 maxcherry = Math.max(cherry,maxcherry);
            }
        }
          return dp[i][j1][j2] = maxcherry;
    }
}