package br.com.manieri.guarany.repository

import br.com.manieri.guarany.model.Cliente
import br.com.manieri.guarany.repository.dao.ClienteDao

class RepositoryCliente (private val clienteDao: ClienteDao) {
    fun getClientes() = clienteDao.getListaCLiente()
    fun getClienteByCode(code : String) : Cliente =  clienteDao.getClienteByCode(code)

}