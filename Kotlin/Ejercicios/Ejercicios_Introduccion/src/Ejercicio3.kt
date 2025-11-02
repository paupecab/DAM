//􎇺􎇻􎇼􎇽􎇾 Ejercicio 3: val vs var
//Declara un val con el año de nacimiento.
//eclara un var con la edad.
//Cambia la edad y muestra por consola el resultado.
//Explica en un comentario por qué val no se puede reasignar.

fun main(){
    val nacimiento : Int = 1998
    var edad : Int = 27
    println("El año de nacimiento es $nacimiento y la edad es $edad")
    edad = 28
    println("Ha pasado un año, el año de nacimiento es $nacimiento y la edad es ahora $edad")
    //var es una variable mutable, pero val es inmutable y no se puede cambiar una vez asignado un valor
}