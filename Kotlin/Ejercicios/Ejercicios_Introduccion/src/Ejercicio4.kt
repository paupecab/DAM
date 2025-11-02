//Ejercicio 4: Lectura desde consola
//Usa readLine() para pedir datos al usuario:
//Pide nombre, edad y ciudad, y muestra un mensaje personalizado.
fun main(){
    println("Introduce tu nombre: ")
    val nombre : String? = readlnOrNull()

    println("Introduce tu edad: ")
    val edad : Int = readln()!!.toInt()

    println("Introduce la ciudad donde resides: ")
    val ciudad : String = readln()

    println("Eres $nombre , tienes $edad años y vives en $ciudad")
    println("Dentro de 5 años tendras ${edad+5} años.")
}