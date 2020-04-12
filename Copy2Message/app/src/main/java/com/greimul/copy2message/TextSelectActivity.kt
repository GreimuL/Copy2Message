package com.greimul.copy2message

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.greimul.copy2message.db.History
import com.greimul.copy2message.viewmodel.HistoryViewModel
import kotlinx.android.synthetic.main.activity_text_select.*
import java.util.*

class TextSelectActivity:AppCompatActivity() {

    lateinit var historyViewModel: HistoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_select)

        historyViewModel = ViewModelProvider(this).get(HistoryViewModel::class.java)

        var text:CharSequence = intent.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT)
        kakaoSendText(text.toString(),applicationContext)
        val history = History(0, Date().toString(),text.toString())
        historyViewModel.insert(history).invokeOnCompletion {
            finish()
        }
    }
}