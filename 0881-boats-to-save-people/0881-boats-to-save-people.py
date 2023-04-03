class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        ans = 0
        
        while len(people) > 1:
            maxWeight = people.pop(len(people)-1)
            spaceLeft = limit - maxWeight
            
            ind = bisect.bisect_left(people, spaceLeft)

            if ind == len(people):
                people.pop(ind - 1)
            elif people[ind] <= spaceLeft:
                people.pop(ind)
            elif ind > 0 and people[ind-1] <= spaceLeft:
                people.pop(ind-1)
            ans += 1
            
        if len(people) > 0:
            ans += 1
        return ans
            
        