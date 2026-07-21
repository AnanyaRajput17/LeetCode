import java.util.ArrayList;
import java.util.List;

class Solution {
    private boolean hasCycle(int u, List<List<Integer>> adj, int[] vis) {
        vis[u] = 1;
        for (int v : adj.get(u)) {
            if (vis[v] == 1) return true;
            if (vis[v] == 0 && hasCycle(v, adj, vis)) return true;
        }

        vis[u] = 2; 
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        
        int[] vis = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (hasCycle(i, adj, vis)) return false; 
                }
        }

        return true;
    }
}