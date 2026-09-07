class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, HashSet<Integer>> row = new HashMap<>();
        Map<Integer, HashSet<Integer>> col = new HashMap<>();
        Map<String, HashSet<Integer>> square = new HashMap<>();

        for(int r=0; r < 9; r++){
            for(int c=0; c < 9; c++){
                if(board[r][c] == '.') continue;

                String squareKey = (r / 3) + "," + (c / 3);

                if(row.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c] - '0') ||
                   col.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c] - '0') ||
                   square.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c] - '0')){
                    return false;
                   }

                   row.get(r).add(board[r][c] - '0');
                   col.get(c).add(board[r][c] - '0');
                   square.get(squareKey).add(board[r][c] - '0');
            }
        }
        return true;
    }
}
