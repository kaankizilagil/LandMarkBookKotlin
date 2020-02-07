package com.kaankizilagil.landmarkbookkotlin

import android.graphics.Bitmap

class Singleton {   // Singleton structure has only one object in the class.

    companion object Selected {

        var selectedImage : Bitmap? = null
    }
}
