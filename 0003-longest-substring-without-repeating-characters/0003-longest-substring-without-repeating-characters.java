class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int windowStart = 0;
        int windowEnd = 1;
        Set<Character> chars = new HashSet<>();
        int max = 1;
        chars.add(s.charAt(windowStart));
        while (windowEnd < s.length()) {
            if (!chars.add(s.charAt(windowEnd))) {
                chars.remove(s.charAt(windowStart++));
            } else {
                max = Math.max(max, chars.size());
                windowEnd++;
            } 
        }
        return max;
    }
}