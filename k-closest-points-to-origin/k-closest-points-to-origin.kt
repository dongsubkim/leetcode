class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        return points.sortedBy {
            it[0]*it[0] + it[1]*it[1]
        }.take(k).toTypedArray()
    }
}
