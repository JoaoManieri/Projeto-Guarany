package br.com.manieri.guarany.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.manieri.guarany.repository.RepositoryCliente
import br.com.manieri.guarany.repository.dto.ClienteListView
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class ClienteViewModel : ViewModel(), KoinComponent {
    private val repositoryCliente: RepositoryCliente by inject()

    val observerCliente = MutableLiveData<MutableList<ClienteListView>>()

    fun postClients() {
        Log.w("req", "postClients: ", )
        val c = repositoryCliente.getClientes()
        Log.w("req", "postClients: $c", )
    }

}