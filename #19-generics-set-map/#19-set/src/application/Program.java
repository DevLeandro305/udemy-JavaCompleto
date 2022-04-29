package application;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Program {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<>();				//mais r�pido, mas n�o garante a ordem dos conjuntos
		//Set<String> set = new TreeSet<>();			//menos r�pido, mas mantem os dados ordenados por ordem alfab�tica;
		//Set<String> set = new LinkedHashSet<>()		//velocidade m�dia, mantem a ordem de incer��o dos itens no conjunto
		
		set.add("Tv");
		set.add("Notebook");
		set.add("Tablet");
		
		System.out.println(set.contains("Notebook"));
		
		set.remove("Tablet");
		set.removeIf(x -> x.length() >= 3);				//Remove aqueles que tem 3 ou mais caracteres
		set.removeIf(x -> x.charAt(0) == 'T');			//Remove alguem que tenho o primeiro caracter come�ando com T
		
		for (String p : set) {
			System.out.println(p);
		}
		
		Set<Integer> a = new TreeSet<>(Arrays.asList(0,2,4,5,6,8,10));
		Set<Integer> b = new TreeSet<>(Arrays.asList(5,6,7,8,9,10));
		
		//uniao
		Set<Integer> c = new TreeSet<>(a);				//Cria um conjunto c que vai ser uma copia do conjunto a
		c.addAll(b);
		System.out.println(c);
		
		//Interse��o
		Set<Integer> d = new TreeSet<>(a);
		d.retainAll(b);
		System.out.println(d);
		
		//diferen�a
		Set<Integer> e = new TreeSet<>(a);
		e.removeAll(b);
		System.out.println(e);

	}

}
