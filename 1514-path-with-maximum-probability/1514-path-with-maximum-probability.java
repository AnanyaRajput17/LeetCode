class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(new double[]{v, succProb[i]});
            adj.get(v).add(new double[]{u, succProb[i]});
        }
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a,b)->Double.compare(b[1], a[1])
        );
        pq.offer(new double[]{start_node, 1.0});
        double[] dist = new double[n];
        dist[start_node] = 1.0;
        while(!pq.isEmpty()) {
            double[] arr = pq.poll();
            int node = (int)arr[0];
            double d = arr[1];
            if(node == end_node) return d;
            for(double[] neigh : adj.get(node)) {
                int newNode = (int)neigh[0];
                double newDist = neigh[1];
                if(d * newDist > dist[newNode]) {
                    dist[newNode] = d * newDist;
                    pq.offer(new double[]{newNode, d * newDist});
                }
            }
        }
        return 0;
    }
}