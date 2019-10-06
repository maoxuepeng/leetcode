package mao.leetcode.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinations {
	public static void main(String[] args) {
		Solution s = new LetterCombinations().new Solution();
		List<String> result = s.letterCombinations("234");
		for (String ss : result) {
			System.out.println(ss);
		}
	}
	
	class Solution {
		  private final Map<String, String> phone = new HashMap<String, String>() {{
			  	put("1", "");
			    put("2", "abc");
			    put("3", "def");
			    put("4", "ghi");
			    put("5", "jkl");
			    put("6", "mno");
			    put("7", "pqrs");
			    put("8", "tuv");
			    put("9", "wxyz");
			  }};
		private List<String> result = new ArrayList<String>();
		public List<String> letterCombinations(String digits) {
			
			combination("", digits);
			return result;
		}
		
		private void combination(String combination, String digits) {
			if (digits.length() == 0) {
				result.add(combination);
			} else {
				String letters = phone.get(digits.substring(0,1));
				for (int i = 0; i < letters.length(); i++) {
					String letter = letters.substring(i, i+1);
					combination(combination+letter, digits.substring(1));
				}
			}
		}
	}
	
	//暴力解法：找到当前元素，与已有的数字组合成的字母组合
	class Solution2 {
		private final Map<Character, String[]> numberMapping = new HashMap<Character, String[]>(){{
			put('2', new String[]{"a", "b", "c"});
			put('3', new String[]{"d", "e", "f"});
			put('4', new String[]{"g", "h", "i"});
			put('5', new String[]{"j", "k", "l"});
			put('6', new String[]{"m", "n", "o"});
			put('7', new String[]{"p", "q", "r", "s"});
			put('8', new String[]{"t", "u", "v"});
			put('9', new String[]{"w", "x", "y", "z"});
		}};
		
	    public List<String> letterCombinations(String digits) {
	        char[] ds = digits.toCharArray();
	        int n = ds.length;
	        List<String> result = new ArrayList<String>();
	        List<String> temp = new ArrayList<String>();
	        
	        for (int i = 0; i < n; i++) {
	        	if (!Character.isDigit(ds[i])) {
	        		continue;
	        	}
	        	if (ds[i] == '1' || ds[i] == '0') {
	        		continue;
	        	}
	        	combinate(ds[i], temp, result);
	        }
	        return result;
	    }

		private void combinate(char c, List<String> temp, List<String> result) {
        	if (result.isEmpty()) {
        		//第一个元素与已有的数字（空集）组合
        		String[] ab = numberMapping.get(c);
        		for (String s : ab) {
        			result.add(s);
        		}
        	} else {
        		//第i个元素与已有的数字组合
        		temp.clear();
        		temp.addAll(0, result);
        		result.clear();
        		String[] ab = numberMapping.get(c);
        		for (String s : ab) {
        			for (String ss : temp) {
        				result.add(ss.concat(s));
        			}
        		}
        	}			
		}

	    
	}
}
