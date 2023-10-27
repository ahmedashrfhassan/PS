class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> horizontal = null;
        HashSet<Character> vertical = null;

        for (int i = 0; i < board.length; i++) {
            horizontal = new HashSet<>();
            vertical = new HashSet<>();
            for (int j=0 ; j< board.length; j++){
                char horizontalChar = board[j][i];
                if (horizontalChar != '.' && !horizontal.add(horizontalChar)) {
                    return false;
                }
                char verticalChar = board[i][j];
                if (verticalChar != '.' && !vertical.add(verticalChar)) {
                    return false;
                }
            }
        }


        for (int i = 2 ; i < board.length ; i +=3){
            horizontal = new HashSet<>();
            vertical = new HashSet<>();
            HashSet<Character> third = new HashSet<>();
            for (int j=i-2; j<=i; j++){
                for (int k = 0; k<3 ; k++){
                    char horizontalChar = board[k][j];
                    if (horizontalChar != '.' && !horizontal.add(horizontalChar)) {
                        return false;
                    }
                    char verticalChar = board[k+3][j];
                    if (verticalChar != '.' && !vertical.add(verticalChar)) {
                        return false;
                    }
                    char thirdSetChar = board[k+6][j];
                    if (thirdSetChar != '.' && !third.add(thirdSetChar)) {
                        return false;
                    }

                }
            }
        }

        return true;
    }
}