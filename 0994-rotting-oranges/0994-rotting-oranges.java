class Pair{
    int r;
    int c;
    Pair(int r, int c){
        this.r= r;
        this.c=c;
        }
}


class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int row=0;
        int col=0;
        int orange =0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j));
                }
                if(grid[i][j]==1){
                    orange++;
                }
            }
        }
        if(orange==0) return 0;
        int minutes=0;
        while(!q.isEmpty()&&orange>0){
            int size= q.size();
            for(int i =0;i<size;i++){
                Pair pair = q.poll();
                int r = pair.r;
                int c = pair.c;
                int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
                for(int[] d : dir){
                    int nr=r+d[0];
                    int nc=c+d[1];
                    if(nc>=0&&nc<m && nr>=0&& nr<n && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        q.offer(new Pair(nr , nc));
                        orange--;
                    }
                }
            }
            minutes++;
        }
        
        return orange==0 ? minutes : -1;
        
    }
}