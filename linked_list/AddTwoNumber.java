//https://leetcode.com/problems/add-two-numbers/description/

public class AddTwoNumber {
    /**
     * While list 1 has a value or list 2 has a value or carry is greater than 0 we will continue our loop.
     * In the loop we will sum all the values.
     * We will mod the sum to create a new node.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int sum = v1 + v2 + carry;

            carry = sum / 10;
            sum = sum % 10;

            curr.next = new ListNode(sum);

            curr = curr.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return dummy.next;
    }
}
