package com.example.junkfoodcounterapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.junkfoodcounterapp.config.FoodApplication.Companion.db
import com.example.junkfoodcounterapp.model.Food
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Date


class MainViewModel: ViewModel() {
    private val _foodList = MutableLiveData<List<Food>?>()
    val foodList : LiveData<List<Food>?> get() = _foodList

    fun start() {
        viewModelScope.launch {
            _foodList.value = withContext(Dispatchers.IO){
                db.foodDao().getAll()
            }
        }
    }
}