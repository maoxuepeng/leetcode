
package mao.leetcode.cn;

import java.util.HashMap;
import java.util.Map;

public class FindJudge {
    public static void main(String[] args) {
        Solution s = new FindJudge().new Solution();
        int trust[][] =
            new int[][] {new int[] {1, 3}, new int[] {1, 4}, new int[] {2, 3}, new int[] {2, 4}, new int[] {4, 3}};
        int judge = s.findJudge(4, trust);
        System.out.println(judge);
    }

    class Solution {
        int judge = -1;

        public int findJudge(int N, int[][] trust) {
            if (N == 1) {
                return 1;
            }
            Map<Integer, Integer> trustMap = new HashMap<Integer, Integer>();

            int rows = trust.length;
            for (int i = 0; i < rows; i++) {
                int truster = trust[i][0];
                int trusted = trust[i][1];

                trustMap.put(truster, -1);

                if (trustMap.containsKey(trusted)) {
                    int trustedCount = trustMap.get(trusted);
                    if (trustedCount != -1) {
                        trustMap.put(trusted, trustedCount + 1);
                    }
                } else {
                    trustMap.put(trusted, 1);
                }
            }

            trustMap.forEach((k, v) -> {
                if (v == (N - 1)) {
                    judge = k;
                }
            });
            return judge;
        }
    }
}
