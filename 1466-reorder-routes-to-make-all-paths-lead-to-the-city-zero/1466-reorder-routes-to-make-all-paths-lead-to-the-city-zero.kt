class Solution {
    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        
        var count = 0
        
        val adj = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        
        fun dfs(node: Int, parent: Int) {
            if (!adj.containsKey(node)) {
                return
            }
            
            adj[node]?.forEach { nei ->
                val child = nei.first
                val sign = nei.second
                
                if (child != parent) {
                    count += sign
                    dfs(child, node)
                }
            }
        }
        
        connections.forEach { conn ->
            adj.getOrPut(conn[0]) { mutableListOf<Pair<Int, Int>>() }.add(Pair(conn[1], 1))
            adj.getOrPut(conn[1]) { mutableListOf<Pair<Int, Int>>() }.add(Pair(conn[0], 0))
        }
        
        dfs(0, -1)
        return count
    }
}