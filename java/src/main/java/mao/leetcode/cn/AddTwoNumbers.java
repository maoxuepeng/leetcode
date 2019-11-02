package mao.leetcode.cn;

import datastruct.ListNode;

public class AddTwoNumbers {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(5);
		
		ListNode l = new AddTwoNumbers().addTwoNumbers(l1,l2);
		
		ListNode n = l;
		StringBuffer sb = new StringBuffer();
		while (n != null) {
			sb.append(n.val).append("->");
			n = n.next;
		}
		System.out.println(sb.toString());
	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode next1 = l1;
    	ListNode next2 = l2;
    	
    	ListNode result = null;
    	
    	if (next1 == null) {
    		return next2;
    	}
    	if (next2 == null) {
    		return next1;
    	}
    	
    	int bitmap = 0;
    	int val1, val2, sum = 0;
    	while (next1 != null && next2 != null) {
    		val1 = next1.val;
    		val2 = next2.val;
    		
    		sum = val1 + val2;
    		if (sum >= 10) {
    			sum = sum % 10;
    			bitmap = 1;
    		} else {
    			//do nothing
    		}
    		
    		//set new value
    		next1.val = sum;
    		next2.val = sum;
    		
    		next1 = next1.next;
    		next2 = next2.next;
    		
    		//add 1 to only one list 
    		if (next1 != null && next2 != null) {
    			next1.val = next1.val + bitmap;
    			result = l1;
    		} else if (next1 == null && next2 != null) {
    			//list2 longer than list1
    			next2.val = next2.val + bitmap;
    			mergeLeft(next2);
    			result = l2;
    		} else if (next2 == null && next1 != null) {
    			//list1 longer than list2
    			next1.val = next1.val + bitmap;
    			mergeLeft(next1);
    			result = l1;
    		} else {
    			//list1 and list2 are equal size, check the last number
    			ListNode n = l1;
    			while(n.next != null) {
    				n = n.next;
    			}
    			if (bitmap == 1) {
    				ListNode nn = new ListNode(1);
    				n.next = nn;
    			}
    			result = l1;
    		}
    		
    		bitmap = 0;
    	}
    	
        return result;
    }
    
    private void mergeLeft(ListNode node) {
		while (node.val >= 10) {
			node.val = node.val % 10;
			if (node.next == null) {
				ListNode n = new ListNode(1);
				n.next = null;
				node.next = n;
			} else {
				node.next.val = node.next.val + 1;
			}
			
			node = node.next;
		}
    	
    }
}


