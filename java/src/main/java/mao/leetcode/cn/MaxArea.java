
package mao.leetcode.cn;

//https://leetcode-cn.com/problems/container-with-most-water/
public class MaxArea {
    public static void main(String[] args) {
        Solution s = new MaxArea().new Solution();
        // int[] height = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height = new int[] {1, 1};
        int maxArea = s.maxArea(height);
        System.out.println(maxArea);
    }

    class Solution {
        public int maxArea(int[] height) {
            int max = 0;
            int x = 0, y = 0;
            int n = height.length;
            for (int i = 0; i < (n - 1); i++) {
                for (int j = i + 1; j < n; j++) {
                    x = j - i;
                    y = Math.min(height[i], height[j]);
                    if ((x * y) > max) {
                        max = x * y;
                    }
                }
            }
            return max;
        }
    }
}
