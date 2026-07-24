import java.util.*;

class Pair {
    int row;
    int col;
    int effort;

    Pair(int row, int col, int effort) {
        this.row = row;
        this.col = col;
        this.effort = effort;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
       
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        
        int[][] distance = new int[n][m];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        distance[0][0] = 0;
        pq.offer(new Pair(0, 0, 0));
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int row = curr.row;
            int col = curr.col;
            int effort = curr.effort;
            
           
            if (row == n - 1 && col == m - 1) return effort;
            
           
            if (effort > distance[row][col]) continue;
            
            for (int[] d : directions) {
                int nrow = row + d[0];
                int ncol = col + d[1];
                
               
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    
                    int currentStepEffort = Math.abs(heights[row][col] - heights[nrow][ncol]);
                    int nextEffort = Math.max(effort, currentStepEffort);
                    
                    if (nextEffort < distance[nrow][ncol]) {
                        distance[nrow][ncol] = nextEffort;
                        pq.offer(new Pair(nrow, ncol, nextEffort));
                    }
                }
            }
        }
        
        return 0;
    }
}