/**
 * @author Tenton Lien
 */
public class LeetCode83 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                sb.append(cur.val + " ");
                cur = cur.next;
            }
            return sb.toString();
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        if (node == null) {
            return null;
        }
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }

        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode83().deleteDuplicates(
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(2)))).toString());

        System.out.println(new LeetCode83().deleteDuplicates(
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(2,
                                                new ListNode(3,
                                                        new ListNode(3)))))).toString());
    }
}
