package zaduzozamalo;

import java.util.Random;
import java.util.Scanner;

public class ZaDuzoZaMalo {
	public static void main(String[] args) {
		int losowaLiczba = new Random().nextInt(100);
		System.out.println(losowaLiczba);
		int iloscStrzalow = 0;
		int strzal;
		int[] historia = new int[0];
		
		boolean graAktywna = true;
		
		while (graAktywna) {
			System.out.print("Zgadnij liczb� od 0-100: ");
			Scanner sc = new Scanner(System.in);
			String zgadnij = sc.nextLine();
			if (zgadnij.equals("exit")) {
				System.out.println("Przerwa�e� gre");
				graAktywna = false;
				break;
			}
			strzal = Integer.parseInt(zgadnij);
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
				System.out.println("Gratulacje, trafi�e� za " + iloscStrzalow + " razem");
				graAktywna = false;
			} else if (strzal > losowaLiczba) {
				System.out.println("Za duuu�o");
			} else {
				System.out.println("Za ma�o!!");
			}
		}
		
		System.out.println("Historia Twoich strza��w: ");
		for (int each: historia) {
			System.out.print(each + " ");
		}
	}
}
