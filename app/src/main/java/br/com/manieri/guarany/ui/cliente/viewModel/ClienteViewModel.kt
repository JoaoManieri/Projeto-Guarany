package br.com.manieri.guarany.ui.cliente.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.manieri.guarany.repository.RepositoryCliente
import br.com.manieri.guarany.repository.dto.ClienteListView
import br.com.manieri.guarany.ui.cliente.data.CliData
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ClienteViewModel(
    private var listClientes: MutableList<ClienteListView> = mutableListOf()
) : ViewModel(), KoinComponent {
    private val repositoryCliente: RepositoryCliente by inject()
    private val cliData: CliData by inject()

    val observerCliente = MutableLiveData<MutableList<ClienteListView>>()
    val observeDBOperation = MutableLiveData<Int>()

    fun clientFound() {
        viewModelScope.launch {
            listClientes = repositoryCliente.getClientes().toMutableList()
            observerCliente.postValue(listClientes)
        }
    }

    fun search(query: String) {
        val fill = listClientes.filter {
            it.cgccpf.contains(query, true) || it.razaoSocial.toString()
                .contains(query) || it.nomeFantasia.toString().contains(query)
        }
        observerCliente.postValue(fill.toMutableList())
    }

    fun getClienteDataByCode(code : String) {
        viewModelScope.launch {
            cliData.cliente = repositoryCliente.getClienteByCode(code)
        }
    }

    fun updateClient(){
        viewModelScope.launch {
            val i = repositoryCliente.updateCliente(cliData.cliente)
            observeDBOperation.postValue(i)
        }
    }

    fun insert(){
        viewModelScope.launch {
            val i = repositoryCliente.insert(cliData.cliente)
            observeDBOperation.postValue(i.toInt())
        }
    }

    fun delete() {
        viewModelScope.launch {
            val i = repositoryCliente.deleteCliente(cliData.cliente.codigoCliente)
            observeDBOperation.postValue(i)
        }
    }

}