class Solution {
    public int largestRectangleArea(int[] heights) {

    //     int[] minRightIndex = new int[heights.length];
    //     int[] minLeftIndex = new int[heights.length];

    //     minLeftIndex[0] = 0;

    //     minRightIndex[heights.length - 1] = heights.length;

    //     for (int i = heights.length-2; i >= 0 ; i--) {
    //         for (int j=i+1; j< heights.length ; j++) {
    //             if (heights[j] >= heights[i]) {
    //                 if (j == heights.length-1) minRightIndex[i] = j+1;
    //             } else {
    //                 minRightIndex[i] = j;
    //                 break;
    //             }
    //         }
    //     }

    //     for (int i = 1; i < heights.length ; i++) {
    //         for (int j=i-1; j >= 0 ; j--) {
    //             if (heights[j] >= heights[i]) {
    //                 if (j == 0) minLeftIndex[i] = j;
    //             } else {
    //                 minLeftIndex[i] = j +1  ;
    //                 break;
    //             }
    //         }
    //     }
    //     int maxArea = 0;
    //     for (int i = 0; i < heights.length ; i++) {
    //         int height = heights[i];
    //         height = height * (minRightIndex[i] - minLeftIndex[i]);
    //         maxArea = Math.max(height, maxArea);
    //     }
    //     return maxArea;
    // }
        if (heights == null || heights.length == 0) {
        return 0;
    }
    int[] lessFromLeft = new int[heights.length]; // idx of the first bar the left that is lower than current
    int[] lessFromRight = new int[heights.length]; // idx of the first bar the right that is lower than current
    lessFromRight[heights.length - 1] = heights.length;
    lessFromLeft[0] = -1;

    for (int i = 1; i < heights.length; i++) {
        int p = i - 1;

        while (p >= 0 && heights[p] >= heights[i]) {
            p = lessFromLeft[p];
        }
        lessFromLeft[i] = p;
    }

    for (int i = heights.length - 2; i >= 0; i--) {
        int p = i + 1;

        while (p < heights.length && heights[p] >= heights[i]) {
            p = lessFromRight[p];
        }
        lessFromRight[i] = p;
    }

    int maxArea = 0;
    for (int i = 0; i < heights.length; i++) {
        maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
    }

    return maxArea;
    }
}