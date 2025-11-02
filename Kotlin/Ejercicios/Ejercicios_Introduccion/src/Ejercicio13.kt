//Ejercicio 13: Mini programa combinado
//Pide la edad de 5 personas (en un bucle).
//Usa la función esMayorDeEdad para contar cuántas son mayores de 18.
//Al final, imprime: "Hay X personas mayores de edad".

fun contarMenores(){
    val edades = IntArray(5)
    for (i in 0..4){
        println("¿Qué edad tienes?")
        val edad:Int = readln()!!.toInt()
        edades[i] = edad
    }
    var menores:Int=0
    for (edad in edades){
        if(edad<18){
            menores ++
        }
    }
    println("El numero de menores de edad es: "+ menores)
}

fun main(){
    contarMenores()
}