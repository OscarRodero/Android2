package Modelo

object Almacen {
    var Almacenaje = ArrayList<Apunte>()
    fun addRegistro(re:Apunte){
        this.Almacenaje.add(re)
    }
}