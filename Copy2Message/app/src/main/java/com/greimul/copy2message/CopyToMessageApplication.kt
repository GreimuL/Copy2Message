package com.greimul.copy2message

import android.app.Application
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import com.kakao.auth.IApplicationConfig
import com.kakao.auth.KakaoAdapter
import com.kakao.auth.KakaoSDK

class CopyToMessageApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSDK.init(object:KakaoAdapter(){
            override fun getApplicationConfig(): IApplicationConfig {
                return IApplicationConfig { this@CopyToMessageApplication }
            }
        })
    }
}