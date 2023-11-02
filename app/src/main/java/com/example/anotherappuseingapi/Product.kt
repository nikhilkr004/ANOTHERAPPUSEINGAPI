package com.example.anotherappuseingapi

data class Product(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
)