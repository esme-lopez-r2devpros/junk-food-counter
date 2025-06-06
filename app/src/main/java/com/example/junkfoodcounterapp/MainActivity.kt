package com.example.junkfoodcounterapp

import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.junkfoodcounterapp.adapters.FoodAdapter
import com.example.junkfoodcounterapp.databinding.ActivityMainBinding
import com.example.junkfoodcounterapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var layout: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        layout = ActivityMainBinding.inflate(layoutInflater)
        setContentView(layout.root)
        val basePadding = 20.dpToPx()
        ViewCompat.setOnApplyWindowInsetsListener(layout.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left + basePadding, systemBars.top + basePadding, systemBars.right + basePadding, systemBars.bottom + basePadding)
            insets
        }

        viewModel = ViewModelProvider(this).get()
        layout.lifecycleOwner = this
        layout.model = viewModel
        viewModel.start()

        layout.myRecyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
        }
        
        viewModel.foodList.observe(this, Observer{
            Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_LONG).show()
            layout.myRecyclerView.adapter = FoodAdapter(it)
        })
        val items = resources.getStringArray(R.array.spinner_items)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        layout.spnTime.adapter = adapter
        layout.spnTime.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }
    }

    fun Int.dpToPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

}