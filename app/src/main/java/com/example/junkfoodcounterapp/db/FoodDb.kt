package com.example.junkfoodcounterapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.junkfoodcounterapp.dao.FoodDao
import com.example.junkfoodcounterapp.model.Food

@Database(
    entities = [Food::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class FoodDb : RoomDatabase() {
    abstract fun foodDao(): FoodDao
}