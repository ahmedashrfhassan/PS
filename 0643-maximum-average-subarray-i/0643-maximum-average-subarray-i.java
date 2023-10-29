class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1) return nums[0];
        double currentSum = 0;
        double currentAvg;
        double maxAvg = Integer.MIN_VALUE;
        int i = 0;
        for (int j = 0; j< nums.length; j++) {
            while (j-i < k-1) {
                currentSum +=  nums[j++];
            }
//            j++;
            currentSum +=  nums[j];
            currentAvg = currentSum/k;
            maxAvg = Math.max(maxAvg, currentAvg);
            currentSum -= nums[i++];
        }
        return maxAvg;
    }

}