package com.cmfspay.viewcollection.foundation

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.cmfspay.viewcollection.R
import kotlinx.android.synthetic.main.activity_foundation.*

class FoundationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foundation)
        btn_coordinate_system.setOnClickListener { startActivity(Intent(this@FoundationActivity, CoordinateSystemActivity::class.java)) }
    }

}
