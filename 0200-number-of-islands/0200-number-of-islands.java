class Solution {
    public int numIslands(char[][] grid) {
        int island = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j =0;j<m;j++){
                   if(visited[i][j]==0 && grid[i][j]=='1'){
                    island++;
                    dfs(i,j,grid,visited,n,m);
                       
                   }
            }
        }
            return island;
        }
    
    public void dfs(int r , int c , char[][] grid , int[][] visited,int n , int m){
        visited[r][c]=1;
        if(r+1<n&& visited[r+1][c]==0&&grid[r+1][c]=='1'){
               dfs(r+1,c,grid,visited,n,m);
        }
        if(r-1>=0&& visited[r-1][c]==0&&grid[r-1][c]=='1'){
               dfs(r-1,c,grid,visited,n,m);
        }
        if(c+1<m&& visited[r][c+1]==0&&grid[r][c+1]=='1'){
               dfs(r,c+1,grid,visited,n,m);
        }
        if(c-1>=0&& visited[r][c-1]==0&&grid[r][c-1]=='1'){
               dfs(r,c-1,grid,visited,n,m);
        }
    }
}