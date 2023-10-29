class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length ==0 || k==0 ) return false;

        HashMap<Integer, Integer> numberToIndex = new HashMap<>();
        for (int i = 0 ; i< nums.length; i++) {
            Integer index = numberToIndex.get(nums[i]);
            if (index != null && i - index <= k) {
                return true;
            } else if (index == null) {
                numberToIndex.put(nums[i], i);
            } else numberToIndex.replace(nums[i], i);
        }
        return false;
    }
}