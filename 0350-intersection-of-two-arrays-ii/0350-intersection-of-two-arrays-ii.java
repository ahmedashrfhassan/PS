class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = Arrays.stream(nums1).boxed().collect(Collectors.groupingBy(e -> e,Collectors.reducing(0, e -> 1, Integer::sum)));
        List<Integer> intersection = new ArrayList<>();

        for(int i = 0 ; i < (nums2.length)  ; i++){
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                map.put(nums2[i], map.get(nums2[i]) - 1);
                intersection.add(nums2[i]);
            }
        }
            int[] out = new int[intersection.size()];
        for(int i=0; i<intersection.size();i++) {
            out[i] = intersection.get(i);
        }
        return out;
    }
}