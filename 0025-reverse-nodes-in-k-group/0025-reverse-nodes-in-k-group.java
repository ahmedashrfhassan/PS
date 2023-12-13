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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode iterator = head;
        List<Integer> values = new ArrayList<>();
        while (iterator != null) {
            values.add(iterator.val);
            iterator = iterator.next;
        }
        iterator = head;
        int x = values.size() / k;
        int remaining = values.size() % k;
        int constant = k - 1;
        for (int l = constant; l <= (x * k -1); l += k) {
            for (int i = l; i >= l - constant; i--) {
                iterator.val = values.get(i);
                iterator = iterator.next;
            }
        }
        for (int i = 0; i < remaining; i++) {
            iterator.val = values.get(i + (x * k) );
            iterator = iterator.next;
        }
        return head;
    }
}