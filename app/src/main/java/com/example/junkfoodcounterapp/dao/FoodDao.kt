package com.example.junkfoodcounterapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.junkfoodcounterapp.model.Food

@Dao
interface FoodDao {

    @Query("SELECT * FROM Food")
    suspend fun getAll(): List<Food>

    @Insert
    suspend fun insert(food: Food): Long

    @Update
    suspend fun update(food: Food): Int

    @Delete
    suspend fun delete(food: Food): Int
}