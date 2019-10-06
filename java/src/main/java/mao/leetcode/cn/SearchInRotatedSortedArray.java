/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019年9月22日. All rights reserved.
 */

package mao.leetcode.cn;

//https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution s = new SearchInRotatedSortedArray().new Solution();
        // int[] a = new int[] {4, 5, 6, 7, 0, 1, 2};
        // int[] a = new int[] {6, 7, 1, 2, 3, 4, 5};
        int[] a = new int[] {3, 5, 1};

        int target = 3;
        int index = s.search(a, target);
        System.out.println(index);
    }

    class Solution {
        public int search(int[] nums, int target) {
            return search(0, 0, nums.length, nums, target);
        }

        private int search(int base, int start, int end, int[] nums, int target) {
            // 空输入
            if (start >= end) {
                return -1;
            }
            // 找到末尾
            if (start == (end - 1)) {
                return nums[start] == target ? start : -1;
            }
            int middle = base + ((end - start) / 2);
            if (nums[middle] != target) {
                int leftSearch = search(start, start, middle, nums, target);
                int rightSearch = search(middle, middle, end, nums, target);
                return rightSearch > leftSearch ? rightSearch : leftSearch;
            } else {
                return middle;
            }

        }
    }

}
