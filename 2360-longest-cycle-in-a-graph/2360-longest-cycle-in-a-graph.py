class Solution:
    def __init__(self):
        self.visited = []
        self.answer = -1
        
        
    def longestCycle(self, edges: List[int]) -> int:
        n = len(edges)
        self.visited = [False] * n
        
        for i in range(n):
            if self.visited[i] == False:
                dist = {}
                dist[i] = 1
                self.dfs(i, edges, dist)
                
        return self.answer
                
                
    def dfs(self, node:int, edges: List[int], dist: map):
        self.visited[node] = True
        nextNode = edges[node]
        
        if nextNode != -1 and self.visited[nextNode] == False:
            dist[nextNode] = dist[node] + 1
            self.dfs(nextNode, edges, dist)
        elif nextNode != -1 and nextNode in dist:
            self.answer = max(self.answer, dist[node] - dist[nextNode] + 1)