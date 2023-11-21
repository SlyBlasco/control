/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.control.entidades;

/**
 *
 * @author Daniel Labrada y Luis Blasco
 */
public class Cola {
    
    private int[] cola;
    private int tamanio;
    private int frente;
    private int ultimo;

    public Cola(int tamanio) {
        this.tamanio = tamanio;
        this.cola = new int[tamanio];
        this.frente = 0;
        this.ultimo = -1;
    }

    public boolean isVacia() {
        return frente > ultimo;
    }

    public boolean isLlena() {
        return ultimo == tamanio - 1;
    }

    public void pop() {
        if (isVacia()) {
            System.out.println("Cola vacia, no se pueden eliminar mis elementos de la cola...");
        } else {
            frente++;
        }
        if (isVacia()) {
            frente = 0;
            ultimo = -1;
        }
    }

    public void push(int _valor) {
        if (isLlena()) {
            System.out.println("Cola llena, no se pueden agregar el valor " + _valor + " a la cola...");
        } else {
            ultimo++;
            cola[ultimo] = _valor;
        }
    }

    
    public void imprimir() {
        if (isVacia()) {
            System.out.println("Cola vacia, no hay elementos para imprimir...");
        } else {
            System.out.println("- Cola -");
            for (int indice = frente; indice <= ultimo; indice++) {
                System.out.println("[" + cola[indice] + "]");
            }
        }
    }
    
    public int[] getCola() {
        return cola;
    }

    public void setCola(int[] cola) {
        this.cola = cola;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public int getFrente() {
        return frente;
    }

    public void setFrente(int frente) {
        this.frente = frente;
    }

    public int getUltimo() {
        return ultimo;
    }

    public void setUltimo(int ultimo) {
        this.ultimo = ultimo;
    }
}
