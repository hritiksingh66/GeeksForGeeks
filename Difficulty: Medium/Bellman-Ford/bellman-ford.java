// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src){
        int[] res = new int[V];
        
        Arrays.fill(res,100000000);
        
        res[src] = 0;
        
        for(int i = 0; i <= V-1; i++){
            
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int dist = edge[2];
                if(res[u] != 100000000 && res[u] + dist < res[v]){
                    res[v] = res[u] + dist;
                }
            }
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int dist = edge[2];
            if(res[u] != 100000000 && res[u] + dist < res[v]){
               return new int[]{-1};
            }
        }
        return res;
    }
}
