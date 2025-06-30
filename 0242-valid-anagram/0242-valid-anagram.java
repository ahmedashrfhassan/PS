class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()){ 
            icreaseCharOccurrence(map, c);
        }
        for (Character c : t.toCharArray()){
            var value = map.get(c);
            if (value == null) return false;
            else if (value == 1) map.remove(c);
            else map.put(c, value-1);
        }
        return map.isEmpty();
    }
    
    private void icreaseCharOccurrence(Map<Character, Integer> map, Character c){
        map.compute(c, (k,v)-> v==null? 1 : v + 1);
    }
}
