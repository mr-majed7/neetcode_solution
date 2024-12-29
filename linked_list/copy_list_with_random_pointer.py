# https://leetcode.com/problems/copy-list-with-random-pointer/

"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        copy = {None:None}

        curr = head

        while curr:
            curr_c = Node(curr.val)
            copy[curr] = curr_c
            curr = curr.next
        
        curr = head

        while curr:
            curr_c = copy[curr]
            curr_c.next = copy[curr.next]
            curr_c.random = copy[curr.random]
            curr = curr.next
        
        return copy[head]
