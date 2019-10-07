
package mao.leetcode.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BrickWall {
    public static void main(String[] args) {
        Solution s = new BrickWall().new Solution();
        int[][] wallArray = new int[][] {new int[] {1, 2, 2, 1}, new int[] {3, 1, 2}, new int[] {1, 3, 2},
            new int[] {2, 4}, new int[] {3, 1, 2}, new int[] {1, 3, 1, 1}};
        // int[][] wallArray = new int[][] {new int[] {1}, new int[] {1}, new int[] {1}};

        List<List<Integer>> wall = creatWall(wallArray);
        int minumumGoThroughBlocks = s.leastBricks(wall);
        System.out.println(minumumGoThroughBlocks);
    }

    private static List<List<Integer>> creatWall(int[][] is) {
        List<List<Integer>> wall = new ArrayList<List<Integer>>();
        int m = is.length;
        for (int i = 0; i < m; i++) {
            int n = is[i].length;
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                row.add(is[i][j]);
            }
            wall.add(row);
        }
        return wall;
    }

    class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            int minumumGoThroughBlocks = Integer.MAX_VALUE;

            Set<Integer> lineWidthSet = getLineWidthSet(wall);
            Iterator<Integer> it = lineWidthSet.iterator();
            while (it.hasNext()) {
                int width = it.next();
                int goThroughBlocks = 0;
                for (List<Integer> row : wall) {
                    int size = row.size();
                    int wallLen = 0;
                    for (int i = 0; i < size; i++) {
                        if (wallLen < width) {
                            wallLen += row.get(i);
                        }
                        if (wallLen > width) {
                            goThroughBlocks++;
                            break;
                        } else if (wallLen == width) {
                            break;
                        }
                    }
                }
                if (minumumGoThroughBlocks > goThroughBlocks) {
                    minumumGoThroughBlocks = goThroughBlocks;
                }
            }
            return minumumGoThroughBlocks == Integer.MAX_VALUE ? wall.size() : minumumGoThroughBlocks;
        }

        private Set<Integer> getLineWidthSet(List<List<Integer>> wall) {
            Set<Integer> set = new HashSet<Integer>();
            for (List<Integer> row : wall) {
                int size = row.size();
                int width = 0;
                for (int i = 0; i < (size - 1); i++) {
                    width = width + row.get(i);
                    set.add(width);
                }
            }
            return set;
        }
    }
}
