#https://leetcode.com/problems/find-the-town-judge/description/

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        incoming = defaultdict(int)
        outgoing = defaultdict(int)

        for s,d in trust:
            outgoing[s] += 1
            incoming[d] +=1
        
        for  i in range(1,n+1):
            if incoming[i] == n -1 and outgoing[i] == 0:
                return i
        return -1