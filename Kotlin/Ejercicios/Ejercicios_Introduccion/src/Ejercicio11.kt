// Ejercicio 11: Bucle for
// Muestra los números del 1 al 10 usando for.
// Luego muestra solo los pares del 1 al 20.

fun numeros(){
    println("Mostrando los números del 1 al 10:")
    for(i in 1..10){
        println(i)
    }
}

fun pares(){
    //iteración con avance de 2
    println("Mostrando los pares del 1 al 20:")
    for(i in 2..20 step 2){
        println(i)
    }
}

fun main(){
    numeros()
    pares()
}