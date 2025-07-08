class Solution {
    public String minWindow(String originalString, String givenString) {
        HashMap<Character, Integer> givenStringMap = new HashMap<>(givenString.length());
        for (Character c : givenString.toCharArray()) {
            givenStringMap.put(c, givenStringMap.getOrDefault(c, 0) + 1);
        }
        String subString = "";
        HashMap<Character, Integer> currentWordMap = new HashMap<>();
        int start = 0, end = 0, minLength = Integer.MAX_VALUE, requiredLength = givenStringMap.size(), formed=0;
        while (end < originalString.length()) {
            char key = originalString.charAt(end);
            currentWordMap.put(key, currentWordMap.getOrDefault(key, 0) + 1);
            if (givenStringMap.containsKey(key) && currentWordMap.get(key).equals(givenStringMap.get(key))) {
                formed++;
            }
            if (requiredLength == formed) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    subString = originalString.substring(start, end + 1);
                }
                while (start <= end && formed == requiredLength) {
                    if (end - start + 1 < minLength) {
                        minLength = end - start + 1;
                        subString = originalString.substring(start, end + 1);
                    }
                    char startKey = originalString.charAt(start);
                    currentWordMap.put(startKey, currentWordMap.get(startKey) - 1);
                    if (currentWordMap.get(startKey) == 0) {
                        currentWordMap.remove(startKey);
                    }
                    if (givenStringMap.containsKey(startKey) && (!currentWordMap.containsKey(startKey)
                            || currentWordMap.get(startKey) < givenStringMap.get(startKey)) ) {
                        formed--;
                    }
                    start++;
                }
            }
            end++;
        }
        return subString;
    }
}