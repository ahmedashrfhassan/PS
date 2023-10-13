class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0],0);
        for (int i=1 ; i<nums.length ; i++){
            int complementary = target - nums[i]; 
            if (map.containsKey(complementary)) return new int[] {i , map.get(complementary)};
            else map.put(nums[i],i);
        }
        return null;
    }
}