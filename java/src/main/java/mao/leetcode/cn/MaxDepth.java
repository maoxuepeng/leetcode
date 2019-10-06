/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019年9月22日. All rights reserved.
 */

package mao.leetcode.cn;

//https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
public class MaxDepth {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            return depth(root);
        }

        // 回溯算法
        private int depth(TreeNode root) {

            // 回溯终止条件1
            if (root == null) {
                return 0;
            }
            // 回溯终止条件2
            if ((root.left == null) && (root.right == null)) {
                return 1;
            } else if ((root.left != null) && (root.right == null)) { // 继续回溯（尝试）
                return 1 + depth(root.left);
            } else if ((root.left == null) && (root.right != null)) {
                return 1 + depth(root.right);
            } else {
                return 1 + Math.max(depth(root.left), depth(root.right));
            }
        }
    }
}
