package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.Formigas;

public class Program {

	public static void main(String[] args) {
		
		int tamanho_populacao = 50;
		List<Integer> ambiente = new ArrayList<>();
		List<Formigas> geracoes = new ArrayList<>();
		
		for (int x=0; x<3; x++) {
			Random r = new Random();
			int y = r.nextInt(2);
			ambiente.add(y);
		}
		
		Formigas formigas = new Formigas(tamanho_populacao, ambiente);
		geracoes.add(formigas);
		
		for (int x=0; x<10000; x++) {
			Formigas decendentes = new Formigas(tamanho_populacao, ambiente);
			geracoes.add(decendentes);
		}
		for (int x=0; x<=10000; x++) {
			System.out.println(geracoes.get(x));

		}
		
		
	}

}

