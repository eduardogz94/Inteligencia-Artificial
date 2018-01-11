package eagz.org;

import java.util.Random;
import java.util.Scanner;

public class Neurona {
	public static void main(String[] args) {
		int[][] tv = { { 1, 1, 1},
					   { 1,-1, 1},
					   {-1, 1, 1},
					   {-1,-1,-1} };
		
		System.out.println("\nInicializar pesos:\n");
		double w1 = new Random().nextDouble();
		double w2 = new Random().nextDouble();
		double umbral = 0.7;
		double y = 0;
		double wx = 0;
		double error = 0;
		System.out.println("W1: "+w1);
		System.out.println("W2: "+w2);
		System.out.println("Umbral: "+umbral);
		System.out.println("Iniciar aprendizaje");
		int i = 0;
		while(i<tv.length) {
			wx = (tv[i][0] * w1) + (tv[i][1] * w2) - umbral;
			y = (wx>umbral) ? 1 : -1;
			System.out.println("Entrada ["+tv[i][0]+","+tv[i][1]+"]"
					+ " Valor esperado ["+tv[i][2]+"]Salida["+y+"]");
			if (y == tv[i][2]) {
				i++;
			} else {
				System.out.println("Valor esperado difiere de la salida");
				System.out.println("Reajustando pesos");
				error = tv[i][2] - wx;
				w1 = w1 + error * tv[i][0];
				w2 = w2 + error * tv[i][1];
				umbral = umbral + error * (-1);
				i = 0;
		
			}
		}
		
		System.out.println("Fase de aprendizaje finalizada con exito");
		System.out.println("W1: "+w1);
		System.out.println("W2: "+w2);
		System.out.println("Umbral: "+umbral);
		System.out.println("Inicio de fase de testeo");
		System.out.println("Introduce entrada 1 (X1): ");
		Scanner leer_x1 = new Scanner(System.in);
		double x1 = Double.parseDouble(leer_x1.next());
		System.out.println("Introduce entrada 2 (X2): ");
		Scanner leer_x2 = new Scanner(System.in);
		double x2 = Double.parseDouble(leer_x2.next());
		y = (x1 * w1) + (x2 * w2) - umbral;
		y = (y >= umbral) ? 1 : -1;
		System.out.println("Salida: "+y);
		leer_x1.close();
		leer_x2.close();
	}
}