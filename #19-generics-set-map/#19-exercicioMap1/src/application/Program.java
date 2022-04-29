/*
 * Na contagem de votos de uma eleição, são gerados vários registros
 * de votação contendo o nome do condidato e a quantisdade de votos
 * (formato .csv) que ele obteve em uma urna de votação. Você deve
 * fazer um programa para ler os registro de votação a partir de um
 * arquivo, e daí gerar um relatório consolidado com totais de cada
 * candidato
 */


package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Map<String, Integer> votes = new LinkedHashMap<>();
		
		System.out.println("Enter file full path: ");
		String path = scan.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			while (line != null) {
				
				String[] fields = line.split(",");
				String name = fields[0];
				Integer count = Integer.parseInt(fields[1]);
				
				if (votes.containsKey(name)) {
					int votesSoFar = votes.get(name);
					votes.put(name, count + votesSoFar);
				} else {
					votes.put(name, count);
				}
				
				line = br.readLine();
			}
			
			for (String key : votes.keySet()) {
				System.out.println(key + ": " + votes.get(key));
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
		scan.close();
	}

}
