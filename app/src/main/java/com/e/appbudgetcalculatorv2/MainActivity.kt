package com.e.appbudgetcalculatorv2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.e.appbudgetcalculatorv2.ui.BaseFragment
import com.e.appbudgetcalculatorv2.ui.hello.HelloFragment

class MainActivity : AppCompatActivity() {

    private val helloFragment = HelloFragment()
    private val baseFragment = BaseFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getPreferences(Context.MODE_PRIVATE)

        if (sharedPref.getBoolean("firstTime", false)){
            if(savedInstanceState==null){
                supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, baseFragment).commit()
            }else{
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, baseFragment).commit()
            }
        }else{
            val editorPref = sharedPref.edit()
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, helloFragment).commit()
            editorPref.putBoolean("firstTime", true)
            editorPref.apply()
        }
    }
}