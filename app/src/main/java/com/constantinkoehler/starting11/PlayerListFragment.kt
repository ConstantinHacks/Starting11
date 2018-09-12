package com.constantinkoehler.starting11

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import com.constantinkoehler.starting11.Model.PlayerListAdapter
import com.constantinkoehler.starting11.Model.allPlayers

class PlayerListFragment : Fragment() {

    private lateinit var listView: ListView

    companion object {
        fun newInstance(): PlayerListFragment {
            return PlayerListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_playerlist,container,false)

        val players = allPlayers

        val adapter = this.activity?.let { PlayerListAdapter(it,players) }

        listView = view.findViewById(R.id.playerList)

        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedPlayer = allPlayers[position]

            Toast.makeText(activity, "Clicked on Player",
                    Toast.LENGTH_LONG).show()



        }

        return view
    }
}