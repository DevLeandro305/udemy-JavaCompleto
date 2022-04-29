package services;

import java.util.List;

public class CalculationService {
																							//Comparable<? super T> o comparable vai ser herdado para qualquer superClasse de T;
	public static <T extends Comparable<? super T>> T max(List<T> list) {					//Forma de parametrizar somente o método para GENERIC;
		if (list.isEmpty()) {																//Extendeu o método genérico T para Comparable<T> (do tipo T) para porder usar o compareTo(); 
			throw new IllegalStateException("List can't be empty");
		}
		T max = list.get(0);										//Algoritimo para encontrar o maior elemento da lista;
		for (T item : list) {
			if (item.compareTo(max) > 0) {
				max = item;
			}
		}
		return max;
	}

}
