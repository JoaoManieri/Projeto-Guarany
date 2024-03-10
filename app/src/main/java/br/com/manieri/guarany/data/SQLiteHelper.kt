package br.com.manieri.guarany.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class SQLiteHelper(val context: Context) : SQLiteOpenHelper(context, "bancomovel.db", null, 1) {

    fun getInstance(): SQLiteDatabase {
        if (!checkDatabase()) {
            copyDatabase()
        }
        return writableDatabase
    }

    override fun onCreate(db: SQLiteDatabase?) {
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    private fun copyDatabase() {
        val inputStream: InputStream = context.assets.open("bancomovel.db")
        val outputStream: FileOutputStream = FileOutputStream(context.getDatabasePath("bancomovel.db"))
        val buffer = ByteArray(1024)
        var length: Int
        while (inputStream.read(buffer).also { length = it } > 0) {
            outputStream.write(buffer, 0, length)
        }
        outputStream.flush()
        outputStream.close()
        inputStream.close()
    }
    private fun checkDatabase(): Boolean {
        val dbFile: File = context.getDatabasePath("bancomovel.db")
        return dbFile.exists() && dbFile.canRead()
    }

}
