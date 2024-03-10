package br.com.manieri.guarany.repository.dao

import br.com.manieri.guarany.model.EstoqueEmpresa

interface EstoqueEmpresaDao {
    fun getAll(): List<EstoqueEmpresa>
    fun insert(estoqueEmpresa: EstoqueEmpresa): Long
    fun delete(codigoEmpresa: String): Int
    fun update(estoqueEmpresa: EstoqueEmpresa): Int
}
