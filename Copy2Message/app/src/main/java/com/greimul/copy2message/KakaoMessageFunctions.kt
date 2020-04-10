package com.greimul.copy2message

import android.content.Context
import android.widget.Toast
import com.kakao.kakaotalk.callback.TalkResponseCallback
import com.kakao.kakaotalk.v2.KakaoTalkService
import com.kakao.message.template.LinkObject
import com.kakao.message.template.TextTemplate
import com.kakao.network.ErrorResult

fun makeTextMessage(text:String):TextTemplate{
    return TextTemplate.newBuilder(text,LinkObject.newBuilder().build()).build()
}

fun kakaoSendText(text:String,context:Context){
    KakaoTalkService.getInstance().requestSendMemo(object: TalkResponseCallback<Boolean>() {
        override fun onNotKakaoTalkUser() {
            Toast.makeText(context,"Not KakaoTalk User",Toast.LENGTH_SHORT).show()
        }

        override fun onSessionClosed(errorResult: ErrorResult?) {
            Toast.makeText(context,"Session Closed",Toast.LENGTH_SHORT).show()
        }

        override fun onFailure(errorResult: ErrorResult?) {
            Toast.makeText(context,"Send Failed",Toast.LENGTH_SHORT).show()
        }

        override fun onSuccess(result: Boolean?) {
            Toast.makeText(context,"Send Success",Toast.LENGTH_SHORT).show()
        }
    }, makeTextMessage(text))
}