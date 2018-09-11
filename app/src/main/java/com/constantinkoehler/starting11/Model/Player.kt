package com.constantinkoehler.starting11.Model

data class Statistic(val k : String, val v: Double){
    var statKey : String = k
    var statVal : Double = v

    override fun toString(): String {
        return "$statVal $statKey"
    }
}

open class Player(val name: String) {
    var mainStatistic = Statistic("",0.0)
    var secondStatistic = Statistic("",0.0)

    open fun simpleDescription() =
            "Player's Name: $name"
}

class Forward(val goalsScores: Double, val assists: Double, name: String) : Player(name) {
    init {
        mainStatistic = Statistic("Goals", goalsScores)
        secondStatistic = Statistic("Assists",assists)
    }

    override fun simpleDescription(): String {
        return "$name: ${mainStatistic}, ${secondStatistic}"
    }
}

class Midfielder(val goalsScores: Double, val assists: Double, name: String) : Player(name) {
    init {
        mainStatistic = Statistic("Goals", goalsScores)
        secondStatistic = Statistic("Assists",assists)
    }

    override fun simpleDescription(): String {
        return "$name: ${mainStatistic}, ${secondStatistic}"
    }
}



