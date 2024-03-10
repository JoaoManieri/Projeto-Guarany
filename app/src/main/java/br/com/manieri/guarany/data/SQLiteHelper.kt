package br.com.manieri.guarany.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class SQLiteHelper(val context: Context) : SQLiteOpenHelper(context, "bancomovel.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    private fun copyDatabase() {
        // Abre o arquivo que deve estar na pasta assets
        val inputStream: InputStream = context.assets.open("bancomovel.db")
        // Abre o arquivo do banco vazio na pasta de dados
        val outputStream: FileOutputStream = FileOutputStream(context.getDatabasePath("bancomovel.db"))
        // Copia byte a byte o arquivo do assets para a pasta de dados
        val buffer = ByteArray(1024)
        var length: Int
        while (inputStream.read(buffer).also { length = it } > 0) {
            outputStream.write(buffer, 0, length)
        }
        // Fecha os fluxos de entrada e saída
        outputStream.flush()
        outputStream.close()
        inputStream.close()
    }

    // Verifica se o banco de dados já existe na pasta de dados do aplicativo
    fun checkDatabase(): Boolean {
        Log.w("TAG", "checkDatabase: SIM", )
        val dbFile: File = context.getDatabasePath("bancomovel.db")
        Log.w("TAG", "checkDatabase: dbFile ${dbFile.exists()}", )
        Log.w("TAG", "checkDatabase: dbFile ${dbFile.canRead()}", )
        return dbFile.exists() && dbFile.canRead()
    }

    // Abre o banco de dados e retorna uma instância de SQLiteDatabase
    fun getInstance(): SQLiteDatabase {
        // Verifica se o banco de dados já existe
        if (!checkDatabase()) {
            // Se não existir, copia o banco de dados da pasta assets
            copyDatabase()
        }
        // Retorna o banco de dados aberto para leitura e escrita
        return getWritableDatabase()
    }
}
