package com.example.surmarket.models

data class product (
    val id: Int,
    val name: String,
    val category: String,
    val price: Double,
    val imageUrl: String,
    val description: String,
    val availabel: Boolean,
    val stock: Int
)