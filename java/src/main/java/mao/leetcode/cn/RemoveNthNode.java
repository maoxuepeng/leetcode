package mao.leetcode.cn;

import datastruct.ListNode;

//https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
/**
 * 1. 数出链表长度n
 * 2. 倒数m，就是正数n-m+1
 * 3. 遍历链表，找到正数 i == n-m+1 ，删除第i个元素
 * @author mao
 *
 */
public class RemoveNthNode {
	public static void main(String[] args) {
		Solution s = new RemoveNthNode().new Solution();
		ListNode head = s.removeNthFromEnd(createListNode(new int[]{1,2,3,4,5}), 1);
		System.out.println(listNode2String(head));
	}
	private static ListNode createListNode(int[] values) {
		int n = values.length;
		ListNode head = null, cur = null;
		for (int i = 0; i < n; i++) {
			ListNode node = new ListNode(values[i]);
			if (i == 0) {
				head = node;
				cur = head;
			} else {
				cur.next = node;
				cur = node;
			}
		}
		return head;
	}
	private static String listNode2String(ListNode head) {
		StringBuffer sb = new StringBuffer();
		ListNode next = head;
		while(next != null) {
			sb.append(next.val).append("->");
			next = next.next;
		}
		return sb.toString();
	}
	class Solution {
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	        int m = 1;
	        ListNode next = head.next;
	        while (next != null) {
	        	next = next.next;
	        	m++;
	        }
	        
	        //非法
	        if (n > m) {
	        	return head;
	        }
	        //删除第一个
	        if (n == m) {
	        	return head.next;
	        }
	        
	        int i = 1;
	        ListNode cur = head;
	        ListNode pre = cur;
	        next = cur.next;
	        
	        while (next != null) {
	        	if (i == m-n+1) {
	        		pre.next = next;
	        		return head;
	        	}
	        	pre = cur;
	        	cur = next;
	        	next = next.next;
	        	i++;
	        }
	        
	        //删除倒数第一个
	        if (i == m) {
	        	pre.next = next;
	        }
	        return head;
	    }
	}
}
