package zaduzozamalo;

import java.util.Random;
import java.util.Scanner;

public class ZaDuzoZaMalo {
	public static void main(String[] args) {
		int losowaLiczba = new Random().nextInt(100);
		System.out.println(losowaLiczba);
		int iloscStrzalow = 0;
		int strzal = -1;
		int[] historia = new int[0];
		
		boolean graAktywna = true;
		
		while (graAktywna) {
			System.out.print("Zgadnij liczbê od 0-100: ");
			Scanner sc = new Scanner(System.in);
			boolean niePoprawna = true;
			while (niePoprawna) {
				try {
					String zgadnij = sc.nextLine();
					if (zgadnij.equals("exit")) {
						System.out.println("Przerwa³eœ gre");
						graAktywna = false;
						break;
					}
					strzal = Integer.parseInt(zgadnij);
					niePoprawna = false;
				} catch (NumberFormatException ex) {
					System.out.println("Poda³eœ niepoprawn¹ liczbê. Spróbuj jeszcze raz:");
				}
			}
			iloscStrzalow++;
			int[] tempHistoria = historia;
			historia = new int[iloscStrzalow];
			for (int i=0; i<historia.length; i++) {
				for (int j=0; j<tempHistoria.length; j++) {
					historia[j] = tempHistoria[j];
				}
				historia[historia.length-1] = strzal;
			}
			
			if (strzal == losowaLiczba) {
				System.out.println("Gratulacje, trafi³eœ za " + iloscStrzalow + " razem");
				graAktywna = false;
			} else if (strzal > losowaLiczba) {
				System.out.println("Za duuu¿o");
			} else if (strzal < losowaLiczba){
				System.out.println("Za ma³o!!");
			}
		}
		
		System.out.println("Historia Twoich strza³ów: ");
		for (int each: historia) {
			System.out.print(each + " ");
		}
	}
}
