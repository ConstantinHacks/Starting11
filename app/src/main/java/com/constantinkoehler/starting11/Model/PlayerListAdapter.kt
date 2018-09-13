package com.constantinkoehler.starting11.Model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.constantinkoehler.starting11.MAXGOALKEEPERS
import com.constantinkoehler.starting11.MAXONEPOSITION
import com.constantinkoehler.starting11.MAXPLAYERS
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
        val isSelectedCheckBox = rowView.findViewById(R.id.selectedCheckBox) as CheckBox

        val player = getItem(position) as Player

        numberTextView.text = player.number.toString()
        nameTextView.text = player.name

        if (player is Forward){
            positionTextView.text = "Forward"
        } else if (player is Midfielder) {
            positionTextView.text = "Midfield"
        } else if (player is Defender) {
            positionTextView.text = "Defender"
        } else {
            positionTextView.text = "Goalkeeper"
        }

        if(didReachLimitForPosition(player) || didFillLineup()){
            rowView.alpha = 0.3F
        } else {
            rowView.alpha = 1F
        }

        statisticTextView.text = "${player.mainStatistic} & ${player.secondStatistic}"

        isSelectedCheckBox.isChecked = player.isInLineUp

        isSelectedCheckBox.setOnCheckedChangeListener{ _, isChecked ->
            handleClickedPlayer(position,isChecked,rowView)
        }

        return rowView
    }

    private fun tooManyOfOnePositionAlert(context: Context){
        Toast.makeText(context,"Can't field more than $MAXONEPOSITION of this position player",Toast.LENGTH_SHORT).show()
    }

    private fun tooManyPlayers(context: Context){
        Toast.makeText(context,"Can't field more than $MAXPLAYERS players",Toast.LENGTH_SHORT).show()
    }

    private fun handleClickedPlayer(index: Int, isChecked: Boolean, view: View) {
        val selectedPlayer = allPlayers[index]

        var newCheckStatus = isChecked

        //Just Let Them Uncheck a Player
        if (!isChecked) {
            Toast.makeText(view.context, "Removed ${selectedPlayer.name}",
                    Toast.LENGTH_SHORT).show()
        //Make sure we're not at more than 11 players
        } else if (isChecked && didFillLineup()) {
            tooManyPlayers(view.context)
            newCheckStatus = false
        //Check if we're at capacity for a given position
        } else if(didReachLimitForPosition(selectedPlayer)){
            tooManyOfOnePositionAlert(view.context)
            newCheckStatus = false
        }

        if(newCheckStatus){
            Toast.makeText(view.context, "Added ${selectedPlayer.name}",Toast.LENGTH_SHORT).show()
        }

        setPlayerInLineupStatus(index,newCheckStatus)
    }

    private fun setPlayerInLineupStatus(pos: Int, isSelected: Boolean){
        allPlayers[pos].isInLineUp = isSelected
        notifyDataSetChanged()
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

    private fun didFillLineup(): Boolean {
        return allPlayers.filter { it.isInLineUp }.count() >= MAXPLAYERS
    }

    private fun didReachLimitForPosition(playerPos: Player): Boolean {
        when (playerPos) {
            is Goalkeeper -> {
                return allPlayers.filter { it.isInLineUp && it is Goalkeeper }.count() >= MAXGOALKEEPERS
            }
            is Defender -> {
                return allPlayers.filter { it.isInLineUp && it is Defender }.count() >= MAXONEPOSITION
            }
            is Midfielder -> {
                return allPlayers.filter { it.isInLineUp && it is Midfielder }.count() >= MAXONEPOSITION
            }
            is Forward -> {
                return allPlayers.filter { it.isInLineUp && it is Forward }.count() >= MAXONEPOSITION
            }
        }
        return false
    }

}