class Solution {
   public static int reverse(int x) {
        if (x < 0) return -1 * reverseString(Long.toString(-1*(long)x));
        else if (x > 0) return reverseString(Long.toString(x));
        else return x;
    }

    public static int reverseString(String word){
        char[] chars = word.toCharArray();
        for (int i= chars.length-1, j = 0 ; i>j ; i-- , j++){
            char temp = chars[j];
            chars[j] = chars[i];
            chars[i] = temp;
        }
        long x = Long.parseLong(new String(chars));
        return  x>Integer.MAX_VALUE?0:(int) x;
    }
}