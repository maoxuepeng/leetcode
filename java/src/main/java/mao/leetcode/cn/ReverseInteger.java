package mao.leetcode.cn;

public class ReverseInteger {
	public static void main(String[] args) {
		Solution s = new ReverseInteger().new Solution();
		System.out.println(s.reverse(2147483647));
	}
	class Solution {
	    public int reverse(int x) {
	    	double r = 0;
	    	int m;
	    	int[] rr = new int[32];
	    	int i = 0;
	    	
	    	while ((x >= 10 || x <= -10) && i < 32) {
	    		m = x % 10;
	    		x = x / 10;
	    		rr[i] = m;
	    		i++;
	    	}
	    	rr[i++] = x;
	    	
	    	for (int j = 0; j < i; j++) {
	    		r = r + rr[j]*Math.pow(10,(i-j-1));
	    		if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
	    			return 0;
	    		}
	    	}
	        return (int)r;
	    }
	}
}
