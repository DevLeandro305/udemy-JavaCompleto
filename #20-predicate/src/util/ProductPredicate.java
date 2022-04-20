package util;

import java.util.function.Predicate;

import entities.Product;

//Não necessita mais dessa classe

public class ProductPredicate  implements Predicate<Product>{

	@Override
	public boolean test(Product p) {
		return p.getPrice() >= 100.00;
	}
	
	
}
