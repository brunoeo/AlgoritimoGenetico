package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Formiga {
	List<Integer> gen = new ArrayList<>();
	private Colors color;
	private int rgb = 0;
	
	public Formiga() {
		for (int x=0; x<3; x++) {
			Random r = new Random();
			int y = r.nextInt(2);
			gen.add(y);
		}
		colorir();
	}

	public List<Integer> getGen() {
		return gen;
	}
	
	public void setGen(List<Integer> gen1, List<Integer> gen2) {
		gen.set(0, gen1.get(0));
		gen.set(1, gen1.get(1));
		gen.set(2, gen2.get(2));
		mutation();
		colorir();
	}
	
	private void mutation() {
		Random r = new Random();
		int y = r.nextInt(1000);
		if (y == 45) {
			int x = r.nextInt(3);
			if(gen.get(x) == 0) {
				gen.set(x, 1);
				}
			else gen.set(x, 0);
			}
	}

	public Colors getColor() {
		return color;
	}
	public int getRgb() {
		return rgb;
	}


	public void setRgb(int rgb) {
		this.rgb = rgb;
	}

	private void colorir() {
		// arrumar
		int y = 0;
		for (int x: gen) {
			int p = 2 - x;
			y = (int) (x * Math.pow(2,(p)));
		}
		switch(y) {
		case 0:
			color = Colors.BLACK;
			break;		
		case 1:
			color = Colors.BLUE;
			break;
		case 2:
			color = Colors.GREEN;
			break;
		case 3:
			color = Colors.LIGHT_BLUE;
			break;
		case 4:
			color = Colors.RED;
			break;
		case 5:
			color = Colors.PURPLE;
			break;
		case 6:
			color = Colors.YELLOW;
			break;
		case 7:
			color = Colors.WHITE;
			break;
			}
	}
}
