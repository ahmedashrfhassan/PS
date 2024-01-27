class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean found = false;
        int lengthOfArrays = matrix[0].length;
        int start = 0, end = matrix.length - 1;
        while (start <= end) {
            int mid = ((end + start) / 2);
            if (matrix[mid][0] > target) {
                if (end - start <= 1) {
                    if (Arrays.binarySearch(matrix[end], target) > -1) {
                        found = true;
                    }
                    break;
                }
                end = mid;
            } else if (matrix[mid][0] < target) {
                if (end - start <= 1 && target <= matrix[mid][lengthOfArrays - 1]) {
                    if (Arrays.binarySearch(matrix[start], target) > -1) {
                        found = true;
                    }
                    break;
                } else if (end - start <= 1 && target > matrix[mid][lengthOfArrays - 1]) {
                    if (Arrays.binarySearch(matrix[end], target) > -1) {
                        found = true;
                    }
                    break;
                }
                start = mid;
            } else if (matrix[mid][0] == target) {
                found = true;
                break;
            }
        }
        return found;
    }
}