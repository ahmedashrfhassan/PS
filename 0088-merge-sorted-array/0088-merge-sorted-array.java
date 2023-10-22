class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] mergeArr = new int[nums1.length];
            Arrays.fill(mergeArr,0);
            int k=0 , l=0;
            for(int i =0 ; i< mergeArr.length ; i++){
                if(k < m && l < nums2.length){
                    mergeArr[i] = nums1[k] < nums2[l] ? nums1[k++] : nums2[l++];
                } else if (l >= nums2.length) {
                    mergeArr[i] = nums1[k++];
                } else if (k >= m) {
                    mergeArr[i] = nums2[l++];
                }
            }
            for (int i= 0 ; i< nums1.length ; i++){
                nums1[i] = mergeArr[i];
            }

        }
}