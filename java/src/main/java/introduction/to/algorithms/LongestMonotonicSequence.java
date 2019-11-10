
package introduction.to.algorithms;

/**
 * 长度为n的序列的最长单调递增子序列
 * 
 */
public class LongestMonotonicSequence {
    public static void main(String[] args) {
        int[] input = new int[] {5};
        int n = input.length;
        int[][] output = new int[n][n];
        LongestMonotonicSequence lms = new LongestMonotonicSequence();
        int[] mn = lms.longestMonotonicSequence(input, output);
        int m = mn[0];
        int nn = mn[1];
        System.out.print("longest monotonic sequence of ");
        for (int i : input) {
            System.out.print(i + ",");
        }
        System.out.println(" length is: " + m + ", values are: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < nn; j++) {
                System.out.print(output[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
    }

    /**
     * 返回X的所有最长单调递增序列
     * @param X 序列
     * @param longestSeq 所有最长单调递增子序列
     * @param mn 单调子序列每一行的长度
     * @return 单调子序列行数与列数
     */
    int[] longestMonotonicSequence(int[] X, int[][] longestSeq) {
        int n = X.length;

        // 单调递增序列的长度
        int longestSeqLen = 0;

        // 单调递增子序列数量
        int longestSeqCount = 0;

        // Xi起始的所有单调递增序列长度
        int[] longestPis = new int[n];

        // Xi起始的所有单调递增序列
        int[][] xiPossibilities = new int[n][n];
        // Xi起始的所有单调递增序列个数
        int pb = 0;
        int pi = 0;

        // xiPossibilities 中每一行的长度（单调递增序列的长度）
        int[] piLen = new int[n];
        // xiPossibilities每一行，对应的Xm在X中的起始位置
        int[] xmPos = new int[n];

        for (int i = 0; i < n; i++) {
            pb = 1;
            pi = 0;
            xiPossibilities[pi][0] = X[i];
            piLen[pi] = 1;
            xmPos[pi] = i + 1;

            // 找到xi开头的所有子序列，保存在xiPossibilities中
            while ((pi < pb) && (i < (n - 1))) {
                int p = pb(xiPossibilities, pi, piLen, xmPos, X);
                pb = pb + p;
                pi++;
            }

            System.out.println("possibility sequences of X" + i + "(" + X[i] + ")" + " is " + (pb));
            print(xiPossibilities, pb, piLen);

            // 此时pi为xiPossibilities的实际长度
            int longestSeqXiCount = indexOfMaxValue(piLen, pi, longestPis);
            int longestSeqXiLen = piLen[longestPis[0]];

            if (longestSeqLen < longestSeqXiLen) {
                for (int p = 0; p < longestSeqXiCount; p++) {
                    copy(xiPossibilities[longestPis[p]], longestSeq[p], 0, longestSeqXiLen);
                }
                longestSeqLen = longestSeqXiLen;
                longestSeqCount = longestSeqXiCount;
            } else if (longestSeqLen == longestSeqXiLen) {
                for (int p = 0; p < longestSeqXiCount; p++) {
                    copy(xiPossibilities[longestPis[p]], longestSeq[longestSeqCount + p], 0, longestSeqXiLen);
                }
                longestSeqLen = longestSeqXiLen;
                longestSeqCount += longestSeqXiCount;
            }
        }
        return new int[] {longestSeqCount, longestSeqLen};
    }

    void print(int[][] a, int m, int[] n) {
        for (int i = 0; i < m; i++) {
            int len = n[i];
            for (int j = 0; j < len; j++) {
                System.out.print(a[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
    }

    /** 找长度为len的数字a中的最大值
     * @param a
     * @param len
     * @param values
     * @return 最大值
     */
    private int indexOfMaxValue(int[] a, int len, int[] values) {
        int maxIndex = 0;
        for (int i = 1; i < len; i++) {
            if (a[maxIndex] < a[i]) {
                maxIndex = i;
            }
        }

        int count = 1;
        values[count - 1] = maxIndex;

        for (int i = 0; i < len; i++) {
            if (maxIndex == i) {
                continue;
            }
            if (a[maxIndex] == a[i]) {
                count++;
                values[count - 1] = i;
            }
        }
        return count;
    }

    /** 对X的两个子集：Xi, Xm，找出所有单调递增子序列。Xi为单调递增子序列，Xm为原始序列
     * @param xiPossibilities 保存所有子序列
     * @param pi 第 i 个子序列
     * @param piLen 所有子序列长度列表
     * @param xm Xm在集合X中的起始位置，Xm = X(m, n)
     * @param X 原始集合X
     * @return 找到的单调递增子序列数量
     */
    private int pb(int[][] xiPossibilities, int pi, int[] piLen, int[] xmPos, int[] X) {
        int pb = 0;
        int pl = piLen[pi];
        int base = xiPossibilities[pi][pl - 1];
        int xm = xmPos[pi];

        for (int j = xm; j < X.length; j++) {
            if (X[j] >= base) {
                // 找xm中找相对于基准单调递增序列的一个单调递增序列
                xiPossibilities[pi][pl] = X[j];
                base = X[j];
                pl++;
            } else {
                // 在xiPossibilities[pi]向前找到不大于X[j]的位置，从此位置构造一个新的单调递增序列
                for (int k = pl - 1; k >= 0; k--) {
                    if (xiPossibilities[pi][k] <= X[j]) {
                        pb++;
                        copy(xiPossibilities[pi], xiPossibilities[pi + pb], 0, piLen[pi] - k);
                        piLen[pi + pb] = piLen[pi] - k;
                        xmPos[pi + pb] = j;
                    }
                }
            }
        }
        piLen[pi] = pl;
        return pb;
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
}
