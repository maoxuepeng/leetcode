package mao.leetcode.cn;

import datastruct.ListNode;

public class MergeTwoLists {
	public static void main(String[] args) {
		Solution s = new MergeTwoLists().new Solution();
		ListNode l1 = ListNode.createListNode(new int[]{1,2,4});
		ListNode l2 = ListNode.createListNode(new int[]{0});
		
		ListNode l3 = s.mergeTwoLists(l1, l2);
		System.out.println(ListNode.listNode2String(l3));
		
	}
	class Solution {
	    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        ListNode head = null ,next = null, current = null;
	        
	        while (l1 != null && l2 != null) {
	        	if (l1.val < l2.val) {
	        		next = l1;
	        		l1 = l1.next;
	        	} else {
	        		next = l2;
	        		l2 = l2.next;
	        	}
	        	if (head == null) {
	        		head = next;
	        		current = head;
	        	} else {
	        		current.next = next;
	        		current = next;
	        	}
	        }
	        if (l1 != null && l2 == null) {
	        	if (head == null) {
	        		head = l1;
	        	} else {
	        		current.next = l1;
	        	}
	        } else if (l1 == null && l2 != null) {
	        	if (head == null) {
	        		head = l2;
	        	} else {
	        		current.next = l2;
	        	}
	        }
	        return head;
	    }
	    
//	    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
//	    	
//	    }
	}
}
