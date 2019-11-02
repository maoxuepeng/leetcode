
package mao.leetcode.cn;

import java.math.BigInteger;

//https://leetcode-cn.com/problems/string-to-integer-atoi/
public class AtoI {
    public static void main(String[] args) {
        Solution s = new AtoI().new Solution();
        int val = s.myAtoi("+");
        System.out.println(val);
    }

    class Solution {
        public int myAtoi(String str) {
            if (str == null) {
                return 0;
            }

            str = str.trim();
            if (str.length() == 0) {
                return 0;
            }

            StringBuffer intStringBuffer = new StringBuffer();
            char sign;
            char[] input = str.toCharArray();
            int i = 0;

            sign = input[i];
            if ((sign == '+') || (sign == '-') || Character.isDigit(sign)) {
                intStringBuffer.append(sign);
                while ((++i < input.length) && Character.isDigit(input[i])) {
                    intStringBuffer.append(input[i]);
                }
            } else {
                return 0;
            }

            String intString = intStringBuffer.toString();
            if ("+".equals(intString) || "-".equals(intString)) {
                return 0;
            }

            BigInteger any = new BigInteger(intString);
            if (any.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
                return Integer.MIN_VALUE;
            }
            if (any.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
                return Integer.MAX_VALUE;
            }
            return any.intValue();
        }
    }
}
