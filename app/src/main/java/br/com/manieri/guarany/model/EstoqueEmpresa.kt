package br.com.manieri.guarany.model

import androidx.room.PrimaryKey

data class EstoqueEmpresa(
    @PrimaryKey val empresa: String,
    @PrimaryKey val codigo: String,
    val estoque: Double,
    @PrimaryKey val local: String,
)
