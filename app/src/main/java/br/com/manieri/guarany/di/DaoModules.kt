package br.com.manieri.guarany.di

import br.com.manieri.guarany.data.SQLiteHelper
import br.com.manieri.guarany.repository.EstoqueEmpresaDao
import br.com.manieri.guarany.repository.impl.EstoqueEmpresaDaoImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val provideDao = module {
    single<EstoqueEmpresaDao> { EstoqueEmpresaDaoImpl(get()) }
}
