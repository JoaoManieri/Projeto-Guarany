package br.com.manieri.guarany.di

import br.com.manieri.guarany.repository.dao.ClienteDao
import br.com.manieri.guarany.repository.dao.EstoqueEmpresaDao
import br.com.manieri.guarany.repository.impl.ClienteDaoImpl
import br.com.manieri.guarany.repository.impl.EstoqueEmpresaDaoImpl
import org.koin.dsl.module

val provideDao = module {
    single<EstoqueEmpresaDao> { EstoqueEmpresaDaoImpl(get()) }
    single<ClienteDao> { ClienteDaoImpl(get()) }
}
