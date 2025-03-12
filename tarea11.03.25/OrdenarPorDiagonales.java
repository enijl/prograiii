package umg.edu.gt.test.ClaseArrays;



import java.util.*;

public class OrdenarPorDiagonales {
    public static void main(String[] args) {
        int[][] cantidades1 = {{4, 7, 1, 5}, {3, 9, 6, 2}, {8, 2, 3, 7}};
        int[][] cantidades2 = {
            {12, 27, 65, 2, 70, 6},
            {24, 56, 18, 46, 16, 53},
            {76, 32, 37, 45, 59, 9},
            {21, 26, 34, 24, 67, 3},
            {85, 29, 13, 10, 4, 51}
        };

        System.out.println(Arrays.deepToString(ordenarDiagonales(cantidades1)));
        System.out.println(Arrays.deepToString(ordenarDiagonales(cantidades2)));
    }

    public static int[][] ordenarDiagonales(int[][] cantidades) {
        int filas = cantidades.length;
        int columnas = cantidades[0].length;
        Map<Integer, List<Integer>> diagonales = new HashMap<>();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                diagonales.computeIfAbsent(i - j, k -> new ArrayList<>()).add(cantidades[i][j]);
            }
        }

        for (List<Integer> diagonal : diagonales.values()) {
            Collections.sort(diagonal);
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                cantidades[i][j] = diagonales.get(i - j).remove(0);
            }
        }

        return cantidades;
    }
}
