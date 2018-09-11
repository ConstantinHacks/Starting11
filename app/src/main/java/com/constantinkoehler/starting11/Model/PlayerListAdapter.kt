package com.constantinkoehler.starting11.Model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.constantinkoehler.starting11.R

class PlayerListAdapter(context: Context,
                        private val dataSource: ArrayList<Player>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.player_table_entry,parent,false)

        val numberTextView = rowView.findViewById(R.id.number) as TextView
        val nameTextView = rowView.findViewById(R.id.playerName) as TextView
        val positionTextView = rowView.findViewById(R.id.position) as TextView
        val statisticTextView = rowView.findViewById(R.id.playerStats) as TextView

        val player = getItem(position) as Player

        numberTextView.text = player.number.toString()
        nameTextView.text = player.name

        if (player is Forward){
            positionTextView.text = "Forward"
        } else if (player is Midfielder) {
            positionTextView.text = "Midfield"
        }

        statisticTextView.text = "${player.mainStatistic} & ${player.secondStatistic}"

        return rowView
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }

}