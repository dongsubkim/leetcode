class Solution {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {

        val graph = buildGraph(equations, values)
        
        val result = DoubleArray(queries.size)
        
        queries.forEachIndexed { index, query -> 
            result[index] = getValue(graph, query[0]!!, query[1]!!, mutableSetOf<String>())
        }
        
        return result   
    }
}

fun getValue(
    graph: Map<String, Map<String, Double>>,
    start: String,
    end: String,
    visited: MutableSet<String>
): Double {
    if (!graph.containsKey(start) || !graph.containsKey(end)) {
        return -1.0
    }
    
    if (graph[start]!![end] != null) {
        return graph[start]!![end]!!
    }
    
    visited.add(start)
    graph[start]!!.filter { it.key !in visited }.forEach { 
        val weight = getValue(graph, it.key, end, visited)
        if (weight > -1.0) {
            return weight * it.value
        }
    }

    return -1.0
}


fun buildGraph(
    equations: List<List<String>>,
    values: DoubleArray
): Map<String, Map<String, Double>> {
    val graph = mutableMapOf<String, MutableMap<String, Double>>()
    
    equations.forEachIndexed { index, eq -> 
        val num = eq[0]!!
        val den = eq[1]!!
        
        if (!graph.containsKey(num)) {
            graph[num] = mutableMapOf<String, Double>()
        }
        graph[num]!![den] = values[index]
        
        if (!graph.containsKey(den)) {
            graph[den] = mutableMapOf<String, Double>()
        }
        graph[den]!![num] = 1/values[index]
    }
    
    return graph
}