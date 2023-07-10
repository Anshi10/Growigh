package com.example.growgh

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class UploadPage : AppCompatActivity() {

    //private val PICK_IMAGE_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_page)


        val selectBtn = findViewById<Button>(R.id.select)
        val imagePickerLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            if (uri != null) {
                // Do something with the selected image URI (e.g., display it in an ImageView)
                val image = findViewById<ImageView>(R.id.image)
                image.setImageURI(uri)

            }
        }
        selectBtn.setOnClickListener {
            imagePickerLauncher.launch("image/*")
        }
    }

    private fun selectImagefromGallery() {
//          val intent = Intent(Intent.ACTION_PICK , MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
//          intent.type = "image/*"
//        startActivityForResult(intent, PICK_IMAGE_REQUEST)

    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
//            val selectedImageUri = data.data
//            // Do something with the selected image URI (e.g., display it in an ImageView)
//            val image = findViewById<ImageView>(R.id.image)
//            image.setImageURI(selectedImageUri)
//        }
//    }
}