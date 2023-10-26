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
        HashMap<ListNode, Integer> nodeToIndex = new HashMap<>();
        int index = 0;
        while (head.next != null){
            nodeToIndex.put(head, index);
            index++;
            if (nodeToIndex.get(head.next) != null) return true;
            head = head.next;
        }
        return false;
    }
}