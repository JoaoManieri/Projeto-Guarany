package br.com.manieri.guarany.ui.cliente

import br.com.manieri.guarany.ui.cliente.viewModel.ClienteViewModel

interface ClientView {
    fun initializeRecyclerView(viewModel: ClienteViewModel)
    fun initializeSearchView()
}