package Conexion

import Modelos.Mision
import Modelos.Nave
import Modelos.Piloto
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import com.example.simuladordevader.AltaNaves

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

    /**
     * Busca el piloto por su nombre y lo borra.
     */
    fun delPiloto(contexto: AppCompatActivity, name:String):Int{
        val admin = AdminSQLiteConexion(contexto, nombreDB, null, 1)
        val db = admin.writableDatabase
        val cant = db.delete("pilotos", "name='${name}'", null)
        db.close()
        return cant
    }

    /**
     * Devuelve si el piloto se encuentra o no en la base de datos
     */
    fun buscarPiloto(contexto:AppCompatActivity, name:String):Boolean{
        val admin = AdminSQLiteConexion(contexto, nombreDB, null, 1)
        val db = admin.writableDatabase
        val pilotosEncontrados = db.rawQuery("SELECT * FROM Pilotos WHERE name='${name}'", null)
        var existe:Boolean = false
        if(pilotosEncontrados.moveToFirst()){
            existe=true
        }
        return existe
    }
    /**
     * Devuelve un array de los pilotos
     */
    fun obtenerPilotos(contexto: AppCompatActivity):ArrayList<Piloto>{
        var misPilotos:ArrayList<Piloto> = ArrayList(1)
        val admin = AdminSQLiteConexion(contexto, nombreDB, null, 1)
        val db = admin.writableDatabase
        val pilotosEncontrados = db.rawQuery("SELECT * FROM Pilotos", null)
        while(pilotosEncontrados.moveToNext()){
            var p:Piloto=Piloto(pilotosEncontrados.getString(0), pilotosEncontrados.getInt(1), pilotosEncontrados.getInt(2), pilotosEncontrados.getString(3))
            misPilotos.add(p)
        }
        db.close()
        return misPilotos
    }
    /**
     * Busca la matrícula que le pasas en la lista de naves. Si la encuentra, devuelve verdadero, sino, devuelve falso.
     */
    fun buscarNave(contexto:AppCompatActivity, nave:String):Nave?{
        var n:Nave?=null
        val admin = AdminSQLiteConexion(contexto, nombreDB, null, 1)
        val db = admin.writableDatabase
        val linea = db.rawQuery("SELECT * FROM Naves WHERE license='${nave}'", null)
        if(linea.moveToFirst()){
            n = Nave(nave, linea.getString(0), linea.getInt(1), linea.getInt(2), linea.getString(3))
        }
        return n
    }

    /**
     * Permite añadir una nueva nave a la base de datos.
     */
    fun addNave(contexto: AppCompatActivity, n: Nave){
        val admin = AdminSQLiteConexion(contexto, nombreDB, null, 1)
        val db = admin.writableDatabase
        val registro = ContentValues()
        registro.put("license", n.license)
        registro.put("type", n.type)
        registro.put("canCarryCargo", n.canCarryCargo)
        registro.put("canCarryPassengers", n.canCarryPassengers)
        registro.put("image", n.image)

        db.insert("Naves", null, registro)
        db.close()
    }

    /**
     * Borra una nave de la tabla al pasarle su número de matrícula.
     */
    fun delNave(contexto: AppCompatActivity, license:String):Int{
        val admin = AdminSQLiteConexion(contexto, nombreDB, null, 1)
        val db = admin.writableDatabase
        val cant = db.delete("naves", "license='${license}'", null)
        db.close()
        return cant
    }

    /**
     * Retorna el piloto buscado.
     */
    fun conectar(contexto:AppCompatActivity, nombre:String):Piloto? {
        var n:Piloto?=null
        val admin = AdminSQLiteConexion(contexto, nombreDB, null, 1)
        val db = admin.writableDatabase
        val linea = db.rawQuery("SELECT * FROM Pilotos WHERE name='${nombre}'", null)
        if(linea.moveToFirst()){
            n = Piloto(linea.getString(0), linea.getInt(1), linea.getInt(2), linea.getString(3))
        }
        return n
    }

    fun addMision(contexto: AppCompatActivity, m: Mision){
        val admin = AdminSQLiteConexion(contexto, nombreDB, null, 1)
        val db = admin.writableDatabase
        val registro = ContentValues()
        registro.put("code", m.code)
        registro.put("missionType", m.missionType)
        registro.put("pilotName", m.pilotName)
        registro.put("shipLicense", m.shipLicense)
        registro.put("flyTime", m.flyTime)
        registro.put("objetivesNumber", m.objetivesNumber)
        registro.put("fightersNumber", m.enemies)
        registro.put("canCarryCargo", m.gotCargo)
        registro.put("canCarryPassengers", m.gotPassanger)
        db.insert("Misiones", null, registro)
        db.close()
    }
}