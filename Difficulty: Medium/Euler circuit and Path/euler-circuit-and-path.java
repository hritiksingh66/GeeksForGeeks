class Solution {
    
    boolean isConnected(int V,List<Integer>[] adj){
        int nonZeroDegree = -1;
        
        for(int i = 0 ; i < V ; i++){
            if(adj[i].size() != 0){
                nonZeroDegree = i;
                break;
            }
        }
        
        
        boolean[] visited = new boolean[V];
        
        DFS(nonZeroDegree,adj,visited);
        
        for(int i = 0 ; i < V ; i++){
            if(!visited[i] && adj[i].size() != 0){
                return false;
            }
        }
        
        return true;
    }
    
    void DFS(int node,List<Integer>[] adj,boolean[] visited){
        visited[node] = true;
        
        for(int nbr : adj[node]){
            if(!visited[nbr]){
                DFS(nbr,adj,visited);
            }
        }
    }
    
    public int isEulerCircuit(int V, List<Integer>[] adj) {
        
        if(!isConnected(V,adj)) return 0;
        
        int oddDegreeCount = 0;
        
        for(int i = 0 ; i < V; i++){
            if(adj[i].size() % 2 != 0){
                oddDegreeCount++;
            }
        }
        
        if(oddDegreeCount > 2) 
            return 0;
        if(oddDegreeCount == 2) 
            return 1;
        
        return 2;
    }
}