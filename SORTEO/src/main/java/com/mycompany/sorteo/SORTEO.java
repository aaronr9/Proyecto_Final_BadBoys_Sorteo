/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sorteo;


import java.util.Scanner;

public class SORTEO {
     
    private static int contadorIntentos = 1;
     
    public static void main(String[] args) {
        Bienvenida();
        
        Scanner captu = new Scanner(System.in);
        
        while (true) {
            int intentos;
            intentos = obtenerintento();
            
            int eleccion;
            eleccion = EleccionarPremio();
            mostrarCostoPremio(eleccion);
            
            int[] numerosIngresados = new int[5];
            
            int opcion;
            opcion =obtenerOpciones();
            
            if (opcion == 1) {
                ingresarNumeros(numerosIngresados);
            } else {
                generarNumerosAleatorios(numerosIngresados);
            }
            
            int[] numerosSorteo;
            numerosSorteo = generarNumerosAleatoriosParaSorteo();
            System.out.println("Números sorteados: ");
            mostrarNumeros(numerosSorteo);
            
            int coincidencias;
            coincidencias = compararNumeros(numerosIngresados, numerosSorteo);
            System.out.println("Número de coincidencias: " + coincidencias);
            
            verificarPremio(eleccion, coincidencias);
            
            if (nuevoIntento()) 
                break;  
            
            contadorIntentos++;
        }
        
        capturarMensajeFinal();
    }
    
    public static void Bienvenida() {
        System.out.println("**************************************************");
        System.out.println("**BIENVENIDOS A NUESTRA PAGINA DE SORTEOS ONLINE**");
        System.out.println("**************************************************");
    }

    public static int obtenerintento() {
        Scanner captu = new Scanner(System.in);
        
        System.out.println("Intento #" + contadorIntentos + ":");
        
        String nombre;
        System.out.println("Ingresa tu nombré:");
        nombre = captu.nextLine();
        
        String apellido;
        System.out.println("Ingresa tu apellido:");
        apellido = captu.nextLine();
        
        int edad;
        System.out.println("Ingrese su edad:  ");
        edad = captu.nextInt();
            
        if(edad >= 18 && edad <=124){  
            System.out.println("Bienvenido " + nombre + " " + apellido);
            System.out.println("");
        }else{
            System.out.println("No cumples con la edad necesaria.");
            System.exit(0);
            
            
        }
        return edad;
    }

    public static int EleccionarPremio() {
        Scanner captu = new Scanner(System.in);
        
        int eleccion = 0;
        while (eleccion < 1 || eleccion > 3) {
            System.out.println("¿Para qué tipo de premio vas a participar?");
            System.out.println("1. Participar por premios grandes (mas caros).");
            System.out.println("2. Participar por premios pequeños (mas baratos).");
            System.out.println("3. salir");
            
            eleccion = captu.nextInt();
            System.out.println("");
            
            if (eleccion < 1 || eleccion > 3) {
                System.out.println("¡Por favor, ingresa un numero entre 1 y 3 como esta indicado!");
            }
        }
        if (eleccion == 1) {
            eleccion = EleccionarPremioGrande();
            System.out.println("");
        } else if (eleccion == 2) {
            eleccion = EleccionarPremioPequeño();
            System.out.println("");
        }else{
            System.out.println("El sorteo a terminado gracias por participar");
            System.exit(0);
        }
        return eleccion;
    }
    public static int EleccionarPremioGrande(){
        Scanner captu = new Scanner(System.in);
        int eleccion =0;
       
        while(eleccion <1 || eleccion >5){
        System.out.println("¡Has elegido participar por premios grandes!");
        System.out.println("¿Qué premio te gustaría? Elige del 1 a 5.");
        System.out.println("   premio:          costo:");
        System.out.println("1. $1,000,000        $1,000");
        System.out.println("2. $50,000           $600");
        System.out.println("3. Carro del año     $700");
        System.out.println("4. $500,000          $1,000");
        System.out.println("5. Play Station 5    $1,500");
        
        eleccion = captu.nextInt();
        System.out.println("");
        
        if (eleccion <1 || eleccion >5){
            System.out.println("Por favor elige entre 1 y 5");
            }
        }
        return eleccion;
    }
    public static int EleccionarPremioPequeño() {
        Scanner captu = new Scanner(System.in);
        int eleccion = 0;
        
        while (eleccion <6 || eleccion >10){
        System.out.println("¡Has elegido participar por premios pequeños!");
        System.out.println("¿Qué premio te gustaría? Elige de 6 a 10.");
        System.out.println("   premio:                          costo:");
        System.out.println("6. $5,000                             $50");
        System.out.println("7. Televisor 4K                       $100");
        System.out.println("8. $2,000                             $300");
        System.out.println("9. Smartphone de última generación   $200");
        System.out.println("10.Tableta de última generación      $150");
        
        eleccion = captu.nextInt();
        
        if (eleccion <6 || eleccion >10){
            System.out.println("Por favor elige entre 6 y 10");
         }
        }
        return eleccion;
    }

