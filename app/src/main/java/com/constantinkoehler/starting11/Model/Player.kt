package com.constantinkoehler.starting11.Model

import java.io.Serializable

data class Statistic(val k : String, val v: Int){
    var statKey : String = k
    var statVal : Int = v

    override fun toString(): String {
        return "$statVal $statKey"
    }
}

open class Player(private val firstName: String, val lastName: String, val number: Int) : Serializable {
    var mainStatistic = Statistic("",0)
    var secondStatistic = Statistic("",0)
    var isInLineUp = false
    val name = "$firstName $lastName"

    override fun toString(): String {
        return "$firstName $lastName: $mainStatistic, $secondStatistic"
    }
}

class Forward(goalsScores: Int, shots: Int, firstName: String, lastName: String, number: Int) : Player(firstName,lastName,number) {
    init {
        mainStatistic = Statistic("Goals", goalsScores)
        secondStatistic = Statistic("Shots",shots)
    }
}

class Midfielder(assists: Int, passesCompleted: Int, firstName: String, lastName: String,number: Int) : Player(firstName,lastName,number) {
    init {
        mainStatistic = Statistic("Assists", assists)
        secondStatistic = Statistic("Passes",passesCompleted)
    }
}

class Defender(tacklesWon: Int, foulsConceded: Int, firstName: String, lastName: String,number: Int) : Player(firstName,lastName,number) {
    init {
        mainStatistic = Statistic("Tackles", tacklesWon)
        secondStatistic = Statistic("Fouls", foulsConceded)
    }
}

class Goalkeeper(saves: Int, cleanSheets: Int, firstName: String, lastName: String,number: Int) : Player(firstName,lastName,number) {
    init {
        mainStatistic = Statistic("Saves", saves)
        secondStatistic = Statistic("Clean Sheets", cleanSheets)
    }
}

