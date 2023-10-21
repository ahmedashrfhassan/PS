class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        List<Character> ransomNoteChars = ransomNote.chars().mapToObj(c -> (char) c).toList();
        List<Character> magazineChars = magazine.chars().mapToObj(c -> (char) c).toList();
        int[] ransomCharOccurrences = new int[26];
        int[] magazineCharOccurrences = new int[26];
        for(int i = 0 ; i< ransomNote.length() ; i++ ){
            ransomCharOccurrences[(int) ransomNote.charAt(i) - (int) 'a'] += 1;
        }
        for(int i = 0 ; i< magazine.length() ; i++ ){
            magazineCharOccurrences[(int) magazine.charAt(i) - (int) 'a'] += 1;
        }

        for (int i=0 ; i<ransomCharOccurrences.length ; i++) {
            if (ransomCharOccurrences[i] == 0) continue;
            if (ransomCharOccurrences[i] > magazineCharOccurrences[i]) return false;
        }

        return true;

    }
}