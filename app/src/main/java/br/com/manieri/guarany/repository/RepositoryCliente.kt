package br.com.manieri.guarany.repository

import android.util.Log
import br.com.manieri.guarany.data.SQLiteHelper
import br.com.manieri.guarany.repository.dao.ClienteDao
import br.com.manieri.guarany.repository.dto.ClienteListView

class RepositoryCliente (private val clienteDao: ClienteDao) {
    fun getClientes() = clienteDao.getListaCLiente()

    // fun getClientes() = mutableListOf<ClienteListView>(ClienteListView("0000", "Razao social", "Nome fantasia", "00.000.000/0001-00"))
    fun getClienteByCode(code : String) {

    }
}