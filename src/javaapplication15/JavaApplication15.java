package javaapplication15;

import java.io.*;
import java.util.Scanner;

public class JavaApplication15 {
    public static double[] insertion_sort(double[] unsorted){
        for (int i = 1 ; i < unsorted.length ; i++){    
            double aux = unsorted[i];
            int j = i-1;
            
            while(j>=0 && unsorted[j] > aux){
                unsorted[j+1] = unsorted[j];
                j--;
            }
            unsorted[j+1] = aux;
        }
        return unsorted;
    } 
    public static double obtener_mayor (double[] array){
        double mayor = 0;
        for (int i = 0 ; i < array.length ; i++){
            if(i == 0){
                mayor = array[i];
            } else {
                if(array[i] > mayor){
                    mayor = array[i];
                }
            }  
        }
        return mayor;
    }
    public static double obtener_menor (double[] array){
        double menor = 0;
        for (int m = 0 ; m < array.length ; m++){
            if(m == 0){
                menor = array[m];
            } else {
                if(array[m] < menor){
                    menor = array[m];
                }
            }  
        }
        return menor;
    }
    
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Que desea hacer");
        System.out.println("1 - Registrar");
        System.out.println("2 - Leer el registro");
        
        int menu = input.nextInt();
        
        if(menu == 2){
            BufferedReader file = new BufferedReader(new FileReader("registro.txt"));
            
            String line = file.readLine();
            
            while(line != null){
            
                System.out.println(line);
                line = file.readLine();
                
            }   
        } else {
            PrintWriter file = new PrintWriter(new FileWriter("registro.txt",true));           
            String sep = "===============";

            System.out.println("Ingrese la cantidad de estudiantes");
            int cantidad_estudiantes = input.nextInt();

            //Vectores que guardan la informacion
            String meses[] = {"julio","agosto","septiembre","octubre","noviembre","diciembre"};
            String nombres[] = new String[cantidad_estudiantes];

            double prom_ahorros_mes[] = new double[6];      
            double prom_ahorros_estudiante[] = new double[cantidad_estudiantes];
            double ahorros_estudiantes[] = new double[6];
            double ahorros_mes[] = new double[cantidad_estudiantes];

            double ahorros[][] = new double[6][cantidad_estudiantes];

            //Variables acumuladoras
            double acumulado_total = 0;



            input.nextLine();

            //Rellenar el vector de nombres
            for(int i = 0 ; i < cantidad_estudiantes ; i++){     
                System.out.println("Ingrese el nombre del estudiante " + (i + 1));
                nombres[i] = input.nextLine();     
            }

            System.out.println(sep);
            System.out.println("Cantidad de meses: " + 6);
            System.out.println("Cantidad de estudiantes: " + cantidad_estudiantes);
            System.out.println(sep);
            System.out.println("Nombres");
            System.out.println(sep);

            file.println(sep);
            file.println("Cantidad de meses: " + 6);
            file.println("Cantidad de estudiantes: " + cantidad_estudiantes);

            file.println(sep);
            file.println("Nombres");
            file.println(sep);

            for(int i = 0 ; i < cantidad_estudiantes ; i++){
                System.out.println(nombres[i]);
                file.println(nombres[i]);
            }

            System.out.println(sep);
            file.println(sep);

            System.out.println("Meses");
            System.out.println(sep);
            file.println("Meses");
            file.println(sep);

            for(int i = 0 ; i < 6 ; i++){
                System.out.println(meses[i]);
                file.println(meses[i]);
            }

            file.println(sep);
            System.out.println(sep);

            file.println("Ahorros");
            file.println(sep);

            //Rellenar la matriz
            for(int i = 0; i < 6 ; i++){
                for(int j = 0 ; j < cantidad_estudiantes ; j++){
                    System.out.println("Ingrese los ahorros en " + meses[i] + " de " + nombres[j]);
                    ahorros[i][j] = input.nextDouble();
                    acumulado_total = acumulado_total + ahorros[i][j];
                    file.println("Los ahorros en " + meses[i] + " de " + nombres[j] + " son: " + ahorros[i][j]);
                }
                file.println(sep);
            } 

            System.out.println(sep);
            System.out.println("Ahorros");
            System.out.println(sep);

            for(int i = 0; i < 6 ; i++){
                for(int j = 0 ; j < cantidad_estudiantes ; j++){
                    System.out.println("Los ahorros en " + meses[i] + " de " + nombres[j] + " son: " + ahorros[i][j]);
                }
                System.out.println(sep);
            }

            System.out.println("Ahorros por mes");

            file.println("Ahorros por mes");


            //Ciclos de procesamiento

            //hallar el promedio por mes
            //Hallamos el menor y el mayor por mes

            for(int i = 0; i < 6 ; i++){
                double acumulado_mes = 0;

                for(int j = 0 ; j < cantidad_estudiantes ; j++){
                      acumulado_mes = acumulado_mes + ahorros[i][j];
                      ahorros_mes[j] = ahorros[i][j];
                }
                prom_ahorros_mes[i] = (acumulado_mes / cantidad_estudiantes);
                double mayor_ahorro_mes = obtener_mayor(ahorros_mes);
                double menor_ahorro_mes = obtener_menor(ahorros_mes);

                System.out.println(sep);
                System.out.println("El mayor ahorro en " + meses[i] + " fue de: " + mayor_ahorro_mes);
                System.out.println("El menor ahorro en " + meses[i] + " fue de: " + menor_ahorro_mes);

                file.println(sep);   
                file.println("El mayor ahorro en " + meses[i] + " fue de: " + mayor_ahorro_mes);
                file.println("El menor ahorro en " + meses[i] + " fue de: " + menor_ahorro_mes);
            }

            System.out.println(sep);
            System.out.println("Ahorros por estudiante");

            file.println(sep);
            file.println("Ahorros por estudiante");

            //Hallar el promedio por estudiante
            for(int j = 0; j < cantidad_estudiantes ; j++){
                double acumulado_estudiante = 0;

                for(int i = 0 ; i < 6 ; i++){
                      acumulado_estudiante = acumulado_estudiante + ahorros[i][j];
                      ahorros_estudiantes[i] = ahorros[i][j];
                }
                prom_ahorros_estudiante[j] = (acumulado_estudiante / 6);
                double mayor_ahorro_est = obtener_mayor(ahorros_estudiantes);
                double menor_ahorro_est = obtener_menor(ahorros_estudiantes);

                System.out.println(sep);      
                System.out.println("El menor ahorro de " + nombres[j] + " fue de: " + menor_ahorro_est);
                System.out.println("El mayor ahorro de " + nombres[j] + " fue de: " + mayor_ahorro_est);

                file.println(sep);
                file.println("El menor ahorro de " + nombres[j] + " fue de: " + menor_ahorro_est);
                file.println("El mayor ahorro de " + nombres[j] + " fue de: " +  mayor_ahorro_est);

            }
            //Mostrar los resultados
            System.out.println(sep);
            System.out.println("Promedios por estudiante");
            System.out.println(sep);

            file.println(sep);
            file.println("Promedios por estudiante");
            file.println(sep);


            //Resultados por estudiante
            for (int i = 0 ; i < cantidad_estudiantes ; i++){
                System.out.println("El promedio de " + nombres[i] + " fue de: " + prom_ahorros_estudiante[i]);
                file.println("El promedio de " + nombres[i] + " fue de: " + prom_ahorros_estudiante[i]);
            }
            //Resultados ordenados
            System.out.println(sep);
            System.out.println("Promedios por estudiante ordenado");
            System.out.println(sep);

            file.println(sep);
            file.println("Promedios por estudiante ordenado");
            file.println(sep);

            double prom_ahorros_estudiante_ordenados[] = insertion_sort(prom_ahorros_estudiante);
            for (int i = 0 ; i < cantidad_estudiantes ; i++){
                System.out.println(prom_ahorros_estudiante_ordenados[i]);
                file.println(prom_ahorros_estudiante_ordenados[i]);
            }

            System.out.println(sep);
            System.out.println("Promedios por mes");
            System.out.println(sep);

            file.println(sep);
            file.println("Promedios por mes");
            file.println(sep);

            //Resultados por mes
            for (int i = 0 ; i < 6 ; i++){
                System.out.println("El promedio en " + meses[i] + " fue de: " + prom_ahorros_mes[i]);
                file.println("El promedio en " + meses[i] + " fue de: " + prom_ahorros_mes[i]);
            }
            //Resultados ordenados
            System.out.println(sep);
            System.out.println("Promedios por mes ordenado");
            System.out.println(sep);

            file.println(sep);
            file.println("Promedios por mes ordenado");
            file.println(sep);

            double prom_ahorros_mes_ordenados[] = insertion_sort(prom_ahorros_mes);
            for (int i = 0 ; i < 6 ; i++){
                System.out.println(prom_ahorros_mes_ordenados[i]);
                file.println(prom_ahorros_mes_ordenados[i]);
            }

            System.out.println(sep);
            System.out.println("Acumulado " + acumulado_total);
            System.out.println("Promedio general " + acumulado_total / (cantidad_estudiantes * 6));

            file.println(sep);
            file.println("Acumulado " + acumulado_total);
            file.println("Promedio general " + acumulado_total / (cantidad_estudiantes * 6));

            file.close();
        }
    }  
}
