/*
 * Com o uso da express�o lambda passado diretamento como sintaxe do m�todo .sort, essa classe n�o � mais necess�ria
 */
package application;

import java.util.Comparator;

import entities.Product;

public class MyComparator implements Comparator<Product>{

	@Override
	public int compare(Product p1, Product p2) {
		return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
	}

}
