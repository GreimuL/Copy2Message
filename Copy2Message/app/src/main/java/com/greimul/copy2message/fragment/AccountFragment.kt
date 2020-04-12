package com.greimul.copy2message.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.greimul.copy2message.R
import com.kakao.usermgmt.UserManagement
import com.kakao.usermgmt.callback.LogoutResponseCallback
import com.kakao.usermgmt.request.LogoutRequest
import kotlinx.android.synthetic.main.fragment_account.view.*

class AccountFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_account,container,false)

        view.button_logout.setOnClickListener {
            UserManagement.getInstance().requestLogout(object:LogoutResponseCallback(){
                override fun onCompleteLogout() {
                    Toast.makeText(context,"Logout Success",Toast.LENGTH_SHORT).show()
                }
            })
        }

        return view
    }
}