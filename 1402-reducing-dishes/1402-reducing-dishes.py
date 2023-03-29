class Solution:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        ans = 0
        n = len(satisfaction)
        satisfaction.sort(reverse = True)
        cumSum = []
        if (satisfaction[0] < 0):
            return 0
        
        for i in range(n):
            if i == 0:
                cumSum.append(satisfaction[0])
            else:
                s = cumSum[-1] + satisfaction[i]
                if s < 0:
                    break
                else:
                    cumSum.append(s)
        return sum(cumSum)