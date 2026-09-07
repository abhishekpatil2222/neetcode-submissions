class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
        int p2 = numbers.length-1;
        while(p1 < p2){
            int sum = numbers[p1] + numbers[p2];

            if(target == sum){
                return new int[]{p1 + 1, p2 + 1};
            }else if(target < sum ){
                p2--;
            }else{
                p1++;
            }
        }
        return new int[1];
    }
}
