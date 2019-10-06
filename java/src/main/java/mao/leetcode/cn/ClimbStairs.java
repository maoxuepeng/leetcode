package mao.leetcode.cn;

//https://leetcode-cn.com/problems/climbing-stairs/
public class ClimbStairs {
	public static void main(String[] args) {
		Solution s = new ClimbStairs().new Solution();
		long start = System.currentTimeMillis();
		int ways = s.climbStairs(44);
		long end = System.currentTimeMillis();
		System.out.println(ways);
		System.out.println("time cost: " + (end-start));
	}
	class Solution {
		
	    public int climbStairs(int n) {
	    	int memo[] = new int[n + 1];
	    	return climb(0, n, memo);
	    }

		private int climb(int current, int n, int memo[]) {

			if (current == n ) {
				return 1;
			} else if (current > n ) {
				return 0;

			}
			if (memo[current] > 0) {
				return memo[current];
			}
			
			memo[current] = climb(current + 1, n, memo) + climb(current + 2, n, memo);
			return memo[current];
		}
	}
	class Solution2 {
		int ways = 0;
	    public int climbStairs(int n) {
	    	climb(n);
	        return ways;
	    }

		private void climb(int n) {
			if (n == 0) {
				ways ++;
			} else if (n < 0) {
				return;
			} else {
				climb(n-1);
				climb(n-2);
				
			}
		}
	}
}
