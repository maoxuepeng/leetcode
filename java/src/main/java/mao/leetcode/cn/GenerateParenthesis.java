package mao.leetcode.cn;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/generate-parentheses/
public class GenerateParenthesis {
	public static void main(String[] args) {
		Solution s = new GenerateParenthesis().new Solution();
		List<String> result = s.generateParenthesis(1);
		for (String r : result) {
			System.out.println(r);
		}
	}
	class Solution {
	    public List<String> generateParenthesis(int n) {
	        List<String> result = new ArrayList<String>();
	        generate(new char[2*n], 0, result);
	        return result;
	    }

		private void generate(char[] cs, int i, List<String> result) {
			if (i == cs.length) {
				if (valid(cs)) {
					result.add(new String(cs));
				}
			} else {
				cs[i] = '(';
				generate(cs, i+1, result);
				cs[i] = ')';
				generate(cs, i+1, result);
			}
		}

		private boolean valid(char[] cs) {
			int valid = 0;
			for (char c : cs) {
				if (c == '(') {
					valid ++;
				} else {
					valid --;
				}
				if (valid < 0) {
					return false;
				}
			}
			return valid == 0;
		}
	}
}
