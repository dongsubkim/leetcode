class Trie() {

    private val root: Node = Node()

    fun insert(word: String) {
        var currNode: Node = root

        word.toCharArray().forEach { char ->
            if (currNode.children == null) {
                currNode.children = createNodes()
            }
            currNode = currNode.children!![char.toInd()].apply { onPath = true }
        }
        currNode.end = true
    }

    fun search(word: String): Boolean {
        var currNode: Node? = root
        word.toCharArray().forEach { char ->
            if (currNode?.children == null) { return false }
            currNode = currNode!!.children?.get(char.toInd())!!
        }
        return currNode?.end ?: false
    }

    fun startsWith(prefix: String): Boolean {
        var currNode: Node? = root
        prefix.toCharArray().forEach { char ->
            if (currNode?.children == null) { return false }
            currNode = currNode!!.children?.get(char.toInd())!!
        }
        return currNode?.onPath ?: false
    }

    data class Node(
        var end: Boolean = false,
        var onPath: Boolean = false,
        var children: ArrayList<Node>? = null
    )

    private fun createNodes(): ArrayList<Node> = ArrayList((0 .. 26).map { Node() })

    private fun Char.toInd(): Int = this - 'a'
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */