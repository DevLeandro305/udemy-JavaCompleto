package application;

import java.util.Arrays;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		List<Integer> myInts = Arrays.asList(5, 2, 10);						//instanciada como Integer, s� por conter n�meros
		printList(myInts);													//O m�todo imprime qualquer lista, j� que ele foi criado com o tipo curinga <?> que � a super classe de qualquer lista
		
		List<String> myStrs = Arrays.asList("Maria", "Alex", "Bob");		//Instanciada como String, s� pode conter nomes
		printList(myStrs);
	}
	
	public static void printList(List<?> list) {			//O tipo curinga de uma lista � a <?>, assim a lista vai assumir qualquer tipo na hora da instancia��o
		
		//list.add(3)										//N�o pode ser adicionado dados em uma lista curinga, j� que o compilador n�o sabe qual o tipo de lista
		
		for (Object obj : list) {							//O m�todo (neste caso o print) vai se encarregar de imprimir a lista, seja ela de qualquer tipo
			System.out.println(obj);
		}
	}

}
