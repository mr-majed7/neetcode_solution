#https://leetcode.com/problems/open-the-lock/description/

class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        if "0000" in deadends:
            return -1
        
        def child(l):
            res = []
            for i in range(4):
                digit = str((int(l[i]) + 1) % 10)
                res.append(l[:i] + digit + l[i+1:])
                digit = str((int(l[i]) - 1 + 10) % 10)
                res.append(l[:i] + digit + l[i+1:])
            return res

        q = deque()
        q.append(["0000",0])
        visit = set(deadends)

        while q:
            l,t = q.popleft()
            if l == target:
                return t
            for c in child(l):
                if c not in visit:
                    visit.add(c)
                    q.append([c,t+1])
        return -1
