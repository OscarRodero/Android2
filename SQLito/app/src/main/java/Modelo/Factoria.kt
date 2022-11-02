package Modelo

object Factoria {
    var MisPersonas:ArrayList<Persona> = Factoria.generarPersonas()

    private fun generarPersonas(): ArrayList<Persona> {
        var x = Persona("1", "A", "10")
        var Lista = ArrayList<Persona>()
        Lista.add(x)
        return Lista
    }

}