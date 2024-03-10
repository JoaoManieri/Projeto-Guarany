package br.com.manieri.guarany.repository.impl

import android.annotation.SuppressLint
import br.com.manieri.guarany.data.SQLiteHelper
import br.com.manieri.guarany.model.Cliente
import br.com.manieri.guarany.repository.dao.ClienteDao
import br.com.manieri.guarany.repository.dto.ClienteListView

class ClienteDaoImpl(private val sqLiteHelper: SQLiteHelper) : ClienteDao {

    @SuppressLint("Range")
    override fun getListaCLiente(): List<ClienteListView> {
        val registros = mutableListOf<ClienteListView>()
        val db = sqLiteHelper.getInstance()

        val cursor = db.rawQuery(
            "SELECT CLI_CODIGOCLIENTE, CLI_RAZAOSOCIAL, CLI_CGCCPF,  CLI_NOMEFANTASIA FROM GUA_CLIENTES",
            null
        )
        cursor.use {
            while (it.moveToNext()) {
                val codigoCliente = it.getString(it.getColumnIndex("CLI_CODIGOCLIENTE"))
                val razaoSocial = it.getString(it.getColumnIndex("CLI_RAZAOSOCIAL"))
                val nomeFantasia = it.getString(it.getColumnIndex("CLI_CGCCPF"))
                val cgccpf = it.getString(it.getColumnIndex("CLI_NOMEFANTASIA"))
                val clienteListView =
                    ClienteListView(codigoCliente, razaoSocial, nomeFantasia, cgccpf)
                registros.add(clienteListView)
            }
        }
        db.close()
        return registros
    }

    @SuppressLint("Range")
    override fun getClienteById(codigoCliente: String): Cliente {
        val db = sqLiteHelper.getInstance()

        val sql = "SELECT * FROM GUA_CLIENTES WHERE CLI_CODIGOCLIENTE = ?"
        val selectionArgs = arrayOf(codigoCliente)

        val cursor = db.rawQuery(sql, selectionArgs)

        var cliente: Cliente? = null
        if (cursor.moveToFirst()) {
            cliente = Cliente(
                cursor.getString(cursor.getColumnIndex("CLI_CODIGOCLIENTE")),
                cursor.getString(cursor.getColumnIndex("CLI_RAZAOSOCIAL")),
                cursor.getString(cursor.getColumnIndex("CLI_CGCCPF")),
                cursor.getString(cursor.getColumnIndex("CLI_ENDERECO")),
                cursor.getString(cursor.getColumnIndex("CLI_NUMERO")),
                cursor.getString(cursor.getColumnIndex("CLI_COMPLEMENTO")),
                cursor.getString(cursor.getColumnIndex("CLI_BAIRRO")),
                cursor.getString(cursor.getColumnIndex("CLI_CODIGOMUNICIPIO")),
                cursor.getString(cursor.getColumnIndex("CLI_TELEFONE")),
                cursor.getString(cursor.getColumnIndex("CLI_CEP")),
                cursor.getString(cursor.getColumnIndex("CLI_STATUS")),
                cursor.getString(cursor.getColumnIndex("CLI_NOMEFANTASIA")),
                cursor.getString(cursor.getColumnIndex("CLI_DATACADASTRO")),
            )
        }
        cursor.close()
        db.close()
        return cliente!!
    }

    @SuppressLint("Range")
    override fun insert(cliente: Cliente): Long {
        val db = sqLiteHelper.getInstance()
        val sql = """
        INSERT INTO GUA_CLIENTES (
            CLI_CODIGOCLIENTE,
            CLI_RAZAOSOCIAL, 
            CLI_CGCCPF, 
            CLI_ENDERECO, 
            CLI_NUMERO,
            CLI_COMPLEMENTO,
            CLI_BAIRRO,
            CLI_CODIGOMUNICIPIO,
            CLI_TELEFONE,
            CLI_CEP,
            CLI_STATUS,
            CLI_NOMEFANTASIA,
            CLI_DATACADASTRO
        ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? );
    """.trimIndent()

        val stmt = db.compileStatement(sql)
        stmt.bindString(1, cliente.codigoCliente)
        stmt.bindString(2, cliente.razaoSocial)
        stmt.bindString(3, cliente.cgccpf)
        stmt.bindString(4, cliente.endereco)
        stmt.bindString(5, cliente.numero)
        stmt.bindString(6, cliente.complemento)
        stmt.bindString(7, cliente.bairro)
        stmt.bindString(8, cliente.codigoMunicipio)
        stmt.bindString(9, cliente.telefone)
        stmt.bindString(10, cliente.cep)
        stmt.bindString(11, cliente.status)
        stmt.bindString(12, cliente.nomeFantasia)
        stmt.bindString(13, cliente.dataCadastro)

        val result = stmt.executeInsert()
        stmt.close()
        db.close()

        return result
    }

    @SuppressLint("Range")
    override fun delete(cliente: String): Int {
        val db = sqLiteHelper.getInstance()
        val sql = "DELETE FROM GUA_CLIENTES WHERE CLI_CODIGOCLIENTE = ?"

        val stmt = db.compileStatement(sql)
        stmt.bindString(1, cliente)

        val result = stmt.executeUpdateDelete()
        stmt.close()
        db.close()

        return result
    }

    @SuppressLint("Range")
    override fun update(cliente: Cliente): Int {
        val db = sqLiteHelper.getInstance()
        val sql = """
        UPDATE GUA_CLIENTES
        SET 
            CLI_RAZAOSOCIAL = ?, 
            CLI_CGCCPF = ?, 
            CLI_ENDERECO = ?, 
            CLI_NUMERO = ?,
            CLI_COMPLEMENTO = ?,
            CLI_BAIRRO = ?,
            CLI_CODIGOMUNICIPIO = ?,
            CLI_TELEFONE = ?,
            CLI_CEP = ?,
            CLI_STATUS = ?,
            CLI_NOMEFANTASIA = ?,
            CLI_DATACADASTRO = ?
        WHERE CLI_CODIGOCLIENTE = ?
    """.trimIndent()

        val stmt = db.compileStatement(sql)

        stmt.bindString(1, cliente.razaoSocial)
        stmt.bindString(2, cliente.cgccpf)
        stmt.bindString(3, cliente.endereco)
        stmt.bindString(4, cliente.numero)
        stmt.bindString(5, cliente.complemento)
        stmt.bindString(6, cliente.bairro)
        stmt.bindString(7, cliente.codigoMunicipio)
        stmt.bindString(8, cliente.telefone)
        stmt.bindString(9, cliente.cep)
        stmt.bindString(10, cliente.status)
        stmt.bindString(11, cliente.nomeFantasia)
        stmt.bindString(12, cliente.dataCadastro)
        stmt.bindString(13, cliente.codigoCliente)

        val result = stmt.executeUpdateDelete()
        stmt.close()
        db.close()

        return result
    }
}