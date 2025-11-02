//Ejercicio 6: Funcion con retorno
//Crea una función sumar(a: Int, b: Int): Int que devuelva la suma.
//Pide los valores por consola y muestra el resultado usando la función.

fun sumar(a:Int, b:Int):Int {
    return a+b
}

fun main(){
    println("Introduce el primer sumando: ")
    val a:Int = readln()!!.toInt()
    println("Introduce el segundo sumando: ")
    val b:Int = readln()!!.toInt()
    val c = sumar(a,b)

    println("El resultado es: $c")
}