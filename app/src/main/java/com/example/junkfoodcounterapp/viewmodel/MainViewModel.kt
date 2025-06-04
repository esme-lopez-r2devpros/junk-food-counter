package com.example.junkfoodcounterapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.junkfoodcounterapp.model.Food
import java.util.Date

class MainViewModel: ViewModel() {
    val foodList = MutableLiveData<List<Food>>()

    fun start() {
        foodList.value = mutableListOf(
            Food(12345, "ic_ice_cream","Cheetos", listOf(Date()) ),
            Food(123456, "ic_ice_cream","Fritos", listOf(Date()) ),
            Food(123456, "ic_ice_cream","Donas", listOf(Date()) ))
    }
}