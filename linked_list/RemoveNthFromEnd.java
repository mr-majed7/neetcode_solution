//https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

public class RemoveNthFromEnd {
    /**
     * We can use two pointers approach.
     * We will have a left node and right node.
     * We will get our right node to be n node front of the left
     * In that way in the second iteration when our right pointer is at null left pointer will be at the node that
     * we have to remove.
     * We can add a dummy node before head and initialize left node at that point.
     * In this way left node will be one node before the nth node from the end.
     * It will help with do the removing operation.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0, head);
        ListNode left = node;
        ListNode right = head;

        while (n > 0) {
            right = right.next;
            n--;
        }

        while (right != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;
        return node.next;
    }
}
