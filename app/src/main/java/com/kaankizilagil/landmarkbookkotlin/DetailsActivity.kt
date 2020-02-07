package com.kaankizilagil.landmarkbookkotlin

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val intent = intent

        val landmarkNameDetails = intent.getStringExtra("names")
        textView.text = landmarkNameDetails

        /*
        val landmarkImageDetails = intent.getIntExtra("images",0)
        val selectedBitmap = BitmapFactory.decodeResource(applicationContext.resources, landmarkImageDetails)
        imageView.setImageBitmap(selectedBitmap)
        */

        val singleton = Singleton.Selected
        val selectedBitmap = singleton.selectedImage
        imageView.setImageBitmap(selectedBitmap)
    }
}
