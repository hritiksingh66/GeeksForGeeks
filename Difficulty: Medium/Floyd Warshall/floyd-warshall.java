// User function template for JAVA
class Solution {
    static final int INF = 100000000;
    public void floydWarshall(int[][] dist){
        int V = dist.length;
        
        for(int k = 0 ; k < V; k++){
            for(int u = 0; u < V ; u++){
                for(int v = 0 ; v < V ; v++){
                    if(dist[u][k] != INF && dist[k][v] != INF){
                        dist[u][v] = Math.min(dist[u][v] , dist[u][k] + dist[k][v]);
                    }
                }
            }
        }
        
    }
}