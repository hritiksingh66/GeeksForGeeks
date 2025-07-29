class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> edges){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] vis = new boolean[V];
    
        pq.offer(new int[]{0, 0});
        int sum = 0;
    
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int w = curr[0];
            int u = curr[1];
    
            if (vis[u]) continue;
            vis[u] = true;
            sum += w;
    
            for (int[] edge : edges.get(u)) {
                int v = edge[0];
                int wt = edge[1];
                if (!vis[v]) {
                    pq.offer(new int[]{wt, v});
                }
            }
        }
    
        return sum;
    }
}