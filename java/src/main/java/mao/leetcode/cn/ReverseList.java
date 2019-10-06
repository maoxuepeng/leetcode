package mao.leetcode.cn;

//https://leetcode-cn.com/problems/reverse-linked-list/
public class ReverseList {
	public static void main(String[] args) {
		Solution s = new ReverseList().new Solution();
		ListNode list = ListNode.createListNode(new int[]{1});
		ListNode rlist = s.reverseList(list);
		System.out.println(ListNode.listNode2String(rlist));
	}
	class Solution {
		//用三个指针：p 上一个，head 当前，next 下一个来反转
	    public ListNode reverseList(ListNode head) {
	    	if (head == null) {return head;}
	        ListNode next = null, p = null, rh = head, tmp = null;
	        next = head.next;
	        while (next != null) {
	        	//把next.next先存起来
	        	tmp = next.next;
	        	
	        	//反转
	        	rh = next;
	        	rh.next = head;
	        	head.next = p;
	        	
	        	//往后移动
	        	p = head;
	        	head = next;
	        	next = tmp;
	        }
	        return rh;
	    }
	}
}
