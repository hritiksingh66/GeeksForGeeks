class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // Store order of DFS in stack of original Graph --> Topo sort 
        int V = adj.size();
        
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        
        for(int i = 0 ; i < V ; i++){
            if(!visited[i]){
                dfs(i,adj,visited,st);
            }
        }
        
        
        
        Arrays.fill(visited,false); // reset all unvisited 
        
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        
        for(int i = 0 ; i < V ; i++){
            adjRev.add(new ArrayList<>());
        }
        
        
        for(int u = 0 ; u < V; u++){
            
            for(int v : adj.get(u)){
                adjRev.get(v).add(u);
            }
        }
        
        int res = 0;
        
        while(!st.isEmpty()){
            
            int node = st.pop();
            
            if(!visited[node]){
                dfs(node,adjRev,visited,st);
                res += 1;
            }else{
                continue;
            }
            
        }
        
        return res;
    }
    
    void dfs(int u,ArrayList<ArrayList<Integer>> adj,boolean[] visited,Stack<Integer> st){
        
        visited[u] = true;
        
        for(int nbr : adj.get(u)){
            if(!visited[nbr]){
                dfs(nbr,adj,visited,st);
            }
        }
        
        st.push(u);
    }
}