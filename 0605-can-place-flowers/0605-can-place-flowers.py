class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        i = 0
        count = 0
        while i < len(flowerbed):
            if count >= n:
                return True
            if i + 1 == len(flowerbed):
                if flowerbed[i] == 0:
                    count += 1
                break
            
            if flowerbed[i] == 1:
                i += 2
            else:
                if flowerbed[i+1] == 0:
                    count += 1
                    i += 2
                else:
                    i += 3
                    
        return count >= n