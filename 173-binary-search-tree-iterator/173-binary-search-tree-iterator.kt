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
class BSTIterator(root: TreeNode?) {
    
    private val inOrder = travel(root).toMutableList()
    private var pointer = -1

    fun next(): Int {
        return inOrder.removeAt(0)
    }

    fun hasNext(): Boolean {
        return inOrder.isNotEmpty()
    }
    
    fun travel(root: TreeNode?): List<Int> {
        if (root == null) return listOf()
        val left = root?.let { travel(root?.left)}
        val right = root?.let { travel(root?.right)}
        return left + listOfNotNull(root?.`val`) + right
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */