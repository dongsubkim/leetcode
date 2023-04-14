class Solution:
    
    
    def __init__(self):
        self.memo = {}
    
    def longestPalindromeSubseq(self, s: str) -> int:
        if s in self.memo:
            return self.memo[s]
        
        if not s:
            return 0
        
        if len(s) == 1:
            self.memo[s] = 1
            return 1
        
        if s[0] == s[-1]:
            self.memo[s] = 2 + self.longestPalindromeSubseq(s[1:-1])
        else:
            self.memo[s] = max(
                self.longestPalindromeSubseq(s[1:]),
                self.longestPalindromeSubseq(s[:-1]),
            )
            
        return self.memo[s]
    
        