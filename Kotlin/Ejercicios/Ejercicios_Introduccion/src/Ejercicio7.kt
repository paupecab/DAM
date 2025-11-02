//Funcion con condicional interna
//Crea una función esMayorDeEdad(edad: Int): Boolean que devuelva true si edad >= 18.
// Desde main, pide la edad al usuario y muestra un mensaje dis􀆟nto según el resultado

fun esMayorDeEdad(edad:Int):Boolean{
    val edad:Int = edad
    if(edad >= 18){
        return true}
    else return false
}

fun main(){
    println("Introduce tu edad: ")
    val edad:Int = readln()!!.toInt()
    if (esMayorDeEdad(edad) == true){
        println("Eres mayor de edad.")
    } else {
        println("No eres mayor de edad.")
    }
}