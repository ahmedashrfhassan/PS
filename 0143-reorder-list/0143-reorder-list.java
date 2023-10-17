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
    public void reorderList(ListNode head) {
        if(head.next == null || head.next.next == null) return;
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        list.add(new ListNode(head.val, null));
        while (temp.next != null) {
            list.add(new ListNode(temp.next.val, null));
            temp = temp.next;
        }
        ListNode tempo = head;
        ListNode next = null;
        for (int j = list.size() - 1; j > list.size() / 2; j--) {
            next = tempo.next;
            tempo.next = list.get(j);
            tempo.next.next = next;
            tempo = tempo.next.next;
        }
        if (list.size()%2 ==1) {
            tempo.next = next;
            tempo = tempo.next;
        }
        tempo.next.next = null;

    }
}