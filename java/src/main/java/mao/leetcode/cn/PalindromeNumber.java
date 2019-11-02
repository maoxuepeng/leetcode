
package mao.leetcode.cn;

public class PalindromeNumber {
    public static void main(String[] args) {
        Solution s = new PalindromeNumber().new Solution();
        boolean isPalindrome = s.isPalindrome(101);
        System.out.println(isPalindrome);
    }

    class Solution {
        public boolean isPalindrome(int x) {
            // x<0
            if (x < 0) {
                return false;
            }

            // x>=10
            int mode[] = new int[64];
            int len = 0;

            int r = x;
            int m = r;
            int i = 0;

            while (r >= 10) {
                m = r;
                while (m >= 10) {
                    m = m / 10;
                    i++;
                }
                mode[i] = m;
                len = Math.max(len, i);
                r = r - (m * (int) Math.pow(10, i));
                i = 0;
            }
            mode[i] = r;
            len++;

            boolean isPalindrome = true;
            int head = 0, tail = len - 1;
            while (head < tail) {
                if (mode[head] != mode[tail]) {
                    isPalindrome = false;
                }
                head++;
                tail--;
            }

            return isPalindrome;
        }
    }
}
