package com.kaankizilagil.landmarkbookkotlin

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Data(Names)
        var landmarkNames = ArrayList<String>()
        landmarkNames.add("Bosphorus Bridge")
        landmarkNames.add("Brooklyn Bridge")
        landmarkNames.add("Golden Gate Bridge")
        landmarkNames.add("London Bridge")


        // Data(Images) (Complex and Different Structure)
        val bosphorusBridge = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.bosphorusbridge)
        val brooklynBridge = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.brooklynbridge)
        val goldenGateBridge = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.goldengatebridge)
        val londonBridge = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.londonbridge)

        var landmarkImages = ArrayList<Bitmap>()
        landmarkImages.add(bosphorusBridge)
        landmarkImages.add(brooklynBridge)
        landmarkImages.add(goldenGateBridge)
        landmarkImages.add(londonBridge)


        /*
        // Data(Images) (Better and More Efficient)
        val bosphorusBridgeId = R.drawable.bosphorusbridge
        val brooklynBridgeId = R.drawable.brooklynbridge
        val goldenGateBridgeId = R.drawable.goldengatebridge
        val londonBridgeId = R.drawable.londonbridge

        var landmarkImagesId = ArrayList<Int>()
        landmarkImagesId.add(bosphorusBridgeId)
        landmarkImagesId.add(brooklynBridgeId)
        landmarkImagesId.add(goldenGateBridgeId)
        landmarkImagesId.add(londonBridgeId)
        */


        // Adaptor: Layout & Data
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarkNames)      // Default

        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(applicationContext, DetailsActivity::class.java)
            intent.putExtra("names", landmarkNames[position])

            /*
            intent.putExtra("images", landmarkImagesId[position])
            */

            val singleton = Singleton.Selected
            singleton.selectedImage = landmarkImages[position]

            startActivity(intent)
        }
    }
}
