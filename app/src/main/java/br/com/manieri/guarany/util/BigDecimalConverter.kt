package br.com.manieri.guarany.util

import androidx.room.TypeConverter
import java.math.BigDecimal
import java.math.BigInteger

class BigDecimalConverter {
    @TypeConverter
    fun fromByteArray(value: ByteArray?): BigDecimal? {
        return value?.let { BigDecimal(BigInteger(it), 2) }
    }

    @TypeConverter
    fun toByteArray(value: BigDecimal?): ByteArray? {
        return value?.unscaledValue()?.toByteArray()
    }
}