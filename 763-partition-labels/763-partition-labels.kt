import kotlin.math.max


class Solution {
    fun partitionLabels(s: String): List<Int> {
        val lastIndex = mutableListOf<Int>()
        for (i in 0..26) {
            lastIndex.add(-1)
        }
        s.forEachIndexed { index, c ->
            lastIndex[c - 'a'] = index
        }
        val answer = mutableListOf<Int>()
        var index = 0
        var anchor = 0
        for (i in s.indices) {
            index = max(index, lastIndex[s[i] - 'a'])
            if (i == index) {
                answer.add(i - anchor + 1)
                anchor = i + 1
            }
        }
        return answer.toList()
    }
}