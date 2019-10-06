/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019年9月22日. All rights reserved.
 */

package mao.leetcode.cn;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution s = new MoveZeroes().new Solution();
        int[] nums = new int[] {0, 1, 0, 3, 12};
        // int[] nums = new int[] {0};
        s.moveZeroes(nums);
        for (int i : nums) {
            System.out.println(i + " ");
        }
    }

    class Solution {
        public void moveZeroes(int[] nums) {
            int n = nums.length;
            int i;
            int zeroPos = n;
            for (i = 0; i < zeroPos; i++) {
                while ((nums[i] == 0) && (zeroPos > 0)) {
                    move(i, zeroPos, nums);
                    zeroPos--;
                }
            }

        }

        private void move(int i, int zeroPos, int[] nums) {
            int tmp = nums[i];
            int j = i;
            for (; j < (zeroPos - 1); j++) {
                nums[j] = nums[j + 1];
            }
            nums[j] = tmp;
        }
    }
}
