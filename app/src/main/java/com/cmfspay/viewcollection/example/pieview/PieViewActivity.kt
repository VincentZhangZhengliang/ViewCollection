package com.cmfspay.viewcollection.example.pieview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.cmfspay.viewcollection.R
import kotlinx.android.synthetic.main.activity_pie_view.*

class PieViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pie_view)
        val list = mutableListOf<PieBean>()
        list.add(PieBean("halo",20f))
        list.add(PieBean("halo",10f))
        list.add(PieBean("halo",40f))
        list.add(PieBean("halo",16f))
        list.add(PieBean("halo",23f))
        list.add(PieBean("halo",65f))
        list.add(PieBean("halo",87f))
        pie_view.setData(list)
    }

}
