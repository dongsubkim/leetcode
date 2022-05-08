class Solution {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val neighbors = mutableListOf<List<Int>>()
        val n = isConnected.size
        isConnected.forEach { arr ->
            val a = arr.toList().mapIndexedNotNull { index, con ->
                if (con == 1) 
                    index
                else 
                    null
            }
            neighbors.add(a)
        }
        
        var answer = 0
        val visited = mutableSetOf<Int>()
        for (i in 0 until n) {
            if (i !in visited) {
                val queue = mutableListOf<Int>()
                queue.add(i)
                
                while (queue.isNotEmpty()) {
                    
                    val curr = queue.removeAt(0)
                    
                    visited.add(curr)
                    
                    queue.addAll(neighbors[curr]?.filter { it !in visited } ?: listOf())
                }
                
                answer += 1
            }
        }
        return answer
    }
}