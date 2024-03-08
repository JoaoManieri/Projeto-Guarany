package br.com.manieri.guarany.di

import br.com.manieri.guarany.data.SQLiteHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

//val appModule = module {
//
//}

val provideAppDatabase = module {
    single {
        SQLiteHelper(androidContext())
    }
}