package Model

object Almacen {
    var Almacenaje = ArrayList<Registro>()
    fun addRegistro(re:Registro){
        this.Almacenaje.add(re)
    }
}