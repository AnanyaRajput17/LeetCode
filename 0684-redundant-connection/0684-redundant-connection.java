import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            boolean[] visited = new boolean[n + 1];

           
            if (hasPath(u, v, -1, list, visited)) {
                return edge;
            }

            
            list.get(u).add(v);
            list.get(v).add(u);
        }

        return new int[0];
    }

    private boolean hasPath(int src, int target, int parent, List<List<Integer>> list, boolean[] visited) {
        if (src == target) return true;

        visited[src] = true;

        for (int neighbor : list.get(src)) {
            if (neighbor == parent) continue; 
            if (!visited[neighbor]) {
                if (hasPath(neighbor, target, src, list, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}