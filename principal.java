package umg.edu.progra.listas;

/**
 * Clase principal para probar las operaciones con listas enlazadas.
 * 
 * @author Walter Cordova
 */
public class Principal {
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.insertarCabezaLista(1);
        lista.insertarCabezaLista(2);
        lista.insertarCabezaLista(3);
        lista.insertarCabezaLista(4);
        lista.insertarCabezaLista(5);
        lista.insertarCabezaLista(6);
        lista.visualizar();
        
        System.out.println("\n");
        System.out.println("Primero: " + lista.leerPrimero());
        lista.eliminar(3);
        System.out.println("Lista: " + lista);
        
        System.out.println("\n");
        Nodo dato = lista.buscarLista(4);
        System.out.println("Dato: " + dato);
        lista.insertarLista(dato, 10);
        System.out.println("Lista: " + lista);
        
        dato = lista.buscarLista(5);
        System.out.println("Dato: " + dato);
        lista.insertarLista(dato, 600);
        System.out.println("Lista: " + lista);
        lista.visualizar();
        
        // Ejercicio 1: Ordenar la lista de forma ascendente
        lista = ordenarLista(lista);
        System.out.println("Lista ordenada: ");
        lista.visualizar();
        
        // Ejercicio 2: Unir dos listas enlazadas
        Lista lista2 = new Lista();
        lista2.insertarCabezaLista(7);
        lista2.insertarCabezaLista(8);
        lista2.insertarCabezaLista(9);
        Lista listaUnida = unirListas(lista, lista2);
        System.out.println("Lista unida: ");
        listaUnida.visualizar();
        
        // Ejercicio 3: Separar números pares e impares en dos listas diferentes
        Lista pares = new Lista();
        Lista impares = new Lista();
        separarParesImpares(lista, pares, impares);
        System.out.println("Lista de pares: ");
        pares.visualizar();
        System.out.println("Lista de impares: ");
        impares.visualizar();
    }
    
    /**
     * Método para ordenar la lista de forma ascendente usando el método de burbuja.
     * 
     * @param lista Lista a ordenar
     * @return Lista ordenada
     */
    public static Lista ordenarLista(Lista lista) {
        if (lista.leerPrimero() == null) return lista; // Si la lista está vacía
        Nodo actual;
        Nodo siguiente;
        boolean intercambiado;
        do {
            actual = lista.leerPrimero();
            intercambiado = false;
            while (actual != null && actual.enlace != null) {
                siguiente = actual.enlace;
                if (actual.dato > siguiente.dato) {
                    // Intercambiar los datos
                    int temp = actual.dato;
                    actual.dato = siguiente.dato;
                    siguiente.dato = temp;
                    intercambiado = true;
                }
                actual = siguiente;
            }
        } while (intercambiado);
        return lista;
    }
    
    /**
     * Método para unir dos listas enlazadas en una sola.
     * 
     * @param lista1 Primera lista
     * @param lista2 Segunda lista
     * @return Lista combinada
     */
    public static Lista unirListas(Lista lista1, Lista lista2) {
        Lista listaUnida = new Lista();
        Nodo actual = lista1.leerPrimero();
        // Copiar elementos de lista1
        while (actual != null) {
            listaUnida.insertarCabezaLista(actual.dato);
            actual = actual.enlace;
        }
        actual = lista2.leerPrimero();
        // Copiar elementos de lista2
        while (actual != null) {
            listaUnida.insertarCabezaLista(actual.dato);
            actual = actual.enlace;
        }
        // Invertir la lista unida para mantener el orden
        listaUnida.invertirLista();
        return listaUnida;
    }
    
    /**
     * Método para separar números pares e impares en dos listas diferentes.
     * 
     * @param lista Lista original
     * @param pares Lista para almacenar números pares
     * @param impares Lista para almacenar números impares
     */
    public static void separarParesImpares(Lista lista, Lista pares, Lista impares) {
        Nodo actual = lista.leerPrimero();
        while (actual != null) {
            if (actual.dato % 2 == 0) {
                pares.insertarCabezaLista(actual.dato); // Inserta en la lista de pares
            } else {
                impares.insertarCabezaLista(actual.dato); // Inserta en la lista de impares
            }
            actual = actual.enlace;
        }
        // Invertir las listas para mantener el orden original
        pares.invertirLista();
        impares.invertirLista();
    }
}
