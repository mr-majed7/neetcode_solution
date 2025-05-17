#https://leetcode.com/problems/asteroid-collision/description/

class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        st = []
        for a in asteroids:
            if a >=0:
                st.append(a)
            else:
                while st and st[-1] >0 and abs(a) > st[-1]:
                    st.pop()
                if st and abs(a) == st[-1]:
                    st.pop()
                elif len(st) == 0 or st[-1] < 0:
                    st.append(a)
        return st