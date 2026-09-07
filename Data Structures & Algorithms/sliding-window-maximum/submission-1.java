class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> MaxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int n = nums.length, idx = 0;
        int[] output = new int[n-k+1];

        for(int i=0; i < n; i++){
            MaxHeap.offer(new int[]{nums[i], i});
            if(i+1 >= k){
                while(MaxHeap.peek()[1] <= i - k){
                    MaxHeap.poll();
                }
                output[idx++] = MaxHeap.peek()[0];
            }
        }
        return output;
    }
}
