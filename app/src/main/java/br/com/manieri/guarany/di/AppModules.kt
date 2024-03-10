package br.com.manieri.guarany.di

import br.com.manieri.guarany.data.SQLiteHelper
import br.com.manieri.guarany.repository.RepositoryCliente
import br.com.manieri.guarany.ui.home.ClienteViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val provideAppDatabase = module {
    single {
        SQLiteHelper(androidContext())
    }
}