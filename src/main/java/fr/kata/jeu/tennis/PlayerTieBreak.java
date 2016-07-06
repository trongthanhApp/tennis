package fr.kata.jeu.tennis;

public class PlayerTieBreak implements Runnable{

	private int idPlayer;
	private Resultat resultat;
	
	public PlayerTieBreak(int idPlayer, Resultat resultat) {
		super();
		this.idPlayer = idPlayer;
		this.resultat = resultat;
	}

	@Override
	public void run() {
		resultat.jouerTieBreak(idPlayer);
	}

}
