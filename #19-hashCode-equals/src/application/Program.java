package application;

import entities.Client;

public class Program {

	public static void main(String[] args) {
		
		String a = "Maria";
		String b = "Alex";
		
		System.out.println(a.equals(b));
		
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		
		System.out.println();
		
		Client c1 = new Client("Maria", "maria@gmail.com");
		Client c2 = new Client("Alex", "alex@gmail.com");
		
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c1.equals(c2));
		
		System.out.println();
		
		Client c3 = new Client("Maria", "maria@gmail.com");
		Client c4 = new Client("Maria", "maria@gmail.com");
		
		System.out.println(c3.equals(c4));							//a função equals compara o contrudo da variável
		System.out.println(c3 == c4);								//Aqui o compilador está comparando somente o espaço de memoria, que são diferentes
		
		System.out.println();
		
		String s1 = "teste";
		String s2 = "teste";
		
		System.out.println(s1 == s2);								//O compilador tem um tratamento especial para String com valor literais;
	}

}
