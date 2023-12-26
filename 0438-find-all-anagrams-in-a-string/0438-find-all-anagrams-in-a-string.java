class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>(s.length() / p.length());
        Map<Character, Long> charToNumber = p.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                ));
        Map<Character, Long> probableAnagram = new HashMap<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            addLetterToMap(s.charAt(right), probableAnagram);
            if (charToNumber.equals(probableAnagram)) {
                result.add(left);
            }
            if (right - left == p.length()-1) {
                removeLetterFromMap(s.charAt(left), probableAnagram);
                left++;
            }
        }
        return result;
    }

    private void addLetterToMap(char c, Map<Character, Long> probableAnagram) {
        Long number = probableAnagram.get(c);
        if (number == null) {
            probableAnagram.put(c, 1L);
        } else {
            probableAnagram.replace(c, number + 1);
        }
    }
    private void removeLetterFromMap(char c, Map<Character, Long> probableAnagram) {
        Long number = probableAnagram.get(c);
        if (number == 1) {
            probableAnagram.remove(c);
        } else {
            probableAnagram.replace(c, number - 1);
        }
    }}