package fr.kata.jeu.tennis;

public class Player implements Runnable{

	private int idPlayer;
	private Resultat resultat;

	public Player(int idPlayer, Resultat resultat) {
		super();
		this.idPlayer = idPlayer;
		this.resultat = resultat;
	}

	@Override
	public void run() {
		
		resultat.jouer(idPlayer);
	}

}
