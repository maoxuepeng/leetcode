/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019年9月30日. All rights reserved.
 */

package mao.leetcode.cn;

//https://leetcode-cn.com/problems/longest-palindromic-subsequence/
public class LongestPalindromeSubseq {
    public static void main(String[] args) {
        Solution s = new LongestPalindromeSubseq().new Solution();
        String seq = "abcd";
        int max = s.longestPalindromeSubseq(seq);
        System.out.println(max);
    }

    class Solution {
        public int longestPalindromeSubseq(String s) {
            char[] sequence = s.toCharArray();
            int n = sequence.length;
            int m = n;
            while (m > 0) {
                int start = 0;
                int end = start + m;
                while (end <= n) {
                    if (isPalindrome(sequence, start, end)) {
                        return m;
                    }
                    start++;
                    end = start + m;
                }
                m--;
            }
            return m;
        }

        private boolean isPalindrome(char[] sequence, int start, int end) {
            end = end - 1;
            while (start < end) {
                if (sequence[start] != sequence[end]) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }
}
