package com.constantinkoehler.starting11

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import com.constantinkoehler.starting11.Model.*

const val MAXPLAYERS = 11
const val MAXONEPOSITION = 5
const val MAXGOALKEEPERS = 1

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

        return view
    }
}