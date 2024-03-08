package br.com.manieri.guarany.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import br.com.manieri.guarany.model.EstoqueEmpresa

class SQLiteHelper(context: Context) : SQLiteOpenHelper(context, "bancomovel.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun getInstance() = readableDatabase

}
