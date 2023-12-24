class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0, end = 0, iterator = 0, max = 0;
        int[] charArr = new int[26];
        while (end < s.length()) {
            int i = s.charAt(end) - 'A';
            charArr[i] += 1;
            max = Math.max(max, charArr[i]);
            if (end - start +1 - max > k) {
                charArr[s.charAt(start++) - 'A']--;
            }
            end++;
        }
        return Math.min(s.length(), max + k);
    }
}