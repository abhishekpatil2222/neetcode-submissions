class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int x : nums){
            count.put(x, count.getOrDefault(x,0)+1);
        }
        
        List<List<Integer>> freq = new ArrayList<>();

        for(int i=0; i < nums.length+1; i++){
            freq.add(i, new ArrayList<>());
        }

        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            freq.get(entry.getValue()).add(entry.getKey());
        }
        
        int[] res = new int[k];
        int index = 0;
        for(int i = freq.size()-1; i > 0 && index < k; i--){
            for(int n : freq.get(i)){
                res[index++] = n;
                if(index == k){
                    return res;
                }
            }
        }
        return res;
    }
}
