class Solution {
    public void reverseString(char[] chars) {
        for (int i= chars.length-1, j = 0 ; i>j ; i-- , j++){
            char temp = chars[j];
            chars[j] = chars[i];
            chars[i] = temp;
        }
    }
}