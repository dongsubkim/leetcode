class Solution {
    fun find132pattern(nums: IntArray): Boolean {
        var s3 = Int.MIN_VALUE
        val stack = mutableListOf<Int>()
        for (i in (nums.size - 1) downTo 0) {
            if (nums[i] < s3) return true
            while (stack.isNotEmpty() && nums[i] > stack[stack.size - 1]) {
                s3 = stack.removeAt(stack.size - 1)
            }
            stack.add(nums[i])
        }
        return false
    }
    
}