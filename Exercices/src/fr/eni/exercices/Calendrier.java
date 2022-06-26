package fr.eni.exercices;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Calendrier {

	
	public static Scanner choix = new Scanner(System.in);
	
	public static void menu() {
		
		System.out.println("################Bienvenue dans le calendrier####################");
		System.out.println("################Veuillez faire un choix#########################");	
		System.out.println("################Choix numero 1 : Inserez l'annee de votre choix pour visualiser cette annee choisie.");
		System.out.println("################Choix numero 2 : Afficher la date de la revolution francaise.");
		System.out.println("################Choix numero 3 : Quittez le systeme .");
		System.out.println("################################################################");
		System.out.println("#################C'est a vous , faites votre choix.");
		Scanner choix = new Scanner(System.in);
		int playerChoice = choix.nextInt();
		
		if (playerChoice == 1 ) {
			afficherAnnee();
		} else if (playerChoice == 2) {
			dateRevo();
		} else {
			System.out.println("Au revoir !!");
			System.exit(0);
			choix.close();
		}
		
	}
	
	public static void afficherAnnee() {
		   int Y;    // year
	        int startDayOfMonth = 5;
			int spaces = startDayOfMonth;
			
			Scanner chooseYear = new Scanner(System.in);
			System.out.println("Chosissez une annee.");
			Y = chooseYear.nextInt();

	        // months[i] = name of month i
	        String[] months = {
	                "",                               // leave empty so that we start with months[1] = "January"
	                "January", "February", "March",
	                "April", "May", "June",
	                "July", "August", "September",
	                "October", "November", "December"
	            };

	            // days[i] = number of days in month i
	            int[] days = {
	                0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
	            };

	            for (int M = 1; M <= 12; M++) {

	            // check for leap year
	            if  ((((Y % 4 == 0) && (Y % 100 != 0)) ||  (Y % 400 == 0)) && M == 2)
	                days[M] = 29;


	            // print calendar header
	            // Display the month and year
	            System.out.println("          "+ months[M] + " " + Y);

	            // Display the lines
	            System.out.println("_____________________________________");
	            System.out.println("   Sun  Mon Tue   Wed Thu   Fri  Sat");

	            // spaces required
	               spaces = (days[M-1] + spaces)%7;

	            // print the calendar
	            for (int i = 0; i < spaces; i++)
	                System.out.print("     ");
	            for (int i = 1; i <= days[M]; i++) {
	                System.out.printf(" %3d ", i);
	                if (((i + spaces) % 7 == 0) || (i == days[M])) System.out.println();
	            }

	            System.out.println();
	            
	            System.out.println("___________________________________________________________________________________________");
	            System.out.println("Pour retourner au menu faites le 1.");
	            System.out.println("Pour voire la date de la revolution francaise faite le 2");
	            System.out.println("Pour quitter faites le 3 .");
	            int choixNb3 = choix.nextInt();
	            if(choixNb3 == 1) {
	            	menu();
	            } else if (choixNb3 == 2) {
	            	dateRevo();
	            } else {
	            	System.out.println("Au revoir !!");
	            System.exit(0);
	            chooseYear.close();
	            choix.close();
	            }
        };
    }

                
        
	
	
	public static void dateRevo() {
	GregorianCalendar revo;
	revo = new GregorianCalendar(1789,6,14);
	System.out.printf("%02d/%02d/%d%n",
			revo.get(GregorianCalendar.DAY_OF_MONTH),
			revo.get(GregorianCalendar.MONTH)+1,
			revo.get(GregorianCalendar.YEAR));
	System.out.println("voulez vous retourner au menu ? Si oui faites le 1, pour quitter faites le 2");
	
	int choixNb2 = choix.nextInt();
	if (choixNb2 == 1) {
		menu();
	}else {
		System.out.println("Au revoir !!");
	    System.exit(0);
	    choix.close();
	}
	
	};
	
	
	

	public static void main(String[] args) {
		
		menu();
		
		
		
		
	}

}
