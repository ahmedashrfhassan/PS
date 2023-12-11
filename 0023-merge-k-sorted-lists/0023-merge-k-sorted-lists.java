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
        public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode mergedLists = lists[0];
        for (int i = 1; i < lists.length; i++) {
            mergedLists = mergeTwoLinkedLists(mergedLists, lists[i]);
        }

        return mergedLists;
    }

    private ListNode mergeTwoLinkedLists(ListNode mergedLists, ListNode list) {
                if (Objects.isNull(mergedLists) && Objects.isNull(list)) return null;
        else if (Objects.isNull(mergedLists)) return list;
        else if (Objects.isNull(list)) return mergedLists;
        ListNode newMergedList = setMergedListHead(mergedLists, list);
        ListNode newListIterator = new ListNode();
        newListIterator.next = newMergedList;
        while (mergedLists != null && list != null) {

            if (mergedLists.val <= list.val) {
                newListIterator.next = mergedLists;
                mergedLists = mergedLists.next;
            } else {
                newListIterator.next = list;
                list = list.next;
            }
            newListIterator = newListIterator.next;
        }
        if (list != null) {
            newListIterator.next = list;
        } else {
            newListIterator.next = mergedLists;
        }
        return newMergedList;
    }

    private ListNode setMergedListHead(ListNode mergedLists, ListNode list) {
        if (mergedLists.val <= list.val) {
            return mergedLists;
        } else {
            return list;
        }
    }

}