class UndergroundSystem() {
    
    private val customers = mutableMapOf<Int, Pair<String, Int>>()
    
    private val endStations = mutableMapOf<String, MutableMap<String, MutableList<Int>>>()

    fun checkIn(id: Int, stationName: String, t: Int) {
        customers.put(id, Pair(stationName, t))
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val customerIn = customers[id]!!
        if (!endStations.containsKey(stationName)) {
            endStations[stationName] = mutableMapOf<String, MutableList<Int>>()
        }
        val endStation = endStations[stationName]!!
        
        if (!endStation.containsKey(customerIn.first)) {
            endStation[customerIn.first] = mutableListOf<Int>()
        }
        endStation[customerIn.first]!!.add(t - customerIn.second)
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        return endStations[endStation]!![startStation]!!.average()
    }

}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * var obj = UndergroundSystem()
 * obj.checkIn(id,stationName,t)
 * obj.checkOut(id,stationName,t)
 * var param_3 = obj.getAverageTime(startStation,endStation)
 */