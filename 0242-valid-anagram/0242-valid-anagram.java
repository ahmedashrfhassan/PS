class Solution {
    public boolean isAnagram(String s, String t) {
            if(s.length() != t.length()){
                return false;
            }else {
                Map<Character, Integer> charToOccurrence = new HashMap<>();
                for (int i =0 ; i< s.length() ; i++) {
                    char currentChar = s.charAt(i);
                    if (charToOccurrence.containsKey(currentChar)) {
                        charToOccurrence.replace(currentChar, (charToOccurrence.get(currentChar) + 1));
                    } else {
                        charToOccurrence.put(currentChar, 1);
                    }
                }
                for (int i =0 ; i< t.length() ; i++) {
                    char currentChar = t.charAt(i);
                    if (charToOccurrence.containsKey(currentChar)) {
                        Integer occurenceOfCurrentChar = charToOccurrence.get(currentChar);
                        if (occurenceOfCurrentChar == 0) return false;
                        charToOccurrence.replace(currentChar, (occurenceOfCurrentChar - 1));
                    } else {
                        return false;
                    }
                }
                boolean empty = !charToOccurrence.values().stream().anyMatch(v -> v >0);
                return empty;
            }
    }
}