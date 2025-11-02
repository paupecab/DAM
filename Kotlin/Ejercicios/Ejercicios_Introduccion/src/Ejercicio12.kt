//Ejercicio 12: Bucle while
// Pide un número al usuario.
// Muestra la cuenta regresiva hasta 0 con un while.

fun main(){
    println("Introduce un número para la cuenta regresiva:")
    var contador:Int = readln()!!.toInt()
    while(contador!=0){
        contador = contador-1
        println(contador)
    }
    println("Ha finalizado la cuenta regresiva.")
}