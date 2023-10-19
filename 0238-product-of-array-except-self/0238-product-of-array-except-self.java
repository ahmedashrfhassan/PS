class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] rightProduct = new int[nums.length];
        rightProduct[nums.length - 1] = 1;
        int[] leftProduct = new int[nums.length];
        leftProduct[0] = 1;
        for (int i = nums.length-2 ; i >= 0 ; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }
        for (int i = 1 ; i < nums.length ; i++) {
                leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
                nums[i-1] = rightProduct[i-1] * leftProduct[i-1];
        }
        nums[nums.length-1] = leftProduct[nums.length-1] * rightProduct[nums.length-1];

        return nums;
    }

}