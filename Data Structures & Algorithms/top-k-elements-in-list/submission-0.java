class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int x : nums){
            count.put(x, count.getOrDefault(x,0)+1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        for(Map.Entry<Integer, Integer> pair : count.entrySet()){
            heap.offer(new int[]{pair.getValue(), pair.getKey()});

            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] res = new int[k];
        for(int i=0; i < k; i++){
            res[i] = heap.poll()[1];
        }
        return res;
    }
}
