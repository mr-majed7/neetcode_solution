//https://leetcode.com/problems/merge-two-sorted-lists/description/

public class MergeTwoSortedList {
    /**
     * We will iterate through both list
     * Add the smaller value at that point to the new list
     * After iteration of both list is completed add the remaining list to the new list
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode curr = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }
        return head.next;
    }
}
