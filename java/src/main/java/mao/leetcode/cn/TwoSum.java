package mao.leetcode.cn;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i, j;
        int size = nums.length;
        for (i = 0; i < size-1; i++) {
            for (j = i+1; j < size; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
