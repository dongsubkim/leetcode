class BrowserHistory(homepage: String) {

    private val backHistory: MutableList<String> = mutableListOf()
    private val forwardHistory: MutableList<String> = mutableListOf()

    init {
        backHistory.add(homepage)
    }

    fun visit(url: String) {
        backHistory.add(url)
        forwardHistory.clear()
    }

    fun back(steps: Int): String {
        for (i in 0 until steps) {
            if (backHistory.size == 1) break
            forwardHistory.add(backHistory.removeAt(backHistory.lastIndex))
        }
        return backHistory.last()
    }

    fun forward(steps: Int): String {
        for (i in 0 until steps) {
            if (forwardHistory.isEmpty()) break
            backHistory.add(forwardHistory.removeAt(forwardHistory.lastIndex))
        }
        return backHistory.last()
    }

}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * var obj = BrowserHistory(homepage)
 * obj.visit(url)
 * var param_2 = obj.back(steps)
 * var param_3 = obj.forward(steps)
 */