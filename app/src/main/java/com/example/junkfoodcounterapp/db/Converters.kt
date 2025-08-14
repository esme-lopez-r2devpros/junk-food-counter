package com.example.junkfoodcounterapp.db

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

    class Converters {
        private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US)

        @TypeConverter
        fun fromDateList(dates: List<Date>?): String? {
            return dates?.joinToString(",") { dateFormat.format(it) }
        }

        @TypeConverter
        fun toDateList(data: String?): List<Date> {
            if (data.isNullOrEmpty()) return emptyList()
            return data.split(",").mapNotNull {
                try {
                    dateFormat.parse(it)
                } catch (e: Exception) {
                    e.printStackTrace()
                    null
                }
            }
        }
    }