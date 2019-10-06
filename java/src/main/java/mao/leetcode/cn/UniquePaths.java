/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019年9月23日. All rights reserved.
 */

package mao.leetcode.cn;

//https://leetcode-cn.com/problems/unique-paths/
public class UniquePaths {

    public static void main(String[] args) {
        Solution s = new UniquePaths().new Solution();
        int paths = s.uniquePaths(3, 2);
        System.out.println(paths);
    }

    class Solution {
        int paths = 0;

        public int uniquePaths(int m, int n) {
            int row = n, col = m;
            serachPaths(0, 0, row, col);
            return paths;
        }

        private void serachPaths(int startRow, int startCol, int endRow, int endCol) {
            if ((startRow == (endRow - 1)) && (startCol == (endCol - 1))) {
                paths++;
            } else if ((startRow == (endRow - 1)) && (startCol < (endCol - 1))) {
                serachPaths(startRow, startCol + 1, endRow, endCol);
            } else if ((startRow < (endRow - 1)) && (startCol == (endCol - 1))) {
                serachPaths(startRow + 1, startCol, endRow, endCol);
            } else {
                serachPaths(startRow, startCol + 1, endRow, endCol);
                serachPaths(startRow + 1, startCol, endRow, endCol);
            }
        }
    }
}
