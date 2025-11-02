import java.util.Arrays; // Importación de métodos de clase Arrays

public class Arrays_Ejercicio1 {

    public static void main(String[] args) {


        // a. DECLARACION Y CREACION DE ARRAYS
        String[] nombres = new String[4]; // Array unidimensional de nombres
        int[][] horas = new int[4][5];    // Array bidimensional: 100 empleados, 5 días

        // Aunque el enunciado solicita crear arrays para este caso práctico, en la 
        // práctica y situación de esta empresa y para satisfacer sus necesidades en el futuro
        // un ArrayList sería más flexible y eficiente en términos de escalabilidad.
        // Por ahora se ha asumido que hay 4 empleados.


        // b. INICIALIZACIÓN Y ACCESO A ELEMENTOS:

        // Inicializando arrays con datos de ejemplo
        // Nombres
        nombres[0] = "Alicia";
        nombres[1] = "Sergio";
        nombres[2] = "Marta";
        nombres[3] = "Alberto";

        // Horas[i][j]= i=empleado , j=dias --> 5 días (lunes a viernes)
        horas[0] = new int[]{8, 8, 8, 6, 7};    // Posición horas[0] = nombres [0]: Alicia
        horas[1] = new int[]{7, 6, 8, 9, 8};    // Posición horas[1] = nombres [1]: Sergio
        horas[2] = new int[]{6, 7, 7, 7, 7};    // Posición horas[2] = nombres [2]: Marta
        horas[3] = new int[]{8, 8, 8, 9, 9};    // Posición horas[3] = nombres [3]: Alberto

        // Acceso al tercer nombre de empleado 
        System.out.println("Tercer empleado: " + nombres[2]); // Marta

        // Mostrar horas del segundo empleado el martes
        System.out.println("Horas del segundo empleado, " + nombres[1] + ", el martes: " + horas[1][1]); 
        // Sergio, 6


        // c. RECORRIDOS Y BÚSQUEDA:

        // Recorre lista de empleados y muestra sus nombres con salto de línea \n
        System.out.println("\nLista de empleados:");
        for (String nombre : nombres) {  // Bucle for: por cada elemento en array nombres:
            System.out.println("\n" + nombre);  // Imprime un nombre con salto de línea
        }

        // Buscar un nombre
        String buscado = "Marta"; // Nueva variable 'buscado', tipo String, valor "Marta"
        boolean encontrado = false; // Nueva variable 'encontrado', tipo Booleano, valor 'false'
        for (String nombre : nombres) { // Para cada elemento en nombres
            if (nombre.equalsIgnoreCase(buscado)) { // Se compara el elemento con 'buscado' 
            // ignorando mayúsculas o minúsculas
                encontrado = true; // Entonces la variable 'encontrado' toma el valor 'true'
                break; // Salida del bucle cuando 'encontrado = true'
            }
        }
        // Mostrar si se encuentra o no
        System.out.println("\n¿Se encontró a " + buscado + "? "
         + (encontrado ? "Sí" : "No")); 
         // Operador ternario ? : Si encontrado es true --> "Sí"; si es false --> "No"


        // d. ORDENACIÓN:

        // Ordenar nombres alfabéticamente
        System.out.println("\nNombres ordenados alfabéticamente:");
        Arrays.sort(nombres); // Método sort de la clase Arrays importado al inicio
        for (String nombre : nombres) { // Por cada elemento en nombre ya ordenado
            System.out.println(nombre); // Imprimir nombre
        }

        // Ordenar empleados por total de horas trabajadas

        // Cálculo de totales y asociación a nombres

        int[] totales = new int[4]; // Array que guarda total de horas por empleado
        // totales[i] = nombres[i]

        for (int i = 0; i < horas.length; i++) { 
            // Contador i que empieza en 0
            // se incrementa en 1 al final de cada iteración
            int suma = 0; 
            // Variable suma que empieza en 0 y que guarda el total de horas cada empleado
            for (int j = 0; j < horas[i].length; j++) {
                // Contador j para recorrer cada elemento j, se incrementa en 1, 
                // No mayor al numero de elementos por empleado.
                suma += horas[i][j]; 
                // Por cada i se suman los elementos j del array horas
            }
            totales[i] = suma; 
            // El total de horas de cada empleado se guarda en el array totales3
        }

        // Ordenación ascendente por totales usando bubble sort
        for (int i = 0; i < totales.length - 1; i++) {
            for (int j = 0; j < totales.length - i - 1; j++) {
                if (totales[j] > totales[j + 1]) {
                    // Intercambiar totales
                    int tempHoras = totales[j];
                    totales[j] = totales[j + 1];
                    totales[j + 1] = tempHoras;

                    // intercambiar nombres
                    String tempNombre = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = tempNombre;

                    // Intercambiar arrays de horas
                    int[] tempArray = horas[j];
                    horas[j] = horas[j + 1];
                    horas[j + 1] = tempArray;
                }
            }
        }

        // Imprimir Empleados ordenados
        System.out.println("\nEmpleados ordenados por total de horas trabajadas:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i] + ": " + totales[i] + " horas");
        }
    }
}
