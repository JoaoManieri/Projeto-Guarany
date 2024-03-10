package br.com.manieri.guarany.repository.impl

import android.annotation.SuppressLint
import android.util.Log
import br.com.manieri.guarany.data.SQLiteHelper
import br.com.manieri.guarany.model.EstoqueEmpresa
import br.com.manieri.guarany.repository.dao.EstoqueEmpresaDao

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

    @SuppressLint("Range")
    override fun insert(estoqueEmpresa: EstoqueEmpresa): Long {
        val db = sqLiteHelper.getInstance()
        val sql = """
        INSERT INTO GUA_ESTOQUEEMPRESA (
            ESE_EMPRESA, 
            ESE_CODIGO, 
            ESE_ESTOQUE, 
            ESE_LOCAL
        ) VALUES (?, ?, ?, ?);
    """.trimIndent()

        val stmt = db.compileStatement(sql)
        stmt.bindString(1, estoqueEmpresa.empresa)
        stmt.bindString(2, estoqueEmpresa.codigo)
        stmt.bindDouble(3, estoqueEmpresa.estoque)
        stmt.bindString(4, estoqueEmpresa.local)

        val result = stmt.executeInsert()
        stmt.close()
        db.close()

        return result
    }

    @SuppressLint("Range")
    override fun delete(codigoEmpresa: String): Int {
        val db = sqLiteHelper.getInstance()
        val sql = "DELETE FROM GUA_ESTOQUEEMPRESA WHERE ESE_CODIGO = ?"

        val stmt = db.compileStatement(sql)
        stmt.bindString(1, codigoEmpresa)

        val result = stmt.executeUpdateDelete()
        stmt.close()
        db.close()

        return result
    }

    @SuppressLint("Range")
    override fun update(estoqueEmpresa: EstoqueEmpresa): Int {
        val db = sqLiteHelper.getInstance()
        val sql = """
        UPDATE GUA_ESTOQUEEMPRESA
        SET ESE_EMPRESA = ?, 
            ESE_ESTOQUE = ?, 
            ESE_LOCAL = ?
        WHERE ESE_CODIGO = ?
    """.trimIndent()

        val stmt = db.compileStatement(sql)
        stmt.bindString(1, estoqueEmpresa.empresa)
        stmt.bindDouble(2, estoqueEmpresa.estoque)
        stmt.bindString(3, estoqueEmpresa.local)
        stmt.bindString(4, estoqueEmpresa.codigo)

        val result = stmt.executeUpdateDelete()
        stmt.close()
        db.close()

        return result
    }
}