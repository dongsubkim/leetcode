class Solution:
    def partitionString(self, s: str) -> int:
        ans = 0
        chars = set([])
        for c in s:
            if c in chars:
                chars = set([c])
                ans += 1
            else:
                chars.add(c)
        if len(chars) > 0:
            ans += 1
        return ans