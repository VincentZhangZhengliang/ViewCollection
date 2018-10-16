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
        btn_basic_shape.setOnClickListener { startActivity(Intent(this@FoundationActivity, BasicShapeActivity::class.java)) }
        btn_canvas_convert.setOnClickListener { startActivity(Intent(this@FoundationActivity, CanvasConvertActivity::class.java)) }
        btn_canvas_picture.setOnClickListener { startActivity(Intent(this@FoundationActivity, CanvasPictureTextActivity::class.java)) }
    }

}
