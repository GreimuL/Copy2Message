package com.greimul.copy2message.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.greimul.copy2message.R
import com.greimul.copy2message.SettingSingleton
import kotlinx.android.synthetic.main.fragment_setting.view.*

class SettingFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_setting,container,false)

        view.switch_service.isChecked = SettingSingleton.settingList["isServiceStart"]?:false
        view.switch_kakaotalk.isChecked = SettingSingleton.settingList["isKakaoTalkServiceStart"]?:false

        view.switch_service.setOnClickListener {
            SettingSingleton.settingList["isServiceStart"] = view.switch_service.isChecked
        }

        view.switch_kakaotalk.setOnClickListener {
            SettingSingleton.settingList["isKakaoTalkServiceStart"] = view.switch_kakaotalk.isChecked
        }


        return view
    }
}