//En una compañía necesitan saber cuánto le tienen que pagar de salario semanal a un
//empleado que trabaja X horas a la semana teniendo en cuenta lo siguiente
//1- El pago es de 50.50 dólares por hora trabajada
//2- Si el empleado trabaja más de 40 horas a la semana las horas adicionales son
//declaras horas extras y se pagan lo que vale una hora normal más la mitad de esa
//misma hora.
//Codifica en Kotlin cómo sería la aplicación que, solicitando por pantalla el “nombre del
//empleado” y las “horas trabajadas”, calcule el salario semanal que percibirá el empleado

fun calculoHoras(horas: Int, nombre: String){
    val nombre: String = nombre
    var horas: Int = horas
    var horasExtra: Int = 0
    val precioHoras: Double = 50.50
    val precioExtra: Double = precioHoras*1.5
    val salario: Double
//378.75
    if (horas>40){
        horasExtra = horas - 40
        horas = 40
    }
    salario = (precioHoras*horas) + (precioExtra*horasExtra)
    println ("El salario semanal de $nombre es de $salario $")
}

fun main() {
    println("Introduce el nombre del empleado: ")
    val nombre: String = readln()
    println("Introduce las horas trabajadas esta semana: ")
    val horas: Int = readln()!!.toInt()

    calculoHoras(horas, nombre)
}