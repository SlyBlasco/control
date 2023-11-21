package mx.itson.control.ui;

import mx.itson.control.entidades.Cola;
import java.util.Scanner;

/**
 *
 * @author Daniel Labrada y Luis Blasco
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear una cola para el registro vehicular con capacidad para 10 vehiculos.
        Cola registroVehicular = new Cola(10);
        int[] entradasPorPlaca = new int[10000];

        while (true) {
            System.out.println("*** Registro Vehicular ***");
            System.out.println("1. Mostrar registro");
            System.out.println("2. Entrada de vehiculo");
            System.out.println("3. Salida de vehiculo");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registroVehicular.imprimir();
                    break;
                case 2:
                    if (!registroVehicular.isLlena()) {
                        System.out.print("Ingrese la placa del vehiculo que entra: ");
                        int placa = scanner.nextInt();

                        int entradasAnteriores = entradasPorPlaca[placa];
                        if (entradasAnteriores < 2) {
                            // Verificar si la placa ya existe en la cola.
                            boolean placaRepetida = false;
                            for (int i = registroVehicular.getFrente(); i <= registroVehicular.getUltimo(); i++) {
                                if (registroVehicular.getCola()[i] == placa) {
                                    placaRepetida = true;
                                    break;
                                }
                            }

                            if (!placaRepetida) {
                                // Agregar la placa a la cola si no esta repetida.
                                entradasPorPlaca[placa]++;
                                registroVehicular.push(placa);
                                System.out.println("Vehiculo con placa " + placa + " registrado correctamente.");
                            } else {
                                System.out.println("La placa " + placa + " ya esta registrada en la cola. No se pueden agregar placas repetidas.");
                            }
                        } else {
                            System.out.println("El vehiculo con placa " + placa + " ha alcanzado el limite de entradas (2 veces).");
                        }
                    } else {
                        System.out.println("Registro vehicular lleno. No se pueden agregar mas vehiculos.");
                    }
                    break;

                case 3:
                    if (!registroVehicular.isVacia()) {
                        System.out.print("Ingrese la placa del vehículo que sale: ");
                        int placaSalida = scanner.nextInt();

                        // Buscar la posicion del vehículo en la cola.
                        int posicionVehiculo = -1;
                        for (int i = registroVehicular.getFrente(); i <= registroVehicular.getUltimo(); i++) {
                            if (registroVehicular.getCola()[i] == placaSalida) {
                                posicionVehiculo = i;
                                break;
                            }
                        }

                        if (posicionVehiculo != -1) {
                            // Eliminar el vehiculo encontrando en la posicion especifica.
                            for (int i = posicionVehiculo; i < registroVehicular.getUltimo(); i++) {
                                registroVehicular.getCola()[i] = registroVehicular.getCola()[i + 1];
                            }

                            registroVehicular.setUltimo(registroVehicular.getUltimo() - 1);

                            System.out.println("Vehiculo con placa " + placaSalida + " ha salido del registro.");
                        } else {
                            System.out.println("Vehiculo con placa " + placaSalida + " no encontrado en el registro.");
                        }
                    } else {
                        System.out.println("Registro vehicular vacio. No hay vehiculos para sacar.");
                    }
                    break;
                default:
                    System.out.println("Opcion no válida.");
            }
        }
    }

}
