class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        stack = [pushed[0]]
        i, j = 1, 0
        while j < len(popped):
            if not stack:
                if i >= len(pushed):
                    return False
                stack.append(pushed[i])
                i += 1
            elif popped[j] == stack[-1]:
                stack.pop()
                j += 1
            elif i >= len(pushed):
                return False
            else:
                stack.append(pushed[i])
                i += 1
        return len(stack) == 0
        