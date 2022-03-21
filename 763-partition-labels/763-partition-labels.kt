import kotlin.math.max


class Solution {
    fun partitionLabels(s: String): List<Int> {
        val lastIndex = IntArray(26)
        var index = 0
        var anchor = 0
        s.forEachIndexed { i, c ->
            lastIndex[c - 'a'] = i
        }
        val answer = mutableListOf<Int>()
        s.mapIndexed { i, c ->
            index = max(index, lastIndex[c - 'a'])
            if (i == index) {
                answer.add(i - anchor + 1)
                anchor = i + 1
            } 
        }
        return answer.toList()
    }
}