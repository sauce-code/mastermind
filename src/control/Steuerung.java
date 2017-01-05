package control;

import view.Ausgabe;
import model.Mastermind;

/**
 * Stererungs-Klasse.
 * 
 * @author ich
 *
 */
public class Steuerung {

	/**
	 * Erzeugt eine neue Steuerung.
	 * 
	 * @param spiel
	 *            Mastermind-Spiel, welches ausgegeben werden soll
	 * @param ausgabe
	 *            Ausgabe, die verwendet werden soll
	 */
	public Steuerung(Mastermind spiel, Ausgabe ausgabe) {

	}

	/**
	 * Hier wird gesamte Spielverlauf abgewickelt. Nach der R&uuml;ckkehr ist
	 * das Spiel beendet.
	 */
	public void starteSpiel() {

	}

	/**
	 * Main Methode zum Ausf&uuml;hren des Mastermind-Spiels.
	 * 
	 * @param args ungenutzt
	 */
	public static void main(String args[]) {
		Mastermind m = new Mastermind();
		Ausgabe a = new Ausgabe(m);
		Steuerung s = new Steuerung(m, a);
		s.starteSpiel();
	}

}
