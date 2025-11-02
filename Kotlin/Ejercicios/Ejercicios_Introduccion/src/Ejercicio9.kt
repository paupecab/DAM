//Ejercicio 9: Condicional simple
//Declara una variable nota.
//Usa un if para imprimir “Aprobado” si es ≥ 5, o “Suspenso” en caso contrario

fun main() {
    println("¿Cuál es tu nota?")
    val nota:Double = readln()!!.toDouble()
    if(nota>=5){
        println("Aprobado :)")
    }else{
        println("Suspenso :(")
    }
}