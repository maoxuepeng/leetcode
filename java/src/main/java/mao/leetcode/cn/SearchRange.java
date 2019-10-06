/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019年9月22日. All rights reserved.
 */

package mao.leetcode.cn;

//https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class SearchRange {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int n = nums.length;
            int[] result = new int[] {-1, -1};
            for (int i = 0; i < n; i++) {
                if (nums[i] == target) {
                    result[0] = i;
                    result[1] = i;
                    while ((++i < n) && (nums[i] == target)) {
                        result[1] = i;
                    }

                }
            }
            return result;
        }
    }
}
