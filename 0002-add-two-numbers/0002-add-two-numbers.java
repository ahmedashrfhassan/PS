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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode copy1 = l1;
        ListNode copy2 = l2;
        int remainder = 0;
        while (copy1.next != null && copy2.next != null)
        {
            int sum = (int)copy1.val + (int)copy2.val + remainder;
            copy2.val = copy1.val = sum % 10;
            remainder = sum / 10;
            copy1 = copy1.next;
            copy2 = copy2.next;
        }
        if(copy1 != null && copy2 != null) {
            int sum = (int)copy1.val + (int)copy2.val + remainder;
            copy2.val = copy1.val = sum % 10;
            remainder = sum / 10;
        }
        if(copy1.next != null){
            completeAddition(copy1, remainder);
            return l1;
        } else if (copy2.next != null) {
            completeAddition(copy2, remainder);
            return l2;
        }
        if (remainder > 0) copy2.next = new ListNode(remainder);
        return l2;
    }

    private void completeAddition(ListNode copy1, int remainder2) {
        int remainder = remainder2;
        while (copy1.next != null) {
            copy1 = copy1.next;
            int sum = (int)copy1.val + remainder;
            copy1.val = sum % 10;
            remainder = sum / 10;
        }
                if (copy1 != null && remainder>0) {
            int sum = (int) copy1.val + remainder;
            copy1.next = new ListNode(sum%10);
            remainder = sum / 10;
            copy1 = copy1.next;
        }
        if (remainder>0) copy1.next = new ListNode(remainder);
    }

}