
package introduction.to.algorithms;

/**
 * 最长单调递增子序列的递归实现
 */
public class LongestMonotonicSequence2 {
    public static void main(String[] args) {
        LongestMonotonicSequence2 lms2 = new LongestMonotonicSequence2();
        int[] X = new int[] {1, 3, 2, 3, 4, 5};
        int[] lms = new int[X.length];
        int lmsLen = lms2.lms(X, 0, X.length, lms);
        System.out.print("longest monotonic sequence of ");
        for (int i : X) {
            System.out.print(i + ",");
        }
        System.out.println(" length is: " + lmsLen + ", values are: ");
        for (int i = 0; i < lmsLen; i++) {
            System.out.print(lms[i] + ",");
        }

    }

    int lms(int[] X, int startx, int endx, int[] lms, int lmsi) {
        if (endx == startx) {
            lms[lmsi] = X[startx];
            return 1;
        }

        int middlex = ((endx - startx) / 2) + startx;
        System.out.println("startx=" + startx + ", middlex=" + middlex + ", endx=" + endx);
        int[] leftLMS = new int[middlex - startx];
        int[] rightLMS = new int[endx - middlex];
        int leftLMSCount = lms(X, startx, startx + middlex, leftLMS);
        int rightLMSCount = lms(X, startx + middlex, endx, rightLMS);
        int leftLMSLast = leftLMS[leftLMSCount - 1];
        int rightLMSFirst = rightLMS[0];
        if (leftLMSLast <= rightLMSFirst) {
            copy(leftLMS, lms, 0, leftLMSCount);
            copy(rightLMS, lms, leftLMSCount, leftLMSCount + rightLMSCount);
            return leftLMSCount + rightLMSCount;
        } else {
            if (leftLMSCount <= rightLMSCount) {
                copy(rightLMS, lms, 0, rightLMSCount);
                return rightLMSCount;
            } else {
                copy(leftLMS, lms, 0, leftLMSCount);
                return leftLMSCount;
            }
        }
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
