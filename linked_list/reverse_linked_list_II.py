#https://leetcode.com/problems/reverse-linked-list-ii/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        dummy = ListNode(0,head)
        leftPrev = dummy
        curr = head

        for _ in range(left-1):
            leftPrev = curr
            curr = curr.next
        
        prev = None

        for _ in range(right - left + 1):
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        
        leftPrev.next.next = curr
        leftPrev.next = prev

        return dummy.next

