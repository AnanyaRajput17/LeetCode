class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
       if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
       int[][] dirs={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
       Queue<int[]> q=new LinkedList<>();
       boolean[][] vis=new boolean[n][n];
       q.offer(new int[] {0,0});
       vis[0][0]=true;
       int dis=1;
       while(!q.isEmpty()){
        int size=q.size();
        for(int i=0;i<size;i++){
            int[] tp=q.poll();
            int r=tp[0];
            int c=tp[1];
        
        if(r==n-1 && c==n-1)return dis;
        for(int[] d:dirs){
            int nr=r+d[0];
            int nc=c+d[1];
            if(nr>=0 && nr<=n-1 && nc>=0 && nc<n && vis[nr][nc]!=true && grid[nr][nc]==0){
                vis[nr][nc]=true;
                q.offer(new int[] {nr,nc});
            }
        }
    } 
        dis++;
       }
        return -1;
    }
}