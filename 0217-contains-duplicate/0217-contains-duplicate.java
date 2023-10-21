class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> occurenceSet = new HashSet<>();
        for (int i = 0 ; i < nums.length ; i++){
            if (occurenceSet.add(nums[i]) == false) return true;
        }
        return false;
        
    }
}