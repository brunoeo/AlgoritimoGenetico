package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Formigas {
	private int tamanho_populacao;
	private List<Formiga> formigas = new ArrayList<>();
	List<Integer> ambiente = new ArrayList<>();
	
	public Formigas(int tamanho_populacao, List<Integer> ambiente2) {
		this.tamanho_populacao = tamanho_populacao;
		this.ambiente = ambiente2;
		eva();
	}
	
	public Formigas(int tamanho_populacao, List<Integer> ambiente2, List<Formiga> pais) {
		this.tamanho_populacao = tamanho_populacao;
		this.ambiente = ambiente2;
		selecao(pais);
	}
	
	private void eva() {
		for (int x=0; x<tamanho_populacao; x++) {
			Formiga formiga = new Formiga();
			formiga.setRgb(fitness(formiga.getGen()));
			formigas.add(formiga);
		}
	}
	
	private int fitness(List<Integer> list) {
		List<Integer> x = new ArrayList<>();
		x.add(30);
		x.add(30);
		x.add(30);
		int rt = 0;
		int x1=0;
		for (int y : list) {
			if (y == ambiente.get(x1)){
				rt += x.get(x1);
			}
			x1++;
		}
		return rt;
	}
	

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ambiente);
		sb.append("\n \n \n \n");
		for (Formiga x : formigas) {
			sb.append("[");
			sb.append(x.getRgb());
			sb.append(" / ");
			sb.append(x.getColor());
			sb.append(" / ");
			sb.append(x.getGen());
			sb.append("]");
			sb.append("  ");
		}
		return sb.toString();
	}
	
	public void selecao(List<Formiga> list) {
		List<Formiga> selecionado = new ArrayList<>();
		Random r = new Random();
		int k = tamanho_populacao;
		int y = r.nextInt(k);
		int prmt = r.nextInt(100);
		for (int x=0; x<15; x++) {
			if (list.get(y).getRgb() >= prmt) {
			selecionado.add(list.get(y));
			list.remove(y);
			}
			k--;
		}
		crossover(selecionado, list);
	}

	private void crossover(List<Formiga> mae, List<Formiga> pai) {
		
		Random g = new Random();
		while (formigas.size()<tamanho_populacao) {
			int p = g.nextInt(25);
			int m;
			do{
				m = g.nextInt(25);
			}while(m==p);
			
			Formiga filho = new Formiga();
			filho.setGen(mae.get(m).gen, mae.get(p).gen);
			formigas.add(filho);
		}
	}
	
}
