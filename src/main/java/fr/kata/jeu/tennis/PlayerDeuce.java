package fr.kata.jeu.tennis;

public class PlayerDeuce implements Runnable{

	private int idPlayer;
	private Resultat resultat;
	
	public PlayerDeuce(int idPlayer, Resultat resultat) {
		super();
		this.idPlayer = idPlayer;
		this.resultat = resultat;
	}

	@Override
	public void run() {
		resultat.jouerDeuce(idPlayer);
	}

}
