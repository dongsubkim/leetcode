class Solution {
    fun getSmallestString(n: Int, k: Int): String {
        val ans = IntArray(n)
        var remain = k - n
        var index = n - 1

        while (remain > 0) {
            if (remain >= 25) {
                ans[index] += 25
                remain -= 25
                index -= 1
            } else {
                ans[index] += remain
                remain = 0
            }
        }

        return ans.map {
            'a' + it
        }.joinToString("")
    }
}