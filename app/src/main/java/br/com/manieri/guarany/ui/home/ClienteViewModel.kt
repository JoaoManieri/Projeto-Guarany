package br.com.manieri.guarany.ui.home


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.manieri.guarany.repository.RepositoryCliente
import br.com.manieri.guarany.repository.dto.ClienteListView
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class ClienteViewModel : ViewModel(), KoinComponent {
    private val repositoryCliente: RepositoryCliente by inject()

    val observerCliente = MutableLiveData<MutableList<ClienteListView>>()

    fun postClients() {
        viewModelScope.launch {
            val listClient = repositoryCliente.getClientes()
            observerCliente.postValue(listClient.toMutableList())
        }
    }
}