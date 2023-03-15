/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun isCompleteTree(root: TreeNode?): Boolean {
        val queue = mutableListOf<TreeNode?>(root)

        while (queue.isNotEmpty()) {
            val node: TreeNode? = queue.removeAt(0)
            if (node == null) {
                return !queue.any { it != null }
            } else {
                queue.add(node?.left)
                queue.add(node?.right) 
            }
        }
        return true
    }
}