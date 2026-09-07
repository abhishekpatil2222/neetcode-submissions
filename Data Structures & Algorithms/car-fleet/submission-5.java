class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] distSpeed = new int[n][2];
        for(int i=0; i<n; i++){
            distSpeed[i][0] = target - position[i];
            distSpeed[i][1] = speed[i];
        }
        Arrays.sort(distSpeed, (a, b)-> a[0] - b[0]);

        int fleets = 1;
        double fleetTime = (double)(distSpeed[0][0])/distSpeed[0][1];
        for(int i=1; i<n; i++){
            double carTime = (double)(distSpeed[i][0])/distSpeed[i][1];

            if(carTime > fleetTime){
                fleets++;
                fleetTime = carTime;
            }
        }

        return fleets;

    }
}
