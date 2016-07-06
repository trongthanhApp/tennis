package fr.kata.jeu.tennis;

public class Resultat {

	private int pointPlayer1 = 0;
	private int pointPlayer2 = 0;

	private int deucePlayer1 = 0;
	private int deucePlayer2 = 0;

	private int tieBreakPlayer1 = 0;
	private int tieBreakPlayer2 = 0;

	private boolean finPartie = false;


	public synchronized void jouer(int idPlayer){

		// marquer des points
		while(pointPlayer1 < 40 && pointPlayer2 < 40) {
			if(idPlayer == 1) {
				pointPlayer1 = traiterPoint(pointPlayer1);
			} else if (idPlayer == 2) {
				pointPlayer2 = traiterPoint(pointPlayer2);
			}
		}

		afficherPoint();


	}

	public synchronized void jouerDeuce(int idPlayer){
		while ((deucePlayer1 < 6) && (deucePlayer2 < 6)) {
			if (idPlayer == 1) {
				deucePlayer1 = traiterDeuce(deucePlayer1);
			} else if (idPlayer == 2) {
				deucePlayer2 = traiterDeuce(deucePlayer2);
			}
		}

		afficherDeuce();
	}

	public synchronized void jouerTieBreak(int idPlayer) {
		while ((tieBreakPlayer1 - tieBreakPlayer2 < 2) && (tieBreakPlayer2 - tieBreakPlayer1 < 2)) {
			if (idPlayer == 1) {
				tieBreakPlayer1 = traiterTieBreak(tieBreakPlayer1);
			} else if (idPlayer == 2) {
				tieBreakPlayer2 = traiterTieBreak(tieBreakPlayer2);
			}
		}
	}

	private int traiterPoint(int pointPlayer) {

		if (pointPlayer == 0){
			pointPlayer = 15;
		} else if (pointPlayer == 15) {
			pointPlayer = 30;
		} else if (pointPlayer == 30) {
			pointPlayer = 40;
		}
		afficherPoint();
		return pointPlayer;
	}

	private int traiterDeuce(int deucePlayer) {
		deucePlayer = deucePlayer + 1;

		afficherDeuce();
		return deucePlayer;
	}

	private int traiterTieBreak(int tieBreakPlayer) {
		tieBreakPlayer = tieBreakPlayer + 1;

		afficherTieBreak();
		return tieBreakPlayer;
	}

	public void afficherPoint(){
		System.out.println("Point player 1 : " + pointPlayer1);
		System.out.println("Point player 2 : " + pointPlayer2);
	}

	public void afficherDeuce() {
		System.out.println("Deuce player 1 : " + deucePlayer1);
		System.out.println("Deuce player 2 : " + deucePlayer2);
	}

	private void afficherTieBreak() {
		System.out.println("Tie break player 1 : " + tieBreakPlayer1);
		System.out.println("Tie break player 2 : " + tieBreakPlayer2);	
	}

	public void afficherJoueurGagnant(int idPlayer) {
		System.out.println("Le gagnant est le joueur : " + idPlayer);		
	}

	public int getPointPlayer1() {
		return pointPlayer1;
	}

	public void setPointPlayer1(int pointPlayer1) {
		this.pointPlayer1 = pointPlayer1;
	}

	public int getPointPlayer2() {
		return pointPlayer2;
	}

	public void setPointPlayer2(int pointPlayer2) {
		this.pointPlayer2 = pointPlayer2;
	}

	public boolean isFinPartie() {
		return finPartie;
	}

	public void setFinPartie(boolean finPartie) {
		this.finPartie = finPartie;
	}

	public int getDeucePlayer1() {
		return deucePlayer1;
	}

	public void setDeucePlayer1(int deucePlayer1) {
		this.deucePlayer1 = deucePlayer1;
	}

	public int getDeucePlayer2() {
		return deucePlayer2;
	}

	public void setDeucePlayer2(int deucePlayer2) {
		this.deucePlayer2 = deucePlayer2;
	}

	public int getTieBreakPlayer1() {
		return tieBreakPlayer1;
	}

	public void setTieBreakPlayer1(int tieBreakPlayer1) {
		this.tieBreakPlayer1 = tieBreakPlayer1;
	}

	public int getTieBreakPlayer2() {
		return tieBreakPlayer2;
	}

	public void setTieBreakPlayer2(int tieBreakPlayer2) {
		this.tieBreakPlayer2 = tieBreakPlayer2;
	}

}
