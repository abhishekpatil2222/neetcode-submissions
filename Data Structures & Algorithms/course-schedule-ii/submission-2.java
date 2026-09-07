class Solution {
    List<Integer> output = new ArrayList<>();
    List<List<Integer>> adj;
    Set<Integer> cycle;
    Set<Integer> visit;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();
        cycle = new HashSet<>();
        visit = new HashSet<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] E : prerequisites){
            adj.get(E[0]).add(E[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(dfs(i) == false){
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            res[i] = output.get(i);
        }
        return res;
    
    }

    boolean dfs(int course){
        if(cycle.contains(course)){
            return false;
        }
        if(visit.contains(course)){
            return true;
        }
        cycle.add(course);
        for(int x : adj.get(course)){
            if(dfs(x) == false){
                return false;
            }
        }
        cycle.remove(course);
        visit.add(course);
        output.add(course);
        return true;
    }
    

}
