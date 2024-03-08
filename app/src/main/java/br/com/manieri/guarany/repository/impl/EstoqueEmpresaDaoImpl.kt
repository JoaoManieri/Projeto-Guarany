package br.com.manieri.guarany.repository.impl

import android.annotation.SuppressLint
import android.util.Log
import br.com.manieri.guarany.data.SQLiteHelper
import br.com.manieri.guarany.model.EstoqueEmpresa
import br.com.manieri.guarany.repository.EstoqueEmpresaDao

class EstoqueEmpresaDaoImpl(private val sqLiteHelper: SQLiteHelper) : EstoqueEmpresaDao {
    @SuppressLint("Range")
    override fun getAll(): List<EstoqueEmpresa> {

        val registros = mutableListOf<EstoqueEmpresa>()
        val db = sqLiteHelper.getInstance()

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