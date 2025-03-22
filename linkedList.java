package umg.edu.gt.test.EjercicioLinkedList;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Esta clase es para realiar listas enlazadas.
 */
public class limnk {
    /**
     * Quita los números que se repiten en la lista, dejando solo el primero que aparece.
     *
     * @param numbers La lista de números que pueden tener repetidos.
     * @return Una nueva lista sin números repetidos.
     */
    public LinkedList<Integer> removeRepeats(LinkedList<Integer> numbers) {
        LinkedList<Integer> newList = new LinkedList<>();
        for (Integer num : numbers) {
            if (!newList.contains(num)) {
                newList.add(num);
            }
        }
        return newList;
    }

    /**
     * Voltea la lista de palabras sin usar otra lista extra.
     *
     * @param words La lista de palabras que se va a dar la vuelta.
     */
    public void flipList(LinkedList<String> words) {
        int n = words.size();
        for (int i = 0; i < n / 2; i++) {
            String temp = words.get(i);
            words.set(i, words.get(n - 1 - i));
            words.set(n - 1 - i, temp);
        }
    }

    /**
     * Junta dos listas de números mezclando los elementos de cada una en orden.
     *
     * @param listOne La primera lista con números ordenados.
     * @param listTwo La segunda lista con números ordenados.
     * @return Una nueva lista con los números mezclados.
     */
    public LinkedList<Integer> mixLists(LinkedList<Integer> listOne, LinkedList<Integer> listTwo) {
        LinkedList<Integer> mixedList = new LinkedList<>();
        Iterator<Integer> iter1 = listOne.iterator();
        Iterator<Integer> iter2 = listTwo.iterator();
        
        while (iter1.hasNext() || iter2.hasNext()) {
            if (iter1.hasNext()) {
                mixedList.add(iter1.next());
            }
            if (iter2.hasNext()) {
                mixedList.add(iter2.next());
            }
        }
        
        return mixedList;
    }
}