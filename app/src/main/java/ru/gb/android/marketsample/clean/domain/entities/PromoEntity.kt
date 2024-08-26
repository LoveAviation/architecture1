package ru.gb.android.marketsample.clean.domain.entities

import kotlinx.serialization.Serializable

@Serializable
class PromoEntity (
    val id: String,
    val name: String,
    val image: String,
    val discount: Double,
    val description: String,
    val type: String,
    val products: List<String>,
)