package mao.leetcode.cn;

import java.util.Stack;

//https://leetcode-cn.com/problems/valid-parentheses/
/**
 * 栈模型
 * @author mao
 *
 */
public class ValidParentheses {
	public static void main(String[] args) {
		Solution s = new ValidParentheses().new Solution();
		System.out.println(s.isValid("]"));
	}
	
	class Solution {
	    public boolean isValid(String s) {
	    	Stack<Character> stack = new Stack<Character>();
	    	char[] chars = s.toCharArray();
	    	int n = chars.length;
	    	char c, p;
	    	for (int i = 0; i < n; i++) {
	    		c = chars[i];
	    		switch(c) {
	    		case '(':
	    			stack.push(c);
	    			break;
	    		case ')':
	    			if (stack.isEmpty()) {return false;}
	    			p = stack.pop();
	    			if (p != '(') {
	    				stack.push(p);
	    				stack.push(c);
	    			}
	    			break;
	    		case '[':
	    			stack.push(c);
	    			break;
	    		case ']':
	    			if (stack.isEmpty()) {return false;}
	    			p = stack.pop();
	    			if (p != '[') {
	    				stack.push(p);
	    				stack.push(c);
	    			}
	    			break;
	    		case '{':
	    			stack.push(c);
	    			break;
	    		case '}':
	    			if (stack.isEmpty()) {return false;}
	    			p = stack.pop();
	    			if (p != '{') {
	    				stack.push(p);
	    				stack.push(c);
	    			}
	    			break;
	    		case ' ':
	    			break;
	    		default:
	    			return false;
	    		}
	    	}
	    	return stack.isEmpty();
	    }
	}

}
