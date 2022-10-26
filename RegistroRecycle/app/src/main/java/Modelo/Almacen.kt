package Modelo

object Almacen {
    var Almacenaje = ArrayList<Apunte>()
    fun addApunte(re:Apunte){
        this.Almacenaje.add(re)
    }
}