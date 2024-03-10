package br.com.manieri.guarany

import android.app.Application
import br.com.manieri.guarany.di.cliente
import br.com.manieri.guarany.di.provideAppDatabase
import br.com.manieri.guarany.di.provideDao
import br.com.manieri.guarany.di.provideRepository
import br.com.manieri.guarany.di.provideViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GuaranyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@GuaranyApplication)
            modules(
                provideAppDatabase,
                provideDao,
                provideViewModel,
                provideRepository,
                cliente
            )
        }
    }
}