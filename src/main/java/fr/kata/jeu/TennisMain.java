package fr.kata.jeu;

import fr.kata.jeu.tennis.Player;
import fr.kata.jeu.tennis.PlayerDeuce;
import fr.kata.jeu.tennis.PlayerTieBreak;
import fr.kata.jeu.tennis.Resultat;

public class TennisMain {

	public static void main (String[] args) throws InterruptedException {
		Resultat resultat = new Resultat();

		// marquer des points
		Player player1 = new Player(1, resultat);
		Player player2 = new Player(2, resultat);

		Thread threadPlayer1 = new Thread(player1);
		Thread threadPlayer2 = new Thread(player2);

		threadPlayer1.start();
		threadPlayer2.start();
		
		threadPlayer1.join();
		threadPlayer2.join();
		
		Thread threadPlayerDeuce1 = new Thread(new PlayerDeuce(1, resultat));
		Thread threadPlayerDeuce2 = new Thread(new PlayerDeuce(2, resultat));

		// deuce
		if(resultat.getPointPlayer1() == 40 || resultat.getPointPlayer2() == 40) {

			if (resultat.getPointPlayer1() == resultat.getPointPlayer2()) {

				System.out.println("Partie deuce");
				
				threadPlayerDeuce1.start();
				threadPlayerDeuce2.start();
				
				threadPlayerDeuce1.join();
				threadPlayerDeuce2.join();
				
				if (resultat.getDeucePlayer1() > resultat.getDeucePlayer2()) {
					resultat.setFinPartie(true);
					resultat.afficherJoueurGagnant(1);
				}  else if (resultat.getDeucePlayer1() < resultat.getDeucePlayer2()) {
					resultat.setFinPartie(true);
					resultat.afficherJoueurGagnant(2);
				} else {
					// tie break
					
					Thread threadPlayerTieBreak1 = new Thread(new PlayerTieBreak(1, resultat));
					Thread threadPlayerTieBreak2 = new Thread(new PlayerTieBreak(2, resultat));
					
					threadPlayerTieBreak1.start();
					threadPlayerTieBreak2.start();
					
					threadPlayerTieBreak1.join();
					threadPlayerTieBreak2.join();
					
					if (resultat.getTieBreakPlayer1() > resultat.getTieBreakPlayer2()) {
						resultat.setFinPartie(true);
						resultat.afficherJoueurGagnant(1);
					} else {
						resultat.setFinPartie(true);
						resultat.afficherJoueurGagnant(2);
					}
				}
				
				
			} else {
				resultat.setFinPartie(true);
				if (resultat.getPointPlayer1() > resultat.getPointPlayer2()) {
					resultat.afficherJoueurGagnant(1);
				} else {
					resultat.afficherJoueurGagnant(2);
				}
			}
		}
	}
}
