package br.com.manieri.guarany.ui.home

import br.com.manieri.guarany.ui.home.viewModel.ClienteViewModel

interface ClientView {
    fun initializeRecyclerView(viewModel: ClienteViewModel)
    fun initializeSearchView()
}