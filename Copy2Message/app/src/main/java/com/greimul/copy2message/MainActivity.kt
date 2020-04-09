package com.greimul.copy2message

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.greimul.copy2message.adapter.MainAdapter
import com.greimul.copy2message.db.History
import com.kakao.auth.*
import com.kakao.util.exception.KakaoException
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfig:AppBarConfiguration

    private val sessionCallback: ISessionCallback = object: ISessionCallback {
        override fun onSessionOpenFailed(exception: KakaoException?) {
            Toast.makeText(applicationContext,"Login Failed", Toast.LENGTH_SHORT).show()
        }

        override fun onSessionOpened() {
            Toast.makeText(applicationContext,"Login Success", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Session.getCurrentSession().removeCallback(sessionCallback)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(Session.getCurrentSession().handleActivityResult(requestCode,resultCode,data)){
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navigationController = findNavController(R.id.fragment_nav_host)
        return navigationController.navigateUp(appBarConfig)||super.onSupportNavigateUp()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu_48px)

        Session.getCurrentSession().addCallback(sessionCallback)

        val navigationController = findNavController(R.id.fragment_nav_host)

        appBarConfig = AppBarConfiguration(setOf(R.id.nav_home,R.id.nav_account,R.id.nav_setting),drawerlayout_main)

        setupActionBarWithNavController(navigationController,appBarConfig)
        navigationview_main.setupWithNavController(navigationController)
    }
}
