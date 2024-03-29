package com.example.submission_proejct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val imageView = findViewById<ImageView>(R.id.img_profile)
        loadRoundedImage(imageView)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun loadRoundedImage(imageView: ImageView) {
        Glide.with(imageView.context)
            .load(R.drawable.foto)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .into(imageView)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}