     public static void mostrarCostoPremio(int eleccion) {
         Scanner captu = new Scanner(System.in);
         
        String premio = "";
        int costo = 0;
        
        switch (eleccion) {
            case 1: 
                premio = "$1,000,000";
                costo = 1000;
                break;
            case 2: 
                premio = "$50,000"; 
                costo = 500;
                break;
            case 3: 
                premio = "Carro del año"; 
                costo = 700;
                break;
            case 4: 
                premio = "500,000"; 
                costo = 1000;
                break;
            case 5: 
                premio = "Play Station 5"; 
                costo = 1500;
                break;
            case 6: 
                premio = "5,000"; 
                costo = 50;
                break;
            case 7: 
                premio = "Televizor 4k"; 
                costo = 100;
                break;
            case 8: 
                premio = "$2,000"; 
                costo = 300;
                break;
            case 9: 
                premio = "Smartphone de ultima generacion"; 
                costo = 200;
                break;
            case 10: 
                premio = "Tableta de Ultima generacion"; 
                costo = 150;
                break;
            default:
                System.out.println("Opcion no valida");
                return;
          
        }
        
         System.out.println("El costo de participar por " + premio + " es de $" + costo);
         
         int pago =0;
         while (pago != costo){
         System.out.println("Ingresa el monto para participar:");
         pago = captu.nextInt();
         
         if (pago == costo) {
             System.out.println("Listo puedes participar por  " + premio);
             System.out.println("");
         }else {
             System.out.println("El costo para paticipar es de $" + costo);
           }
         }
     }
    public static int obtenerOpciones() {
        
        int opcion = 0;
        while (opcion < 1 || opcion  > 2) {
            Scanner captu = new Scanner(System.in);
            System.out.println("¿Quieres ingresar tus propios números o generarlos aleatoriamente?");
            System.out.println("1. Ingresar mis propios numeros");
            System.out.println("2. Generarlos aleatoriamente");
            opcion = captu.nextInt();
            System.out.println("");
            
            if (opcion < 1 || opcion > 2) {
                System.out.println("¡Por favor, ingresa una opcion valida (1 o 2)!");
            }
        }
        return opcion;
    }

    public static void ingresarNumeros( int[] numerosIngresados) {
        Scanner captu = new Scanner(System.in);
        
        System.out.println("Por favor ingresa 5 numeros entre 0 y 9:");
        captu.nextLine();
        
        for (int i = 0; i < 5; i++) {
            int num1 = -1;
           while (num1 < 0 || num1 > 9) { 
            System.out.println("Ingrese el numero #" + (i + 1) + ":");
            num1 = captu.nextInt();
            if (num1 >= 0 && num1 <= 9) {
                numerosIngresados[i]=num1;
                System.out.println("Numero elegido: " + num1);
            } else {
                System.out.println("¡Los numeros deben estar entre 0 y 9! Intenta nuevamente.");
            }
          }         
        }
        System.out.println("Tus numeros ingresados son: ");
        mostrarNumeros(numerosIngresados);
    }

    public static void generarNumerosAleatorios(int [] numerosIngresados) {
        System.out.println("Tus numeros aleatorios son: ");
       
        for (int i = 0; i < 5; i++) {
            int num =(int)(Math.random()*10);
            System.out.print(num + "-");
            numerosIngresados[i]= num;
        }
        System.out.println("");
    }

