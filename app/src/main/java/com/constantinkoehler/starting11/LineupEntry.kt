package com.constantinkoehler.starting11

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView

class LineupEntry : LinearLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    var numberTextView: TextView
    var nameTextView: TextView

    init {
        LayoutInflater.from(context)
                .inflate(R.layout.player_lineup_entry, this, true)

        numberTextView = findViewById(R.id.playerNumber)
        nameTextView = findViewById(R.id.playerLastName)
    }



}