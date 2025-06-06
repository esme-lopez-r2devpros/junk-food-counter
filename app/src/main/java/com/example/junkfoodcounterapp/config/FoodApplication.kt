package com.example.junkfoodcounterapp.config

import android.app.Application
import androidx.room.Room
import com.example.junkfoodcounterapp.db.FoodDb

class FoodApplication: Application() {
    companion object {
        lateinit var db: FoodDb
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            this,
            FoodDb::class.java,
            "Food"
        ).build()
    }
}