class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        count = 0
        
        zc = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                zc += 1
            else:
                count += zc * (zc + 1) // 2
                zc = 0
        
        return count + zc * (zc + 1) // 2