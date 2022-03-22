import kotlin.math.max

class Solution {
    fun getSmallestString(n: Int, k: Int): String {
        val z = (k - n) / 25
        val x = (k - n) % 25
        if (x > 0) 
            return "a".repeat(max(0, n - z - 1)) + ('a' + x) + "z".repeat(z)
        else 
            return "a".repeat(max(0, n - z)) + "z".repeat(z)
    }
}