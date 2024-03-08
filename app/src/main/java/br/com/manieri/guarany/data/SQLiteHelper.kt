package br.com.manieri.guarany.data

import android.annotation.SuppressLint
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

    @SuppressLint("Range")
    fun getAllRegistros(): List<EstoqueEmpresa> {
        val registros = mutableListOf<EstoqueEmpresa>()
        val db = readableDatabase

        val cursor = db.rawQuery("SELECT * FROM GUA_ESTOQUEEMPRESA", null)
        cursor.use {
            while (it.moveToNext()) {
                val eseLocal = it.getString(it.getColumnIndex("ESE_LOCAL"))
                val eseEmpresa = it.getString(it.getColumnIndex("ESE_EMPRESA"))
                val eseCodigo = it.getString(it.getColumnIndex("ESE_CODIGO"))
                val eseEstoque = it.getDouble(it.getColumnIndex("ESE_ESTOQUE"))
                val guaTst = EstoqueEmpresa(eseEmpresa,eseCodigo,eseEstoque,eseLocal)
                registros.add(guaTst)
            }
        }
        db.close()
        Log.w("TAG", "getAllRegistros: $registros", )
        return registros
    }
}
