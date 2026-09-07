class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] output = new int[temperatures.length];
        for(int i=0; i < temperatures.length; i++){
            int days = 0;
            for(int j = i+1; j < temperatures.length; j++){
                days++;
                if(temperatures[j] > temperatures[i]){
                    output[i] = days;
                    break;
                }
                output[i] = 0;
            }
        }
        return output;
    }
}
