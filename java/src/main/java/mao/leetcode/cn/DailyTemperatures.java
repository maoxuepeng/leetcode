/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019年9月30日. All rights reserved.
 */

package mao.leetcode.cn;

//https://leetcode-cn.com/problems/daily-temperatures/
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
        Solution s = new DailyTemperatures().new Solution();
        int[] result = s.dailyTemperatures(temperatures);
        for (int i : result) {
            System.out.println(i);
        }
    }

    class Solution {
        public int[] dailyTemperatures(int[] T) {
            int n = T.length;
            if ((n <= 0) || (n > 30000)) {
                return new int[] {};
            }
            int[] result = new int[n];
            for (int i = 0; i < (n - 1); i++) {
                int j = i + 1;
                while (j < n) {
                    if (T[j] > T[i]) {
                        result[i] = j - i;
                        break;
                    }
                    j++;
                }
            }
            return result;
        }
    }
}
