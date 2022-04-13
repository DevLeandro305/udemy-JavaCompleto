package application;

import java.util.Scanner;

import services.PrintService;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		PrintService<Integer> ps = new PrintService<>();		//Como a classe PrintService é genérica, eu tenho que dizer na instanciação do objeto, o tipo que ele vai ser (int ou String, por exemplo)
		
		System.out.println("How many values? ");
		int n = scan.nextInt();
		
		for (int i = 0; i < n ; i++) {
			int value = scan.nextInt();
			ps.addValue(value);
		}
		
		ps.print();
		Integer x = ps.first();
		System.out.println("First: " + x);
		
		
		scan.close();
	}

}
