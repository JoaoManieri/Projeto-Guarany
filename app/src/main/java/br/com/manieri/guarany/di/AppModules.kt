package br.com.manieri.guarany.di

import androidx.room.Room
import br.com.manieri.guarany.data.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    //single { get<AppDatabase>().yourDao() }
    //viewModelOf()
}

val provideAppDatabase = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "bancomovel.db"
        )
            .createFromAsset("bancomovel.db")
            .build()
    }
}