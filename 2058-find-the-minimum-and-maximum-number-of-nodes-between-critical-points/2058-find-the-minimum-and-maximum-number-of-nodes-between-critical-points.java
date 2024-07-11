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
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head, curr = head.next, next = head.next.next;
        int pos = 2, firstPoint = 0, prevPoint = 0, minDist = Integer.MAX_VALUE;

        while (next != null) {
            boolean isLocalMinima = prev.val > curr.val && next.val > curr.val;
            boolean isLocalMaxima = curr.val > prev.val && curr.val > next.val;

            if (isLocalMinima || isLocalMaxima) {
                if (firstPoint == 0) firstPoint = pos;
                if (prevPoint > 0) minDist = Math.min(minDist, pos - prevPoint);

                prevPoint = pos;
            }

            pos++;
            prev = prev.next;
            curr = curr.next;
            next = next.next;
        }

        return new int[]{minDist == Integer.MAX_VALUE ? -1 : minDist,
                firstPoint == prevPoint ? -1 : prevPoint - firstPoint};
    }
}