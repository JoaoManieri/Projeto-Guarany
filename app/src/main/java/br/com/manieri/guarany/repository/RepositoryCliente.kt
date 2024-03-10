package br.com.manieri.guarany.repository

import android.util.Log
import br.com.manieri.guarany.repository.dao.ClienteDao

class RepositoryCliente (private val clienteDao: ClienteDao) {
    fun getClientes() = clienteDao.getListaCLiente()
}