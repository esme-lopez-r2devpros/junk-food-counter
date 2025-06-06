package com.example.junkfoodcounterapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.junkfoodcounterapp.model.Food
import java.util.Date


class MainViewModel: ViewModel() {
    private val _foodList = MutableLiveData<List<Food>?>()
    val foodList : LiveData<List<Food>?> get() = _foodList

    fun start() {
//        viewModelScope.launch {
//
//        }
        _foodList.value = mutableListOf(
            Food(12345, "ic_ice_cream","Cheetos", listOf(Date()) ),
            Food(123456, "ic_ice_cream","Fritos", listOf(Date()) ),
            Food(123456, "ic_ice_cream","Donas", listOf(Date()) ))
    }
}