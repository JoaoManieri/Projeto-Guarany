package br.com.manieri.guarany.repository.dao

import br.com.manieri.guarany.model.Cliente
import br.com.manieri.guarany.model.EstoqueEmpresa
import br.com.manieri.guarany.repository.dto.ClienteListView

interface ClienteDao {

    fun getListaCLiente(): List<ClienteListView>
    fun getClienteById(codigoCliente: String): Cliente
    fun insert(cliente: Cliente): Long
    fun delete(cliente: String): Int
    fun update(cliente: Cliente): Int
}
