package com.s2d5.recyclerviewwithplus

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.s2d5.recyclerviewwithplus.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val personAdapter = PersonAdapter()
    private val personData: ArrayList<PersonData> = arrayListOf()
    private val jobArray: Array<String> by lazy { resources.getStringArray(R.array.job) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setRecyclerview()
        binding.ivAdd.setOnClickListener {
            addData()
        }

    }

    private fun addData() {
        val newData = PersonData(
            "https://picsum.photos/id/${Random().nextInt(800) + 1}/100/100",
            jobArray[Random().nextInt(jobArray.size)]
        )

        Log.e("newData", newData.imageUri)

        personData.add(newData)
        personAdapter.addData(newData)
    }

    private fun setRecyclerview() {
        binding.rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = personAdapter
        }
    }
}