class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        i = 0
        ans = ""
        while i < len(word1) or i < len(word2):
            if i < len(word1):
                ans += word1[i]
            if i < len(word2):
                ans += word2[i]
            i += 1
        return ans
        