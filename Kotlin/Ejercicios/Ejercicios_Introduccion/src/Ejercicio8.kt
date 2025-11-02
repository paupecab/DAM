//Ejercicio 8: Menú en consola
//Crea una función mostrarMenu() que imprima:
//1. Saludar, 2.Sumar dos numeros, 3. Salir
//Usa un when para ejecutar la opción elegida.
fun saludar(){
    println("Hola, ¿qué tal?")
    mostrarMenu()
}

fun sumar(){
    println("Introduce un numero")
    val a:Int = readln()!!.toInt()
    println("Introduce un numero")
    val b:Int = readln()!!.toInt()
    println("El resultado de la suma es: ${a+b} \n")
    mostrarMenu()
}

fun salir(){
    println("Has salido del menú.")
}

fun mostrarMenu(){
    println("Elige una opción \n1. Saludar. \n2. Sumar. \n3. Salir. \n")
    val seleccion = readln()!!.toInt()
    when (seleccion){
        1 -> saludar()
        2 -> sumar()
        3 -> salir()
    }
}

fun main(){
    mostrarMenu()
}