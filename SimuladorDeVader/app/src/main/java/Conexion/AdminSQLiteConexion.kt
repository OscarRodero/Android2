package Conexion

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AdminSQLiteConexion(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version:Int):SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase){
        db.execSQL("create table Pilotos(name primary key, age, exp, password, image)")
        db.execSQL("create table Naves(license primary key, type, canCarryCargo, canCarryPassengers, image)")
        db.execSQL("create table Misiones(code primary key, missionType, pilotName, shipLicense, flyTime, objetivesNumber, fightersNumber, canCarryCargo, canCarryPassengers, finalized)")
    }

    override fun onUpgrade(pdb: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }
}