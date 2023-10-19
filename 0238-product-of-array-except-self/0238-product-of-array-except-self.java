class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] rightProduct = new int[nums.length];
        rightProduct[nums.length - 1] = 1;
        int[] leftProduct = new int[nums.length];
        leftProduct[0] = 1;
        int[] result = new int[nums.length];
        for (int i = nums.length-2 ; i >= 0 ; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }
        for (int i = 0 ; i < nums.length ; i++) {
            if (i==0) result[i] = leftProduct[i] * rightProduct[i];
            else {
                leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
                result[i] = rightProduct[i] * leftProduct[i];
            }
        }
        return result;
    }

}