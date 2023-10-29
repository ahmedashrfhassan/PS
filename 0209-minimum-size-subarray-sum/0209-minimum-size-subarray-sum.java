class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        for (int j=0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target && start <= j) {
                minLength = Math.min(minLength, j-start+1);
                sum -= nums[start++];
            }
        }
        return minLength == Integer.MAX_VALUE? 0: minLength;
    }
}
