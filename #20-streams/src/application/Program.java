package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Program {

	public static void main(String[] args) {
		
		//Criando uma stream e imprimindo ela a partir de uma lista
		List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
		Stream<Integer> st1 = list.stream();
		System.out.println(Arrays.toString(st1.toArray()));
		
		//Criando uma stream direta com a função Stream.of
		Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
		System.out.println(Arrays.toString(st2.toArray()));
		
		//Criando uma stream de números pares, limitando a 10 iterações
		Stream<Integer> st3 = Stream.iterate(0, x -> x +2);
		System.out.println(Arrays.toString(st3.limit(10).toArray()));
		
		//Criando uma sequência de Fibonacci
		Stream<Long> st4 = Stream.iterate(new Long[]{0L, 1L}, p -> new Long[]{p[1], p[0]+p[1]}).map(p ->p[0]);
		System.out.println(Arrays.toString(st4.limit(30).toArray()));
		
	}

}
