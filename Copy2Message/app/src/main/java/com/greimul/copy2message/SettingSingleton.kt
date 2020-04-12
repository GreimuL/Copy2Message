package com.greimul.copy2message

object SettingSingleton{
    var settingList:HashMap<String,Boolean> =
        hashMapOf(
            "isServiceStart" to true,
            "isKakaoTalkServiceStart" to false
        )

    fun set(setting:MutableMap<String,*>){
        setting.forEach {
            settingList[it.key] = it.value as Boolean
        }
    }
}