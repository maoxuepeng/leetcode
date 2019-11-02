
package introduction.to.algorithms;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSequence {
    public static void main(String[] args) {
        String x = "ABCBDAB";
        String y = "BDCABA";
        int m = x.length();
        int n = y.length();
        int c[][] = new int[m + 1][n + 1];
        int b[][] = new int[m + 1][n + 1];

        LongestCommonSequence lcs = new LongestCommonSequence();
        lcs.lcsLength(x, y, c, b);
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(c[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }

        List<String> seqs = lcs.allLCS(c, b, x);
        System.out.println(seqs);
    }

    public List<String> allLCS(int[][] c, int[][] b, String x) {
        List<String> lcsStrings = new ArrayList<String>();
        int i = c.length - 1, j = c[i].length - 1;
        int maxLCSLen = c[i][j];
        int lcsLen = maxLCSLen;
        while ((lcsLen == maxLCSLen) && (i > 0)) {
            StringBuffer lcsString = new StringBuffer();
            constructLCS(b, x, i, j, lcsString);
            lcsStrings.add(lcsString.toString());
            i--;
            lcsLen = c[i][j];
        }

        i = c.length - 1;
        j = c[i].length - 1;
        maxLCSLen = c[i][j];
        lcsLen = maxLCSLen;
        while ((lcsLen == maxLCSLen) && (j > 0)) {
            StringBuffer lcsString = new StringBuffer();
            constructLCS(b, x, i, j, lcsString);
            lcsStrings.add(lcsString.toString());
            j--;
            lcsLen = c[i][j];
        }
        return lcsStrings;
    }

    public void constructLCS(int[][] b, String x, int i, int j, StringBuffer lcs) {
        if ((i == 0) || (j == 0)) {
            return;
        }
        if (b[i][j] == 1) {
            constructLCS(b, x, i - 1, j - 1, lcs);
            lcs.append(String.valueOf(x.charAt(i - 1)));
        } else if (b[i][j] == 2) {
            constructLCS(b, x, i - 1, j, lcs);
        } else {
            constructLCS(b, x, i, j - 1, lcs);
        }
    }

    public void lcsLength(String x, String y, int[][] c, int[][] b) {
        for (int i = 1; i < c.length; i++) {
            for (int j = 1; j < c[i].length; j++) {
                char xi, yj;
                xi = x.charAt(i - 1);
                yj = y.charAt(j - 1);
                if (xi == yj) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 2;
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = 3;
                }
            }
        }

    }
}
