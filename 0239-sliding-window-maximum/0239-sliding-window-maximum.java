class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        int left = 0, right = 0, max = 0;
        for (; right < k ; right++) {
            addToDequeue(deque, nums[right]);
            max = deque.getFirst();
        }
        int x = right - 1;
        result[0]= max;
        for (; right < nums.length; right++) {

            //remove from left of queue at left index
            if (nums[left] == deque.getFirst()) {
                deque.pollFirst();
            }
            left++;
            //add to queue from right
            addToDequeue(deque, nums[right]);
            //max is the most left in queue
            max = deque.getFirst();
            result[right-x]= max;
        }
        return result;
    }

    private static void addToDequeue(Deque<Integer> deque, int num) {
        while (deque.size() > 0 && num > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(num);
    }
}