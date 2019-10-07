
package mao.leetcode.cn;

//https://leetcode-cn.com/problems/maximal-rectangle/
public class MaximalRectangle {
    public static void main(String[] args) {
        Solution s = new MaximalRectangle().new Solution();
        // char[][] matrix = new char[][] {
        // new char[] {'1', '1', '1', '1', '1', '1', '1', '1'},
        // new char[] {'1', '1', '1', '1', '1', '1', '1', '0'},
        // new char[] {'1', '1', '1', '1', '1', '1', '1', '0'},
        // new char[] {'1', '1', '1', '1', '1', '0', '0', '0'},
        // new char[] {'0', '1', '1', '1', '1', '0', '0', '0'}};
        char[][] matrix = new char[][] {new char[] {'1', '0', '1', '0', '0'}, new char[] {'1', '0', '1', '1', '1'},
            new char[] {'1', '1', '1', '1', '1'}, new char[] {'1', '0', '0', '1', '0'}};
        int area = s.maximalRectangle(matrix);
        System.out.println(area);
    }

    class Solution {
        int maxArea = 0;

        public int maximalRectangle(char[][] matrix) {
            int m = matrix.length;
            if (m == 0) {
                return 0;
            }
            int n = matrix[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int width = 1, height = 1;
                    if (matrix[i][j] == '0') {
                        continue;
                    }
                    while ((height < (m - i)) && (matrix[i + height][j] == '1')) {
                        height++;
                    }
                    while ((width < (n - j)) && (matrix[i][j + width] == '1')) {
                        width++;
                    }
                    int area = calcMaxArea(matrix, i, j, height, width);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
            return maxArea;
        }

        private int calcMaxArea(char[][] matrix, int i, int j, int height, int width) {
            int maxWidth = width;
            int maxArea = 0;
            for (int h = 0; h < height; h++) {
                for (int w = 0; w < maxWidth; w++) {
                    if (matrix[i + h][j + w] == '0') {
                        maxWidth = w;
                        break;
                    }
                }
                int area = (maxWidth) * (h + 1);
                if (area > maxArea) {
                    maxArea = area;
                }

            }
            return maxArea == 0 ? height * width : maxArea;
        }
    }
}
