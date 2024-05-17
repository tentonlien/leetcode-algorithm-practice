import common.ListNode;

public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode[] arr = new ListNode[n + 1];
        int i = n;
        int len = 0;
        while (cur != null) {
            if (i == n) {
                i = 0;
            } else {
                i ++;
            }
            arr[i] = cur;
            len ++;
            cur = cur.next;
        }
        if (i == n) {
            cur = arr[0];
        } else {
            cur = arr[i + 1];
        }
        if (cur == null) {
            if (len == n) {
                return head.next;
            } else {
                return null;
            }
        } else {
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode19().removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
        System.out.println(new LeetCode19().removeNthFromEnd(new ListNode(1), 1));
        System.out.println(new LeetCode19().removeNthFromEnd(new ListNode(1, new ListNode(2)), 1));
        System.out.println(new LeetCode19().removeNthFromEnd(new ListNode(1, new ListNode(2)), 2));
    }
}
