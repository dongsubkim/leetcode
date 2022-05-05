class MyStack(
    private val q1: MutableList<Int> = mutableListOf<Int>(),
    private val q2: MutableList<Int> = mutableListOf<Int>()
) {

    fun push(x: Int) {
        q2.add(x)
        trans()
    }

    fun pop(): Int {
        return q1.removeAt(0)
    }

    fun top(): Int {
        return q1[0]!!
    }

    fun empty(): Boolean {
        return q1.isEmpty()
    }
    
    private fun trans() {
        while(q1.isNotEmpty()) {
            q2.add(q1.removeAt(0))
        }
        while(q2.isNotEmpty()) {
            q1.add(q2.removeAt(0))
        }
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */
 