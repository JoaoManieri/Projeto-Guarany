package br.com.manieri.guarany.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.com.manieri.guarany.model.EstoqueEmpresa

//@Dao
interface EstoqueEmpresaDao {
    fun getAll(): List<EstoqueEmpresa>
//    fun getById(id: Long): EstoqueEmpresa?
//    fun insert(estoqueEmpresa: EstoqueEmpresa): Long
//    fun update(estoqueEmpresa: EstoqueEmpresa): Int
//    fun delete(estoqueEmpresa: EstoqueEmpresa): Int
//
}
