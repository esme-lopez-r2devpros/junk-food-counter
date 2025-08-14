package com.example.junkfoodcounterapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.Date

@Entity
data class Food(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= "id_Food")  var idFood: Int = 0,
    @ColumnInfo(name= "iconName") var iconName: String? = "",
    @ColumnInfo(name= "name")     var name:  String? = "",
    @ColumnInfo(name = "times")   var times: List<Date>? = emptyList()
):Serializable
