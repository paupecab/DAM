//Ejercicio 5: Funcion de saludo. Llamar desde el main.

fun saludar(nombre:String){
    println("Hola, $nombre !")
}

fun main() {
    println("¿Cómo te llamas?")
    val nombre:String = readln()

    saludar(nombre)
}

