package application;

import java.util.Arrays;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		List<Integer> myInts = Arrays.asList(5, 2, 10);						//instanciada como Integer, só por conter números
		printList(myInts);													//O método imprime qualquer lista, já que ele foi criado com o tipo curinga <?> que é a super classe de qualquer lista
		
		List<String> myStrs = Arrays.asList("Maria", "Alex", "Bob");		//Instanciada como String, só pode conter nomes
		printList(myStrs);
	}
	
	public static void printList(List<?> list) {			//O tipo curinga de uma lista é a <?>, assim a lista vai assumir qualquer tipo na hora da instanciação
		
		//list.add(3)										//Não pode ser adicionado dados em uma lista curinga, já que o compilador não sabe qual o tipo de lista
		
		for (Object obj : list) {							//O método (neste caso o print) vai se encarregar de imprimir a lista, seja ela de qualquer tipo
			System.out.println(obj);
		}
	}

}
