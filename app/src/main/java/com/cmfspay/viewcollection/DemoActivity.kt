package com.cmfspay.viewcollection

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.cmfspay.viewcollection.example.pieview.PieViewActivity
import kotlinx.android.synthetic.main.activity_demo.*

class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
        btn_pie_view.setOnClickListener { startActivity(Intent(this@DemoActivity, PieViewActivity::class.java)) }
    }

}
