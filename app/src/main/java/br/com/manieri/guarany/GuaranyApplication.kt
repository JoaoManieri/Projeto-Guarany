package br.com.manieri.guarany

import android.app.Application
import br.com.manieri.guarany.di.provideAppDatabase
import br.com.manieri.guarany.di.provideDao
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
                provideDao
            )
        }
    }
}