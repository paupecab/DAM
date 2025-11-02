public class EstructurasControl {

    /* Se van a crear dos métodos para practicar las estructuras de control*/
    /* Mostrar por pantalla los números pares del 1 al 20 */
    /* Los metodos static se pueden llamar sin crear objetos
     * Los metodos public deben llamarse desde el objeto creado
     */

    /*Bucle while*/
    static void numerosParesWhile(){
        int i = 1;
        while(i<=20){
            if(i%2==0){
                System.out.println(i);
            }
            i++;
        }
    }

    /* Bucle for */
    static void numerosParesFor(){
        for(int i=2; i<=20; i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        numerosParesFor();
    }
}
