import java.sql.Array;
import java.util.*;
import java.io.IOException;

import static java.lang.String.join;

public class Main {
    //FELIPE DUARTE F-301M//
    //Ejercicios Taller #1//
    //2024//
    public static void main(String[] arg) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        int opcion_usuario;

        //Menu Opciones Visual
        System.out.println("Ingrese su opcion: ");
        System.out.println("[1] Tablas Multiplicar");
        System.out.println("[2] Calcular numeros Array");
        System.out.println("[3] Puede Votar");
        System.out.println("[4] Contar Numeros / Promedio");
        System.out.println("[5] Promedio Estudiantes");
        System.out.println("[6] Salir");

        opcion_usuario = input.nextInt();
        //Proceso segun la opcion del usuario
        switch (opcion_usuario) {
            case 1:
                //Se llaman las funciones limpiarPantalla y TablasMultiplicar
                limpiarPantalla();
                tablasMultiplicar();
                break;
            case 2:
                limpiarPantalla();
                System.out.println("Ingrese la longitud de numeros que desea ingresar: ");
                int longitud_array = input.nextInt();
                arrayContadorPositivosNegativos(longitud_array);
                break;
            case 3:
                limpiarPantalla();
                puedeVotar();
                break;
            case 4:
                limpiarPantalla();
                promedioNumeros();
                break;
            case 5:
                limpiarPantalla();
                vectorMultidimensional();
                break;
            case 6:
                limpiarPantalla();
                System.out.println("Adios!");
                break;
        }
    }

    //Funcion para imitar la limpieza de la consola
    static void limpiarPantalla() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    //Se imprimen las tablas de multiplicar desde el 1 al 10 con el numero que proporcione el usuario
    static void tablasMultiplicar() {
        Scanner input = new Scanner(System.in);
        int multiplicador;
        System.out.println("Ingrese el numero a multiplicar: ");
        multiplicador = input.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println("[" + i + "] " + multiplicador + "x" + i + " = " + (multiplicador * i));
        }
    }

    //Se pide un rango de numeros elegido por el usuario
    //Imprime el total de numeros negativos, positivos y ceros
    static void arrayContadorPositivosNegativos(int len_array) {
        Scanner input = new Scanner(System.in);
        System.out.println("Por favor ingrese " + len_array + " numeros: ");

        //Se inician las variables
        List<Integer> numeros = new ArrayList<>();
        int positivos = 0;
        int negativos = 0;
        int ceros = 0;

        //Se añaden los numeros que introduce el usuario a la ArrayList
        for (int i = 0; i < len_array; i++) {
            numeros.add(input.nextInt());
        }

        //Utilizando un forEach se evaluan los valores y se aumentan los contadores
        for (int numero: numeros) {
            if (numero > 0) {
                positivos += 1;
            }
            else if (numero < 0) {
                negativos += 1;
            }
            else {
                ceros += 1;
            }
        }

        //Se llama a la funcion limpiarPantalla
        limpiarPantalla();

        //Se imprimen resultados
        System.out.println("Numeros: " + numeros.toString());
        System.out.println("Positivos: " + positivos);
        System.out.println("Negativos: " + negativos);
        System.out.println("Ceros: " + ceros);
    }

    //Evalua si el usuario puede votar segun su edad
    //Imprime el resultado y su año de nacimiento sefun edad
    static void puedeVotar() {
        //Se inicia variable para el bucle
        boolean salir = false;
        Scanner input = new Scanner(System.in);

        while (!salir) {
            System.out.println("Ingrese su edad: ");
            int edad = input.nextInt();

            //Se hace el calculo del año de nacimiento segun edad
            int ano_actual = 2024;
            int ano_nacimiento_usuario = ano_actual - edad;

            //Comprueba si puede votar e imprime el resultado
            if (edad >= 18) {
                System.out.println("Usted es apropiado para votar, su año de nacimiento es: " + ano_nacimiento_usuario);
            }
            else {
                System.out.println("Usted NO es apropiado para votar, es menor de edad, su año de nacimiento es: " + ano_nacimiento_usuario);
            }

            //Se comprueba si el usuario desea salir o seguir verificando personas
            System.out.println();
            System.out.println("Si desea salir ingrese la letra Q y luego enter");
            String decision_usuario = input.next();

            //Se rompe el bucle
            if (decision_usuario.toLowerCase().equals("q")) {
                salir = true;
                break;
            }

            limpiarPantalla();
        }
    }

    //Imprime las veces que se introdujo un numero y calcula el promedio de los 10 digito ingresados
    static void promedioNumeros() {
        Scanner input = new Scanner(System.in);

        //Se declara un Map para guardar los numeros que se van contando
        HashMap<Integer, Integer> numeros_contados = new HashMap<Integer, Integer>();

        //Se declara Array
        int[] numeros = new int[10];
        System.out.println("Ingrese 10 numeros: ");

        //Se guardan los valores en el vector
        for (int i = 0; i < 10; i++) {
            numeros[i] = input.nextInt();
        }

        //Itear el Array para comprobar si ya existe en el Map, en caso de que no lo añade
        for (int numero: numeros) {
            //En caso de que si suma 1 a el numero guardado anteriormente
            if (numeros_contados.containsKey(numero)) {
                numeros_contados.put(numero, numeros_contados.get(numero) + 1);
            } else {
                numeros_contados.put(numero, 1);
            }
        }

        //Se llama funcion limpiarPantalla
        limpiarPantalla();

        //Recorre el Map para imprimir su Key: Value
        for (Map.Entry<Integer, Integer> numero: numeros_contados.entrySet()) {
            System.out.println("Numero: " + numero.getKey() + " total -> " + numero.getValue());
        }

        //Se declara variable para suma
        float sumatoria = 0;

        //Se hace la suma mediante un forEach
        for (int numero: numeros) {
            sumatoria += numero;
        }

        //Se calcula el promedio
        float promedio = sumatoria / numeros.length;

        System.out.println();
        System.out.println("Promedio de los numeros: " + promedio);
    }

    //Se guardan notas en una matriz y calcula su promedio para mostrarlo
    static void vectorMultidimensional() {
        Scanner input = new Scanner(System.in);

        //Se declara la Matriz como double para guardar datos double (3.5434345)
        double alumnos[][] = new double[5][4];

        //Se usan dos bucle for, uno para iterar las filas de la matriz y el
        //for de adentro se utiliza para iterar las columnas y guardar las notas
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Ingrese la " + (j + 1) + " nota del estudiante [" + (i + 1) + "]: ");
                alumnos[i][j] = input.nextInt();
            }
        }

        //Se guarda el promedio en la ultima columna de cada fila de la matriz
        for (int i = 0; i < 5; i++) {
            alumnos[i][3] = (alumnos[i][0] + alumnos[i][1] + alumnos[i][2] + alumnos[i][3]) / 3;
        }

        //Por medio de dos bucles se imprime el resultado
        for (int i = 0; i < 5; i++) {
            System.out.println();
            System.out.println("Promedio Alumno " + (i + 1) + ": ");
            for (int j = 0; j < 4; j++) {
                //Se hacen comprobaciones para imprimir de una forma bonita
                //el resultado
                if (j == 3) {
                    System.out.print(" = ");
                    System.out.print(alumnos[i][j]);
                } else {
                    System.out.print(alumnos[i][j]);
                    if (j != 2){
                        System.out.print(" + ");
                    }
                }
            }
            System.out.println();
        }
    }
}