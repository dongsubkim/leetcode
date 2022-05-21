class Solution {
    
    val cache = mutableMapOf(0 to 0)
    
    fun coinChange(coins: IntArray, amount: Int): Int {        
        coins.forEach { coin -> 
            cache[coin] = 1
        }
        return solve(coins.toList(), amount)
    }
    
    fun solve(coins: List<Int>, amount: Int): Int {
        if (cache.containsKey(amount)) return cache[amount]!!
        
        val minCount = coins.map { coin ->
            if (coin > amount) {
                -1
            } else {
                val sub = solve(coins, amount - coin)
                if (sub == -1) -1
                else sub + 1
            }
        }.filter { it != -1 }.min() ?: -1
        
        cache[amount] = minCount
        return minCount
    }
}
