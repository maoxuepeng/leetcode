
package mao.leetcode.cn;

//https://leetcode-cn.com/problems/game-of-life/
public class GameOfLife {
    public static void main(String[] args) {
        Solution s = new GameOfLife().new Solution();
        int[][] board =
            new int[][] {new int[] {0, 1, 0}, new int[] {0, 0, 1}, new int[] {1, 1, 1}, new int[] {0, 0, 0}};
        print(board);
        s.gameOfLife(board);
        System.out.println("\n");
        print(board);
    }

    static void print(int[][] board) {
        int m = board.length;
        for (int i = 0; i < m; i++) {
            int n = board[i].length;
            StringBuffer sb = new StringBuffer();
            sb.append('[');
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]).append(',');
            }
            sb.append(']');
            System.out.println(sb.toString());
        }
    }

    class Solution {
        public void gameOfLife(int[][] board) {
            int m = board.length;
            if (m == 0) {
                return;
            }
            int n = board[0].length;

            int[][] updateBoard = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    updateBoard[i][j] = -1;
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    updateBoard(board, updateBoard, m, n, i, j);
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (updateBoard[i][j] != -1) {
                        board[i][j] = updateBoard[i][j];
                    }
                }
            }

        }

        private void updateBoard(int[][] board, int[][] updateBoard, int m, int n, int i, int j) {
            int northWestI = i - 1, northWestJ = j - 1;
            int northI = i - 1, northJ = j;
            int northEastI = i - 1, northEastJ = j + 1;
            int eastI = i, eastJ = j + 1;
            int southEastI = i + 1, southEastJ = j + 1;
            int southI = i + 1, southJ = j;
            int southWestI = i + 1, southWestJ = j - 1;
            int westI = i, westJ = j - 1;

            int[] around = new int[8];
            around[0] = (northWestI >= 0) && (northWestJ >= 0) ? board[northWestI][northWestJ] : -1;
            around[1] = northI >= 0 ? board[northI][northJ] : -1;
            around[2] = (northEastI >= 0) && (northEastJ < n) ? board[northEastI][northEastJ] : -1;
            around[3] = eastJ < n ? board[eastI][eastJ] : -1;
            around[4] = (southEastI < m) && (southEastJ < n) ? board[southEastI][southEastJ] : -1;
            around[5] = southI < m ? board[southI][southJ] : -1;
            around[6] = (southWestI < m) && (southWestJ >= 0) ? board[southWestI][southWestJ] : -1;
            around[7] = westJ >= 0 ? board[westI][westJ] : -1;

            int aroundLiveCells = 0;
            for (int a : around) {
                if (a == 1) {
                    aroundLiveCells++;
                }
            }

            int currentCellState = board[i][j];
            if (currentCellState == 1) {
                if ((aroundLiveCells < 2) || (aroundLiveCells > 3)) {
                    updateBoard[i][j] = 0;
                }
            } else if (currentCellState == 0) {
                if (aroundLiveCells == 3) {
                    updateBoard[i][j] = 1;
                }
            }

        }
    }
}
