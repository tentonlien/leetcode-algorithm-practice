import common.ListNode;

public class LeetCode61 {
    private ListNode[] getLast2Nodes(ListNode head) {
        ListNode[] nodes = new ListNode[2];
        ListNode first = head;
        ListNode second = head.next;
        while (second.next != null) {
            first = second;
            second = second.next;
        }
        nodes[0] = first;
        nodes[1] = second;
        return nodes;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len ++;
            cur = cur.next;
        }
        for (int i = 0; i < k % len; i ++) {
            ListNode[] arr = getLast2Nodes(head);
            ListNode beforeTail = arr[0];
            ListNode tail = arr[1];
            beforeTail.next = null;
            tail.next = head;
            head = tail;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode61().rotateRight(new ListNode(0, new ListNode(1, new ListNode(2))), 4));
    }
}
