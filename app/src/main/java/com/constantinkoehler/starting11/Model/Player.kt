package com.constantinkoehler.starting11.Model

import java.io.Serializable

data class Statistic(val k : String, val v: Double){
    var statKey : String = k
    var statVal : Double = v

    override fun toString(): String {
        return "$statVal $statKey"
    }
}

open class Player(private val firstName: String, val lastName: String, val number: Int) : Serializable {
    var mainStatistic = Statistic("",0.0)
    var secondStatistic = Statistic("",0.0)
    var isInLineUp = true
    val name = "$firstName $lastName"

    override fun toString(): String {
        return "$firstName $lastName: $mainStatistic, $secondStatistic"
    }
}

class Forward(goalsScores: Double, shots: Double, firstName: String, lastName: String, number: Int) : Player(firstName,lastName,number) {
    init {
        mainStatistic = Statistic("Goals", goalsScores)
        secondStatistic = Statistic("Shots",shots)
    }
}

class Midfielder(assists: Double, passesCompleted: Double, firstName: String, lastName: String,number: Int) : Player(firstName,lastName,number) {
    init {
        mainStatistic = Statistic("Assists", assists)
        secondStatistic = Statistic("Passes",passesCompleted)
    }
}