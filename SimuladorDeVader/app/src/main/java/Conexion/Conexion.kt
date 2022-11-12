package Conexion

import Modelos.Nave
import Modelos.Piloto
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity

object Conexion {
    var nombreDB = "administracion.db3"

    fun cambiarDB(nombreDB:String){
        this.nombreDB=nombreDB
    }

    fun addPiloto(contexto: AppCompatActivity, p: Piloto){
        val admin = AdminSQLiteConexion(contexto, nombreDB, null, 1)
        val db = admin.writableDatabase
        val registro = ContentValues()
        registro.put("name", p.name)
        registro.put("age", p.age)
        registro.put("exp", p.exp)
        registro.put("password", p.password)
        db.insert("pilotos", null, registro)
        db.close()
    }
    fun delPiloto(contexto: AppCompatActivity, name:String):Int{
        val admin = AdminSQLiteConexion(contexto, nombreDB, null, 1)
        val db = admin.writableDatabase
        val cant = db.delete("pilotos", "name='${name}'", null)
        db.close()
        return cant
    }
    fun addNave(contexto: AppCompatActivity, n: Nave){
        val admin = AdminSQLiteConexion(contexto, nombreDB, null, 1)
        val db = admin.writableDatabase
        val registro = ContentValues()
        registro.put("license", n.license)
        registro.put("type", n.type)
        registro.put("canCarryCargo", n.canCarryCargo)
        registro.put("canCarryPassengersvar", n.canCarryPassengers)
        registro.put("image", n.image)
        db.insert("Naves", null, registro)
        db.close()
    }
    fun delNave(contexto: AppCompatActivity, license:String):Int{
        val admin = AdminSQLiteConexion(contexto, nombreDB, null, 1)
        val db = admin.writableDatabase
        val cant = db.delete("naves", "license='${license}'", null)
        db.close()
        return cant
    }
}