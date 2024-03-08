package br.com.manieri.guarany.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.manieri.guarany.model.Cliente
import br.com.manieri.guarany.model.EstoqueEmpresa
import br.com.manieri.guarany.model.Preco
import br.com.manieri.guarany.model.Produto
import br.com.manieri.guarany.repository.EstoqueEmpresaDao

@Database(
    entities = [EstoqueEmpresa::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun estoqueEmpresaDao(): EstoqueEmpresaDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "bancomovel.db"
                )
                    .createFromAsset("databases/bancomovel.db")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }
    }
}

