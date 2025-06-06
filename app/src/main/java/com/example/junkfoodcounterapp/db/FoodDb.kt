package com.example.junkfoodcounterapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.junkfoodcounterapp.dao.FoodDao
import com.example.junkfoodcounterapp.model.Food

@Database(
    entities = [Food::class],
    version = 1
)
abstract class FoodDb : RoomDatabase() {
    abstract fun foodDao(): FoodDao

}