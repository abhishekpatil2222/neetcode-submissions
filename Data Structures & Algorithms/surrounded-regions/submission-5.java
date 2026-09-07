class Solution {
    int rows, cols;

    int[][] directions = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (board[i][j] == 'O' && !visited[i][j]) {

                    boolean surrounded = dfs_surround(
                        i, j, board, visited
                    );

                    if (surrounded) {
                        fillSurround(i, j, board);
                    }
                }
            }
        }
    }

    public boolean dfs_surround(
        int r,
        int c,
        char[][] board,
        boolean[][] visited
    ) {

        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{r, c});
        visited[r][c] = true;

        boolean surrounded = true;

        while (!stack.isEmpty()) {

            int[] curr = stack.pop();

            int row = curr[0];
            int col = curr[1];

            // If any O touches boundary,
            // the entire region cannot be surrounded.
            if (row == 0 || col == 0 ||
                row == rows - 1 || col == cols - 1) {

                surrounded = false;
            }

            for (int[] dir : directions) {

                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr >= 0 && nr < rows &&
                    nc >= 0 && nc < cols &&
                    board[nr][nc] == 'O' &&
                    !visited[nr][nc]) {

                    visited[nr][nc] = true;
                    stack.push(new int[]{nr, nc});
                }
            }
        }

        return surrounded;
    }

    public void fillSurround(int r, int c, char[][] board) {

        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{r, c});
        board[r][c] = 'X';

        while (!stack.isEmpty()) {

            int[] curr = stack.pop();

            int row = curr[0];
            int col = curr[1];

            for (int[] dir : directions) {

                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr >= 0 && nr < rows &&
                    nc >= 0 && nc < cols &&
                    board[nr][nc] == 'O') {

                    board[nr][nc] = 'X';
                    stack.push(new int[]{nr, nc});
                }
            }
        }
    }
}