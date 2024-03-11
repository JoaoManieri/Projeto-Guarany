package br.com.manieri.guarany.di

import br.com.manieri.guarany.ui.home.viewModel.ClientEditViewModel
import br.com.manieri.guarany.ui.home.viewModel.ClienteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val provideViewModel = module {
    viewModel { ClienteViewModel() }
    viewModel { ClientEditViewModel(get()) }
}


