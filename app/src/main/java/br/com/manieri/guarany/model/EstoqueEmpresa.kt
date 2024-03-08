package br.com.manieri.guarany.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GUA_ESTOQUEEMPRESA", primaryKeys = ["ESE_EMPRESA", "ESE_CODIGO"])
data class EstoqueEmpresa(
    @ColumnInfo(name = "ESE_EMPRESA") val empresa: String,
    @ColumnInfo(name = "ESE_CODIGO") val codigo: String,
    @ColumnInfo(name = "ESE_ESTOQUE") val estoque: Double,
    @ColumnInfo(name = "ESE_LOCAL") val local: String,
)
