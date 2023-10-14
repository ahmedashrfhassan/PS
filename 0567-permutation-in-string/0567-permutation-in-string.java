class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;}
        Set<Character> firstWordCharSet = s1.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        Map<Character, Integer> charToOccurrence = new HashMap<>();
        for (int i = 0; i< s1.length() ; i++) {
            Character key = s1.charAt(i);
            charToOccurrence.computeIfPresent(key, (c, integer) -> integer + 1);
            charToOccurrence.putIfAbsent(key, 1);
        }
        for (int i=0 ; i<s2.length(); i++) {
            if (firstWordCharSet.contains(s2.charAt(i))) {
                int indication = confirmItsPermutation(s2, i, s1.length(), charToOccurrence);
                if (indication == i+s1.length()) {
                    return true;
                } else if (indication == -1) {
                    return false;
                } else {
                    i = indication -1;
                }
            }
        }
        return false;
    }

    private int confirmItsPermutation(String s2, int i, int length, Map<Character, Integer> wordMao) {
        Map<Character, Integer> copyMap = new HashMap<>(wordMao);
        for (int j=i; j < i+length ; j++) {
            if (j >= s2.length()) return -1;
            Integer i1Value = copyMap.get(s2.charAt(j));
            if (i1Value == null) return j;
            else if ( i1Value <= 0) return i+1;
            else copyMap.compute(s2.charAt(j), (k, v) -> v - 1);
        }
        return i+length;
    }
}