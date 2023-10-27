class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0, pointer_1 = 0, pointer_2 = height.length - 1;
        while(pointer_1 < pointer_2) {
            int containerHeight = Math.min(height[pointer_1], height[pointer_2]);
            int containerWidth = pointer_2 - pointer_1;
            int area = containerHeight * containerWidth;
            maxArea = Math.max(maxArea, area);
            if (height[pointer_2] <= height[pointer_1]) {
                pointer_2--;
            } else {
                pointer_1++;
            }
        }
        return maxArea;
    }
}