/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

        public boolean hasCycle(ListNode head) {
                    if (head == null) return false;

        Set<ListNode> nodeToIndex = new HashSet<>();
        int index = 0;
        while (head.next != null){
            nodeToIndex.add(head);
            index++;
            if (nodeToIndex.contains(head.next)) return true;
            head = head.next;
        }
        return false;
    }
}