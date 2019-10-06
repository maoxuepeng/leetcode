package mao.leetcode.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class SingleNumber {
	public static void main(String[] args) {
		Solution s = new SingleNumber().new Solution();
		int n = s.singleNumber(new int[]{2,2,1});
		System.out.println(n);
	}
	class Solution {
	    public int singleNumber(int[] nums) {
	    	IntStream stream1 = Arrays.stream(nums);
	    	IntStream stream2 = Arrays.stream(nums);
	    	IntStream stream3 = stream2.distinct();
	    	return 2*stream3.sum() - stream1.sum();
	    }
	}
	
	class Solution3 {
	    public int singleNumber(int[] nums) {
	    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    	for (int i : nums) {
	    		if (map.containsKey(i)){
	    			map.remove(i);
	    		}else{
	    			map.put(i, i);
	    		}
	    	}
	    	return map.values().iterator().next();
	    }
	}
	
	class Solution2 {
	    public int singleNumber(int[] nums) {
	        int n = nums.length;
	        boolean found = false;
	        for (int i = 0; i < n; i++) {
	        	found  = false;
	        	for (int j = 0; j < n; j++) {
	        		if (nums[i] == nums[j] && i != j) {
	        			found = true;
	        			break;
	        		}
	        	}
	        	if (! found) {
	        		return nums[i];
	        	}
	        }
	        return nums[0];
	    }
	}
}
