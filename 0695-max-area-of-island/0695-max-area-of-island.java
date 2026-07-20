class Solution {
 
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        for(int i= 0;i<n;i++){
            for(int j = 0;j<m;j++){
                  if(visited[i][j]==0 && grid[i][j]==1){
                    int area=dfs(i,j,visited,grid,n,m,max);
                    max= Math.max(max,area);
                  }
            }
        }
        return max;
        
    }
    public int dfs(int r, int c , int[][] visited , int[][] grid ,int n , int m, int max){
        
        int area=1;
        visited[r][c]=1;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] d:directions){
            int nr = r+d[0];
            int nc= c+d[1];
            if(nr>=0 && nr<n&& nc>=0 && nc<m&&visited[nr][nc]==0 && grid[nr][nc]==1){
                area+=dfs(nr,nc,visited,grid,n,m,max);
            }
        }
        return area;
    }
}