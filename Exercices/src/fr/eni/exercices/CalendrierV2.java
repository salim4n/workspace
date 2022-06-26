package fr.eni.exercices;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class CalendrierV2 {

	public static Scanner choix = new Scanner(System.in);
	
	public static void afficherMois() {
		int year;
		int month;
		
		System.out.println("choix de l'annee.");
		year = choix.nextInt();
		do {
		System.out.println("choix du mois.");
		month = choix.nextInt() - 1;
		} while  (month < 0 || month > 12);
		GregorianCalendar date = new GregorianCalendar(year, month,1);
		System.out.format("* %s %d *%n",date.getDisplayName
				(GregorianCalendar.MONTH,
				GregorianCalendar.LONG_FORMAT,
				Locale.FRANCE),
				date.get(GregorianCalendar.YEAR));
		System.out.println("L Ma Me J V S D");
		int decalage =0;
		switch (date.get(GregorianCalendar.DAY_OF_WEEK)) {
		case GregorianCalendar.TUESDAY :
			decalage = 1;
			break;
		case GregorianCalendar.WEDNESDAY :
			decalage = 2;
			break;
		case GregorianCalendar.THURSDAY :
			decalage = 3;
			break;
		case GregorianCalendar.FRIDAY :
			decalage = 4;
			break;
		case GregorianCalendar.SATURDAY :
			decalage = 5;
			break;
		case GregorianCalendar.SUNDAY :
			decalage = 6;
			break;
		}
		
		for (int i=0; i< decalage; i++) {
			System.out.println("  ");
		}
		int nbJourMois = date.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		for (int i=1; i <= nbJourMois ; i++) {
			System.out.format("%02d ",
					date.get(GregorianCalendar.DAY_OF_MONTH));
			date.add(GregorianCalendar.DAY_OF_MONTH,1);
			if (date.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.MONDAY)
             System.out.println();
		}
		
		System.out.println();	
		}
		
		
	
	public static void main(String[] args) {
		afficherMois();
	

	}

}
