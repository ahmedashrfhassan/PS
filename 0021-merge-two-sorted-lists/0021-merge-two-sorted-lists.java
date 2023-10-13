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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        ListNode lastNode = null;
        while (list1 != null && list2 != null) {
            if ((Integer) list1.val > (Integer) list2.val) {
                if (result == null) lastNode = result = addNodeToResultListNode(result, list2, lastNode);
                else lastNode = addNodeToResultListNode(result, list2, lastNode);
                list2 = list2.next;
            } else if ((Integer) list2.val > (Integer) list1.val) {
                if (result == null) lastNode = result = addNodeToResultListNode(result, list1, lastNode);
                else lastNode = addNodeToResultListNode(result, list1, lastNode);
                list1 = list1.next;
            } else {
                if (result == null) lastNode = result = addNodeToResultListNode(result, list1, lastNode);
                else lastNode = addNodeToResultListNode(result, list1, lastNode);
                lastNode = addNodeToResultListNode(result, list2, lastNode);
                list1 = list1.next;
                list2 = list2.next;
            }
        }
        if (list1 == null && lastNode != null) {
            lastNode.next = list2;
        } else if (list1 == null) {
            result = list2;
        } else if (lastNode != null) {
            lastNode.next = list1;
        } else result = list1;
        return result;
    }

private ListNode addNodeToResultListNode(ListNode result, ListNode list, ListNode lastNode) {
        if (lastNode == null) return  new ListNode(list.val, null);
        lastNode.next = new ListNode(list.val);
        return lastNode.next;
    }

}