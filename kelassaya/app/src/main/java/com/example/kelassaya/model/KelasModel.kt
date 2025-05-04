package com.example.kelassaya.model

data class KelasModel(
    val id: Int,
    val title: String,
    val tanggal: String,
    val rating: Double,
    val peserta: Int,
    val isPremium: Boolean,
    val isUnlocked: Boolean,
    val isCompleted: Boolean,
    val hasFeedback: Boolean,
    val progress: Int
)
