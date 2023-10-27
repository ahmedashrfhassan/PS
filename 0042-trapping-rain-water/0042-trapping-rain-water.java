class Solution {
        public static int trap(int[] height) {
            int trap = 0, pointer_1 = 0, pointer_2 = pointer_1 + 1;
            int tempTrap = 0;
            while (pointer_2 < height.length) {
                if (height[pointer_2] >= height[pointer_1]) {
                    trap += tempTrap;
                    tempTrap = 0;
                    pointer_1 = pointer_2;
                    pointer_2++;
                } else {
                    tempTrap += (height[pointer_1] - height[pointer_2]) * 1;
                    pointer_2++;
                    if (pointer_2 == height.length ) {
                        tempTrap = 0;
                        int loopBreak = pointer_1;
                        pointer_2--;
                        pointer_1 = pointer_2 - 1;
                        while (pointer_1 >= loopBreak) {
                            if (height[pointer_1] >= height[pointer_2]) {
                                trap += tempTrap;
                                tempTrap = 0;
                                pointer_2 = pointer_1;
                                pointer_1--;
                            } else {
                                tempTrap += (height[pointer_2] - height[pointer_1]) * 1;
                                pointer_1--;
                            }
                        }
                        break;
                    }
                }
            }
            return trap;
        }
}