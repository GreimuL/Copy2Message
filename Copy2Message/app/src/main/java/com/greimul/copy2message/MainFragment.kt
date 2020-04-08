package com.greimul.copy2message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.greimul.copy2message.adapter.MainAdapter
import com.greimul.copy2message.db.History
import kotlinx.android.synthetic.main.fragment_main.view.*
import java.util.*

class MainFragment: Fragment() {

    lateinit var mainAdapter: MainAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var viewManager:RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main,container,false)

        viewManager = LinearLayoutManager(context)
        mainAdapter = MainAdapter()
        recyclerView = view.recyclerview_main.apply{
            setHasFixedSize(true)
            adapter = mainAdapter
            layoutManager = viewManager
        }

        mainAdapter.setHistoryList(listOf(History(0, Date().toString(),"asdf"),History(5,Date().toString(),"wef")))
        return view
    }
}