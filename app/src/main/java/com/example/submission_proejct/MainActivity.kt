package com.example.submission_proejct

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvTourism: RecyclerView
    private val list = ArrayList<Tourism>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTourism = findViewById(R.id.rv_tourism)
        rvTourism.setHasFixedSize(true)

        list.addAll(getListTourism())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListTourism(): ArrayList<Tourism> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataOverview = resources.getStringArray(R.array.data_overview)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataCountry = resources.getStringArray(R.array.data_country)
        val dataContent = resources.getStringArray(R.array.data_content)
        val listTourism = ArrayList<Tourism>()
        for (i in dataName.indices) {
            val tourism = Tourism(dataName[i], dataOverview[i],dataPhoto.getResourceId(i, -1), dataCountry[i], dataContent[i])
            listTourism.add(tourism)
        }
        return listTourism
    }

    private fun showRecyclerList() {
        rvTourism.layoutManager = LinearLayoutManager(this)
        val listTourismAdapter = ListTourismAdapter(list)
        rvTourism.adapter = listTourismAdapter

        listTourismAdapter.setOnItemClickCallback(object : ListTourismAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Tourism) {
                showSelectedHero(data)
            }
        })
    }

    private fun showSelectedHero(tourism: Tourism) {
        val moveIntent = Intent(this@MainActivity, DetailActivity::class.java)
        moveIntent.putExtra(DetailActivity.EXTRA_NAME, tourism.name)
        moveIntent.putExtra(DetailActivity.EXTRA_OVERVIEW, tourism.overview)
        moveIntent.putExtra(DetailActivity.EXTRA_PHOTO, tourism.photo)
        moveIntent.putExtra(DetailActivity.EXTRA_COUNTRY, tourism.country)
        moveIntent.putExtra(DetailActivity.EXTRA_CONTENT, tourism.content)
        startActivity(moveIntent)
    }
}