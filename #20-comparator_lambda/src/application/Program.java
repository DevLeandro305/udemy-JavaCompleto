/*
 * Comparar uma lista de produtos com nome e preço
 */

package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//import java.util.Collections;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));
		
		//Collections.sort(list);															//Primeiro modo de comparar elementos de uma lista, implementando o metodo Comparable na classe Product - Pouco eficiente
		
		//list.sort(new MyComparator());													//Segundo modo, criando uma classe Comparator e instanciando dentro do list.sort()
		
		/*
		Comparator<Product> comp = new Comparator<Product>() {								//Terceiro modo, trazendo o comparator para dentro da classe principal - Método muito verboso
	
			@Override
			public int compare(Product p1, Product p2) {
				return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
			}
		};
		
		list.sort(comp);
		*/
		
		/*
		Comparator<Product> comp = (p1, p2) -> {											//Quarto modo com função lambda (arrow function) com uma sintaxe maior
			return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
		};
		
		list.sort(comp);
		*/
		
		/*
		Comparator<Product> comp = (p1, p2) ->  p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());	//Quinto modo (versão resumida do quarto) retirando o return e as chaves
		
		list.sort(comp);
		*/
		
		list.sort((p1, p2) ->  p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));		//versão final - passando as expressão lambda direto como argumento do list.sort()
		
		
		for (Product p : list) {
			System.out.println(p);
		}
	}

}
