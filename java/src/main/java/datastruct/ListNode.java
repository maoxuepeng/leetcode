
package datastruct;

public class ListNode {
    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode createListNode(int[] values) {
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

    public static String listNode2String(ListNode head) {
        StringBuffer sb = new StringBuffer();
        ListNode next = head;
        while (next != null) {
            sb.append(next.val).append("->");
            next = next.next;
        }
        return sb.toString();
    }

}
