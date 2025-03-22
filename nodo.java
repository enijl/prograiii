package umg.edu.progra.listas;

/**
 * Representa un nodo en una lista enlazada.
 */
public class Nodo {
    int dato;
    Nodo enlace;

    public Nodo(int dato) {
        this.dato = dato;
        this.enlace = null;
    }

    public Nodo(int dato, Nodo enlace) {
        this.dato = dato;
        this.enlace = enlace;
    }

    public int leerDato() {
        return dato;
    }

    public Nodo siguiente() {
        return enlace;
    }

    @Override
    public String toString() {
        return dato + "=>" + enlace;
    }
}
