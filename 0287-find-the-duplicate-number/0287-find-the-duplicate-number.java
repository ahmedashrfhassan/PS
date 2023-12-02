class Solution {
    public int findDuplicate(int[] nums) {
        int[] numbers = new int[nums.length];
        for (int i =0; i<nums.length ; i++) {
            if (numbers[nums[i]-1] == 1) return nums[i];
            numbers[nums[i]-1]++;           
        }
        return 0;
    }
}