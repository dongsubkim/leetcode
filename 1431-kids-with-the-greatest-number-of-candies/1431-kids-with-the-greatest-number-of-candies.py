class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        maxCandy = max(candies)
        ans = []
        for candy in candies:
            if candy+extraCandies >= maxCandy:
                ans.append(True)
            else:
                ans.append(False)
        return ans