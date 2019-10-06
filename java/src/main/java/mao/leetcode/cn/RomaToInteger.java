package mao.leetcode.cn;

import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/roman-to-integer/
public class RomaToInteger {
	public static void main(String[] args) {
		Solution s = new RomaToInteger().new Solution();
		System.out.println(s.romanToInt("MCMXCIV"));
	}

	class Solution {
		private final Map<Character, Integer> m = new HashMap<Character, Integer>(){
			{
				put('I', 1);
				put('V', 5);
				put('X', 10);
				put('L', 50);
				put('C', 100);
				put('D', 500);
				put('M', 1000);
			}
		};
		
	    public int romanToInt(String s) {
	        char[] chars = s.toCharArray();
	        int n = chars.length;
	        
	        if (n == 0) {
	        	return 0;
	        }
	        
	        int r = 0;
	        char c, pc;
	        for (int i = n - 1; i >= 0; i--) {
	        	c = chars[i];
	        	r = r + m.get(c);
	        	if (i == 0) {
	        		break;
	        	}
	        	
	        	pc = chars[i-1];
	        	if ( c == 'V' || c == 'X' ) {
	        		if (pc == 'I') {
	        			r = r - m.get(pc);
	        			i --;
	        		}
	        	} else if (c == 'L' || c == 'C') {
	        		if (pc == 'X') {
	        			r = r - m.get(pc);
	        			i --;
	        		}
	        	} else if (c == 'D' || c == 'M') {
	        		if (pc == 'C') {
	        			r = r - m.get(pc);
	        			i --;
	        		}
	        	} else {
	        		//
	        	}
	        }
	        return r;
	    }
	}
	
}

