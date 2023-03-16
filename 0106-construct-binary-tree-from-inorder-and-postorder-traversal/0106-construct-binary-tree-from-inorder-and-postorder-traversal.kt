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
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        // null
        if (inorder.isEmpty()) return null
        
        // leaf
        if (inorder.size == 1) return TreeNode(inorder[0])
        
        
        // inorder : left -> value -> right
        // postorder : left -> right -> value
        // find center
        val root = postorder.last()
        // split left, right from inorder
        val rootIndex = inorder.indexOf(root)
        val leftInorder = inorder.take(rootIndex).toIntArray()
        val leftPostorder = postorder.take(rootIndex).toIntArray()
        
        val rightInorder = inorder.drop(rootIndex + 1).toIntArray()
        val rightPostorder = postorder.slice(leftInorder.size .. (postorder.size - 2)).toIntArray()
        
        return TreeNode(root).apply {
            left = buildTree(leftInorder, leftPostorder)
            right = buildTree(rightInorder, rightPostorder)
        }

    }
}