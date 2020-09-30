package com.study.deliverycenter.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.study.deliverycenter.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SearchFragment())
                .commitNow()


            imageSair.setOnClickListener {
                finish()
            }
        }
    }

}