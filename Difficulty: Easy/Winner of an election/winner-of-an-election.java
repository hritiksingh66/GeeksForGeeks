// User function Template for Java

class Solution {
    // Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n){
        Map<String,Integer> map = new HashMap<>();
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) ->{
                if (a.num == b.num)
                    return a.str.compareTo(b.str);
                return b.num - a.num;
            }
        );
        
        for(String str : arr){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        
        int max = -1;
        
        for(String key : map.keySet()){
            pq.add(new Pair(map.get(key),key));
        }
        
        Pair p = pq.poll();
        
        return new String[]{p.str ,Integer.toString(p.num)};
    }
}

class Pair{
    int num;
    String str;
    
    Pair(int num,String str){
        this.num = num;
        this.str = str;
    }
    
    @Override
    public String toString() {
        return "(" + num + ", " + str + ")";
    }
}
