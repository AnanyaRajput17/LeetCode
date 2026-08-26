import java.util.Arrays;

class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int n = grid.length;
        int m = grid[0].length;
        
        Integer[][] memo = new Integer[n][m];
        int minTotalCost = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            minTotalCost = Math.min(minTotalCost, dfs(grid, moveCost, 0, j, memo));
        }

        return minTotalCost;
    }

    private int dfs(int[][] grid, int[][] moveCost, int row, int col, Integer[][] memo) {
        int n = grid.length;
        int m = grid[0].length;

        
        if (row == n - 1) {
            return grid[row][col];
        }

        if (memo[row][col] != null) {
            return memo[row][col];
        }

        int val = grid[row][col];
        int minNext = Integer.MAX_VALUE;

      
        for (int nextCol = 0; nextCol < m; nextCol++) {
            int currentStepCost = val + moveCost[val][nextCol] + dfs(grid, moveCost, row + 1, nextCol, memo);
            minNext = Math.min(minNext, currentStepCost);
        }

        return memo[row][col] = minNext;
    }
}