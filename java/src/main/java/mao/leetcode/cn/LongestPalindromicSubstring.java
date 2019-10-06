package mao.leetcode.cn;

//https://leetcode-cn.com/problems/longest-palindromic-substring/
/**
 * 1. 先找子串m，m in [1-n]
 * 2. 如果m是回文子串，记录m为最大回文子串max
 * 3. 尝试在子串m+1里找回文子串，找到了则更max=m+1，直到m=n
 * @author mao
 *
 */
public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		Solution s = new LongestPalindromicSubstring().new Solution();
		System.out.println(s.longestPalindrome("aaaa"));
	}
	
	
	class Solution {
	    public String longestPalindrome(String s) {
	    	int n = s.length();
	    	if (n == 0) {
	    		return "";
	    	}
	    	
	        int m = n;
	        while (m <= n) {
	        	for (int i = 0; i <= n-m; i++) {
	        		if (isPalindrome(s, i, i+m)) {
	        			return s.substring(i, i+m);
	        		}
	        	}
	        	m--;
	        }
	        return s.substring(0,1);
	    }

		private boolean isPalindrome(String s, int start, int end) {
			int m = (end-start)/2;
			for (int i = 0; i < m; i++) {
				if (s.charAt(i+start) != s.charAt(end-1-i)) {
					return false;
				}
			}
			return true;
		}
	}
	
	
	class Solution2 {
	    public String longestPalindrome(String s) {
	    	int n = s.length();
	    	if (n == 0) {
	    		return "";
	    	}
	    	
	        int m = n;
	        while (m <= n) {
	        	for (int i = 0; i <= n-m; i++) {
	        		String sub = s.substring(i, i+m);
	        		if (isPalindrome(sub)) {
	        			return sub;
	        		}
	        	}
	        	m--;
	        }
	        return s.substring(0,1);
	    }

		private boolean isPalindrome(String sub) {
			int n = sub.length();
			int m = n/2;
			for (int i = 0; i < m; i++) {
				if (sub.charAt(i) != sub.charAt(n-1-i)) {
					return false;
				}
			}
			return true;
		}
	}
}
