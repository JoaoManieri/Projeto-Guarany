package br.com.manieri.guarany.di

import br.com.manieri.guarany.ui.cliente.data.CliData
import org.koin.dsl.module

val cliente = module {
    single { CliData() }
}