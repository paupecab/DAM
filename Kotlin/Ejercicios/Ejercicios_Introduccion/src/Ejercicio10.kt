// Ejercicio 10: Condicional múltiple con when
// Pide al usuario un número del 1 al 7.
// Usa when para mostrar el día de la semana correspondiente.
// Usa else para manejar valores fuera de rango.

fun diasSemana(dia: Int){
    val dias = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
    when(dia){
        1 -> println(dias[0])
        2 -> println(dias[1])
        3 -> println(dias[2])
        4 -> println(dias[3])
        5 -> println(dias[4])
        6 -> println(dias[5])
        7 -> println(dias[6])
        else -> println("Valor $dia está fuera de rango.")
    }
}

fun main() {
    println("Introduce un número del 1 al 7")
    val dia:Int = readln()!!.toInt()
    diasSemana(dia)
}