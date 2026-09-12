/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int a = -1, b = -1, c = Integer.MAX_VALUE;
        int d = 1;

        while (head != null && head.next != null && head.next.next != null) {
            int x = head.val;
            int y = head.next.val;
            int z = head.next.next.val;

            if ((y > x && y > z) || (y < x && y < z)) {
                if (a == -1) {
                    a = d;
                } else {
                    c = Math.min(c, d - b);
                }
                b = d;
            }

            d++;
            head = head.next;
        }

        if (a == b) return new int[]{-1, -1};
        return new int[]{c, b - a};
    }
}