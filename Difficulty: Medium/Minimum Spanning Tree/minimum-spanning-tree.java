class Solution {
    static int[] parent;
    static int[] rank;
    
    static int find(int u){
        if(u == parent[u]){
            return u;
        }
        
        return parent[u] = find(parent[u]);
    }
    
    static void union(int u , int v){
        int u_parent = find(u);
        int v_parent = find(v);
        
        if(u_parent == v_parent){
            return;
        }
        
        if(rank[u_parent] > rank[v_parent]){
            parent[v_parent] = u_parent;
        }else if(rank[u_parent] < rank[v_parent]){
            parent[u_parent] = v_parent;
        }else{
            parent[v_parent] = u_parent;
            rank[u_parent] += 1;
        }
    }
    
    static int spanningTree(int V, int E, List<List<int[]>> edges){
        parent = new int[V];
        
        for(int i = 0 ; i < V ; i++){
            parent[i] = i;
        }
        
        rank = new int[V];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        
        for(int u = 0 ; u < V; u++){
            for(int[] edge : edges.get(u)){
                int v = edge[0];
                int w = edge[1];
                
                pq.add(new int[]{u,v,w});
            }
        }
        
        int res = 0;
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0]; 
            int v = curr[1]; 
            int w = curr[2];
            
            if(find(u) != find(v)){
                res += w;
                union(u,v);
            }
        }
        
        return res;
    }
}