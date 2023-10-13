class Solution {
    public int maxProfit(int[] prices) {
        int maxRight = 0;
        int minLeft = Integer.MAX_VALUE;
        int[] maxRights = new int[prices.length];
        int[] minLefts = new int[prices.length];
        int maxDiff = 0;
        for (int j = prices.length - 1 ; j >= 0 ; j--) {
            maxRight = Math.max(maxRight, prices[j]);
            maxRights[j] = maxRight;

        }
        for (int i=0 ; i < prices.length ; i++) {
            minLeft = Math.min(minLeft, prices[i]);
            minLefts[i] = minLeft;
            maxDiff = Math.max(maxDiff, maxRights[i] - minLefts[i]);
        }
        return maxDiff;
    }
}