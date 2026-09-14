class Solution {
    public ListNode deleteDuplicates(ListNode x) {
        ListNode y = x;

        while (y != null && y.next != null) {
            if (y.val == y.next.val)
                y.next = y.next.next;
            else
                y = y.next;
        }

        return x;
    }
}