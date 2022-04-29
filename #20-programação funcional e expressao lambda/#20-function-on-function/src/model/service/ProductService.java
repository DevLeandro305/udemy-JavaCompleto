package model.service;

import java.util.List;
import java.util.function.Predicate;

import entities.Product;

public class ProductService {
	
	//O m�todo recebe como par�metro uma lista do tipo product e um predicado tamb�m do tipo product
	public double filteredSum(List<Product> list, Predicate<Product> criteria) {
		double sum = 0.0;
		for (Product p : list) {		//Para cada produto p da lista
			if (criteria.test(p)) {		//Se o testo do crit�rio (passado como par�metro) for verdadeiro
				sum += p.getPrice();	//Ele vai somar o valor do produto p e adicionar ao somador
			}
		}
		
		return sum;
	}

}
