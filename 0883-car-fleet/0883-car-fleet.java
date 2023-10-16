class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1 ) return 1;
        int numberOfFleets = 1;
        Map<Integer, Double> carToTime = new HashMap<>();
        for (int i=0; i < position.length; i++) {
            int carPosition = position[i];
            carToTime.put(carPosition, (target - carPosition) / (double)speed[i]);
        }
        Arrays.sort(position);
        Double lastCarTime = carToTime.get(position[position.length-1]);
        for (int i = position.length-1; i >= 0 ; i--) {
            Double carSpeed = carToTime.get(position[i]);
            if (carSpeed > lastCarTime) {
                lastCarTime = Math.max(lastCarTime, carSpeed);
                numberOfFleets += 1;
            }
        }
        return numberOfFleets;
    }
}