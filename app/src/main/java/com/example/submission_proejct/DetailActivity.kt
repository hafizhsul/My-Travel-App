package com.example.submission_proejct

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_OVERVIEW = "extra_overview"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_COUNTRY = "extra_country"
        const val EXTRA_CONTENT = "extra_content"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name = intent.getStringExtra(EXTRA_NAME)
        val overview = intent.getStringExtra(EXTRA_OVERVIEW)
        val country = intent.getStringExtra(EXTRA_COUNTRY)
        val content = intent.getStringExtra(EXTRA_CONTENT)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)

        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailOverview: TextView = findViewById(R.id.tv_detail_overview)
        val tvDetailCountry: TextView = findViewById(R.id.tv_detail_country)
        val tvDetailContent: TextView = findViewById(R.id.tv_detail_content)
        val imgDetail: ImageView = findViewById(R.id.img_detail)

        tvDetailName.text = name
        tvDetailOverview.text = overview
        tvDetailContent.text = content
        tvDetailCountry.text = country
        imgDetail.setImageResource(photo)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_share, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.action_share -> {
                shareContent()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun shareContent() {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            val content = intent.getStringExtra(EXTRA_OVERVIEW)
            putExtra(Intent.EXTRA_TEXT, content)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Share"))
    }
}