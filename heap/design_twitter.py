#https://leetcode.com/problems/design-twitter/description/

class Twitter:

    def __init__(self):
        self.count = 0     
        self.tweets = defaultdict(list)   
        self.follows = defaultdict(set) 

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweets[userId].append([self.count, tweetId])
        self.count -= 1

    def getNewsFeed(self, userId: int) -> List[int]:
        res = []
        heap = []
        
        self.follows[userId].add(userId)
        for fId in self.follows[userId]:
            if fId in self.tweets and self.tweets[fId]:
                idx = len(self.tweets[fId]) - 1
                count, tId = self.tweets[fId][idx]
                heap.append([count, tId, fId, idx - 1])

        heapq.heapify(heap)

        while heap and len(res) < 10:
            count, tId, fId, idx = heapq.heappop(heap)
            res.append(tId)
            if idx >= 0:
                count, tId = self.tweets[fId][idx]
                heapq.heappush(heap, [count, tId, fId, idx - 1])
        return res

    def follow(self, followerId: int, followeeId: int) -> None:
        self.follows[followerId].add(followeeId)       

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followeeId != followerId and followeeId in self.follows[followerId]:
            self.follows[followerId].remove(followeeId)


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)