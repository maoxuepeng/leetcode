
package introduction.to.algorithms;

//最长回文子串
public class LongestPalindromeSequence {

    public static void main(String[] args) {
        String X = "character";
        LongestPalindromeSequence LPS = new LongestPalindromeSequence();
        String[] lps = LPS.lps(X);
        for (String l : lps) {
            System.out.println(l);
        }
    }

    String[] lps(String X) {
        int n = X.length();
        int maxy = n * ((n * (n + 1)) / 2);
        int[][][] Y = new int[n + 1][maxy][n];
        int[] Z = new int[n + 1];
        int[][] LPS = new int[n][n];
        int[] mn = new int[2];

        longestPalindromeSubSequence(n, Y, Z, LPS, mn, X);
        int lpsm = mn[0];
        int lpsn = mn[1];
        String[] lps = new String[lpsm];
        StringBuffer sb = new StringBuffer();
        char c;
        for (int i = 0; i < lpsm; i++) {
            for (int j = 0; j < lpsn; j++) {
                c = X.charAt(LPS[i][j]);
                sb.append(c);
            }
            lps[i] = sb.toString();
            sb.delete(0, sb.length());
        }
        return lps;
    }

    /**
     * 给定长度为n的子串，返回最长的回文子串
     * @param n 输入字符串长度
     * @param Y 运算中间结果，Y[mi] 表示长度为mi的所有子串，Y[mi][yi] 表示长度为mi的第yi个字串在X中的所有位置索引
     * @param Z 运算辅助记忆，Z[mi] 表示长度为mi的字串数量 
     * @param LPS 所有最长回文子串
     * @param mn 对应LPS中所包含的所有最长回文子串的数量与长度
     * @return 最长回文子串长度
     */
    int longestPalindromeSubSequence(int n, int[][][] Y, int[] Z, int[][] LPS, int[] mn, String X) {
        int lpsLen = 0;
        int lpsCount = 0;

        // 求所有子串
        for (int m = 1; m <= n; m++) {
            subSequence(m, n, Y, Z);
        }

        print(n, Y, Z);

        // 在所有子串中找回文字串
        for (int m = 1; m <= n; m++) {
            int lpsCountOfM = findPalindromSubSequence(m, Y, Z, LPS, X);
            if (lpsCountOfM > 0) {
                lpsLen = m;
                lpsCount = lpsCountOfM;
            }
        }

        mn[0] = lpsCount;
        mn[1] = lpsLen;

        return lpsLen;
    }

    /**
     * 返回长度为n的字符串中，长度为m的子串
     * @param m 子串长度
     * @param n 给定字符串长度
     * @param Y 所有长度为m的子串
     * @param Z 所有长度为m的子串数量
     * @return 长度为m的子串数量
     */
    int subSequence(int m, int n, int[][][] Y, int[] Z) {
        if (m == 1) {
            int mi = 0;
            for (; (mi + m) <= n; mi++) {
                Y[m][mi][m - 1] = mi;
            }
            Z[m] = mi;
            return mi;
        } else {
            int y0 = Z[m - 1];// 长度为m-1字串的数量
            int y1i = 0;
            int k = 0;
            int index = 0;
            for (int y0i = 0; y0i < y0; y0i++) {
                k = 1;
                index = k + Y[m - 1][y0i][m - 2];
                while (index < n) {
                    copy(Y[m - 1][y0i], Y[m][y1i], 0, m);
                    Y[m][y1i][m - 1] = index;
                    y1i++;
                    k++;
                    index = k + Y[m - 1][y0i][m - 2];
                }
            }
            Z[m] = y1i;
            return y1i;
        }
    }

    /**
     * 在给定的子串Y中找长度为m的回子串
     * @param m
     * @param Y
     * @param Z
     * @param LPS
     * @return 长度为m的回文子串数量
     */
    int findPalindromSubSequence(int m, int[][][] Y, int[] Z, int[][] LPS, String X) {
        int y = Z[m];
        boolean isPalindromSubSequence = false;
        int palindromeCount = 0;
        for (int yi = 0; yi < y; yi++) {
            isPalindromSubSequence = isPalindromSubSequence(X, Y[m][yi], m);
            if (isPalindromSubSequence) {
                copy(Y[m][yi], LPS[palindromeCount], 0, m);
                palindromeCount++;
            }
        }
        return palindromeCount;
    }

    /**
     * @param x
     * @param is
     * @return
     */
    private boolean isPalindromSubSequence(String X, int[] indexes, int len) {
        int start = 0, end = len - 1;
        while (start < end) {
            if (X.charAt(indexes[start]) != X.charAt(indexes[end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    int copy(int[] src, int[] dest, int from, int to) {
        for (int i = from; i < to; i++) {
            dest[i] = src[i];
        }
        for (int i = to; i < dest.length; i++) {
            dest[i] = 0;
        }
        return to - from;
    }

    void print(int n, int[][][] Y, int[] Z) {
        for (int m = 1; m <= n; m++) {
            int y = Z[m];
            System.out.println("sub sequences of length " + m + " are:");
            for (int yi = 0; yi < y; yi++) {
                System.out.print("[" + yi + "]: ");
                for (int mi = 0; mi < m; mi++) {
                    System.out.print(Y[m][yi][mi]);
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
