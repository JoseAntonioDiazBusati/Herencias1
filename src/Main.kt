open class Persona(val nombre:String, edad:Int = 0){
    var edad: Int =edad
        set(value){
            requireEdad()
            field=value
        }
    init {
        requireEdad()
        require(nombre.isNotEmpty()){"El nombre no puede estar vacío."}
    }
    private fun requireEdad(){
        require(edad>=0){"La edad no puede ser negativa."}
    }
    fun Cumple() {
        println("Ha cumplido ${++edad} añitos!!")
    }

    override fun toString(): String {
        return "Persona (nombre = $nombre, edad = $edad)"
    }
}
class Estudiante(nombre: String, edad: Int,val carrera:String): Persona(nombre,edad){
    override fun toString(): String {
        return "${super.toString().dropLast(1)}, carrera= $carrera"
    }
}
fun main(){
    val persona1=Persona("Joan Dibu",21)
    println("Soy ${persona1.nombre} de ${persona1.edad} años de edad")
    persona1.Cumple()
    val e=Estudiante("Peter",20,"ingeniería")
    println("Soy ${e.nombre} de ${e.edad} años y estudio ${e.carrera}")
}