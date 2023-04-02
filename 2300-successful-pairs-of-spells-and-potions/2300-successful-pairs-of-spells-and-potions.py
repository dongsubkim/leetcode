class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()
        ans = []
        
        m = len(potions)
        maxPo = potions[m-1]
        
        for spell in spells:
            minPo = (success + spell - 1) // spell
            if minPo > maxPo:
                ans.append(0)
                continue
            ind = bisect.bisect_left(potions, minPo)
            ans.append(m - ind)
    
        return ans