package com.constantinkoehler.starting11

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.constantinkoehler.starting11.Model.Forward
import com.constantinkoehler.starting11.Model.Midfielder
import com.constantinkoehler.starting11.Model.allPlayers

class LineupFragment : Fragment() {

    private lateinit var attackers: LinearLayout
    private lateinit var midfielders: LinearLayout
    private lateinit var defenders: LinearLayout
    private lateinit var goalkeepers: LinearLayout


    companion object {

        fun newInstance(): LineupFragment {
            return LineupFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lineup,container,false)

        attackers = view.findViewById(R.id.attackPositions)
        midfielders = view.findViewById(R.id.midfieldPositions)
        defenders = view.findViewById(R.id.defenderPositions)
        goalkeepers = view.findViewById(R.id.goalkeeperPositions)

        allPlayers.filter { it.isInLineUp }.map {
            val player = it
            val playerCell = LineupEntry(context)
            playerCell.nameTextView.text = player.lastName
            playerCell.numberTextView.text = player.number.toString()

            playerCell.setOnClickListener {
                Toast.makeText(context,player.toString(),Toast.LENGTH_LONG).show()
            }

            when (player){
                is Forward -> {
                    attackers.addView(playerCell)
                }
                is Midfielder -> {
                    midfielders.addView(playerCell)
                }
                else -> {
                    print("Unknown Player Type")
                }
            }
        }


        return view
    }


}