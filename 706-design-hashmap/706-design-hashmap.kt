class MyHashMap() {

    private val myMap = mutableListOf<Pair<Int, Int>>()
    
    fun put(key: Int, value: Int) {
        remove(key)
        myMap.add(Pair(key, value))
    }

    fun get(key: Int): Int {
        return myMap.firstOrNull { it.first == key }?.second ?: -1
    }

    fun remove(key: Int) {
        myMap.indexOfFirst { it.first == key}.let {
            if (it >= 0) {
                myMap.removeAt(it)
            }
        }
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */