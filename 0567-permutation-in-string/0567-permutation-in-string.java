class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;}
        int[] wordOccurrence = new int[26];
        for (int i = 0; i< s1.length()  ; i++) {
            char key = s1.charAt(i);
            wordOccurrence[key-'a']++;
        }
        int[] compareArr = new int[26];
        for (int i =0; i < s1.length() -1 ; i++) {
            compareArr[s2.charAt(i) - 'a'] += 1;
        }
        for (int i=0 ; i<=s2.length()-s1.length(); i++) {
            int j = i + s1.length() - 1;
            compareArr[s2.charAt(j)-'a']++;
            boolean bool = checkPermutation(wordOccurrence, compareArr, s1);
            if (bool) return true;
            compareArr[s2.charAt(i)-'a'] -= 1;
        }
        return false;
    }

    private boolean checkPermutation(int[] wordOccurrence, int[] compareArr, String s1) {
        for (int i = 0 ; i < s1.length() ; i++) {
            char charr = s1.charAt(i);
            if (wordOccurrence[charr-'a'] != compareArr[charr-'a']) return false;
        }
        return true;
    }

}