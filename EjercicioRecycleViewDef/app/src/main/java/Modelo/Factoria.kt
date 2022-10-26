package Modelo

object Factoria {
    fun generarContacto(): Contacto{
        var nombre = listOf<String>("Pepe", "Juan", "Jose", "Luis")
        var apellidos = listOf<String>("Ramírez", "Herrera", "de Guzmán", "Álvarez", "Villarejo")
        var imagenes = listOf<String>("https://cdn-icons-png.flaticon.com/512/57/57108.png")
        var c = Contacto(nombre[(nombre.indices).random()], apellidos[(apellidos.indices).random()], imagenes[(imagenes.indices).random()])
        return c
    }
    fun generarAgenda(cant:Int):ArrayList<Contacto>{
        var Agenda = ArrayList<Contacto>()
        for(i in 1..cant){
            Agenda.add(generarContacto())
        }
        return Agenda
    }
}