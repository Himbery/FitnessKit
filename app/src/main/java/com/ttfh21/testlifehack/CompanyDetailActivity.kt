package com.ttfh21.testlifehack

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detail_activty.*

class CompanyDetailActivity : AppCompatActivity() {

    lateinit var companyStartTime : String
    lateinit var companyEndTime : String
    lateinit var companyDescription :String
    lateinit var companyName : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activty)

        companyStartTime = intent.getStringExtra("starttime")
        companyEndTime = intent.getStringExtra("endtime")
        companyDescription = intent.getStringExtra("description")
        companyName = intent.getStringExtra("name")


        name_detail.text = companyName
        time_detail.text = companyStartTime + " - " + companyEndTime
        d_detail.text = companyDescription

    }
}