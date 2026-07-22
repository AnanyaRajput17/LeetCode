class Solution {
    public int findShortestCycle(int n, int[][] edges) {

        
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int shortest = Integer.MAX_VALUE; 
        for(int start=0; start<n; start++){
            int[] parent = new int[n]; 
            Arrays.fill(parent, -1); 
            int[] level = new int[n]; 
            Arrays.fill(level, -1); 

            Queue<Integer> q = new LinkedList<>(); 
            q.offer(start); 
            level[start] = 0;

            //BFS

            while(!q.isEmpty()){
                int curr = q.poll();
                for(int neighbour : graph[curr]){
                    if(level[neighbour]==-1){ 
                        level[neighbour] = level[curr] + 1;
                        parent[neighbour] = curr; 
                        q.offer(neighbour);
                    }else if(neighbour != parent[curr]){ 
                    int currCycle = level[neighbour] + level[curr] + 1; 
                        shortest = Math.min(shortest, currCycle); 
                    }
                }
            }
        }
        return shortest==Integer.MAX_VALUE? -1 : shortest;
    }
}