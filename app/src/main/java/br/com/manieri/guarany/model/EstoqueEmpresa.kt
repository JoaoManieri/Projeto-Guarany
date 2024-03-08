package br.com.manieri.guarany.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import br.com.manieri.guarany.util.BigDecimalConverter
import java.math.BigDecimal

data class EstoqueEmpresa(
   @PrimaryKey val empresa: String,
   @PrimaryKey val codigo: String,
   val estoque: Double,
   @PrimaryKey val local: String,
)
