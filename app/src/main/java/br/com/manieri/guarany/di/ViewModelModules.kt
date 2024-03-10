package br.com.manieri.guarany.di

import br.com.manieri.guarany.ui.home.ClienteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val provideViewModel = module {
    viewModel { ClienteViewModel() }
}


