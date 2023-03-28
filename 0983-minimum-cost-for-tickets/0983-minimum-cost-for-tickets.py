from collections import deque
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        last7 = deque([])
        last30 = deque([])
        cost = 0
        for d in days:
            while len(last7) > 0 and last7[0][0] + 7 <= d:
                last7.popleft()
            while len(last30) > 0 and last30[0][0] + 30 <= d:
                last30.popleft()
            last7.append([d, cost + costs[1]])
            last30.append([d, cost + costs[2]])
            cost = min(
                cost + costs[0],
                last7[0][1],
                last30[0][1]
            )
        return cost
