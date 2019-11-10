
package introduction.to.algorithms;

//最长子串的递归实现
public class LongestCommonSequence2 {
    public static void main(String[] args) {
        String x = "ABCBDAB";
        String y = "BDCABA";
        LongestCommonSequence2 lcs = new LongestCommonSequence2();
        StringBuffer lcsString = new StringBuffer();
        int xlen = x.length();
        int ylen = y.length();
        String[][] mem = new String[xlen + 1][ylen + 1];
        for (int i = 0; i < mem.length; i++) {
            for (int j = 0; j < mem[i].length; j++) {
                mem[i][j] = null;
            }
        }

        int len = lcs.lcsString(x, y, xlen, ylen, mem, lcsString, 0);
        System.out.println(len);
        System.out.println(lcsString);

        for (int i = 0; i < mem.length; i++) {
            for (int j = 0; j < mem[i].length; j++) {
                System.out.print(mem[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
    }

    public int lcsString(String x, String y, int xi, int yj, String[][] mem, StringBuffer lcs, int lcsLen) {
        System.out.println("x=" + x + "\t, xi=" + xi + "\t, y=" + y + "\t, yj=" + yj + "\t, len=" + lcsLen + "\t, lcs="
            + lcs.toString());
        if (mem[xi][yj] != null) {
            return lcsLen;
        }
        if ((x.length() == 0) || (y.length() == 0)) {
            return lcsLen;
        }
        String x0 = x.substring(0, 1);
        String y0 = y.substring(0, 1);
        if (x0.equals(y0)) {
            lcs.append(x0);
            mem[xi][yj] = x0;
            return lcsString(x.substring(1, x.length()), y.substring(1, y.length()), xi - 1, yj - 1, mem, lcs,
                lcsLen + 1);
        } else {
            StringBuffer lcs1 = new StringBuffer();
            StringBuffer lcs2 = new StringBuffer();
            int len1 = lcsString(x.substring(1, x.length()), y, xi - 1, yj, mem, lcs1, lcsLen);
            mem[xi - 1][yj] = lcs1.toString();
            int len2 = lcsString(x, y.substring(1, y.length()), xi, yj - 1, mem, lcs2, lcsLen);
            mem[xi][yj - 1] = lcs2.toString();
            if (len1 >= len2) {
                lcs.append(lcs1);
            } else {
                lcs.append(lcs2);
            }
            return len1 >= len2 ? len1 : len2;
        }
    }
}
