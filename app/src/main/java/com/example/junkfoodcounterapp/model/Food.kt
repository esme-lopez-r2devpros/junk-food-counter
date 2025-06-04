package com.example.junkfoodcounterapp.model

import java.util.Date

data class Food(
    var id: Int = 0,
    var iconName: String = "",
    var name:  String = "",
    var times: List<Date>
)