    public static int[] generarNumerosAleatoriosParaSorteo() {
        int[] numerosSorteo = new int[5];
        for (int i = 0; i < 5; i++) {
            int num = (int)(Math.random() * 10);
            numerosSorteo[i]=num;
        }
        return numerosSorteo;
    }

    public static void mostrarNumeros(int[] numerosIngresados) {
        for (int num : numerosIngresados) {
            System.out.print(num + "-");
        }
        System.out.println();
    }

    public static int compararNumeros(int[] numerosIngresados, int[] numerosSorteo) {
        int coincidencias = 0;
        
        for (int i = 0; i < numerosIngresados.length; i++) {
         if (numerosIngresados[i] == numerosSorteo[i]) {
            coincidencias++; 
        }
      }
    return coincidencias;
    }

    public static void verificarPremio(int eleccion, int coincidencias) {
        String premio;
        
        boolean haganado = false;
        
        switch (eleccion) {
            case 1: 
                premio = "$1,000,000";
                break;
            case 2: 
                premio = "$50,000"; 
                break;
            case 3: 
                premio = "Carro del año"; 
                break;
            case 4: 
                premio = "500,000"; 
                break;
            case 5: 
                premio = "Play Station"; 
                break;
            case 6: 
                premio = "5,000"; 
                break;
            case 7: 
                premio = "Televizor 4k"; 
                break;
            case 8: 
                premio = "$2,000"; 
                break;
            case 9: 
                premio = "Smartphone de ultima generacion"; 
                break;
            case 10: 
                premio = "Tableta de Ultima generacion"; 
                break;
            default:
                System.out.println("opcion no valida.");
            return;
        }
        if (coincidencias == 5) {
        haganado = true;
        
        if (eleccion == 1 || eleccion == 2 || eleccion == 4 || eleccion == 6 || eleccion == 8) {
            capturarNumeroCuenta(); 
        } else {
            capturarDireccion();
        }
    }
        
        if (haganado) {
            System.out.println("¡Felicidades! Has ganado " + premio + " con " + coincidencias + " coincidencias.");
        } else {
            System.out.println("No has ganado el premio. Has tenido " + coincidencias + " coincidencias.");
        }
    }
    public static void capturarNumeroCuenta() {
        Scanner captu = new Scanner(System.in);
        System.out.println("Felicidades has ganado por favor, ingresa tu número de cuenta bancaria para el depósito: ");
        int cuenta;
        cuenta = captu.nextInt();
        System.out.println("¡Número de cuenta recibido correctamente! El dinero será transferido pronto.");
    }

    public static void capturarDireccion() {
        Scanner captu = new Scanner(System.in);
        captu.nextLine();  
        System.out.println("felicidades has ganado por favor, ingresa tu dirección completa para el envío del premio: ");
        String direccion;
        direccion = captu.nextLine();
        System.out.println("¡Dirección recibida correctamente! El premio será enviado pronto.");
    }

    
    public static boolean nuevoIntento() {
        String si,no;
         
        while(true){
        Scanner captu = new Scanner(System.in);
        captu.nextLine();
        System.out.println("¿Deseas volver a intentar? (si o no): ");
        no = captu.nextLine();
            System.out.println("Confirma tu respuesta");
        si = captu.nextLine();

        if(si.equals("si") || no.equals("no")){      
            break;
        }
            System.out.println("por favor responde si o no.");
        }
        return no.equals("no");
    }
    
    public static void capturarMensajeFinal() {
        
        System.out.println("¡El sorteo ha terminado! Gracias por participar.");
        System.out.println("FFFFFFFF   I       FFFFFF    III   N    N");
        System.out.println("F          I       F          I    NN   N");
        System.out.println("F          I       FFFFF      I    N N  N");
        System.out.println("FFFF       I       FFF        I    N  N N");
        System.out.println("F          I       F          I    N   NN");
        System.out.println("F          I       F          I    N    N");
        System.out.println("FFFFFFFF   III     F         III   N    N");
    
    }
}
