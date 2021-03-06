package com.cmfspay.viewcollection

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cmfspay.viewcollection.foundation.FoundationActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener()
    }

    private fun initListener() {
        btn_view_foundation.setOnClickListener { startActivity(Intent(this, FoundationActivity::class.java)) }
        btn_demo.setOnClickListener { startActivity(Intent(this, DemoActivity::class.java)) }
    }

}
