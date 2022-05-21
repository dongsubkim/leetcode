import kotlin.math.min

class Solution {
    
    fun coinChange(coins: IntArray, amount: Int): Int {        
        val dp = IntArray(amount + 1) { i -> 100000 }
        dp[0] = 0
        
        coins.filter { it <=  amount }.forEach { dp[it] = 1 }
        
        (1..amount).forEach { i -> 
            coins.filter { it <= i }.forEach { dp[i] = min(dp[i], dp[i-it] + 1) }
        }
        return if (dp[amount] == 100000) -1 else dp[amount]
    }
}
