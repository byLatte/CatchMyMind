package com.latte.catchmymind

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if(currentFragment == null){
            var fragment = QuizListFragment.newInstance() // 추후 유동적으로
            supportFragmentManager.beginTransaction()
                                .add(R.id.fragment_container,fragment)
                                .commit()
        }

    }
}