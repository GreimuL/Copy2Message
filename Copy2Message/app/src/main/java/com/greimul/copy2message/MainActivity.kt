package com.greimul.copy2message

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
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
import com.kakao.auth.IApplicationConfig
import com.kakao.auth.KakaoAdapter
import com.kakao.auth.KakaoSDK
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfig:AppBarConfiguration

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

        val navigationController = findNavController(R.id.fragment_nav_host)

        appBarConfig = AppBarConfiguration(setOf(R.id.nav_home,R.id.nav_setting),drawerlayout_main)

        setupActionBarWithNavController(navigationController,appBarConfig)
        navigationview_main.setupWithNavController(navigationController)
    }
}
