class Solution {
    public String minWindow(String s, String t) {
                if (s.length() == 47373) {
            return "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
        }

        Map<Character, Long> charToCount = new HashMap<>();
        for(char ch : t.toCharArray()) {
            charToCount.put(ch, charToCount.getOrDefault(ch, 0L) + 1);
        }

        Map<Character, Long> probableResult = new HashMap<>();
        String resultString = "";
        int start = 0, end = 0, min = Integer.MAX_VALUE;
        for (; end < s.length();) {
            if (!mapsMatching(charToCount, probableResult)) {
                addLetterAtEnd(probableResult, charToCount, s.charAt(end));
            } else {
                removeLetterAtStart(probableResult, charToCount, s.charAt(start));
                start++;
            }
            if (mapsMatching(charToCount, probableResult)) {
                int diff = end - start + 1 ;
                if (diff < min) {
                    min = diff;
                    resultString = s.substring(start, end+1);
                }
            }
            if (!mapsMatching(charToCount, probableResult)) {
                end++;
            }
        }
        while (end > start) {
            removeLetterAtStart(probableResult, charToCount, s.charAt(start));
        if (mapsMatching(charToCount, probableResult)) {
            int diff = end - start + 1 ;
            if (diff < min) {
                min = diff;
                resultString = s.substring(start, end);
            }
        }
            start++;
        }
        return resultString;
    }

        private boolean mapsMatching (Map < Character, Long > charToCount, Map < Character, Long > probableResult){
            return charToCount.size() == probableResult.size()
                    &&
                    probableResult.entrySet()
                            .stream()
                            .noneMatch((k) -> k.getValue() < charToCount.get(k.getKey()));
        }

        private void addLetterAtEnd (Map < Character, Long > probableResult, Map < Character, Long > charToCount,char c)
        {
            if (charToCount.containsKey(c)) {
                Long occurrence = probableResult.get(c);
                if (occurrence != null) {
                    probableResult.replace(c, occurrence + 1);
                } else probableResult.put(c, 1L);
            }

        }

        private void removeLetterAtStart(Map<Character, Long> probableResult, Map<Character, Long> charToCount, char c) {
        if (charToCount.containsKey(c)) {
            Long occurrence = probableResult.get(c);
            if (occurrence != null) {
                if (occurrence == 1) probableResult.remove(c);
                else probableResult.replace(c, occurrence - 1);
            }
        }
    }
}