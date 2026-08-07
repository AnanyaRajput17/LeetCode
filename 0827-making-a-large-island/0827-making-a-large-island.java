import java.util.HashSet;
import java.util.Set;

class Disjoint {
    int[] size;
    int[] parent;

    public Disjoint(int n) {
        size = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1; 
            parent[i] = i;
        }
    }

    public int findulp(int node) {
        if (parent[node] == node) return node;
        return parent[node] = findulp(parent[node]); 
    }

    public void unionbysize(int u, int v) {
        int ulp_u = findulp(u);
        int ulp_v = findulp(v);

        if (ulp_u == ulp_v) return;

        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Disjoint ds = new Disjoint(n * n);
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int[] dir : dirs) {
                        int nrow = i + dir[0];
                        int ncol = j + dir[1];
                        if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1) {
                            int node1 = i * n + j;
                            int node2 = nrow * n + ncol;
                            ds.unionbysize(node1, node2);
                        }
                    }
                }
            }
        }

        int mx = 0;
        boolean hasZero = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    hasZero = true;
                    Set<Integer> set = new HashSet<>();

                    for (int[] dir : dirs) {
                        int nrow = i + dir[0];
                        int ncol = j + dir[1];
                        if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1) {
                            set.add(ds.findulp(nrow * n + ncol));
                        }
                    }

                    int currentSize = 1; 
                    for (int parent : set) {
                        currentSize += ds.size[parent];
                    }
                    mx = Math.max(mx, currentSize);
                }
            }
        }

  
        if (!hasZero) return n * n;

        return mx;
    }
}