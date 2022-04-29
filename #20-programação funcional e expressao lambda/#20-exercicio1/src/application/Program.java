/*
 * Fazer um programa que leia um conjunto de produtos a partir de uma arquivo .crv,
 * mostrar o pre�o m�dio dos produtos, mostrar o nome em ordem crescente dos produtos
 * com valor inferior a m�dia dos pre�os.
 */

package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter file path: ");
		String path = scan.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			List<Product> list = new ArrayList<>();
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}
			
			//C�lculo da m�dia
			double avg = list.stream()															//transforma a lista para uma stream
					.map(p -> p.getPrice())														//map para aplicar a fun��o de pegar somnete os pre�os de todas os itens da lista
					.reduce(0.0, (x,y) -> x+y) / list.size();									//reduce para fazer a soma de todos os valores come�ando com o indice 0 (zero) e j� executando a m�dia pela quantidade de itens na lista
			
			System.out.println("Avarege price: " + String.format("%.2f", avg));
			
			//Classe comparator para deixar o c�digo abaixo mais leg�vel
			Comparator<String> comp = (s1,s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			
			//Lista para mostrar os nomes dos produtos cujo pre�o est� abaixo da m�dia
			List<String> names = list.stream()						//transforma a lista para stream
					.filter(p -> p.getPrice() < avg)				//filtra por pre�o que � menor que a m�dia
					.map(p -> p.getName())							//map para pegar os nomes dos produtos filtrados
					.sorted(comp.reversed())						//lista os nomes compradando com o comparator criado acima e usando o .reverse para deixar em ordem decrescente
					.collect(Collectors.toList());					//Collectors para voltar o stream para list.
			
			names.forEach(System.out::println);
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		scan.close();
		
	}

}
