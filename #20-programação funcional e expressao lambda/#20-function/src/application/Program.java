/*
 * Programa para ler os nomes de uma lista de produtos e mudar os nomes para caixa alta
 */

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		//A fun��o .map � uma fun��o que aplica outra fun��o (dada) a todos os elementos da lista;
		//A fun��o .map s� funciona com uma stream() de dados, ent�o precisamos transformar a lista em uma stream (com o .stream())
		//e depois retorn�-la para uma lista com a fun��o (.collect(Collectors.toList()) para podermos imprimir a nova lista com
		//a fun��o aplicada para cada elemento (nesse caso, retornar os nomes dos produtos em caixa alta).
		
		List<String> names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
		
		names.forEach(System.out::println);
		
	}		

}
