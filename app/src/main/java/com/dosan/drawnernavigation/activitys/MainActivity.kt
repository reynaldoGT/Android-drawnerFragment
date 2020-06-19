package com.dosan.drawnernavigation.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.dosan.drawnernavigation.Fragments.AlertFragment
import com.dosan.drawnernavigation.Fragments.EmailFragment
import com.dosan.drawnernavigation.Fragments.InfoFragment
import com.dosan.drawnernavigation.R
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    var draweLayout: DrawerLayout? = null
    var navigationView: NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        draweLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)

        setToolbar()
        showSelectFrame(EmailFragment())
        //navigationView.setOnNavigationItemSelectedListener
        navigationView?.setNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.menu_mail -> {
                    //Toast.makeText(this, "item", Toast.LENGTH_LONG).show()
                    showSelectFrame(EmailFragment())

                }
                R.id.menu_alert -> {
                    //Toast.makeText(this, "item", Toast.LENGTH_LONG).show()
                    showSelectFrame(AlertFragment())
                }
                R.id.menu_info -> {
                    //Toast.makeText(this, "item", Toast.LENGTH_LONG).show()
                    showSelectFrame(InfoFragment())
                }
            }
            //it.isChecked = true
            //supportActionBar?.title = title
            draweLayout?.closeDrawers()
            true
        }
    }

    fun setToolbar() {
        var toobar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toobar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_burger)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    fun showSelectFrame(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.contet_frame, fragment)
            .commit()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                draweLayout?.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}








