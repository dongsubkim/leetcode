from collections import deque

class Solution:
    def __init__(self):
        self.visited = [[False for _ in range(100)] for _ in range(100)]
    
    def closedIsland(self, grid: List[List[int]]) -> int:
        ans = 0
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0 and self.visited[i][j] == False:
                    if self.isClosedIsland(i, j, grid, m, n):
                        ans += 1

        return ans
    
    def isClosedIsland(self, i: int, j: int, grid: List[List[int]], m: int, n: int) -> bool:
        seenBorder = False
        queue = deque([[i, j]])
        while len(queue) > 0:
            curr = queue.popleft()
            x, y = curr[0], curr[1]
            self.visited[x][y] = True
            if x == 0 or x == m - 1 or y == 0 or y + 1 == n:
                seenBorder = True
            for d in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
                xx = x + d[0]
                yy = y + d[1]
                if 0 <= xx and xx < m and 0 <= yy and yy < n and grid[xx][yy] == 0 and self.visited[xx][yy] == False:
                    queue.append([xx, yy])

        return not seenBorder