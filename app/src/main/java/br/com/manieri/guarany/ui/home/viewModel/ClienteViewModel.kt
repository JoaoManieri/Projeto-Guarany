package br.com.manieri.guarany.ui.home.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.manieri.guarany.repository.RepositoryCliente
import br.com.manieri.guarany.repository.dto.ClienteListView
import br.com.manieri.guarany.ui.home.data.CliData
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ClienteViewModel(
    private var listClientes: MutableList<ClienteListView> = mutableListOf()
) : ViewModel(), KoinComponent {
    private val repositoryCliente: RepositoryCliente by inject()
    private val cliData: CliData by inject()

    val observerCliente = MutableLiveData<MutableList<ClienteListView>>()

    fun postClients() {
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
            Log.w("TAG", "getClienteDataByCode: Passou aqui claro que sim ",)
            cliData.cliente = repositoryCliente.getClienteByCode(code)
            Log.w("TAG", "getClienteDataByCode: Passou aqui claro que sim ${cliData.cliente}",)
        }
    }

}