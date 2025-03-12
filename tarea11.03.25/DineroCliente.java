package umg.edu.gt.test.ClaseArrays;

public class DineroCliente {
    public static void main(String[] args) {
        int[][] cantidades1 = {{4, 7, 1}, {2, 9, 6}};
        int[][] cantidades2 = {{3, 8}, {5, 2}, {6, 4}};
        int[][] cantidades3 = {{7, 5, 3}, {9, 2, 1}, {4, 6, 8}};
        
        System.out.println(dineroMaximo(cantidades1));
        System.out.println(dineroMaximo(cantidades2)); 
        System.out.println(dineroMaximo(cantidades3)); 
    }

    public static int dineroMaximo(int[][] cantidades) {
        int maxDinero = 0;
        for (int i = 0; i < cantidades.length; i++) {
            int dineroCliente = 0;
            for (int j = 0; j < cantidades[i].length; j++) {
                dineroCliente += cantidades[i][j];
            }
            maxDinero = Math.max(maxDinero, dineroCliente);
        }
        return maxDinero;
    }
}
