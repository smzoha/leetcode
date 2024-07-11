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
    public ListNode mergeNodes(ListNode head) {
        ListNode left = head, right = head.next;
        int sum = 0;

        while (right != null) {
            if (right.val > 0) sum += right.val;
            else {
                left.val = sum;
                left.next = right.next;

                left = right.next;
                sum = 0;
            }

            right = right.next;
        }

        return head;
    }
}