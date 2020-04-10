package com.greimul.copy2message

import android.app.Activity
import android.content.Context

fun savePref(activity: Activity?){
    val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)?:return

    with(sharedPref.edit()){
        SettingSingleton.settingList.forEach{
            putBoolean(it.key,it.value)
        }
        commit()
    }
}

fun loadPref(activity:Activity?){
    val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)?:return
    SettingSingleton.set(sharedPref.all)
}