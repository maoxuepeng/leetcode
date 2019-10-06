package mao.leetcode.cn;


public class MaxSubArray {
	public static void main(String[] args) {
		Solution s = new MaxSubArray().new Solution();
		int max = s.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
		System.out.println(max);
	}
	class Solution {
	    public int maxSubArray(int[] nums) {
	        return maxSubArray2(nums);
	    }
	    
	    public int maxSubArray2(int[] nums) {
	    	//已有子串之和
	    	int sum = 0;
	    	
	    	//最大子串值，初始设置为第一个元素
	    	int max = nums[0];
	    	
	    	for (int i:nums) {
	    		//已有子串之和大于0，则继续找最大子串
	    		if (sum > 0) {
	    			sum += i;
	    		} else {
	    			//否则的话，重新找一个子串
	    			sum = i;
	    		}
	    		max = Math.max(max, sum);
	    	}
	    	return max;
	    }
	    public int maxSubArray1(int[] nums) {
	    	int n = nums.length;
	    	int i = 0;
	    	int max = nums[i];
	    	for (; i < n-1; i++) {
	    		int current = nums[i];
	    		for (int j = i+1; j < n; j++) {
	    			current += nums[j];
	    			if (current > max) {
	    				max = current;
	    			}
	    		}
	    	}
	    	return max;
	    }
	}
}
