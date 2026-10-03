
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = new ListNode(0);
        ListNode b = a;
        int c = 0;

        while (l1 != null || l2 != null || c != 0) {
            int d = c;

            if (l1 != null) {
                d += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                d += l2.val;
                l2 = l2.next;
            }

            c = d / 10;
            b.next = new ListNode(d % 10);
            b = b.next;
        }

        return a.next;
    }
}
