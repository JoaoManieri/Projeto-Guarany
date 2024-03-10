package br.com.manieri.guarany.di

import br.com.manieri.guarany.repository.RepositoryCliente
import org.koin.dsl.module


val provideRepository = module {
    single<RepositoryCliente> { RepositoryCliente(get()) }
}
