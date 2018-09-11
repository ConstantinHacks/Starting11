package com.constantinkoehler.starting11.Model

import java.io.Serializable

data class Statistic(val k : String, val v: Double){
    var statKey : String = k
    var statVal : Double = v

    override fun toString(): String {
        return "$statVal $statKey"
    }
}

open class Player(val name: String,val number: Int) : Serializable {
    var mainStatistic = Statistic("",0.0)
    var secondStatistic = Statistic("",0.0)

    open fun simpleDescription() =
            "No Player Information"
}

class Forward(val goalsScores: Double, val assists: Double, name: String, number: Int) : Player(name,number) {
    init {
        mainStatistic = Statistic("Goals", goalsScores)
        secondStatistic = Statistic("Assists",assists)
    }

    override fun simpleDescription(): String {
        return "$name: ${mainStatistic}, ${secondStatistic}"
    }
}

class Midfielder(val goalsScores: Double, val assists: Double, name: String, number: Int) : Player(name,number) {
    init {
        mainStatistic = Statistic("Goals", goalsScores)
        secondStatistic = Statistic("Assists",assists)
    }

    override fun simpleDescription(): String {
        return "$name: ${mainStatistic}, ${secondStatistic}"
    }
}



