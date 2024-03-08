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
//
//    @Query("SELECT * FROM GUA_ESTOQUEEMPRESA")
//    suspend fun getAll(): List<EstoqueEmpresa>
//
//    @Query("SELECT * FROM GUA_ESTOQUEEMPRESA WHERE ESE_EMPRESA = :empresa AND ESE_CODIGO = :codigo")
//    suspend fun findByEmpresaAndCodigo(empresa: String, codigo: String): EstoqueEmpresa?
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(estoqueEmpresa: EstoqueEmpresa)
//
//    @Update
//    suspend fun update(estoqueEmpresa: EstoqueEmpresa)
//
//    @Delete
//    suspend fun delete(estoqueEmpresa: EstoqueEmpresa)
}
