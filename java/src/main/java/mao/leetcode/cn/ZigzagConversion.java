
package mao.leetcode.cn;

//https://leetcode-cn.com/problems/zigzag-conversion/
public class ZigzagConversion {
    public static void main(String[] args) {
        Solution s = new ZigzagConversion().new Solution();
        String cs = s.convert("LEETCODEISHIRING", 4);
        System.out.println("LDREOEIIECIHNTSG");
        System.out.println(cs);
    }

    class Solution {
        public String convert(String s, int numRows) {
            if (s == null) {
                return s;
            }

            if (numRows <= 1) {
                return s;
            }

            int len = s.length();
            if (len <= numRows) {
                return s;
            }

            // 矩阵的行
            int m = numRows;

            // 矩阵的列
            int n = 0;

            // 矩阵中斜边的长度
            int z = m - 2;

            // 计算列数量
            while (len > 0) {
                if ((n % (z + 1)) == 0) {
                    len -= numRows;
                } else {
                    len -= 1;
                }
                n++;
            }
            len = s.length();

            // 矩阵保存Z字符在S中的索引位置
            int[][] g = new int[m][n];
            int index;
            int ii = 0;
            int mode;

            // 以列的方式遍历
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    mode = j % (z + 1);
                    // j%(z+1) == 0，矩阵中Z的竖边, index=j*z+m
                    if (mode == 0) {
                        index = ii;
                        ii++;
                    } else {
                        // 矩阵中Z的斜边
                        if (i == (m - 1 - mode)) {
                            // 斜边上的点
                            index = ii;
                            ii++;
                        } else {
                            // 非斜边上的点
                            index = -1;
                        }
                    }
                    g[i][j] = index < len ? index : -1;
                }
            }

            // 以行的方式遍历矩阵，得到转换后的字符
            StringBuffer cs = new StringBuffer();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    index = g[i][j];
                    if (index != -1) {
                        cs.append(s.charAt(index));
                    }
                }
            }
            return cs.toString();
        }
    }
}
