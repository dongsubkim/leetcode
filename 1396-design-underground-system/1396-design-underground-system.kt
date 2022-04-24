class UndergroundSystem() {
    
    private val customers = mutableMapOf<Int, Pair<String, Int>>()
    
    private val endStations = mutableMapOf<String, MutableMap<String, Pair<Int, Int>>>()

    fun checkIn(id: Int, stationName: String, t: Int) {
        customers.put(id, Pair(stationName, t))
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val customerIn = customers[id]!!
        if (!endStations.containsKey(stationName)) {
            endStations[stationName] = mutableMapOf<String, Pair<Int, Int>>()
        }
        val endStation = endStations[stationName]!!
        
        if (!endStation.containsKey(customerIn.first)) {
            endStation[customerIn.first] = Pair(1, t - customerIn.second)
        } else {
            val p = endStation[customerIn.first]!!
            endStation[customerIn.first] = Pair(p.first + 1, p.second + t - customerIn.second) 
        }

    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        val p = endStations[endStation]!![startStation]!!
        return 1.0 * p.second / p.first
    }

}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * var obj = UndergroundSystem()
 * obj.checkIn(id,stationName,t)
 * obj.checkOut(id,stationName,t)
 * var param_3 = obj.getAverageTime(startStation,endStation)
 */