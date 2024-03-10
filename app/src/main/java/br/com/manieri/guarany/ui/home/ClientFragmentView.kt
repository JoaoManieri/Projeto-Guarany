package br.com.manieri.guarany.ui.home

import br.com.manieri.guarany.repository.dto.ClienteListView

interface ClientFragmentView {
    fun initializeRecyclerView(viewModel: ClienteViewModel)
}