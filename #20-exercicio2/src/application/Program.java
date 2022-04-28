/*
 * Fazer um programa para ler os dados (nome, email e salário) de funcionários a partir de um arquivo .csv,
 * mostrar em ordem alfabética o email dos funcionários cujo salário seja maior que o fornececido pelo usuário
 *  e mostrar a soma dos salários dos funcionários cujo nome comece com a letra "M".
 */

package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter file path: ");
		String path = scan.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			List<Employee> list = new ArrayList<>();
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
				
			}
			
			System.out.print("Enter salary: ");
			double salary = scan.nextDouble();
			
			System.out.println("Email of people whose salary is more than "+ String.format("%.2f", salary));
			
			
			//Filtra e mostra os emails dos empregados com salário acima do valor fornecido acima
			List<String> emails = list.stream()
					.filter(e -> e.getSalario() > salary)
					.map(e -> e.getEmail())
					.sorted()
					.collect(Collectors.toList());
			
			emails.forEach(System.out::println);
			
			//Mostra a soma dos salários das pessoas cujo nome começa com 'M'
			Double sum = list.stream()
					.filter(e -> e.getName().toUpperCase().charAt(0) == 'M')
					.map(e -> e.getSalario())
					.reduce(0.0, (x,y) -> x+y);
			
			System.out.print("Sum of salary os people whose name stars whith 'M': " + String.format("%.2f", sum));
					
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		scan.close();
		
		
	}

}
