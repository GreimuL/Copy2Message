package com.greimul.copy2message.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.greimul.copy2message.R
import com.greimul.copy2message.adapter.MainAdapter
import com.greimul.copy2message.db.History
import com.greimul.copy2message.kakaoSendText
import com.greimul.copy2message.viewmodel.HistoryViewModel
import kotlinx.android.synthetic.main.fragment_main.view.*
import java.util.*

class HomeFragment: Fragment() {

    lateinit var mainAdapter: MainAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var viewManager:RecyclerView.LayoutManager

    lateinit var historyViewModel:HistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main,container,false)

        historyViewModel = ViewModelProvider(this).get(HistoryViewModel::class.java)

        viewManager = LinearLayoutManager(context)
        mainAdapter = MainAdapter()

        historyViewModel.historyList.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            mainAdapter.setHistoryList(it)
        } )

        recyclerView = view.recyclerview_main.apply{
            setHasFixedSize(true)
            adapter = mainAdapter
            layoutManager = viewManager
        }
        historyViewModel.insert(History(0, Date().toString(),"asdf"))

        view.button_clear.setOnClickListener {
            historyViewModel.deleteAll()
        }

        return view
    }
}