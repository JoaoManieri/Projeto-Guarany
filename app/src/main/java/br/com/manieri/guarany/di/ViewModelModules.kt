package br.com.manieri.guarany.di

import br.com.manieri.guarany.ui.cliente.viewModel.ClientEditViewModel
import br.com.manieri.guarany.ui.cliente.viewModel.ClienteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val provideViewModel = module {
    viewModel { ClienteViewModel() }
    viewModel { ClientEditViewModel(get()) }
}


