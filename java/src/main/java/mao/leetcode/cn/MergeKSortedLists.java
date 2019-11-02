
package mao.leetcode.cn;

import datastruct.ListNode;

//https://leetcode-cn.com/problems/merge-k-sorted-lists/
public class MergeKSortedLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            int n = lists.length;
            if (n == 0) {
                return null;
            }
            if (n == 1) {
                return lists[0];
            }
            ListNode m = lists[0];
            for (int i = 1; i < n; i++) {
                merge(m, lists[i]);
            }
            return m;
        }

        private void merge(ListNode m, ListNode s) {
            ListNode hm = m, hs = s;
            ListNode nm, ns;
            do {
                if (hm.val <= hs.val) {
                    nm = hm.next;
                    hm.next = hs;
                }
                nm = m.next;
                ns = ns.next;
            } while (nm != null)
        }
    }
}
