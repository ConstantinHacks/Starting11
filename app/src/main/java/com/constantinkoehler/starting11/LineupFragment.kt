package com.constantinkoehler.starting11

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.constantinkoehler.starting11.Model.Player

class LineupFragment : Fragment() {

    private lateinit var players: Array<Player>

    companion object {

        fun newInstance(): LineupFragment {
            return LineupFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lineup,container,false)
    }

}